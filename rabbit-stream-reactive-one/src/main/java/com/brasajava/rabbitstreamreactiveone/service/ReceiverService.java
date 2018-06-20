package com.brasajava.rabbitstreamreactiveone.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import reactor.core.publisher.Flux;

@EnableBinding(Sink.class)
@EnableAutoConfiguration
public class ReceiverService {

  @StreamListener
  public void receive(@Input(Sink.INPUT) Flux<String> input) {
    input.subscribe( s -> System.out.println("Receives -> " + s));
  }
}