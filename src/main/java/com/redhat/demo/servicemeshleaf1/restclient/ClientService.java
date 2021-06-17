package com.redhat.demo.servicemeshleaf1.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Value("${leaf2.hostname}")
    private String leaf2Hostname;

    @Value("${leaf2.portnum}")
    private String leaf2Port;

    private String path = "/leaf2";

    @Autowired
    private RestTemplate restTemplate;


    public String callLeaf2() {
        String url = "http://" + leaf2Hostname + ":" + leaf2Port + path;
        System.out.println(url);
//        Span leaf2Span = tracer.buildSpan("leaf1leaf2").withTag("leaf2", 1).start();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//        leaf2Span.finish();
        return response.getBody();
    }
}
