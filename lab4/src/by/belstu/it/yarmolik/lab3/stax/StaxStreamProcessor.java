package by.belstu.it.yarmolik.lab3.stax;

import by.belstu.it.yarmolik.lab3.account.Account;
import by.belstu.it.yarmolik.lab3.account.TypeCard;
import by.belstu.it.yarmolik.lab3.сontrol.Admin;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public StaxStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == stopEvent && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT &&
                    parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT &&
                    element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
    }
    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }

    public static void  xmlParse(Admin admin) throws IOException, XMLStreamException {
        try (StaxStreamProcessor processor = new StaxStreamProcessor(Files.newInputStream(Path.of("files/accounts.xml")))) {
            XMLStreamReader reader = processor.getReader();
            while (processor.startElement("Account", "Accounts")) {
                while (processor.startElement("number", "Account")) {
                    int numberAcc = Integer.parseInt(processor.getText());
                    admin.addAccount(new Account(numberAcc));
                    while (processor.startElement("Card", "Cards")) {
                        while (processor.startElement("number", "Card")) {
                            int numberCard = Integer.parseInt(processor.getText());
                            while (processor.startElement("type", "Card")) {
                                TypeCard typeCard = processor.getText().equals("credit") ? TypeCard.CREDIT : TypeCard.DEBIT;
                                admin.addCard(admin.findAccount(numberAcc), numberCard, typeCard);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}


