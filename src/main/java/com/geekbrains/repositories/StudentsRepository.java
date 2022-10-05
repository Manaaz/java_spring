package com.geekbrains.repositories;

import com.geekbrains.entites.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentsRepository {

    public Student findOneById(int id) {
        Student student = new Student();
        student.setFirstName("Ivan " + id);
        student.setLastName("Ivanov " + id);
        return student;
    }
}
