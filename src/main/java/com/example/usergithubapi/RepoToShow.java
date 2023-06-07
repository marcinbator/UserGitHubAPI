package com.example.usergithubapi;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;

@AllArgsConstructor
@Data
public class RepoToShow{
    int id;
    String name;
    Owner owner;
    ArrayList<Branch> branches;
}