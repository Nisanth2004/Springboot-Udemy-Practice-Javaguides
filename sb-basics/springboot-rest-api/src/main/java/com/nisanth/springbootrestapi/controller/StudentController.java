package com.nisanth.springbootrestapi.controller;

import com.nisanth.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent()
    {
        Student student=new Student(1,"Nisanth","Selvaraj");
       //return  new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","nisanth")
                .body(student);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getStudents()
    {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Nisanth","Selvaraj"));
        students.add(new Student(2,"Knisha","T"));
        students.add(new Student(3,"Preethika","P"));

        return ResponseEntity.ok(students);
    }


    // Spring Boot REST API with path varibale

    // http://localhost:8080/students/10
    @GetMapping("{id}")
    public ResponseEntity<Student> studentpathBaribale(@PathVariable int id)
    {
       Student student=new  Student(id,"Nisanth","Selvaraj");
       return ResponseEntity.ok(student);
    }


    // REST API with Request Param
    // http://localhost:8080/students/query?id=19&firstName=Kanisha&lastName=T
    @GetMapping("query")
    public ResponseEntity<Student> studentRequesVariable(@RequestParam int id,
                                        @RequestParam String firstName,
                                         @RequestParam String lastName
                                         )
    {
       Student student= new Student(id,firstName,lastName);
       return ResponseEntity.ok(student);
    }

    // REST API that handles Post Request
    // @PostMapping and @ReequestBody

    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    // REST API that handles Put Request
    // @PutMapping and @ReequestBody

    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentid)
    {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return ResponseEntity.ok(student);
    }

    // REST API that handles Delete Request
    // @PutMapping and @ReequestBody

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId)
    {
        System.out.println(studentId);
        return ResponseEntity.ok("student deleted successfully");
    }


    
}
