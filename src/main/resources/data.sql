CREATE TABLE person
(
id INTEGER NOT NULL,
name VARCHAR(30) NOT NULL,
location VARCHAR(30),
PRIMARY KEY(id)
);

INSERT INTO person(id, name, location)
VALUES(10001, 'Praveen', 'Erode');
INSERT INTO person(id, name, location)
VALUES(10002, 'Kumar', 'Erode');