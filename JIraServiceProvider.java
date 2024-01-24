public void createJiraIssue(String issueType, String summary, String description, String reporterName) {




            try {

                //Avoid Creating Duplicate Issue
                Date currentTime = new Date();

                Issue.SearchResult sr = Jira.searchIssues("summary ~ \""+summary+ currentTime+"\"");

                if(sr.total!=0) {

                    System.out.println("Same Issue Already Exists on Jira");

                    return;

                }



                //Create issue if not exists

                FluentCreate fleuntCreate = Jira.createIssue(project, issueType);

                fleuntCreate.field(Field.SUMMARY, summary);

                fleuntCreate.field(Field.DESCRIPTION, description);

                Issue newIssue = fleuntCreate.execute();

                System.out.println("********************************************");

                System.out.println("New issue created in Jira with ID: " + newIssue);

                System.out.println("New issue URL is :"+JiraUrl+"/browse/"+newIssue);

                System.out.println("*******************************************");

            } catch (JiraException e) {

                e.printStackTrace();

            }

        }

    }
