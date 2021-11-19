package com.charmander.restsoapclient;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

    public class SoapClient extends WebServiceGatewaySupport {
        public GetStateResponseType getState(String url, Object request) {
            JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
            return (GetStateResponseType) res.getValue();
        }
    }
}
