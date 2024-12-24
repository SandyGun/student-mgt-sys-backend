package com.management.student.controller;

import com.management.student.dto.StudentDTO;
import com.management.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(
            value = "/student/createStudent",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentdto) throws Exception {
        StudentDTO studentDTO = studentService.saveStudent(studentdto);
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/student/getAllStudents",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<StudentDTO>> getAllStudents() throws Exception {
        List<StudentDTO> studentDTOS = studentService.getAllStudents();
        return new ResponseEntity<List<StudentDTO>>(studentDTOS, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/student/updateStudent",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentdto) throws Exception {
        StudentDTO studentDTO = studentService.updateStudent(studentdto);
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/student/deleteStudent/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDTO> deleteStudent(@PathVariable("id") Integer id) throws Exception {
        StudentDTO studentDTO = studentService.deleteStudent(id);
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }


    @RequestMapping(
            value = "/student/getStudent/{indexNo}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<StudentDTO> getStudent(@PathVariable String indexNo) throws Exception {
        StudentDTO studentDTO = studentService.getStudent(indexNo);
        return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
    }

}
