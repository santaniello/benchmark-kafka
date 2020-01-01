package com.example.benchmarkkafkareactive.configs;

import com.example.benchmarkkafkareactive.properties.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.kafka.receiver.ReceiverOptions;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

import java.util.*;

@Slf4j
@Configuration
class SpringSSEConfiguration {

	@Autowired
	private KafkaProperties kafkaProperties;

	@Bean
	public KafkaReceiver kafkaReceiver(){
		List<String> topicsName = new ArrayList<>();
		kafkaProperties.getTopicsEnabled().forEach(t->topicsName.add(t.getName()));
		ReceiverOptions<Object, Object> receiverOptions = ReceiverOptions.create(getConsumerProps()).subscription(topicsName)
				.addAssignListener(partitions -> log.debug("onPartitionsAssigned {}", partitions))
				.addRevokeListener(partitions -> log.debug("onPartitionsRevoked {}", partitions));
		return KafkaReceiver.create(receiverOptions);
	}


	@Bean
	public KafkaSender kafkaSender(){
		SenderOptions<Integer, String> producerOptions = SenderOptions.create(getProducerProps());
		return KafkaSender.create(producerOptions);
	}

	public Map<String,Object> getConsumerProps(){
		Map<String,Object> configProps = new HashMap<>();
		configProps.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		configProps.put( ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getKeyDeserializer());
		configProps.put( ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, kafkaProperties.getValueDeserializer());
		configProps.put( ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());
		configProps.put( ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		return configProps;
	}

	public Map<String,Object> getProducerProps(){
		Map<String,Object> configProps = new HashMap<>();
		configProps.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		configProps.put( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		configProps.put( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return configProps;
	}
}