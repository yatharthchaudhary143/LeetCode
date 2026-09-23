# Write your MySQL query statement below

select distinct a.num as consecutivenums from logs a
    join logs b
        on b.id=a.id+1
    join logs c
        on c.id=a.id+2
    where a.num=b.num
    and b.num=c.num;