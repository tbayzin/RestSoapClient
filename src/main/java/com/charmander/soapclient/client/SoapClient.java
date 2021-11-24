package com.charmander.soapclient.client;

import com.charmander.soapclient.personinfo.Acknowledgement;
import com.charmander.soapclient.personinfo.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    @Autowired
    private Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Acknowledgement getPersonStatus(PersonRequest request) {
        template = new WebServiceTemplate(marshaller);
        Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws",
                request);
        return acknowledgement;
    }

}
