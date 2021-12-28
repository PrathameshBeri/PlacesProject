package com.beri;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import java.util.function.Function;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableJms
public class PlacesProducer
{
    public static void main( String[] args )
    {

        ConfigurableApplicationContext ctx = SpringApplication.run(PlacesProducer.class, args);
        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        System.out.println("Sending a place");
        jmsTemplate.convertAndSend("mailbox", new Place("dombo", "maharash"));
    }


    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory c,
                                                   DefaultJmsListenerContainerFactoryConfigurer conn) throws JMSException {

        DefaultJmsListenerContainerFactory dd = new DefaultJmsListenerContainerFactory();
        conn.configure(dd, c);
        return dd;
    }

    @Bean
    public ConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public MessageConverter msgConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }



}



