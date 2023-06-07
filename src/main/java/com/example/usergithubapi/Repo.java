package com.example.usergithubapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repo {
    int id;
    String name;
    boolean fork;
    Owner owner;
    ArrayList<Branch> branches;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Owner {
    String login;
}
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Branch {
    String name;
    Commit commit;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Commit{
    String sha;
}
