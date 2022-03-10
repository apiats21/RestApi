package com.andrey.restapp.service;

import com.andrey.restapp.model.File;

import java.util.List;

public interface FileService {
    public File getById(Long id);

    public File create(File file);

    public List<File> getAll();

    public  File update(File file);

    public void delete(Long id);
}
