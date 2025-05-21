CREATE TABLE person (
id BIGINT (20) PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
mail VARCHAR (50) NOT NULL,
password VARCHAR(150) NOT NULL
);

CREATE TABLE permission (
	id BIGINT(20) PRIMARY KEY,
	description VARCHAR(50) NOT NULL
);

CREATE TABLE person_permission (
	id_person BIGINT(20) NOT NULL,
	id_permission BIGINT(20) NOT NULL,
	PRIMARY KEY (id_person, id_permission),
	FOREIGN KEY (id_person) REFERENCES person(id),
	FOREIGN KEY (id_permission) REFERENCES permission(id)
);
INSERT INTO person (id, name, mail, password) values (1, 'Administrateur', 'admin@gmail.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO person (id, name, mail, password) values (2, 'Maria Silva', 'maria@gmail.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');
INSERT INTO person (id, name, mail, password) values (3, 'Miria Fassarella', 'miria@fassarella.dev', '$2a$10$31NHI9xEps83R6CvbIeml.6YRmMwBOVfvoXPcAYyTaOL8CNXlAeJO');
INSERT INTO person (id, name, mail, password) values (4, 'Leonardo da Silva', 'leosilva@gmail.com', '$2a$10$fXTIoEyJNEcc5muRy9pl3eKwAw13IapXrNxOYkL3/sOgYF2wxIUGq');


INSERT INTO permission (id, description) values (1, 'ROLE_REGISTER_USER');
INSERT INTO permission (id, description) values (2, 'ROLE_DELETE_USER');

INSERT INTO permission (id, description) values (3, 'ROLE_SEARCH_USER');
INSERT INTO permission (id, description) values (4, 'ROLE_UPDATE_USER');


INSERT INTO permission (id, description) values (5, 'ROLE_REGISTER_PRODUCT');
INSERT INTO permission (id, description) values (6, 'ROLE_DELETE_PRODUCT');
INSERT INTO permission (id, description) values (7, 'ROLE_SEARCH_PRODUCT');
INSERT INTO permission (id, description) values (8, 'ROLE_UPDATE_PRODUCT');

INSERT INTO permission (id, description) values (9, 'ROLE_REGISTER_PERMISSION');
INSERT INTO permission (id, description) values (10, 'ROLE_DELETE_PERMISSION');
INSERT INTO permission (id, description) values (11, 'ROLE_SEARCH_PERMISSION');
INSERT INTO permission (id, description) values (12, 'ROLE_UPDATE_PERMISSION');

INSERT INTO permission (id, description) values (13, 'ROLE_REGISTER_OWNER');
INSERT INTO permission (id, description) values (14, 'ROLE_DELETE_OWNER');
INSERT INTO permission (id, description) values (15, 'ROLE_SEARCH_OWNER');
INSERT INTO permission (id, description) values (16, 'ROLE_UPDATE_OWNER');

INSERT INTO permission (id, description) values (17, 'ROLE_REGISTER_PROFESSIONAL');
INSERT INTO permission (id, description) values (18, 'ROLE_DELETE_PROFESSIONAL');
INSERT INTO permission (id, description) values (19, 'ROLE_SEARCH_PROFESSIONAL');
INSERT INTO permission (id, description) values (20, 'ROLE_UPDATE_PROFESSIONAL');

INSERT INTO permission (id, description) values (21, 'ROLE_REGISTER_USABILITY');
INSERT INTO permission (id, description) values (22, 'ROLE_DELETE_USABILITY');
INSERT INTO permission (id, description) values (23, 'ROLE_SEARCH_USABILITY');
INSERT INTO permission (id, description) values (24, 'ROLE_UPDATE_USABILITY');

INSERT INTO permission (id, description) values (25, 'ROLE_REGISTER_TYPE');
INSERT INTO permission (id, description) values (26, 'ROLE_DELETE_TYPE');
INSERT INTO permission (id, description) values (27, 'ROLE_SEARCH_TYPE');
INSERT INTO permission (id, description) values (28, 'ROLE_UPDATE_TYPE');

INSERT INTO permission (id, description) values (29, 'ROLE_REGISTER_MODEL');
INSERT INTO permission (id, description) values (30, 'ROLE_DELETE_MODEL');
INSERT INTO permission (id, description) values (31, 'ROLE_SEARCH_MODEL');
INSERT INTO permission (id, description) values (32, 'ROLE_UPDATE_MODEL');

INSERT INTO permission (id, description) values (33, 'ROLE_EXPORT_PDF');


-- admin
INSERT INTO person_permission (id_person, id_permission) values (1, 1);
INSERT INTO person_permission (id_person, id_permission) values (1, 2);
INSERT INTO person_permission (id_person, id_permission) values (1, 3);
INSERT INTO person_permission (id_person, id_permission) values (1, 4);
INSERT INTO person_permission (id_person, id_permission) values (1, 5);
INSERT INTO person_permission (id_person, id_permission) values (1, 6);
INSERT INTO person_permission (id_person, id_permission) values (1, 7);
INSERT INTO person_permission (id_person, id_permission) values (1, 8);
INSERT INTO person_permission (id_person, id_permission) values (1, 9);
INSERT INTO person_permission (id_person, id_permission) values (1, 10);
INSERT INTO person_permission (id_person, id_permission) values (1, 11);
INSERT INTO person_permission (id_person, id_permission) values (1, 12);
INSERT INTO person_permission (id_person, id_permission) values (1, 13);
INSERT INTO person_permission (id_person, id_permission) values (1, 14);
INSERT INTO person_permission (id_person, id_permission) values (1, 15);
INSERT INTO person_permission (id_person, id_permission) values (1, 16);
INSERT INTO person_permission (id_person, id_permission) values (1, 17);
INSERT INTO person_permission (id_person, id_permission) values (1, 18);
INSERT INTO person_permission (id_person, id_permission) values (1, 19);
INSERT INTO person_permission (id_person, id_permission) values (1, 20);

INSERT INTO person_permission (id_person, id_permission) values (1, 21);
INSERT INTO person_permission (id_person, id_permission) values (1, 22);
INSERT INTO person_permission (id_person, id_permission) values (1, 23);
INSERT INTO person_permission (id_person, id_permission) values (1, 24);
INSERT INTO person_permission (id_person, id_permission) values (1, 25);
INSERT INTO person_permission (id_person, id_permission) values (1, 26);
INSERT INTO person_permission (id_person, id_permission) values (1, 27);
INSERT INTO person_permission (id_person, id_permission) values (1, 28);
INSERT INTO person_permission (id_person, id_permission) values (1, 29);
INSERT INTO person_permission (id_person, id_permission) values (1, 30);
INSERT INTO person_permission (id_person, id_permission) values (1, 31);
INSERT INTO person_permission (id_person, id_permission) values (1, 32);
INSERT INTO person_permission (id_person, id_permission) values (1, 33);



-- maria
INSERT INTO person_permission (id_person, id_permission) values (2, 2);
INSERT INTO person_permission (id_person, id_permission) values (2, 5);
INSERT INTO person_permission (id_person, id_permission) values (2, 8);

-- miria
INSERT INTO person_permission (id_person, id_permission) values (3, 8);