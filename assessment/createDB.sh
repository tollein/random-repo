#!/bin/bash

# It creates database and its tables from resources/db/database.sql file

RADICE=$(pwd)
mysql -ulunatech -e "source $RADICE/src/main/resources/db/database.sql;"
echo "1/2 Database assessment created."
echo -e "****************************************************************************\n"

sed -i "s/\("db.populated" *= *\).*/\1no/" src/main/resources/config.properties
sed -i "s@csv.path.*@csv.path=`pwd`@g" src/main/resources/config.properties
echo "2/2 Properties file updated."
echo -e "Done!\n"


