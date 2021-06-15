package com.redhat.demo.servicemeshleaf1.controller;

import com.redhat.demo.servicemeshleaf1.restclient.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LeafController {

    private static AtomicLong callCount = new AtomicLong(0);

    @Autowired
    private ClientService clientService;

    @GetMapping("/leaf1")
    public String leaf1() {
        return new StringBuilder("leaf1")
                .append(", call Count: " + callCount.incrementAndGet())
                .toString();
    }

    @GetMapping("callleaf2")
    public String callLeaf2() {
        String response = clientService.callLeaf2();
        StringBuilder finalResponse = new StringBuilder(response).append("\n")
                .append("call count: " + callCount.incrementAndGet());
        return response;
    }
}
