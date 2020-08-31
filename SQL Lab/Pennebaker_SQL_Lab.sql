--Task – Select the employeeId, last name, and email for records in the Employee table where last name is King.15
select "EmployeeId", "LastName", "Email" 
from "Employee" 
where "LastName" = 'King'

--Task – Select the city and state for the records in the Employee table where first name is Andrew and REPORTSTO is NULL.
select "City", "State" 
from "Employee"
where "FirstName" = 'Andrew' and "ReportsTo" = null

--Task – Select all records from the Album table where the composer is AC/DC.
select * from "Album" where "AlbumId" in
(select "AlbumId" from "Track" where "Composer" ='AC/DC');

--Task – Select all albums in Album table and sort result set in descending order by title.
select * 
from "Album"
order by "Title" desc 

--Task – Select first name from Customer and sort result set in ascending order by city
select *
from "Customer"
order by "City" asc 

--1.6
--Task – Select all invoices with a billing address like “T%”
select *
from "Invoice"
where "BillingAddress" like 'T%'

--1.7
--Task – Select all invoices that have a total between 15 and 50.
select *
from "Invoice" 
where "Total" between '15' and '50'

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004.
select *
from "Employee" 
where "HireDate" between '1-JUNE-2003' and '1-MARCH-2004'

--2. DML Statements
--In this section you will be performing various data manipulation statements against the Chinook database.


--Task – Insert two complete new records into Genre table. 
--Task – Insert two complete new records into Employee table.
--Task – Insert two complete new records into Customer table.

select * from "Genre"

insert into "Genre" ("GenreId", "Name")
values(26, 'Rap')

insert into "Genre" ("GenreId", "Name")
values(27, 'Lo-Fi')

select * from "Employee"

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "City", "State", "Country")
values(9, 'Pennebaker', 'Seth', 'Software Engineer', '14-JAN-1997', 'Valrico', 'FL', 'USA')

insert into "Employee" ("EmployeeId", "LastName", "FirstName", "Title", "BirthDate", "City", "State", "Country")
values(10, 'Pennebaker', 'Noah', 'Contractor', '4-SEP-1987', 'Miami', 'Fl', 'USA')

select * from "Customer"

insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email")
values(60, 'Seth', 'Pennebaker', 'seth.penne@gmail.com')

insert into "Customer" ("CustomerId", "FirstName", "LastName", "Email")
values(61, 'Noah', 'Pennebaker', 'noah.penne@gmail.com')


--2.2
--Task – Update Aaron Mitchell in Customer table to Robert Walter.
update "Customer"
set "FirstName" = 'Robert', "LastName" = 'Walter'
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell'


--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	.
update "Artist" 
set "Name" = 'CCR'
where "Name" = 'Creedence Clearwater Revival'

--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).
alter table public."InvoiceLine"
drop constraint "FK_InvoiceLineInvoiceId",
ADD CONSTRAINT "FK_InvoiceLineInvoiceId" FOREIGN KEY ("InvoiceId") REFERENCES "Invoice"("InvoiceId") on delete cascade;

ALTER TABLE public."Invoice"
drop constraint "FK_InvoiceCustomerId",
ADD CONSTRAINT "FK_InvoiceCustomerId" FOREIGN KEY ("CustomerId") REFERENCES "Customer"("CustomerId") on delete cascade;

delete from "Customer" 
where "FirstName" = 'Robert' and "LastName" = 'Walter'


--3.1 System Defined Functions
select localtime 

select length("Name") from "MediaType"


--3.2 System Defined Aggregate Funcitons
select avg("Total") from "Invoice"

select Max("UnitPrice") from "Track"



--3.3
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table.
create or replace function avgInvoice()
returns numeric as $$
declare total integer;
declare sumNum numeric;
begin
	select count("UnitPrice") into total from "InvoiceLine";
	select sum("UnitPrice") into sumNum from "InvoiceLine";
	return sumNum/total;
end;
$$ language plpgsql;

select avgInvoice();


--Task – Create a function that returns all employees who are born after 1968.
 create or replace function birthDateAfter1968()
 returns setof integer as $$
 select "EmployeeId" from "Employee" where "BirthDate" > '1968-12-31 00:00:00';
$$ language sql

select birthDateAfter1968()


--4.1 After Insert Trigger
--Create an after insert trigger on the employee table fired after a new record is inserted into the table to set the phone number to 867-5309.

--NOTE!!!! I added 717 to the beginning of the phone number
--to give an area code for the number
create or replace function phone_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then 
	update "Employee" set "Phone" = '717-867-5309' where "Employee"."EmployeeId" = new."EmployeeId";
	return new;
	end if;
end;
$$ language plpgsql;

--after trigger
create trigger phoneNumber_insert
after insert on "Employee"
for each row
execute function phone_insert();

insert into "Employee"("FirstName", "LastName")
values('Jayson', 'Ciocca');

select * from "Employee"




--4.1 Befopre Insert Trigger
--Task – Create a before trigger on the customer table that 
--fires before a row is inserted from the table to set the company to Revature.
create or replace function cust_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new."Company"='Revature';
	end if;
	return new;
end;
$$ language plpgsql;

--before Trigger
create trigger customer_insert
before insert on "Customer"
for each row
execute function cust_insert();


insert into "Customer"("CustomerId", "FirstName", "LastName", "Email" )
values(62, 'Cody', 'Lehman', 'adsfa@gmail.com');

select * from "Customer"
--5 Joins

--5.1 Inner 
select c."FirstName", c."LastName", i."InvoiceId" from "Customer" c inner join "Invoice" i
on c."CustomerId"=i."InvoiceId" 

--5.2 full outer
select c."CustomerId", c."FirstName", c."LastName", i."InvoiceId", i."Total" from "Customer" c full outer join "Invoice" i
on c."CustomerId"=i."InvoiceId"

--5.3
--right join 
select a."Title", a2."Name" from "Album" a right join "Artist" a2 
on a."ArtistId"=a2."ArtistId"

--5.4
--cross 
select * from "Album" a cross join "Artist" a2 
order by a2."Name" 

--5.5
--self join
select * from "Employee" e inner join "Employee" e2 
on e."ReportsTo"=e2."ReportsTo" 

--6
--6.1
select "LastName", "FirstName", "Phone"from "Employee" -- <--notice no ; here!!
union all
select "LastName", "FirstName", "Phone" from "Customer";

--6.2
select "City", "State", "PostalCode" from "Customer"
except all
select "City", "State", "PostalCode" from "Employee"