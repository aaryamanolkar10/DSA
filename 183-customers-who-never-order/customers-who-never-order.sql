# Write your MySQL query statement below
select Customers.name as customers
from customers
left join orders
on customers.id=orders.customerId
where Orders.customerId is null;