package com.vaadin.flow.demo.helloworld;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Job {
    FIGHTER("Warrior"),
    BLACK_BELT("Monk"),
    THIEF("Thief"),
    RED_MAGE("Red Mage"),
    WHITE_MAGE("White Mage"),
    BLACK_MAGE("Black Mage");

    private final String description;

    private Job(String description) {
        this.description = description;
    }

    private static final List<Job> VALUES =
        Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Job randomJob()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public String toString() {
        return this.description;
    }

}
