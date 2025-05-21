CREATE TABLE professional (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (100) NOT NULL,
	registration VARCHAR(10) NOT NULL
);

INSERT INTO professional(name, registration) VALUES ('Denise Labelle', '987567');
INSERT INTO professional(name, registration) VALUES ('Louise Fontaine', '237679');
INSERT INTO professional(name, registration) VALUES ('Cathrine Bernier', '376589');
INSERT INTO professional(name, registration) VALUES ('Luana Dupre', '876799');