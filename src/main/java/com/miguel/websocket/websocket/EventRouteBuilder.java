package com.miguel.websocket.websocket;

import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventRouteBuilder extends RouteBuilder {

  static final String MY_STREAM = "my-stream";

  @Override
  public void configure() {
    from("rabbitmq:topic?skipExchangeDeclare=true&routingKey=test")
        .convertBodyTo(String.class)
        .to(String.format("reactive-streams:%s", MY_STREAM));
  }
}
