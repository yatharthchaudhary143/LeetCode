# Write your MySQL query statement below


select round(count(p.player_id)/(select count(distinct player_id) from activity), 2) as fraction
    from activity p
    join (select player_id, min(event_date) as first_date from activity group by player_id) f
        on p.player_id=f.player_id
        and p.event_date=date_add(f.first_date, interval 1 day);