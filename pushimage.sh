#!/bin/sh 
docker tag servicemesh-leaf1:latest docker.io/sholly/servicemesh-leaf1:delay
docker push docker.io/sholly/servicemesh-leaf1:delay
