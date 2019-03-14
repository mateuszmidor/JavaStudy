#!/bin/bash

function die() {
    echo "Error: $1. Exiting"
    exit 1
}
mvn package || die "Error building app"
java -jar target/JustifyStudy-1.0-SNAPSHOT.jar
