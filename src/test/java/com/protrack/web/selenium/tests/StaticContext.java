package com.protrack.web.selenium.tests;

public class StaticContext {

    static String projectTitle;
    static String contactTitle;

    public static String getProjectTitle() {
        return projectTitle;
    }

    public static void setProjectTitle(String projectTitle) {
        StaticContext.projectTitle = projectTitle;
    }
    public static String getContactTitle() {
        return projectTitle;
    }
    public static void setContactTitle(String contactTitle) {
        StaticContext.contactTitle = contactTitle;
    }

}
