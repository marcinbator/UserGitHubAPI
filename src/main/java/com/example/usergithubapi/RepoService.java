package com.example.usergithubapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class RepoService {
    public static ArrayList<Repository> getRepos(String username) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<ReceivedRepo> receivedRepos = objectMapper.readValue(new URL("https://api.github.com/users/"+username+"/repos"), new TypeReference<>() {});
        List<ReceivedRepo> filteredReceivedRepos = receivedRepos.stream().filter(repo-> !repo.isFork()).toList();
        ArrayList<Repository> reposToShow = new ArrayList<>();
        for(ReceivedRepo repo:filteredReceivedRepos){
            ArrayList<Branch> branches = objectMapper.readValue(new URL("https://api.github.com/repos/marcinbator/" + repo.getName().toLowerCase() + "/branches"), new TypeReference<>() {});
            repo.setBranches(branches);
            reposToShow.add(new Repository(repo.getId(), repo.getName(), repo.getOwner(), repo.getBranches()));
        }
        return reposToShow;
    }

    public static boolean ifUserExists(String username){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/"+username+"/repos";
        try{
            restTemplate.getForEntity(url, String.class);
        }
        catch(Exception e){
            return false;

        }
        return true;
    }
}
