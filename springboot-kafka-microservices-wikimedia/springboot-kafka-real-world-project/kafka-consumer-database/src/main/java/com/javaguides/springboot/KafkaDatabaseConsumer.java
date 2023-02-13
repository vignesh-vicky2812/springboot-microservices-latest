package com.javaguides.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.javaguides.springboot.entity.WikimediaData;
import com.javaguides.springboot.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
	
	private WikimediaDataRepository wikimediaDataRepository;
	
	public KafkaDatabaseConsumer(WikimediaDataRepository wikimediaDataRepository) {
		this.wikimediaDataRepository = wikimediaDataRepository;
	}

	@KafkaListener(topics="${spring.kafka.topic.name}", groupId = "myGroup")
	public void consumer(String eventMessage) {
		LOGGER.info(String.format("Event Message received -> %s", eventMessage));
		WikimediaData wikimediaData = new WikimediaData();
		wikimediaData.setWikiEventData(eventMessage);
		wikimediaDataRepository.save(wikimediaData);
	}
}
