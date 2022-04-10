insert into suppliers(id, name, city) values(1, 'Greenland', 'Rome');

insert into products (id, name, price, quantity, supplier_id) values (1, 'Cetaphil Redness Control', 50.0 , 250, 1);

insert into users (id, last_name, first_name, email, password) values (1, 'test', 'user', 'test.user@gmail.com', '123pass');

insert into deliveries (id, date, address) values (1,  CURDATE(), '5th Avenue');

insert into invoices (id, generation_date, total_price) values (1,  CURDATE(), 350.0);

insert into orders (id, total, placement_date, delivery_id, invoice_id, user_id) values (1, 350.0,  CURDATE(), 1, 1, 1);

insert into orderItems (id, order_id, product_id, quantity) values (1, 1, 1, 200);


