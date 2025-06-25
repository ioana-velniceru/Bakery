insert into allergen(id, name) values(1, 'strawberry');
insert into category(id, name) values(1, 'Shortcrust Pastry');
insert into product(id, name, price, has_sugar, is_vegan, category_id) values (1, 'Strawberry Tart', 35, true, true, 1);
insert into product_category values(1,1);