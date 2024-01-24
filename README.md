# Jira/xRAY-Integration-Java 

This repo will serve as the installation documentation for the process of integrating the iLAB Java Selenium Framework with Jira/xRAY.

## Table of Contents

- [Jira/xRAY-Integration-Java ](#project-title)
  - [Table of Contents](#table-of-contents)
  - [Description](#description)
  - [Files](#files)
  - [Updates](#updates)
  - [Installation](#installation)

## Description

 It gives the framework the ability to create Jira issues following automated test executions. Currently it can create Bug and Execution issue types. For Bug's it will send the stack trace and depenedning on how the script was crafted where it failed. Currently for Executions it will just create a blank issue to have data to be filled in later. 

 ## Files

  ### Listener
  This file contains two import parts of the integration process. The first one is that it will grab the itestresults after the test is executed and depeneding on the results it will tell the "JiraCreateIssue" file which issue to create. The second is the fact that the Jira instance information is stored here. The infromation is used by the api in order to comunicate with the jira instance. 

  Below are some kep points of the code
  
  

  ```java
public void onTestFailure(ITestResult result) {

        boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();

        if (islogIssue) {

//Provide proper Jira project URL ex: https://browsertack.atlassian.net

//Jira User name ex: fakeEmail@gmail.com

//API token copy from Jira dashboard ex: lorelimpusm12uijk

//Project key should be, Short name ex: BS


            JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://ilabpoc.atlassian.net/",

                    "daniel.goelz@ilabqa.com", "ATATT3xFfGF0UynvxwOvFLyajAx1rvBGr0Halvl322kururv5dMKDCT6dt1dCFui8H5-gePjnr8PD3b_cyjm5FIj3SJ50CAkE-OFmCG3gBCsyYIvAakTad86FiWP_5b0D1gj-ixWxtmWVFL67u7cl3wwsrjPzu-iWZ_4XjeJYylIqDCmasdHThQ=FBE5D8DA", "JWXI");



            String issueDescription = "Failure Reason from Automation Testing\n\n" + result.getThrowable().getMessage()

                    + "\n";

            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));




            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

                    + " Failed in Automation Testing";



            JiraServiceProvider.createJiraIssue("Bug", issueSummary, issueDescription, "Automated Testing");

        }

    }

```
The code snippet above is where you add your own instance data and API token.

### JiraCreateIssue
Uses Annotations to allow it to be accessable during runtime, sourecode and class files.

```java
@Retention(RetentionPolicy.RUNTIME)

    public @interface JiraCreateIssue {

        boolean isCreateIssue();

    }

```

###JiraServiceProvider
A class for interacting with the Jira API to create new issues.

- **Dependencies:** `net.rcarz.jiraclient` library








## Installation

Include instructions on how to install and set up your project. This may include dependencies, environment setup, or any other relevant steps.
