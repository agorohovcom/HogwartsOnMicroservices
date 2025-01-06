package com.agorohov.hgwrts.studentmanagement.dto;

import java.util.Objects;

public class StudentDto {

    private Long id;
    private String name;
    private String faculty;

    public StudentDto(Long id, String name, String faculty) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
    }

    public StudentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
