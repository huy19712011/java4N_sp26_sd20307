package org.example.java4n_sp26_sd20307.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.java4n_sp26_sd20307.entity.Student;

import java.util.List;

public class StudentRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    private EntityManager em = emf.createEntityManager();

    public List<Student> getStudents() {

        return em.createQuery("select s from Student s", Student.class).getResultList();
    }
}
