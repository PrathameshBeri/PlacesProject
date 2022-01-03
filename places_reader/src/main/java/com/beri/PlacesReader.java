package com.beri;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.network.jms.JmsMesageConvertor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

/**
 * Hello world!
 */

@SpringBootApplication
public class PlacesReader {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Place p;
    }


    @Bean("myContainerFact")
    public JmsListenerContainerFactory factory(ConnectionFactory cf, DefaultJmsListenerContainerFactoryConfigurer df) {

        DefaultJmsListenerContainerFactory fact = new DefaultJmsListenerContainerFactory();
        df.configure(fact, cf);
        return fact;
    }

    @Bean
    public ConnectionFactory confact(){
        return new ActiveMQConnectionFactory("http://localhost:61616");
    }

    @Bean
    public MessageConverter jack(){
        MappingJackson2MessageConverter mp = new MappingJackson2MessageConverter();
        mp.setTypeIdPropertyName("_type");
        mp.setTargetType(MessageType.TEXT);
        return mp;
    }
}