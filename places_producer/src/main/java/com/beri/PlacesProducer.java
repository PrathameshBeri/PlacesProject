package com.beri;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
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

        System.out.println( "Hello World!" );
        Place p = new Place("Dombivli", "India");
        ``
    }


    @Bean
    public JmsListenerContainerFactory<?> getListener(ConnectionFactory c,
                                                   DefaultJmsListenerContainerFactoryConfigurer conn)
    {
        DefaultJmsListenerContainerFactory dd = new DefaultJmsListenerContainerFactory();
        conn.configure(dd, c);
        return dd;
    }



}



