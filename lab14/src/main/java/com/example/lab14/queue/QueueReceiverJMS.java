package com.example.lab14.queue;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;

import javax.jms.*;

public class QueueReceiverJMS implements MessageListener {
    ConnectionFactory factory = new com.sun.messaging.ConnectionFactory();
    JMSConsumer consumer;

    QueueReceiverJMS() {
        try (JMSContext context = factory.createContext("admin", "admin")) {
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");
            Destination cardsQueue = context.createQueue("BankCard");

            consumer = context.createConsumer(cardsQueue);

            consumer.setMessageListener(this);
            //System.out.println("New message: " + consumer.receive().getBody(String.class));
            System.out.println("Listening to theBankCardQueue...");

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
        new QueueReceiverJMS();
    }
}
