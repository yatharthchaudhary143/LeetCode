# Write your MySQL query statement below

select e.employee_id from employees e 
    left join employees m on m.employee_id=e.manager_id
        where e.salary<30000
        and e.manager_id is not null
        and m.employee_id is null
        order by e.employee_id;