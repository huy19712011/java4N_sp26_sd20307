INSERT INTO students (id, name, email, phone) VALUES (1001, 'Student 1', 'Email 1', 'Phone 1');
INSERT INTO students (id, name, email, phone) VALUES (1002, 'Student 2', 'Email 2', 'Phone 2');
INSERT INTO students (id, name, email, phone) VALUES (1003, 'Student 3', 'Email 3', 'Phone 3');

--
INSERT INTO Course (id, name) VALUES (1, 'java 1');
INSERT INTO Course (id, name) VALUES (2, 'java 2');
INSERT INTO Course (id, name) VALUES (3, 'java 3');

INSERT INTO Review (id, rating, description, course_id) VALUES (1, '5', 'Ok', 3);

--
INSERT INTO categories (id, name) VALUES (1001, 'category 1');
INSERT INTO categories (id, name) VALUES (1002, 'category 2');
INSERT INTO categories (id, name) VALUES (1003, 'category 3');
--
INSERT INTO products (id, name, price, category_id) VALUES (101, 'product 1', 11.0, 1002);
INSERT INTO products (id, name, price, category_id) VALUES (102, 'product 2', 12.0, 1003);
INSERT INTO products (id, name, price, category_id) VALUES (103, 'product 3', 13.0, 1001);

