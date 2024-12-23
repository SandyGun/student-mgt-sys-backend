package com.management.student.repository;

import com.management.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT student FROM Student as student WHERE student.index =:indexNo")
    Student findStudentByIndexNo(@Param("indexNo") String indexNo);
}
