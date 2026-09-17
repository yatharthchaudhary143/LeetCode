# Write your MySQL query statement below

select c.contest_id, round(count(u.user_id)/(select count(*) from users)*100, 2) as percentage from users u
    join register c on u.user_id=c.user_id group by contest_id
        order by percentage desc, contest_id asc;