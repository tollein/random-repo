DROP DATABASE IF EXISTS assessment;

CREATE DATABASE assessment;

USE assessment;

DROP TABLE IF EXISTS countries;
CREATE TABLE IF NOT EXISTS countries(
   id             INTEGER  NOT NULL PRIMARY KEY 
  ,code           VARCHAR(2) NOT NULL
  ,name           VARCHAR(44) NOT NULL
  ,continent      VARCHAR(2) NOT NULL
  ,wikipedia_link VARCHAR(73) NOT NULL
  ,keywords       VARCHAR(34)
);

DROP TABLE IF EXISTS airports;
CREATE TABLE IF NOT EXISTS airports(
   id                INTEGER  NOT NULL PRIMARY KEY 
  ,ident             VARCHAR(4) NOT NULL
  ,type              VARCHAR(15) NOT NULL
  ,name              VARCHAR(20) NOT NULL
  ,latitude_deg      NUMERIC(20,14) NOT NULL
  ,longitude_deg     NUMERIC(20,14) NOT NULL
  ,elevation_ft      INTEGER  NOT NULL
  ,continent         VARCHAR(2) NOT NULL REFERENCES countries(continent)
  ,iso_country       VARCHAR(2) NOT NULL REFERENCES countries(code)
  ,iso_region        VARCHAR(5) NOT NULL
  ,municipality      VARCHAR(15) NOT NULL
  ,scheduled_service VARCHAR(2) NOT NULL
  ,gps_code          VARCHAR(4) NOT NULL
  ,iata_code         VARCHAR(1)
  ,local_code        VARCHAR(4) NOT NULL
  ,home_link         VARCHAR(1)
  ,wikipedia_link    VARCHAR(1)
  ,keywords          VARCHAR(1)
);

DROP TABLE IF EXISTS runways;
CREATE TABLE IF NOT EXISTS runways(
   id                        INTEGER  NOT NULL PRIMARY KEY 
  ,airport_ref               INTEGER  NOT NULL REFERENCES airports(id)
  ,airport_ident             VARCHAR(5) NOT NULL REFERENCES airports(ident)
  ,length_ft                 INTEGER  NOT NULL
  ,width_ft                  INTEGER  NOT NULL
  ,surface                   VARCHAR(10) NOT NULL
  ,lighted                   BIT  NOT NULL
  ,closed                    BIT  NOT NULL
  ,le_ident                  INTEGER  NOT NULL
  ,le_latitude_deg           NUMERIC(20,4) NOT NULL
  ,le_longitude_deg          NUMERIC(20,3) NOT NULL
  ,le_elevation_ft           VARCHAR(5)
  ,le_heading_degT           INTEGER  NOT NULL
  ,le_displaced_threshold_ft VARCHAR(5)
  ,he_ident                  INTEGER  NOT NULL
  ,he_latitude_deg           NUMERIC(20,4) NOT NULL
  ,he_longitude_deg          NUMERIC(20,3) NOT NULL
  ,he_elevation_ft           VARCHAR(5)
  ,he_heading_degT           VARCHAR(5)
  ,he_displaced_threshold_ft VARCHAR(5)
);
