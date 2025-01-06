package com.agorohov.hgwrts.studentmanagement.repository;

import com.agorohov.hgwrts.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT COUNT(s) > 0 FROM Student s WHERE s.name = :name")
    boolean existsByName(@Param("name") String name);
}
