package utilities;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;


    //JiraCreateIssue.java





    @Retention(RetentionPolicy.RUNTIME)

    public @interface JiraCreateIssue {

        boolean isCreateIssue();

    }


