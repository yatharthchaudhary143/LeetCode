
select round(count(d.customer_id)/(select count(distinct customer_id) from delivery)*100, 2) as immediate_percentage from delivery d 
    join (select customer_id, min(order_date) as first_order from delivery group by customer_id) f
    on d.customer_id=f.customer_id
    and d.customer_pref_delivery_date=f.first_order;
    