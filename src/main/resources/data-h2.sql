
insert into allergen(id, name) values(1, 'lactose');
insert into allergen(id, name) values(2, 'nuts');
insert into allergen(id, name) values(3, 'gluten');

insert into category(id, name) values(1, 'Layered cookie');

insert into product (id, name, price, has_sugar, is_vegan, category_id) values (1, 'Wafer', 10, true, false, 1);

insert into info(id, product_id, description) values (1, 1, 'Thin biscuit with cream filling');
insert into product_allergen (product_id, allergen_id) values(1,1);
insert into category(id, name) values (2, 'Mini-cake');
insert into product (id, name, price, has_sugar, is_vegan, category_id) values (2, 'Cupcake', 15, true, false, 2);
insert into info(id, product_id, description) values (2, 2, 'Small cake wrapped in thin paper');
insert into product_allergen (product_id, allergen_id) values (2, 1);
insert into category(id, name) values (3, 'No-bake cake');
insert into product (id, name, price, has_sugar, is_vegan, category_id) values (3, 'Chocolate Salami', 45, false, false, 3);
insert into info (id, product_id, description) values (3, 3 , 'Cake made from cocoa, broken biscuits and butter');
insert into product_allergen (product_id, allergen_id) values (3, 2);