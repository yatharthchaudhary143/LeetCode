# Write your MySQL query statement below

select c.customer_id, count(*) as count_no_trans from Visits c 
    left join Transactions t on c.visit_id=t.visit_id 
        where t.transaction_id is null 
            group by c.customer_id;