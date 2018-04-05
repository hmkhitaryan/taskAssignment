package com.egs.enums;

/**
 * @author Hayk_Mkhitaryan
 */
public enum Severity {
    MAJOR("major"),
    MINOR("minor");

    private String name;

    Severity(String name) {
        this.name = name;
    }

}
