package com.silah.projecthub.entities;

public enum ProjectCategory {
    FRONTEND("Frontend"),
    BACKEND("Backend"),
    FULLSTACK("Fullstack"),
    MOBILE("Mobile"),
    OTHER("Other");

    private final String category;

    ProjectCategory(String category) {
        this.category = category;
    }
}
