package com.geekbrains.service;

import com.geekbrains.entites.Student;
import com.geekbrains.repositories.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    private StudentsRepository studentsRepository;

    @Autowired
    public void setStudentsRepository(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public Student getStudentById(int id) {
        return studentsRepository.findOneById(id);
    }

    public StudentsService() {

    }
}