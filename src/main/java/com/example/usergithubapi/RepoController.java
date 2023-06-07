package com.example.usergithubapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RepoController {

    @GetMapping("/api/{username}")
    public ResponseEntity<?> getRepositoriesJson(@RequestHeader(HttpHeaders.ACCEPT) String acceptHeader, @PathVariable String username) throws IOException {
//        if(acceptHeader.equals(MediaType.APPLICATION_JSON_VALUE)){
//            System.out.println("json");
//            if(RepoService.ifUserExists(username)){
//                System.out.println("exists");
//                return ResponseEntity.ok(RepoService.getRepos(username));
//            }
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(HttpStatus.NOT_FOUND.value(), "User not found"));
//        }
//        if(acceptHeader.equals(MediaType.APPLICATION_XML_VALUE)){
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(createErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), "XML not supported."));
//        }
//        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(createErrorResponse(HttpStatus.REQUEST_TIMEOUT.value(), "Connection failed - GitHub API rate exceeded."));
        return ResponseEntity.ok(RepoService.getRepos(username));
    }

    private Map<String, Object> createErrorResponse(int status, String message) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("Message", message);
        errorResponse.put("status", status);
        return errorResponse;
    }
}
