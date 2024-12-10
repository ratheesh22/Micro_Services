package com.cognizant.config_client.controller;

import com.cognizant.config_client.LimitsServiceProperiesConfiguration;
import com.cognizant.config_client.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    LimitsServiceProperiesConfiguration config;

    @GetMapping("/limits")
    public Limits getLimits(){


        return new Limits(config.getMinimum(),config.getMaximum(), config.getProfileName());
    }

}
