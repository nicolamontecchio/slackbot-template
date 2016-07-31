(ns slackbot.core
  (:require [gniazdo.core :as ws]
            [cheshire.core :refer [parse-string generate-string]])
  (:gen-class))


(def socket (atom nil))  ;; websocket
(def msg-id (atom 1))    ;; used by slack to sort messages

(defn send-msg [channel text]
  (let [msg {"id" (swap! msg-id inc)
             "type" "message"
             "channel" channel
             "text" text}]
    (ws/send-msg @socket (generate-string msg))))

(defn on-receive [msg]
  ;; DEFINE CUSTOM LOGIC HERE
  (let [input (parse-string msg)
        type (get input "type")]
    (when (= type "message")
      (let [channel (get input "channel")
            user (get input "user")
            text (get input "text")]
        (send-msg channel (str "USER " user " TYPED " text))))))

(defn -main [& args]
  (let [apitoken (System/getenv "SLACKBOTAPITOKEN")]
    (if apitoken
      (let [req-url (str "https://slack.com/api/rtm.start?token=" apitoken)
            slack-response (-> req-url slurp parse-string)
            slack-url (get slack-response "url")
            socket- (ws/connect slack-url :on-receive on-receive)]
        (reset! socket socket-)
        (println "RUNNING"))
      (println "environment variable SLACKBOTAPITOKEN not set, quitting"))))
