CREATE TABLE establishment (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (100) NOT NULL,
	enumber VARCHAR(5) NOT NULL,
	id_sector BIGINT (20) NOT NULL,
    FOREIGN KEY (id_sector) REFERENCES sector(id)
);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Élémentaire Victor Hugo', '071', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Collège Simone de Beauvoir', '078', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée Général Louis Pasteur', '072', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Saint-Exupéry', '074', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Collège International Jules Verne', '089', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée Technique Marie Curie', '082', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Montessori de la Rive', '086', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée des Sciences Appliquées', '075', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Jean Moulin', '081', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Collège Paul Éluard', '084', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Étoiles', '079', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée Professionnel Léonard de Vinci', '092', 3);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Centre de services Secteur 3', '098', 3);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Horizon', '051', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Institut Saint-Benoît', '047', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Académie Lumière', '048', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Forêt', '067', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Communautaire Les Petits Savoirs', '068', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée Jacques Prévert', '058', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Arc-en-Ciel', '063', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Collège du Centre', '055', 1);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Centre de services Secteur 1', '099', 1);

INSERT INTO establishment(name, enumber, id_sector) VALUES ('Institut de la Réussite', '016', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Polytechnique Locale', '015', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Élémentaire La Fontaine', '014', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École des Sciences Naturelles', '017', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Lycée Jean Jaurès', '018', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École du Nord', '032', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École Charles Baudelaire', '034', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École du Savoir', '036', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Collège François Mitterrand', '038', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('École de la Liberté', '035', 2);
INSERT INTO establishment(name, enumber, id_sector) VALUES ('Centre de services Secteur 2', '097', 2);


