Table: `Person`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| email       | varchar |
+-------------+---------+
id is the primary key (column with unique values) for this table.
Each row of this table contains an email. The emails will not contain uppercase letters.
```
Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.

Return the result table in **any order**.
***
To do this question we will be using `GROUP BY` and grouping our unique email into groups and then only outputting groups who have a `COUNT(*) > 1`, meaning emails who have more then `1` occurrence in the table:
```mysql
SELECT email AS Email
FROM Person
GROUP by email
HAVING COUNT(*) > 1;
```