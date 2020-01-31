
CREATE TABLE TBL_CUSTOMER
(
	id serial not null primary key,
	name text not null,
	surname text not null
);

CREATE TABLE TBL_ORDER
(
	id serial not null primary key,
	item text not null,
	price numeric(5,2),
	customer_id numeric not null,
	foreign key (id) references tbl_customer(id)
);
