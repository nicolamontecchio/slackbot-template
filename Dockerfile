FROM java:8-jre-alpine

COPY target/slackbot-0.1.0-SNAPSHOT-standalone.jar /slackbot/app.jar
COPY .apitoken /slackbot/.apitoken
WORKDIR /slackbot
CMD ["java", "-jar", "app.jar"]
