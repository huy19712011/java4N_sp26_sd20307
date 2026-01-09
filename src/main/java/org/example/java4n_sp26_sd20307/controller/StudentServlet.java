package org.example.java4n_sp26_sd20307.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.java4n_sp26_sd20307.entity.Student;
import org.example.java4n_sp26_sd20307.service.StudentService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = {
        "/students"
})
public class StudentServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/students":
                listStudents(request, response);
                break;
        }
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // data
        List<Student> students = new ArrayList<>();
        students = studentService.getStudents();

        // send data to jsp
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}