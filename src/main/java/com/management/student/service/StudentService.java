package com.management.student.service;

import com.management.student.dto.StudentDTO;
import com.management.student.model.Student;
import com.management.student.repository.StudentRepository;
import com.management.student.util.StudentMgtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentDTO saveStudent(StudentDTO studentDTO) {

        try {
            Student student = new Student();

            student.setId(studentDTO.getId());
            student.setIndex(studentDTO.getIndex());
            student.setName(studentDTO.getName());
            student.setDob(studentDTO.getDob());
            student.setGpa(studentDTO.getGpa());

            studentRepository.save(student);

        } catch (Exception e) {
            throw new StudentMgtException(e.getMessage());
        }

        return studentDTO;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setIndex(student.getIndex());
            studentDTO.setName(student.getName());
            studentDTO.setDob(student.getDob());
            studentDTO.setGpa(student.getGpa());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    public StudentDTO updateStudent(StudentDTO studentDTO) {

        try {
            Student student = studentRepository.findById(studentDTO.getId()).get();
            student.setIndex(studentDTO.getIndex());
            student.setName(studentDTO.getName());
            student.setDob(studentDTO.getDob());
            student.setGpa(studentDTO.getGpa());

            studentRepository.save(student);

        } catch (Exception e) {
            throw new StudentMgtException(e.getMessage());
        }

        return studentDTO;
    }

    public StudentDTO deleteStudent(Integer id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.deleteById(id);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setIndex(student.getIndex());
        studentDTO.setName(student.getName());
        studentDTO.setDob(student.getDob());
        studentDTO.setGpa(student.getGpa());
        return studentDTO;
    }

    public StudentDTO getStudent(String indexNo) {
        Student student = studentRepository.findStudentByIndexNo(indexNo);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setIndex(student.getIndex());
        studentDTO.setName(student.getName());
        studentDTO.setDob(student.getDob());
        studentDTO.setGpa(student.getGpa());
        return studentDTO;
    }
}
