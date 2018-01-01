package com.acme.iotthing

import org.springframework.scheduling.annotation.EnableScheduling

import javax.jms.ConnectionFactory

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.config.JmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType

@SpringBootApplication
@EnableJms
@EnableScheduling
class Application {

    @Bean
    JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory()
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory)
        // You could still override some of Boot's default if necessary.
        factory
    }

    @Bean // Serialize message content to json using TextMessage
    MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_type")
        converter
    }

    static void main(String[] args) {
        // Launch the application
        SpringApplication.run(Application.class, args)
    }
}