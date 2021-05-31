package com.example.lab14.topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

public class TopicReceiverJMS implements MessageListener {
    ConnectionFactory factory = new ConnectionFactory();
    JMSConsumer consumer;

    TopicReceiverJMS() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination priceInfo= context.createTopic("PriceInfo");

            consumer = context.createConsumer(priceInfo);

            consumer.setMessageListener(this);
            System.out.println("Listening to thePriceInfo...");

            Thread.sleep(100000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (JMSException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void onMessage(Message msg) {
        try {
            System.out.println("New message: " + msg.getBody(String.class));
            System.out.println("All property" + msg);
        } catch (JMSException e) {
            System.err.println("JMSException: " + e.toString());
        }
    }

    public static void main(String[] args) {
        new TopicReceiverJMS();
    }
}
