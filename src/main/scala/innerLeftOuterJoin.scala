CREATE TABLE employees (
  emp_id INT PRIMARY KEY,
  name VARCHAR(50),
  department_id INT
);
INSERT INTO employees VALUES
  (1, 'Karthik', 101),
(2, 'Veena', 102),
(3, 'Meena', NULL),
(4, 'Veer', 103),
(5, 'Ajay', 104),
(6, 'Vijay', NULL),
(7, 'Keerthi', 105);
select * from employees;
CREATE TABLE departments (
  department_id INT PRIMARY KEY,
  department_name VARCHAR(50)
);
INSERT INTO departments VALUES
  (101, 'HR'),
(102, 'Finance'),
(103, 'IT'),
(104, 'Marketing'),
(106, 'Operations');
select * from departments;

/*List all employees and their department names, but only include employees assigned to a
department. /*

select e.emp_id, e.name,d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id

/*2. Find employees whose department name starts with the letter 'F'. /*

select e.emp_id, e.name,d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id
where d.department_name like '%F%'

/* Find all departments and employees where there is no match between the two tables.*/
select e.emp_id, e.name,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where department_name is null
union
select e.emp_id, e.name,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where emp_id is null;

/*List employees and departments, ensuring departments with names ending in 's' are
included even if no employees are assigned. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where d.department_name like '%s';

/*Find employees with names starting with 'V' and their corresponding departments (if
available*/
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where e.name like 'v%';

/*1.List all employees and their department names, but only include employees assigned to a
department. */

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where department_name is not null;

/*2. Find employees whose department name starts with the letter 'F'. /*

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id
where department_name like '%F%'

//3.Retrieve employee details along with the department name for departments with IDs
greater than 102. //
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id
where e.department_id >102;

//4.Find employees working in the 'IT' or 'Marketing' departments. //
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id
where d.department_name = 'IT' OR d.department_name = 'Marketing';

//..............Needed Revision........5.List department names and the total number of employees in each department. (Hint: Use
GROUP BY with INNER JOIN) //

select e.emp_id,e.name,e.department_id,d.department_name,count(e.emp_id)
from employees e
inner join departments d
on e.department_id = d.department_id
group by e.name,e.department_id,d.department_name

/*6.6. List all employees, including those without a department, and their department details.
*/
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where d.department_name is null;

/*7.7. Find employees not assigned to any department. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where d.department_name is null;

/*Fetch all employees and their departments, replacing missing department names with 'Not
Assigned'./*

select e.emp_id,e.name,e.department_id,coalesce(d.department_name,'Not Assigned') as Department_Name
from employees e
left outer join departments d
on e.department_id = d.department_id;

/*9.List employees along with department details for those working in departments with IDs
less than 104. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where d.department_id < 104;

/*10  Find employees with names starting with 'V' and their corresponding departments (if
available). */

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where e.name  like 'v%';

/*11. List all departments and their employee details, including departments with no
employees.*/
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id;

/*12. Find departments without any employees assigned to them. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where e.emp_id is null;

/*13.Fetch the names of all departments along with employee names, where department
names contain the letter 'O'. */

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where d.department_name like 'O%';

/* 14.Retrieve department details along with employees whose names end with 'a'.*/
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where d.department_name like '%O';

/*15. List all departments with fewer than two employees. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
having count(d.department_name)<2;

/*16 List all employees and departments, ensuring no record is missed./*
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
union
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id

/*17. Find all departments and employees where there is no match between the two tables. /*

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where d.department_id is null

union
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where e.emp_id is null

/*18. Fetch details of all employees and departments, showing 'No Department' for missing
department details and 'No Employee' for missing employee details. /*

select e.emp_id,e.name,coalesce(d.department_id,'No_Department') AS department_id,
coalesce(d.department_name,'No_Department') AS  department_name
from employees e
left outer join departments d
on e.department_id = d.department_id

union

select coalesce(e.emp_id,'No Employee') AS emp_id,coalesce(e.name,'No Employee') AS emp_name,d.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id

/*19. List employees and departments, ensuring departments with names ending in 's' are
included even if no employees are assigned. */
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id

union

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where d.department_name like '%s';

/*20. Find departments and employees where department_id does not match, showing
mismatched rows explicitly. */

select e.emp_id,e.name,e.department_id,d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id
where d.department_id is null
union
select e.emp_id,e.name,e.department_id,d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id
where emp_id is null