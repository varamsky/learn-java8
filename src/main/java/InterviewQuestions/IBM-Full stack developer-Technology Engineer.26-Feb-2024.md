## Job Description
Full stack developer - Technology Engineer
JOB ID - 687580BR

## Test Type - Online Assessment

There were 2 questions in the OA. First was DSA and second was SQL.

1. A password detection system for HackerRank accounts detects a password as similar If the number of vowels is equal to the number of consonants in the password.
   Passwords consist of lowercase English characters only, and vowels are ('a', 'e', 'i', 'o', 'u'). 
   To check the strength of a password and how easily it can be hacked, some manipulations can be made to the password. In one operation, any character of the string can either be Incremented or decremented. For example, 'f' can be incremented to 'g', or decremented to 'e'. Note that character 'a' cannot be decremented and 'z' cannot be Incremented.<br>Find the minimum number of operations In which the password can be made similar. <br><br>**Example**<br>Consider password = "hack". The 'h' can be changed to 'i' in one operation. The resultant string is "iack" which has 2 vowels ('i', 'a') and 2 consonants ('c', 'k') and hence the string is similar. Return 1, the minimum number of operations required.<br><br>Sample Case 0<br>Input:- abcd<br>Output:- 1 <br>Explanation:-<br>In one operation, 'd' can be changed to 'e'. The resultant string is "abce" which has an equal number of vowels and consonants.<br><br>Sample Case 1<br>Input:- bigbangt<br>Output:- 2
   - Solution Pending
2. Write a query to return a list of professor names and their associated courses for all courses outside their departments. There should be no duplicate rows, but they can be in any order.<br>The output should contain two columns: professor.name, course.name.<br><br>Tables with their columns:-<br>PROFESSOR : ID, NAME, DEPARTMENT_ID, SALARY<br>DEPARTMENT : ID , NAME<br>COURSE: ID, NAME, DEPARTMENT_ID, CREDITS<br>SCHEDULE: PROFESSOR_ID, COURSE_ID, SEMESTER, YEAR
   - ```MySQL
     SELECT DISTINCT prof.name AS "PROFESSOR.NAME", cou.name AS "COURSE.NAME"
     FROM professor prof
     INNER JOIN schedule sch
     ON sch.professor_id = prof.id
     INNER JOIN course cou
     ON sch.course_id = cou.id
     WHERE cou.department_id <> prof.department_id;
     ```
   - [Scheduling Errors Hackerrank Question](https://valsze.de/2023/10/29/scheduling-errors/)