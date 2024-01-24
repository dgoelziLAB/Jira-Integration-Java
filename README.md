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
JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://ilabpoc.atlassian.net/","daniel.goelz@ilabqa.com", "ATATT3xFfGF0b7hxrOUYZnJG8LI-1PrAKcmG6AaEob6HOo7i2zMjm1-WnscgusEwpeJ-JwW-coRjN4UfxAFWir_eIt6SenYzYC_V2oxrfukfRWoSKt5FXQIk8y0u5VxXZ4KP_SxqvSfuOrr06DBfMTSzMT78-WXo6RzsFs6itW9aa1L_vpFX7U4=BF9732CD", "JWXI");
```


## Installation

Include instructions on how to install and set up your project. This may include dependencies, environment setup, or any other relevant steps.
