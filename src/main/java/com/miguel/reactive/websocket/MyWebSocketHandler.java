package com.miguel.reactive.websocket;

import static com.miguel.reactive.websocket.EventRouteBuilder.MY_STREAM;

import lombok.AllArgsConstructor;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.reactive.streams.api.CamelReactiveStreamsService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class MyWebSocketHandler implements WebSocketHandler {

  private final CamelReactiveStreamsService service;

  @Override
  public Mono<Void> handle(WebSocketSession session) {
    return session.send(
        Flux.from(service.fromStream(MY_STREAM))
            .map(Exchange::getMessage)
            .map(Message::getBody)
            .map(Object::toString)
            .map(session::textMessage)
    );
  }
}
