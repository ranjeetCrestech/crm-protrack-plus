package com.protrack.web.selenium.tests;

public class StaticContext {

    static String projectTitle;

    public static String getProjectTitle() {
        return projectTitle;
    }

    public static void setProjectTitle(String projectTitle) {
        StaticContext.projectTitle = projectTitle;
    }



}
