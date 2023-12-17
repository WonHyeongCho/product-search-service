-- 브랜드 데이터
INSERT INTO brand (name)
VALUES ('A'), ('B'), ('C'), ('D'), ('E'), ('F'), ('G'), ('H'), ('I');

-- 카테고리 데이터
INSERT INTO category (name)
VALUES ('상의'), ('아우터'), ('바지'), ('스니커즈'), ('가방'), ('모자'), ('양말'), ('악세사리');

-- 상의 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (11200, 1, 1),
    (10500, 2, 1),
    (10000, 3, 1),
    (10100, 4, 1),
    (10700, 5, 1),
    (11200, 6, 1),
    (10500, 7, 1),
    (10800, 8, 1),
    (11400, 9, 1);

-- 아우터 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (5500, 1, 2),
    (5900, 2, 2),
    (6200, 3, 2),
    (5100, 4, 2),
    (5000, 5, 2),
    (7200, 6, 2),
    (5800, 7, 2),
    (6300, 8, 2),
    (6700, 9, 2);

-- 바지 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (4200, 1, 3),
    (3800, 2, 3),
    (3300, 3, 3),
    (3000, 4, 3),
    (3800, 5, 3),
    (4000, 6, 3),
    (3900, 7, 3),
    (3100, 8, 3),
    (3200, 9, 3);

-- 스니커즈 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (9000, 1, 4),
    (9100, 2, 4),
    (9200, 3, 4),
    (9500, 4, 4),
    (9900, 5, 4),
    (9300, 6, 4),
    (9000, 7, 4),
    (9700, 8, 4),
    (9500, 9, 4);

-- 기빙 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (2000, 1, 5),
    (2100, 2, 5),
    (2200, 3, 5),
    (2500, 4, 5),
    (2300, 5, 5),
    (2100, 6, 5),
    (2200, 7, 5),
    (2100, 8, 5),
    (2400, 9, 5);

-- 모자 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (1700, 1, 6),
    (2000, 2, 6),
    (1900, 3, 6),
    (1500, 4, 6),
    (1800, 5, 6),
    (1600, 6, 6),
    (1700, 7, 6),
    (1600, 8, 6),
    (1700, 9, 6);

-- 양말 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (1800, 1, 7),
    (2000, 2, 7),
    (2200, 3, 7),
    (2400, 4, 7),
    (2100, 5, 7),
    (2300, 6, 7),
    (2100, 7, 7),
    (2000, 8, 7),
    (1700, 9, 7);

-- 액세서리 상품
INSERT INTO product (price, brand_id, category_id)
VALUES
    (2300, 1, 8),
    (2200, 2, 8),
    (2100, 3, 8),
    (2000, 4, 8),
    (2100, 5, 8),
    (1900, 6, 8),
    (2000, 7, 8),
    (2000, 8, 8),
    (2400, 9, 8);