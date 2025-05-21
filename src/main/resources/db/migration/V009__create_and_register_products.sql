CREATE TABLE product (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (15),
	dpurchase DATE,
	serial_number VARCHAR(100) NOT NULL,
	id_owner BIGINT(20),
	id_usability BIGINT(20),
	id_model BIGINT(20) NOT NULL,
	id_professional BIGINT,
	id_establishment BIGINT (20),
	FOREIGN KEY (id_owner) REFERENCES owner(id),
	FOREIGN KEY (id_usability) REFERENCES usability(id),
	FOREIGN KEY (id_model) REFERENCES model(id),
	FOREIGN KEY (id_professional) REFERENCES professional(id),
    FOREIGN KEY (id_establishment) REFERENCES establishment(id),
    CONSTRAINT unique_serial_number UNIQUE (serial_number)

);

INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-01', CURRENT_DATE(), 'N87YU98',1, 4, 2, 1, 2);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-02', CURRENT_DATE(), 'HY547JU', 1, 4, 2, 2, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099i-PLAN-01', CURRENT_DATE(), 'NGFH600UYTT400277', 1, 4, 1, 3, 1);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-MBERNIER-01', CURRENT_DATE(), '3ER456', 1, 4, 2, 4, 3);

INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-03', CURRENT_DATE(), 'N87YU96', 1, 4, 2, 1, 2);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-04', CURRENT_DATE(), 'HY545T1', 1, 4, 2, 2, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099i-PLAN-02', CURRENT_DATE(), 'NGFH600UYTT400266', 1, 4, 1, 3, 1);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-MROY-02', CURRENT_DATE(), 'X807028-003',1, 4, 2, 4, 3);

INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-05', CURRENT_DATE(), 'N87J789', 1, 4, 2, 1, 2);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-06', CURRENT_DATE(), 'HY545TG', 1, 4, 2, 2, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099i-PLAN-03', CURRENT_DATE(), 'NGFH600UYTT400255', 1, 4, 1, 3, 1);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-CLAMBERT-03', CURRENT_DATE(), '3ER488', 2, 4, 2, 4, 3);

INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-07', CURRENT_DATE(), 'N87YH5R', 2, 4, 2, 1, 2);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-08', CURRENT_DATE(), 'HY54QW3', 2, 4, 2, 2, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099i-PLAN-04', CURRENT_DATE(), 'NGFH600UYTT400099', 2, 4, 1, 3, 1);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-VBRAGA-04', CURRENT_DATE(), '3ER321', 2, 4, 2, 4, 3);

INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-09', CURRENT_DATE(), 'N87YU91', 2, 4, 2, 1, 2);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099P-BONMIC-10', CURRENT_DATE(), 'HY547JA', 2, 4, 2, 1, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099i-PLAN-05', CURRENT_DATE(), 'NGFH600UYTT400244', 2, 4, 1, 3, 1);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-SSILVA-05', CURRENT_DATE(), '3ER333', 2, 4, 2, 4, 3);
INSERT INTO product (name, dpurchase, serial_number, id_owner, id_usability, id_model, id_professional, id_establishment) values ('099-LROY', CURRENT_DATE(), '3ER222', 2, 4, 2, 4, 3);