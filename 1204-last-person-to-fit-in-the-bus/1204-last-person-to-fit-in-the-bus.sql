# Write your MySQL query statement below


select a.person_name from (
    select person_name, turn, sum(weight) over (order by turn) as total_weight from queue
) a where total_weight<=1000 order by total_weight desc limit 1;