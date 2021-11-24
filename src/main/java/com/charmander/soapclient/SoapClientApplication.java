package com.charmander.soapclient;

import com.charmander.soapclient.client.SoapClient;
import com.charmander.soapclient.personinfo.Acknowledgement;
import com.charmander.soapclient.personinfo.PersonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SoapClientApplication {

    @Autowired
    private SoapClient client;

    @PostMapping("/getPersonStatus")
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody PersonRequest request) {
        return client.getPersonStatus(request);
    }


    public static void main(String[] args) {
        SpringApplication.run(SoapClientApplication.class, args);
    }

}
