package com.beri;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Reciever {

    @JmsListener(destination = "mailbox", containerFactory = "myContainerFact")
    public void receive(Place place){
        System.out.println("received this place " + place.getCountry() + " " + place.getName());
    }
}
