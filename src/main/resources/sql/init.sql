/** CREATE A SCHEMA FOR LOCAL TESTING ***/

//DROP IF EXISTS
DROP SCHEMA IF EXISTS ATHENA;

// CREATE SCHEMA
CREATE SCHEMA ATHENA AUTHORIZATION SA;

// DROP THE TABLE
DROP TABLE IF EXISTS ATHENA.SOURCE;

// CREATE THE DATA_SOURCE TABLE
CREATE TABLE ATHENA.SOURCE
(
  id              INTEGER               AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name            VARCHAR(255)                                     NOT NULL,
  url             VARCHAR(255)                                     NOT NULL,
  source_type     VARCHAR(255)                                     NOT NULL,
  description     TEXT
);

// INSERT SOME CONFIGURATIONS
INSERT INTO SOURCE (name, url, source_type, description) VALUES ('MEM::H2 Datasource', 'jdbc:h2:mem:DEV_ATHENA', 'H2', 'Example DataSource for Athena Application');

