package com.example.demo.web.todo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoForm {
    private Integer id;
    private String title;
    private String details;
    private boolean finished;
}
