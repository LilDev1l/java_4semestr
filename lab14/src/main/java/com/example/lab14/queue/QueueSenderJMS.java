package com.example.lab14.queue;
import javax.jms.*;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.ConnectionConfiguration;


public class QueueSenderJMS {
    public static void main(String[] args){
        ConnectionFactory factory = new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination cardsQueue = context.createQueue("BankCard");

            JMSProducer producer = context.createProducer();
            producer.send(cardsQueue,"PNV 100 5634234");
            System.out.println("Placed an information about to BankCardQueue");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
