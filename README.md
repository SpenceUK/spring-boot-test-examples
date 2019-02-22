# Java Spring-Boot test examples

Collection of examples for testing within spring-boot using Junit and Mockito test frameworks.

### Framework Documentation

[Spring-Boot testing documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html)

[Junit test framework](https://junit.org/junit4/)

[Mockito - mocking and spying framework](https://static.javadoc.io/org.mockito/mockito-core/2.24.5/org/mockito/Mockito.html)

[HamcrestMatchers](http://hamcrest.org/JavaHamcrest/)

[JsonPath](http://jsonpath.com/)

[BDD Mockito](https://www.baeldung.com/bdd-mockito)

### Running Tests

To run tests we use the build tool [Maven](https://maven.apache.org/guides/index.html).

To run all tests:

```bash
mvn test
```

To run a specific test class e.g: classToTest.java use the command:
```bash
mvn -Dtest=classToTest test
```

To run a specific test method within a class:
```bash
mvn -Dtest=classToTest#testMethodToRun test
```
