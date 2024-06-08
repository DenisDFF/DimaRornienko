package com.example.DimaKorn.Dao;

import com.example.DimaKorn.Entity.SystemFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SystemFileDaoImpl implements SystemFileDao {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String directoryPath = ".";

    @Override
    public void save(SystemFile systemFile) throws IOException {
        File file = new File(directoryPath, systemFile.getName() + ".json");
        objectMapper.writeValue(file, systemFile);
    }

    @Override
    public void delete(String name) {
        File file = new File(directoryPath, name + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    public List<SystemFile> findAll() throws IOException {
        File directory = new File(directoryPath);
        List<SystemFile> systemFiles = new ArrayList<>();

        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".json")) {
                SystemFile systemFile = objectMapper.readValue(file, SystemFile.class);
                systemFiles.add(systemFile);
            }
        }
        return systemFiles;
    }

    @Override
    public void update(SystemFile systemFile) throws IOException {
        File file = new File(directoryPath, systemFile.getName() + ".json");
        if (file.exists()) {
            objectMapper.writeValue(file, systemFile);
        } else {
            throw new FileNotFoundException("File not found: " + systemFile.getName());
        }
    }
}
