package com.example.lab14.topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;


public class TopicSenderJMS {
    public static void main(String[] args){
        ConnectionFactory factory = new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination priceInfo= context.createTopic("PriceInfo");

            JMSProducer producer = context.createProducer();
            producer.send(priceInfo,"Epam 100.22");
            System.out.println("Placed an information about to PriceInfo");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
