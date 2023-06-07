package com.example.usergithubapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RepoService {
    public static ArrayList<Repo> getRepos(String username) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<Repo> repos=objectMapper.readValue(new URL("https://api.github.com/users/"+username+"/repos"), new TypeReference<>() {});
        for(Repo repo:repos){
            ArrayList<Branch> branches=objectMapper.readValue(new URL("https://api.github.com/repos/marcinbator/" + repo.name.toLowerCase() + "/branches"), new TypeReference<>() {});
            repo.setBranches(branches);
        }
        return repos;
    }
}
