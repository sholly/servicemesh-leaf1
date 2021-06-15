#!/bin/sh 
mvn clean package
docker build -t servicemesh-leaf1 .
