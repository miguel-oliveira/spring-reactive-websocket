package com.miguel.reactive.websocket;

import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventRouteBuilder extends RouteBuilder {

  static final String MESSAGE_STREAM = "message-stream";

  @Override
  public void configure() {
    from("spring-rabbitmq:amq.direct?autoDeclare=true")
        .convertBodyTo(String.class)
        .to(String.format("reactive-streams:%s", MESSAGE_STREAM));
  }
}
