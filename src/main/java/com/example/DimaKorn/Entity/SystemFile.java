package com.example.DimaKorn.Entity;


import lombok.Data;


public class SystemFile {
    private String name;
    private String content;

    public SystemFile() {
    }

    public SystemFile(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
