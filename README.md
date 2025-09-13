# Interview-Question

# Java 8 stream Interview Questions & Answers

> Click :star:if you like the project. Pull Requests are highly appreciated.

### Table of Contents

| No. | Questions                                                                                                                                                         |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | [Find list of employees whose name starts with alphabet A](#find-list-of-employees-whose-name-starts-with-alphabet-A)                                         |
| 2   | [Group The employees By Department Names](#group-the-employees-by-department-names)                                                         |
| 3   | [Find the total count of employees using stream](#find-the-total-count-of-employees-using-stream)                                                         |
| 4   | [Find the max age of employees](#find-the-max-age-of-employees)                                                         |
| 5   | [Find all department names](#find-all-department-names)                                                         |
| 6   | [Find the count of employee in each department](#find-the-count-of-employee-in-each-department)                                                         |
| 7   | [Find the list of employees whose age is less than 30](#find-the-list-of-employees-whose-age-is-less-than-30)                                                         |
| 8   | [Find the list of employees whose age is in between 26 and 31](#find-the-list-of-employees-whose-age-is-in-between-26-and-31)                                                         |
| 9   | [Find the average age of male and female employee](#find-the-average-age-of-male-and-female-employee)|
| 10   | [Find the department who is having maximum number of employee](#find-the-department-who-is-having-maximum-number-of-employee)|
| 11   | [Find the Employee who stays in Delhi and sort them by their names](#find-the-employee-who-stays-in-delhi-and-sort-them-by-their-names)|
| 12   | [Find the average salary in all departments](#find-the-average-salary-in-all-departments)|
| 13   | [Find the highest salary in each department](#find-the-highest-salary-in-each-department)|
| 14   | [Find the list of employee and sort them by their salary](#find-the-list-of-employee-and-sort-them-by-their-salary)|
| 15   | [Find the employee who has second highest salary](#find-the-employee-who-has-second-highest-salary)|

# Java 8 Interview Sample Coding Questions [Solution Improvement in progress]

This repository contains sample Java 8 coding questions that can be used for interview preparation. Each question focuses on a specific programming concept or problem-solving technique using Java 8 features.

## List of Questions

1. **Separate odd and even numbers in a list of integers**

    Given a list of integers, write a Java 8 program to separate the odd and even numbers into two separate lists.

2. **Remove duplicate elements from a list using Java 8 streams**

    Write a Java 8 program to remove duplicate elements from a list using the stream API and lambda expressions.

3. **Find the frequency of each character in a string using Java 8 streams**

    Write a Java 8 program to find the frequency of each character in a given string using the stream API and collectors.

4. **Find the frequency of each element in an array or a list**

    Write a Java 8 program to find the frequency of each element in an array or a list using streams and collectors.

5. **Sort a given list of decimals in reverse order**

    Write a Java 8 program to sort a given list of decimal numbers in reverse order.

6. **Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter**

    Given a list of strings, write a Java 8 program to join the strings with '[' as a prefix, ']' as a suffix, and ',' as a delimiter.

7. **Print the numbers from a given list of integers that are multiples of 5**

    Write a Java 8 program to print the numbers from a given list of integers that are multiples of 5.

8. **Find the maximum and minimum of a list of integers**

    Given a list of integers, write a Java 8 program to find the maximum and minimum numbers in the list.

9. **Merge two unsorted arrays into a single sorted array using Java 8 streams**

    Write a Java 8 program to merge two unsorted arrays into a single sorted array using the stream API.

10. **Merge two unsorted arrays into a single sorted array without duplicates**

    Write a Java 8 program to merge two unsorted arrays into a single sorted array without duplicates.
11. **Get the three maximum and three minimum numbers from a given list of integers**

    Write a Java 8 program to get the three maximum and three minimum numbers from a given list of integers.

12. **Check if two strings are anagrams or not using Java 8 streams**

    Write a Java 8 program to check if two strings are anagrams or not using the stream API and lambda expressions.

13. **Find the sum of all digits of a number in Java 8**

    Write a Java 8 program to find the sum of all digits of a given number.

14. **Find the second largest number in an integer array**

    Write a Java 8 program to find the second largest number in an integer array.

15. **Sort a list of strings according to the increasing order of their length**

    Write a Java 8 program to sort a given list of strings according to the increasing order of their length.

16. **Find the sum and average of all elements in an integer array**

    Write a Java 8 program to find the sum and average of all elements in an integer array.

17. **Find the common elements between two arrays**

    Write a Java 8 program to find the common elements between two arrays using streams.

18. **Reverse each word of a string using Java 8 streams**

    Write a Java 8 program to reverse each word of a given string using the stream API and lambda expressions.

19. **Find the sum of the first 10 natural numbers**

    Write a Java 8 program to find the sum of the first 10 natural numbers using streams.

20. **Reverse an integer array**

    Write a Java 8 program to reverse an integer array.

21. **Print the first 10 even numbers**

    Write a Java 8 program to print the first 10 even numbers.

22. **Find the most repeated element in an array**

    Write a Java 8 program to find the most repeated element in an array.

23. **Check if a string is a palindrome using Java 8 streams**

    Write a Java 8 program to check if a given string is a palindrome using the stream API and lambda expressions.

24. **Find strings in a list that start with a number**

    Given a list of strings, write a Java 8 program to find the strings that start with a number.

25. **Extract duplicate elements from an array**

    Write a Java 8 program to extract duplicate elements from an array.

26. **Print duplicate characters in a string**

    Write a Java 8 program to print the duplicate characters in a string.

27. **Find the first repeated character in a string**

    Write a Java 8 program to find the first repeated character in a string.

28. **Find the first non-repeated character in a string**

    Write a Java 8 program to find the first non-repeated character in a string.

29. **Generate the Fibonacci series**

    Write a Java 8 program to generate the Fibonacci series.

30. **Print the first 10 odd numbers**

    Write a Java 8 program to print the first 10 odd numbers.

31. **Get the last element of an array**

    Write a Java 8 program to get the last element of an array.

32. **Calculate the age of a person in years**

    Write a Java 8 program to calculate the age of a person in years given their birthday.

1. ### Find list of employees whose name starts with alphabet A


      ```java
      List<Employee> aEmp = empList.stream()
			.filter(emp -> emp.getName().startsWith("A"))
						.collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

2. ### Group The employees By Department Names

   ````java
      Map<String, List<Employee>> deptMap = empList.stream()
	.collect(Collectors.groupingBy(emp -> emp.getDepartmentName()));
      ````

**[⬆ Back to Top](#table-of-contents)**

3. ### Find the total count of employees using stream

   ```java
      long empCount = empList.stream().count();
      ```

**[⬆ Back to Top](#table-of-contents)**

4. ### Find the max age of employees

   ```java
      int maxAge = empList.stream().mapToInt(emp -> emp.getAge()).max().getAsInt();
      ```

**[⬆ Back to Top](#table-of-contents)**

5. ### Find all department names

   ```java
      List<String> deptNamesList = empList.stream()
	.map(emp -> emp.getDepartmentName()).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

6. ### Find the count of employee in each department

   ```java
      Map<String, Long> deptCountMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()));
      ```

**[⬆ Back to Top](#table-of-contents)**

7. ### Find the list of employees whose age is less than 30

   ```java
      List<Employee> ageList = empList.stream().filter(emp -> emp.getAge() < 30).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

8. ### Find the list of employees whose age is in between 26 and 31

   ```java
      List<Employee> ageBetween26And30 = employees.stream().filter(emp -> emp.getAge() < 30 && emp.getAge() > 26).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

9. ### Find the average age of male and female employee

   ```java
      Map<String, Double> avgAgeMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
      ```

**[⬆ Back to Top](#table-of-contents)**


10. ### Find the department who is having maximum number of employee

   ```java
      Map.Entry<String, Long> deptMaxCount = empList.stream().collect(Collectors.groupingBy(
				Employee::getDepartmentName, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get();
```

**[⬆ Back to Top](#table-of-contents)**

11. ### Find the Employee who stays in Delhi and sort them by their names

   ```java
      List<Employee> employees = empList.stream().filter(emp -> emp.getAddress().equals("Delhi")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
```

**[⬆ Back to Top](#table-of-contents)**

12. ### Find the average salary in all departments

   ```java
      Map<String, Double> deptAvgSalary = empList.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.averagingDouble(Employee::getSalary)));
```

**[⬆ Back to Top](#table-of-contents)**

13. ### Find the highest salary in each department

   ```java
      Map<String, Optional<Employee>> highestSalForEachDedpt = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.minBy(Comparator.comparing(Employee::getSalary))));
```

**[⬆ Back to Top](#table-of-contents)**

14. ### Find the list of employee and sort them by their salary

   ```java
      List<Employee> emps = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
```

**[⬆ Back to Top](#table-of-contents)**

15. ### Find the employee who has second lowest salary

   ```java
      Employee emp = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();
```

**[⬆ Back to Top](#table-of-contents)**














Good luck with your interview 😊

---
