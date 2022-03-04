package com.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListener {
    private Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @StreamListener(ConsumerChannels.DEMO)
    public void demo(String message) {
        logger.info("Demo: " + message);
    }
}

