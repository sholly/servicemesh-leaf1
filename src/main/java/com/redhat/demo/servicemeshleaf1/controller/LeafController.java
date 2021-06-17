package com.redhat.demo.servicemeshleaf1.controller;

import com.redhat.demo.servicemeshleaf1.restclient.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class LeafController {

    private static AtomicLong callCount = new AtomicLong(0);

    @Autowired
    private ClientService clientService;

    @GetMapping("/leaf1")
    public String leaf1() throws InterruptedException {
        Random rand = new Random();
        callCount.incrementAndGet();
        int sleep = rand.nextInt();
        if(sleep > 0)
            Thread.sleep(2000);

        System.out.println("leaf1 v10, count: " + callCount.get());
        return new StringBuilder("leaf1 version1.0 : ")
                .append(callCount.get())
                .toString();
    }

    @GetMapping("/callleaf2")
    public String callLeaf2() {
        String response = clientService.callLeaf2();
        StringBuilder finalResponse = new StringBuilder("leaf1 ")
                .append(callCount.incrementAndGet())
                .append(" -> ")
                .append(response);
        return finalResponse.toString();
    }
}
