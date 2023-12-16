-- 브랜드
CREATE TABLE brand (
                       id INT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);

-- 카테고리
CREATE TABLE category (
                          id INT NOT NULL AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          PRIMARY KEY (id)
);

-- 상품
CREATE TABLE product (
                         id INT NOT NULL AUTO_INCREMENT,
                         price DECIMAL(10,2) NOT NULL,
                         brand_id INT NOT NULL,
                         category_id INT NOT NULL,
                         PRIMARY KEY (id),
                         CONSTRAINT fk_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
                         CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES category(id)
);