package com.agorohov.hgwrts.facultyassigner.dto.enums;

import java.util.Random;

public enum Faculties {
    GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN;

    public static Faculties getRandomFaculty() {
        Random random = new Random();
        Faculties[] faculties = Faculties.values();
        return faculties[random.nextInt(faculties.length)];
    }
}