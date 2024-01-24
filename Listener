import org.apache.commons.lang.exception.ExceptionUtils;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;



import utilities.JiraServiceProvider;
import utilities.JiraCreateIssue;


public class jiraTestListener implements ITestListener {


    @Override

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

        @Override

        public void onTestSkipped (ITestResult result){

            // TODO Auto-generated method stub


        }

        @Override

        public void onTestFailedButWithinSuccessPercentage (ITestResult result){

            // TODO Auto-generated method stub


        }

        @Override

        public void onStart (ITestContext context){

            // TODO Auto-generated method stub


        }


        @Override

        public void onFinish (ITestContext context){

            // TODO Auto-generated method stub


        }


        @Override

        public void onTestStart (ITestResult result){

            // TODO Auto-generated method stub


        }


        @Override

        public void onTestSuccess (ITestResult result){
            boolean islogIssue = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraCreateIssue.class).isCreateIssue();

            if (islogIssue) {

//Provide proper Jira project URL ex: https://browsertack.atlassian.net

//Jira User name ex: browserstack@gmail.com

//API token copy from Jira dashboard ex: lorelimpusm12uijk

//Project key should be, Short name ex: BS


                JiraServiceProvider JiraServiceProvider = new JiraServiceProvider("https://ilabpoc.atlassian.net/",

                        "daniel.goelz@ilabqa.com", "ATATT3xFfGF0b7hxrOUYZnJG8LI-1PrAKcmG6AaEob6HOo7i2zMjm1-WnscgusEwpeJ-JwW-coRjN4UfxAFWir_eIt6SenYzYC_V2oxrfukfRWoSKt5FXQIk8y0u5VxXZ4KP_SxqvSfuOrr06DBfMTSzMT78-WXo6RzsFs6itW9aa1L_vpFX7U4=BF9732CD", "JWXI");


                String issueDescription = "Sprint22"

                        + "\n";

                //issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));


                String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName()

                        + " Automation Testing Passed";


                JiraServiceProvider.createJiraIssue("test execution", issueSummary, issueDescription, "Automated Testing");

            }

        }
    }
