package com.example.lab14.topic;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

import javax.jms.*;


public class TopicSenderJMS {
    public static void main(String[] args){
        ConnectionFactory factory = new ConnectionFactory();
        try(JMSContext context = factory.createContext("admin","admin")){
            factory.setProperty(ConnectionConfiguration.imqAddressList,
                                "mq://127.0.0.1:7676,mq://127.0.0.1:7676");

            Destination priceInfo= context.createTopic("PriceInfo");

            JMSProducer producer = context.createProducer();
            TextMessage outMsg = context.createTextMessage();
            outMsg.setText("{'symbol' : 'BTCUSD'" +
                            "'price' : 35478}");
            outMsg.setStringProperty("symbol", "BTCUSD");
            producer.send(priceInfo, outMsg);
            System.out.println("Placed an information about to PriceInfo");
        } catch (JMSException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
