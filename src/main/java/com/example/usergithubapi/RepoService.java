package com.example.usergithubapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

//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

public class RepoService {
    public static ArrayList<RepoToShow> getRepos(String username) throws IOException {
        

        ObjectMapper objectMapper=new ObjectMapper();
        ArrayList<Repo> repos=objectMapper.readValue(new URL("https://api.github.com/users/"+username+"/repos"), new TypeReference<>() {});
        ArrayList<Repo> reposToRemove=new ArrayList<>();
        ArrayList<RepoToShow> reposToShow=new ArrayList<>();
        for(Repo repo:repos){
            if(repo.fork){
                reposToRemove.add(repo);
            }
            ArrayList<Branch> branches=objectMapper.readValue(new URL("https://api.github.com/repos/marcinbator/" + repo.name.toLowerCase() + "/branches"), new TypeReference<>() {});
            repo.setBranches(branches);
        }
        repos.removeAll(reposToRemove);
        for(Repo repo:repos){
            reposToShow.add(new RepoToShow(repo.id, repo.name, repo.owner, repo.branches));
        }
        return reposToShow;
    }

    public static boolean ifUserExists(String username){
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.github.com/users/"+username+"/repos";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        assert responseBody != null;
        return !responseBody.equals("404");
    }
}
