package com.tairovich.spring.soap.api.loaneligibility.api.endpoint;

import com.tairovich.spring.soap.api.loaneligibility.Acknowledgement;
import com.tairovich.spring.soap.api.loaneligibility.CustomerRequest;
import com.tairovich.spring.soap.api.loaneligibility.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityIndicatorEndpoint {

    private static final String NAME_SPACE = "http://www.tairovich.com/spring/soap/api/loanEligibility";

    @Autowired
    private LoanEligibilityService service;

    @PayloadRoot(namespace = NAME_SPACE, localPart = "CustomerRequest")
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return service.checkLoanEligibility(request);
    }

}
