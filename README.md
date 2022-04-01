# Spring Reactive Web Socket

Simple project that consumes messages from an AMQP exchange and forwards them to all active web socket connections:
 * AMQP message consumer implemented using [Apache Camel RabbitMQ](https://camel.apache.org/components/2.x/rabbitmq-component.html);
 * Message forwarding from consumer to web socket connections is done using [Apache Camel Reactive Streams](https://camel.apache.org/components/2.x/reactive-streams-component.html);
 * Web Socket implemented using [Spring WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html).