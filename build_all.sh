#!/usr/bin/env bash

cd discovery
mvn package spring-boot:repackage

cd ../edge/
mvn package spring-boot:repackage

cd ../restaurant/
mvn package spring-boot:repackage -Dskiptests=true

cd ..
