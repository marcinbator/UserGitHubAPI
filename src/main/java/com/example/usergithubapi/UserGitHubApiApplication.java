package com.example.usergithubapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@SpringBootApplication
public class UserGitHubApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserGitHubApiApplication.class, args);
    }
}
