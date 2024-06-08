package com.example.DimaKorn.Dao;

import com.example.DimaKorn.Entity.SystemFile;

import java.io.IOException;
import java.util.List;

public interface SystemFileDao {
    void save(SystemFile systemFile) throws IOException;
    void delete(String name);
    List<SystemFile> findAll() throws IOException;
    void update(SystemFile systemFile) throws IOException;
}
