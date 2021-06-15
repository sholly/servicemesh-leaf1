package com.redhat.demo.servicemeshleaf1.controller;

import com.redhat.demo.servicemeshleaf1.restclient.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeafController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/leaf1")
    public String leaf1() {
        return "leaf1";
    }

    @GetMapping("callleaf2")
    public String callLeaf2() {
        String response = clientService.callLeaf2();
        return response;
    }
}
