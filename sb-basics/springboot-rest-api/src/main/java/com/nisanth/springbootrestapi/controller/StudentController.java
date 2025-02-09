package com.nisanth.springbootrestapi.controller;

import com.nisanth.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent()
    {
        Student student=new Student(1,"Nisanth","Selvaraj");
        return  student;
    }


    @GetMapping("students")
    public List<Student> getStudents()
    {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Nisanth","Selvaraj"));
        students.add(new Student(2,"Knisha","T"));
        students.add(new Student(3,"Preethika","P"));

        return students;
    }


    // Spring Boot REST API with path varibale

    // http://localhost:8080/students/10
    @GetMapping("students/{id}")
    public Student studentpathBaribale(@PathVariable int id)
    {
        return new Student(id,"Nisanth","Selvaraj");
    }


    // REST API with Request Param
    // http://localhost:8080/students/query?id=19&firstName=Kanisha&lastName=T
    @GetMapping("students/query")
    public Student studentRequesVariable(@RequestParam int id,
                                        @RequestParam String firstName,
                                         @RequestParam String lastName
                                         )
    {
        return new Student(id,firstName,lastName);
    }

    // REST API that handles Post Request
    // @PostMapping and @ReequestBody

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // REST API that handles Put Request
    // @PutMapping and @ReequestBody

    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentid)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }

    // REST API that handles Delete Request
    // @PutMapping and @ReequestBody

    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId)
    {
        System.out.println(studentId);
        return "student deleted successfully";
    }


    
}
