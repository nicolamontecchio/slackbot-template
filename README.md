# slackbot

A simple bot that responds to messages.

## Building

- create a bot using [Slack's UI](https://my.slack.com/services/new/bot)
- edit the code in `core.clj` where it says "DEFINE CUSTOM LOGIC HERE"
- `lein uberjar`

## Running

- export the environment variable SLACKBOTAPITOKEN (it's the API key generated in the first step)
- `lein run` or use docker

Note that the bot must be invited to a channel in order to see messages.
