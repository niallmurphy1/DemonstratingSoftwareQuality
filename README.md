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