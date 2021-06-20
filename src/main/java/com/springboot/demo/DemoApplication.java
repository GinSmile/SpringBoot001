package com.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan("com.springboot.demo.mapper")
public class DemoApplication {

    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        Environment env = new SpringApplication(DemoApplication.class).run(args).getEnvironment();
        String envPort = env.getProperty("server.port");
        String envContext = env.getProperty("server.contextPath");
        String port = envPort == null ? "8080" : envPort;
        String context = envContext == null ? "" : envContext;
        String activePath = env.getProperty("spring.profiles.active");

        String path = port + "" + context + "/" + activePath +"/doc.html";
        String externalAPI = InetAddress.getLocalHost().getHostAddress();
        logger.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local-API: \t\thttp://127.0.0.1:{}\n\t"
                        + "External-API: \thttp://{}:{}\n\t----------------------------------------------------------",
                path, externalAPI, path);
    }

}
