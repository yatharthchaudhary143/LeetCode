# Write your MySQL query statement below

select u.user_id, coalesce(round(sum(case when c.action='confirmed' then 1 else 0 end)/count(c.user_id), 2), 0) as confirmation_rate from signups u left join confirmations c on u.user_id=c.user_id group by u.user_id;