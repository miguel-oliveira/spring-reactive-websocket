package com.miguel.websocket.websocket;

import lombok.AllArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageMultiplier {

  private final ProducerTemplate producer;

  public void multiply(String message) {
    for (int i = 0; i < 10000; i++) {
      producer.asyncRequestBody("direct:test", message);
    }
  }

}
