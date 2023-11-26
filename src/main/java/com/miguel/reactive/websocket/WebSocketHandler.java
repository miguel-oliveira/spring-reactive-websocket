package com.miguel.reactive.websocket;

import static com.miguel.reactive.websocket.EventRouteBuilder.MESSAGE_STREAM;

import lombok.AllArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.reactive.streams.api.CamelReactiveStreams;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class WebSocketHandler implements org.springframework.web.reactive.socket.WebSocketHandler {

  private final CamelContext context;

  @Override
  public Mono<Void> handle(WebSocketSession session) {
    return session.send(
        Flux.from(CamelReactiveStreams.get(context).fromStream(MESSAGE_STREAM))
            .map(Exchange::getMessage)
            .map(Message::getBody)
            .map(Object::toString)
            .map(session::textMessage)
    );
  }
}
