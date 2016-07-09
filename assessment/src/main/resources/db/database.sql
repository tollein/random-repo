DROP DATABASE IF EXISTS assessment;

CREATE DATABASE assessment;

USE assessment;

DROP TABLE IF EXISTS countries;
CREATE TABLE countries(
   id             INTEGER  NOT NULL PRIMARY KEY 
  ,code           VARCHAR(5) NOT NULL
  ,name           VARCHAR(45) NOT NULL
  ,continent      VARCHAR(20)
);

DROP TABLE IF EXISTS airports;
CREATE TABLE  airports(
   id                INTEGER  NOT NULL PRIMARY KEY 
  ,ident             VARCHAR(10) NOT NULL
  ,type              VARCHAR(15)
  ,name              VARCHAR(80)
  ,continent         VARCHAR(20) REFERENCES countries(continent)
  ,iso_country       VARCHAR(5) NOT NULL REFERENCES countries(code)
  ,iso_region        VARCHAR(15)
);

DROP TABLE IF EXISTS runways;
CREATE TABLE runways(
   id                        INTEGER  NOT NULL PRIMARY KEY 
  ,airport_ref               INTEGER  NOT NULL REFERENCES airports(id)
  ,airport_ident             VARCHAR(10) NOT NULL REFERENCES airports(ident)
  ,surface                   VARCHAR(60)
  ,le_ident                  VARCHAR(55)
);
