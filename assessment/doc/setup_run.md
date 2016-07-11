SETUP
=====

#### Install MySQL
The program for the assessment uses JDBC driver to interact with MySQL.
As first step, if you do not have `MySQL` installed on your host machine, you need to install it.
During installation, setup username for MySQL as "lunatech". Do not set any password.

CONFIGURATION
=============

#### Database creation
To create the database and its tables, go in the assessment folder and run the script:
```
$ ./createDB.sh
```

RUN ASSESSMENT
==============
To run the assessment, in the assessment folder run the script:
```
$ ./assessment.sh
```

`NOTE: At the first execution, this script populates the database, so it will take a few seconds.`