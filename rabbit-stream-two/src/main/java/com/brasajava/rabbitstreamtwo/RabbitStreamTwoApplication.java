package com.brasajava.rabbitstreamtwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RabbitStreamTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitStreamTwoApplication.class, args);
	}
}
@RestController
class SenderController {
	
	@Autowired
	private SenderService sender;
	
	@PostMapping("/send")
	public ResponseEntity<String> send(@RequestBody Contact contact){
		sender.send(contact);
		return new ResponseEntity<>("The message was sent successfully!!!", HttpStatus.OK);
	}
}

@RestController
class ReceiverController {
	
	@Autowired
	private ContactRepository repository;
	
	@GetMapping("/receive")
	public List<Contact> receive(){
		return repository.findAll();
	}
}

@EnableBinding(Source.class)
class SenderService {
	
	@Autowired
	private Source source;
	
	public void send(Contact contact) {
		source.output().send(MessageBuilder.withPayload(contact).build());
	}
}

@EnableBinding(Sink.class)
class ReceiverService {
	
	@Autowired
	private ContactRepository repository;
	
	@StreamListener(Sink.INPUT)
	public void receive(Contact contact) {
		System.out.println("Received -> " + contact);
		repository.save(contact);
		System.out.println("Saved -> " + contact);
	}
}

interface ContactRepository extends MongoRepository<Contact, String>{}

@Document
class Contact{
	
	@Id
	private String id;
	private String name;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
}