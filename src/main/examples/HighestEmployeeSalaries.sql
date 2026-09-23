/*

https://archive.ph/vOh3R#selection-991.0-1003.250

Write a query to get the top 3 highest employee salaries by department.
Given the employees and departments table, write a query to get the top 3 highest employee salaries by department.
The output should include the full name of the employee, the department name, and the salary,
sorted by department name in ascending order and salary in descending order.

Employee
emp_id,name, salary, dep_id

Department
dep_id,name

 */

SELECT
    CONCAT(e.first_name, ' ', e.last_name) AS full_name,
    d.department_name,
    e.salary
FROM (
         SELECT
             e.*,
             RANK() OVER (
            PARTITION BY e.department_id
            ORDER BY e.salary DESC
        ) AS salary_rank
         FROM employees e
     ) e
         JOIN departments d
              ON e.department_id = d.department_id
WHERE e.salary_rank <= 3
ORDER BY d.department_name ASC, e.salary DESC;



