DROP DATABASE IF EXISTS assessment;

CREATE DATABASE assessment;

USE assessment;

#DROP TABLE IF EXISTS countries;
CREATE TABLE IF NOT EXISTS countries(
   id             INTEGER  NOT NULL PRIMARY KEY 
  ,code           VARCHAR(2) NOT NULL
  ,name           VARCHAR(44) NOT NULL
  ,continent      VARCHAR(2) NOT NULL
);

#DROP TABLE IF EXISTS airports;
CREATE TABLE IF NOT EXISTS airports(
   id                INTEGER  NOT NULL PRIMARY KEY 
  ,ident             VARCHAR(5) NOT NULL
  ,type              VARCHAR(15) NOT NULL
  ,name              VARCHAR(20) NOT NULL
  ,continent         VARCHAR(2) NOT NULL REFERENCES countries(continent)
  ,iso_country       VARCHAR(2) NOT NULL REFERENCES countries(code)
  ,iso_region        VARCHAR(5) NOT NULL
);

#DROP TABLE IF EXISTS runways;
CREATE TABLE IF NOT EXISTS runways(
   id                        INTEGER  NOT NULL PRIMARY KEY 
  ,airport_ref               INTEGER  NOT NULL REFERENCES airports(id)
  ,airport_ident             VARCHAR(5) NOT NULL REFERENCES airports(ident)
  ,surface                   VARCHAR(10) NOT NULL
  ,le_ident                  INTEGER  NOT NULL
);
