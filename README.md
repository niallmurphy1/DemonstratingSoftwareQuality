# Test Covering Metric

To get data on tests for the software component, I used the included Test Coverage tool plugin provided by the IntelliJ IDEA. 

### Running the Code Coverage tool
- Firstly, prepare for testing by creating a test resource folder. More info can be found [here] [intelliJ_set_up_test_link].
- Create tests in test resource folder
- Run tests individually from inside Test classes
- Right click on test folder, and select 'Run 'All tests' with Coverage '. See Figure 1 below

![Run all tests](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/run_all_tests_screesnhot.png "Figure 1: Run all tests")_Figure 1_

### _Closing the gap_
I started testing as I coded and wrote tests for the entities first, and a few for the methods in the Controller class. Let's see how the progression was after some initial tests:
![1st progression](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/test_coverage_screenshot_37.png "Figure 2: Initial progression")_Figure 2_

As we can see, after some initial testing, we have covered 37% of the lines of code in the scope. This is made up of 68% of the entities package lines and 30% of the lines from the driver package, containing the class Controller.java. This class needs more work. After covering some more methods, this is what the test coverage looked like at the next stage.

![2nd progression](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/test_coverage_screesnhot_45.png "Figure 3: second progression ")_Figure 3_

More tests added result in more coverage, and nearly half of all the code in the project.
After some more testing and addditional methods for getting the statistics of a specific criteria, the test Coverage tool reported more than half of the lines tested. see Figure 4 below.

![3rd progression](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/test_coverage_screenshot_56.png "Figure 4: third progression")_Figure 4_

I added another test to round up the testing coverage to 60%. I would have like to get into the 70s or 80s but I had the scanner scanning within some methods and the test Coverage wouldn't allow me to enter input, but I was satisfied that the code worked. See last progression, Figure 5 below. 

![3rd progression](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/test_coverage_60.png "Figure 5: Final progression")_Figure 5_

### Coverage tool thoughts
I found this Coverage tool to be quite useful as it shows you exactly where your code is lacking in testing, which is especially useful for unit testing. The Coverage tool shows you exactly what lines you missed by highlighting them in red in the class. See Figure 6 below.

![Highlighted code](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/lines_missing_highlighted.png "Figure 6: highlighted test missing")_Figure 6_


The tool also shows you a class-by-class breakdown of what code is covered, which may seem obvious, but is very handy for looking at different packages and entities respectively. See Figure 7 below.

![entity breakdown](https://raw.githubusercontent.com/niallmurphy1/DemonstratingSoftwareQuality/test_coverage_metric/screenshots/entities_tested_breakdown.png "Figure 7: Entity breakdown")_Figure 7_







[intelliJ_set_up_test_link]:<https://www.jetbrains.com/help/idea/testing.html>
