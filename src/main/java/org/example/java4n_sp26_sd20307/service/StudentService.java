package org.example.java4n_sp26_sd20307.service;

import org.example.java4n_sp26_sd20307.entity.Student;
import org.example.java4n_sp26_sd20307.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public List<Student> getStudents() {

        return studentRepository.getStudents();
    }
}
