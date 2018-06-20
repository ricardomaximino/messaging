package com.brasajava.rabbitstreamreactiveone.service;

import java.time.Duration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.FluxSender;
import org.springframework.cloud.stream.reactive.StreamEmitter;

import reactor.core.publisher.Flux;

//@EnableBinding(Source.class)
//@EnableAutoConfiguration
public class SenderService {

	private FluxSender output;

	@StreamEmitter
	@Output(Source.OUTPUT)
	public Flux<String> emit() {
		return Flux.interval(Duration.ofSeconds(1)).map(l -> "Hello World 1");
	}

	@StreamEmitter
	public void emit2(@Output(Source.OUTPUT) FluxSender output) {
		this.output = output;
		output.send(Flux.interval(Duration.ofSeconds(2)).map(l -> "Hello World 2"));
	}

	public void send(String message) {
		output.send(Flux.just(message));
	}
}
