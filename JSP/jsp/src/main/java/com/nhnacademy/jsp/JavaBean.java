package com.nhnacademy.jsp;

import java.io.Serializable;

public class JavaBean implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
