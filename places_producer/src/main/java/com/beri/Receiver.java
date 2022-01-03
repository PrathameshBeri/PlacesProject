package com.beri;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

//@Component
public class Receiver implements MessageListener {


    JmsListenerContainerFactory fact;

    @Autowired
    public Receiver(JmsListenerContainerFactory fac) {
        fact = fac;
    }

    //@JmsListener(destination = "mailbox", containerFactory =  "myFactory")
 /*   public void receivePlace(Place place) {

        System.out.println(" received place " + place.toString());
    }*/

    @Override
    public void onMessage(Message message) {

    }
}
