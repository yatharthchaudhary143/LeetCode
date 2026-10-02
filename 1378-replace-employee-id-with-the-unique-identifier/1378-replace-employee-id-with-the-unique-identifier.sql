# Write your MySQL query statement below

select u.unique_id as unique_id, e.name as name from EmployeeUNI u
    right join Employees e on e.id=u.id;