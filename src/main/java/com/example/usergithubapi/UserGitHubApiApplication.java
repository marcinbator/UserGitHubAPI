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

    public static void main(String[] args) throws IOException {
        String username="marcinbator".toLowerCase();
        SpringApplication.run(UserGitHubApiApplication.class, args);
        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<Repo> repos=objectMapper.readValue(new URL("https://api.github.com/users/"+username+"/repos"), new TypeReference<>() {});
        for(Repo repo:repos){
            ArrayList<Branch> branches=objectMapper.readValue(new URL("https://api.github.com/repos/marcinbator/" + repo.name.toLowerCase() + "/branches"), new TypeReference<>() {
            });
            repo.setBranches(branches);
        }
        System.out.println(repos);
    }
}
