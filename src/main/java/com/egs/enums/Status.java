package com.egs.enums;

/**
 * @author Hayk_Mkhitaryan
 */
public enum Status {
    CREATED("created"),
    OPENED("opened"),
    RESOLVED("resolved");

    private String name;

    Status(String name) {
        this.name = name;
    }

}
