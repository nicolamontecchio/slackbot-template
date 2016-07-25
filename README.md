# slackbot

A simple bot that responds to messages.

Steps:

- create a bot using [Slack's UI](https://my.slack.com/services/new/bot)
- make a `.apitoken` file in this directory containing the bot's generated API key
- edit the code in `core.clj` where it says "DEFINE CUSTOM LOGIC HERE"
- `lein uberjar`
- `lein run` or use docker

Note that the bot must be invited to a channel in order to see messages.
