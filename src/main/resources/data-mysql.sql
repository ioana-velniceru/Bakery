insert into allergen(id, name) values(1, 'lactose');
insert into allergen(id, name) values(2, 'nuts');
insert into allergen(id, name) values(3, 'gluten');

insert into category(id, name) values(1, 'Fluffy base cake');

insert into product (id, name, price, has_sugar, is_vegan, category_id) values (1, 'Fruit Cake', 15, false, true, 1);

insert into info(id, product_id, description) values (1, 1, 'Cake with fruit pieces');
insert into product_allergen (product_id, allergen_id) values(1,1);
insert into category(id, name) values (2, 'Rich base cake');
insert into product (id, name, price, has_sugar, is_vegan, category_id) values (2, 'Brownie', 25, true, false, 2);
insert into info(id, product_id, description) values (2, 2, 'Chocolate-based cake');
insert into product_allergen (product_id, allergen_id) values (2, 1);
insert into category(id, name) values (3, 'Puff pastry cake');
insert into product (id, name, price, has_sugar, is_vegan, category_id) values (3, 'Strudel' , 30, true, true, 3);
insert into info (id, product_id, description) values (3, 3 , 'Pastry with fruit filling');
insert into product_allergen (product_id, allergen_id) values (3, 3);