package com.beri;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory =  "myFactory")
    public void receivePlace(Place place){

        System.out.println(" received place " + place.toString());
    }

}
