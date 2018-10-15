package com.exb.client.fileserviceclient.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.exb.client.fileserviceclient.service",
        "com.exb.client.fileserviceclient.config"
})
public class FileServiceConfig {

}
