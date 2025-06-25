CREATE TABLE category (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(50)
);

CREATE TABLE allergen (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(50)
);

CREATE TABLE info (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      photo LONGBLOB,
                      description TEXT,
                      product_id BIGINT
);

CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50),
                         price DOUBLE,
                         has_sugar BOOLEAN,
                         is_vegan BOOLEAN,
                         category_id BIGINT,
                         currency ENUM('RON', 'EUR')
);

ALTER TABLE info ADD FOREIGN KEY (product_id) REFERENCES product(id);

ALTER TABLE product ADD FOREIGN KEY (category_id) REFERENCES category(id);

CREATE TABLE product_allergen (
                                  allergen_id BIGINT,
                                  product_id BIGINT,
                                  FOREIGN KEY (allergen_id) REFERENCES allergen(id),
                                  FOREIGN KEY (product_id) REFERENCES product(id),
                                  PRIMARY KEY (allergen_id, product_id)
);
