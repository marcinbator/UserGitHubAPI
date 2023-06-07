package com.example.usergithubapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
        if (acceptHeader.equals("application/json")){
            return ResponseEntity.ok(RepoService.getRepos(username));
        }
        if (acceptHeader.equals("application/xml")) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(createErrorResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Unsupported media type: application/xml."));
        }
        if (!RepoService.ifUserExists(username)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createErrorResponse(HttpStatus.NOT_FOUND.value(), "User not found."));
        }
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(createErrorResponse(HttpStatus.REQUEST_TIMEOUT.value(), "Request timeout."));
    }

    private Map<String, String> createErrorResponse(int responseCode, String errorMessage) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("status", String.valueOf(responseCode));
        errorResponse.put("Message", errorMessage);
        return errorResponse;
    }
}
