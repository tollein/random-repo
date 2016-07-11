#!/bin/bash

# It run the Main class of assessment

JAR="target/assessment-1.0-jar-with-dependencies.jar"
echo "Maven packaging..."
mvn clean compile assembly:single
echo -e "\n\n"
java -jar $JAR