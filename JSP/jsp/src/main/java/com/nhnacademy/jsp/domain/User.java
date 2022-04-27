package com.nhnacademy.jsp.domain;

import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private String name;
    private int age;
}
