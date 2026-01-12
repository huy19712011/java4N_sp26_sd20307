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
        "/students",
        "/students/new",
        "/students/insert"
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
            case "/students/new":
                showNewForm(request, response);
                break;
            case "/students/insert":
                insertStudent(request, response);
                break;
        }
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read student info from form
        Student student = getStudentFromForm(request);

        // save student to DB
        studentService.addStudent(student);

        // show table
        response.sendRedirect("/students");
    }

    private Student getStudentFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        return new Student(id, name, email, phone);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher("/view/addStudentForm.jsp")
                .forward(request, response);

    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // data
        //List<Student> students = new ArrayList<>();
        List<Student> students = studentService.getStudents();

        // send data to jsp
        request.setAttribute("students", students);
        request.getRequestDispatcher("/view/studentList.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}