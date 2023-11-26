# Spring Reactive Web Socket

## Overview

Simple spring application that exposes a websocket endpoint, listens to incoming messages from an
AMQP exchange (RabbitMQ) and forwards them to every active web socket connection:

* AMQP message consumer implemented
  using [Apache Spring Camel RabbitMQ](https://camel.apache.org/components/4.0.x/spring-rabbitmq-component.html)
* Message forwarding from consumer to web socket connections implemented
  using [Apache Camel Reactive Streams](https://camel.apache.org/components/4.0.x/reactive-streams-component.html)
* Web Socket implemented
  using [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html)

## Usage

### Build and run

Both Docker and Maven with Java 17 are required in order to build and run this project.

Run the following commands in the project's root directory:

````shell
mvn package
````

````shell
docker-compose up
````

### Test the app

* Open a websocket connection to **ws://localhost:8080/web-socket** using a websocket client browser
  app such
  as [Chrome's WebSocket Client Extension](https://chromewebstore.google.com/detail/browser-websocket-client/mdmlhchldhfnfnkfmljgeinlffmdgkjo)
* ![websocket client connection.png](websocket%20client%20connection.png)
* Go to the amq.direct exchange in the rabbitmq management console
  at http://localhost:15672/#/exchanges/%2F/amq.direct (user and password are both "guest")
* Publish a message to the exchange
* ![publish message.png](publish%20message.png)
* Go back to the websocket client application and check if the message was received
* ![receive message.png](receive%20message.png)