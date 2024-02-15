package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String name;
    private String description;
    private Boolean status;
}

