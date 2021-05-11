# Unit testing and Test-Driven-Development
![TDD image ](https://marsner.com/wp-content/uploads/test-driven-development-TDD.png)

#### Approach to TDD
 1. Write a test
 2. Confirm that the test fails
 3.  Write code to pass the test
 4. Confirm test passes
 5. Refactor code 
 6.  Repeat
 

I used these steps to write the tests in the software component. This [commit] [tdd_example_commit] shows how th test was written and would fail in the beginning, as the getAverageOfSpecificCriteria() method body is initially empty. I wrote a test to validate when a value that is null or doesn't exist is passed in the parameter (which can be seen in the previous commit) which passed when "Criterion not found!" was returned.

I then wrote another test to test the standard deviation which failed as there was no code to calculate the standard devviation. I then wrote the code to calculate the standard deviation. I had some errors along the way with recurrinf failing tests but used the test results to my advantage to solve the problem and write code that passed the test. I used this approach for every test in the project. 



[tdd_example_commit]: <https://github.com/niallmurphy1/DemonstratingSoftwareQuality/commit/5d539fc6ae23820d0c7fd04f5f01e1700d490def>


# Scrum Sprint backlog and Task Estimation


![Scrum image ](https://thumbs.dreamstime.com/b/agile-methodology-scrum-master-software-development-concept-miniature-people-team-members-working-cube-block-173188256.jpg)

## Task estimation Table
| Task ID  | Product Backlog Item|  Owner | Worst case |Most likely | Best case|
| :---:| :---:| :---: |:----:|:----: |:----:|
| 1 | Preview tasks, set up repo | Niall Murphy |1 | 1| 1|
| 2 | Create Java objects| Niall Murphy|2 | 1| 1|
| 3 |Create 'Controller' class| Niall Murphy|8 | 5| 4|
| 4 | Implement summary calculations for rubrics|Niall Murphy|3 | 2| 1|
| 5 | Test final system, tidy up code| Niall Murphy |2 | 1| 1|



## 4 Step Task Estimation Process
1.  **Identify and document tasks**
2.  **Order which tasks to be completed first**
3.  **Assign tasks to their appropriate employees**
4.  **Estimate time for tasks using methods below**

Along with these 4 steps, a few more techniques were used to estimate the time of each task:

- **Three-point estimation**
    This process is what you see in the tables, estimating three different possible time outcomes for the tasks, best case scenario, worst case scenario and most likely scenario. This allows for more room for unexpected errors and for less uncertainty. This is useful for big projects as there is more possibility of delays with more tasks to be completed.

- **Bottom-up estimating**
   This was used fopr the task requirement of the Controller class, bar it's mathematical methods, as this was considered another large task. The Controller class was definitely going to be a very large part of the software, so it felt necessary to break it down to estimate a more accurate time for it. Below is the table used for the Controller class task estimation.

| Task ID  | Product Backlog Item|  Owner | Worst case |Most likely | Best case|
| :---:| :---:| :---: |:----:|:----: |:----:|
| 1 | Create new rubric | Niall Murphy |1 | <1| 1|
| 2 | Add criterion to rubric| Niall Murphy|2 | 1| 1|
| 3 |Get list of all rubrics | Niall Murphy| 1 | <1| <1|
| 4 | get specific rubric by name |Niall Murphy|1 | <1| <1|
| 5 | Create new StudentGrade| Niall Murphy |2 | 1| 1|
| 6 | Get student grades by rubric| Niall Murphy |1 | 1| 1|


- **comparative estimating** 
    Comparative testing was also used in the task estimation process. This was decided due to the fact that many tasks similar to those in the requirements had been done before by thr team, so they had a good idea of how long each one would take relative to each other.
    
  ### _Calculating Velocity_
    At the start of each Sprint, the Velocity from the last Sprint is calculated by adding up the estimates of the backlog items that were completed in the last iteration. 
    
    ### _How does this calculation feed into the next Sprint_
    Let's say the team have completed 4 sprints before this, of which they used the same methods for Task estimation and completion. They would get the velocities of each of these Sprints eg. 12, 14, 15, 15. They add all these up ad divide by the number of Sprints: `54 / 4=  14`. The team now know that they should aim for 14 task estimation points for each Sprint. This calculation may seem quite simple but it is extremely helpful to teams tackling new projects and starting new Sprints.


# Code Review

![Code Review](https://www.bounteous.com/sites/default/files/insights/2019-06/previews/20190606_blog_code_review_limbo-_how_low_should_you_go_website.png)
## _What is Code Review?_
Code review is a software quality assurance activity where source code is viewed and assessed by one or several people. Code reviews occur when there is a completion of a software develeopment feature or as a safeguard in prevention of errors. At least one of the reviewers must not be the author of the code. Code review is a common practice adopted in software development to improve software code quality based on static code analysis by peers and automated reviewers. There are studies that provide evidence that it reduces the number of defects detected after release. 

## Code Review checklist
- Ask yourself, what does this pull request do?
- Is the pull request doing what it should be doing, and do it correctly?
- Is the code readable?
- Could the code be shorter?
- Could the code be smarter?
- Are changes covered by test?
- Is the code clean?


## Example Pull request
 https://github.com/niallmurphy1/DemonstratingSoftwareQuality/pull/3
