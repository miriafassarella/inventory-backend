CREATE TABLE model (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (100) NOT NULL,
	id_type BIGINT (20) NOT NULL,
	FOREIGN KEY (id_type) REFERENCES type(id)
);

INSERT INTO  model (name, id_type) values ('Ipad 9ºGeneration A2602', 1);
INSERT INTO  model (name, id_type) values ('Dell Latitude 3520', 2);
INSERT INTO  model (name, id_type) values ('Dell Latitude 3510', 2);
INSERT INTO  model (name, id_type) values ('Ipad 6º Generation A7414', 1);
INSERT INTO  model (name, id_type) values ('Tableau SMART RX Series', 3);
INSERT INTO  model (name, id_type) values ('Chromebook Dell 3110', 4);