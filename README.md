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
  
  The `Listener` class is a TestNG listener designed to integrate with Jira for logging test results. It creates Jira issues based on annotations for test failures and successes.

  
  

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
Be sure to add your JIra Instance info to this file

### JiraCreateIssue

Uses Annotations to allow it to be accessable during runtime, sourecode and class files.

```java
@Retention(RetentionPolicy.RUNTIME)

    public @interface JiraCreateIssue {

        boolean isCreateIssue();

    }

```

### JiraServiceProvider

A class for interacting with the Jira API to create new issues.

- **Dependencies:** `net.rcarz.jiraclient` library


```java
private JiraClient Jira;

        private String project;

        private String JiraUrl;

        public JiraServiceProvider(String JiraUrl, String username, String password, String project) {

            this.JiraUrl=JiraUrl;

            // create basic authentication object

            BasicCredentials creds = new BasicCredentials(username, password);

            // initialize the Jira client with the url and the credentials

            Jira = new JiraClient(JiraUrl, creds);

            this.project = project;

        }


```
Starts the connection to the Jira Instance


```java
public void createJiraIssue(String issueType, String summary, String description, String reporterName) {




            try {

                //Avoid Creating Duplicate Issue
                Date currentTime = new Date();

                Issue.SearchResult sr = Jira.searchIssues("summary ~ \""+summary+ currentTime+"\"");

                if(sr.total!=0) {

                    System.out.println("Same Issue Already Exists on Jira");

                    return;

                }
```
Code was added to the method above in oprder to reduce the manual interactions that are needed between runs. It currently looks for the current time attached to the issue summary


## Updates 
  Few updates being worked on
    * getting screen shots and HTML report attached to Execution Issue
    * add more scenarios where issues are crated 





## Installation

Include instructions on how to install and set up your project. This may include dependencies, environment setup, or any other relevant steps.

### Test File Changes

```java
import org.testng.annotations.Test;
import utilities.JiraCreateIssue;


import java.time.Duration;


public class mk1 extends BaseTest {

    @JiraCreateIssue(isCreateIssue=true)
    @Test
    public void Test_mk1() {
```

Make sure to add the anotation `@JiraCreateIssue(isCreateIssue=true)`and `@Test` to each of your tests. 

### Pom file changes

  ```xml
<dependency>
      <groupId>net.rcarz</groupId>
      <artifactId>jira-client</artifactId>
      <version>0.5</version>
    </dependency>
```


###Runtime

Make sure to add the listeners to the runtime configurations in inteliji teh process will look similar to below.

<img width="948" alt="image" src="https://github.com/iLABQA/Jira-Integration-Java/assets/48806193/9d742423-4d7a-4fc7-9800-347435b03060">

select edit configurations 
<img width="97" alt="image" src="https://github.com/iLABQA/Jira-Integration-Java/assets/48806193/2868752f-d124-4120-a29e-02b5cde30963">

pick your test file
<img width="519" alt="image" src="https://github.com/iLABQA/Jira-Integration-Java/assets/48806193/f8f822bf-4a7e-4629-a85d-cd7f770e289b">

Select listeners
<img width="519" alt="image" src="https://github.com/iLABQA/Jira-Integration-Java/assets/48806193/8af8e1a3-889c-41b4-9e8e-7de9aae93990">

Add all listeners
<img width="515" alt="image" src="https://github.com/iLABQA/Jira-Integration-Java/assets/48806193/577ea805-73f6-4613-b6d4-c0db2d0829ef">






