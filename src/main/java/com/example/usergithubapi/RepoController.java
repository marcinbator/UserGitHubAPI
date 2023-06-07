package com.example.usergithubapi;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RepoController {

    @GetMapping("/api/{username}")
    public ResponseEntity<?> getRepositoriesJson(@PathVariable String username) throws IOException {
        return ResponseEntity.ok(RepoService.getRepos(username));
    }
}
