package com.example.benchmarkkafkareactive;

import com.example.benchmarkkafkareactive.properties.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.kafka.receiver.KafkaReceiver;

@SpringBootApplication
public class BenchmarkKafkaReactiveApplication {

	@Autowired
	private KafkaProperties kafkaProperties;

	public static void main(String[] args) {
		SpringApplication.run(BenchmarkKafkaReactiveApplication.class, args);
	}

//	@Bean
//	public ApplicationRunner runner(KafkaReceiver<String, String> kafkaReceiver) {
//		return args -> {
//			kafkaReceiver.receive()
//                .doOnNext(r -> {
//                	print(r.topic(),r.value());
//				r.receiverOffset().acknowledge();
//			}).subscribe();
//		};
//	}


	private void print(String topic, String message){
		System.out.println("TOPIC: "+ topic + " Message: "+ message + " MapClass "+ kafkaProperties.findTopicByName(topic).get().getMapClass());
	}

}
