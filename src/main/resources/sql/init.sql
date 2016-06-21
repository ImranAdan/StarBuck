/** CREATE A SCHEMA FOR LOCAL TESTING ***/

// Create a schema
CREATE SCHEMA ATHENA AUTHORIZATION SA;

// Create a table for data sources
CREATE TABLE ATHENA.SOURCE
(
  id              INTEGER               AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name            VARCHAR(255)                                     NOT NULL,
  url             VARCHAR(255)                                     NOT NULL,
  source_type     VARCHAR(255)                                     NOT NULL,
  description     TEXT
);

// Insert Test config data
INSERT INTO SOURCE (name, url, source_type, description) VALUES ('MEM::H2 Datasource', 'jdbc:h2:mem:DEV_ATHENA', 'H2', 'Example DataSource for Athena Application');

