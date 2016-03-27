# Simple Camel Boot application

I am just getting started with camel and spring boot as such a lot of questions arise.

## Problem

  - reading properties camel style did not work
      - I now realized from [http://camel.465427.n5.nabble.com/Camel-Properties-Spring-Boot-Unit-test-not-found-td5779765.html](http://camel.465427.n5.nabble.com/Camel-Properties-Spring-Boot-Unit-test-not-found-td5779765.html)
      that instead of Springs test runner Camels test runner would be needed.

## Question

Is stronger coupling e.g. using `{{camelProperty}}` better compared to using a Spring property
like:
```
    @Value("${file.inputPath}")
    private String filePath;
```

Second Question:
  - why does camel not delete the files as specified in the tear down method?
  - why is the null folder created?
  
## Instructions

To run the application execute:

```
./gradlew bootRun
```

to execute the test run

```
./gradlew test
```

or right click on the unit test in your favourite IDE and click run. (Keep in mind in case you use an IDE you first need to properly import the gradle project)
