package com.andrey.restapp.service.impl;

import com.andrey.restapp.model.File;
import com.andrey.restapp.repository.FileRepository;
import com.andrey.restapp.repository.hibernate.HibernateFileRepositoryImpl;
import com.andrey.restapp.service.FileService;

import java.util.List;

public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository = new HibernateFileRepositoryImpl();

    @Override
    public File getById(Long id) { return fileRepository.getById(id); }

    @Override
    public File create(File file) { return fileRepository.save(file); }

    @Override
    public List<File> getAll() { return fileRepository.getAll(); }

    @Override
    public File update(File file) { return fileRepository.update(file); }

    @Override
    public void delete(Long id) { fileRepository.deleteById(id); }
}
