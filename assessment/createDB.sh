#!/bin/bash

# It creates database and its tables from resources/db/database.sql file
RADICE=$(pwd)
mysql -ulunatech -e "source $RADICE/src/main/resources/db/database.sql;"
echo "Database assessment created."
sed -i "s/\("db.populated" *= *\).*/\1no/" conf/config.properties
sed -i "s@csv.path.*@csv.path=`pwd`@g" conf/config.properties