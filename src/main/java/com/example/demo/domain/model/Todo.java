package com.example.demo.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private int id;
    private String title;
    private String details;
    private boolean finished;
}
