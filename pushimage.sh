#!/bin/sh 
docker tag servicemesh-leaf1:latest docker.io/sholly/servicemesh-leaf1:jaeger
docker push docker.io/sholly/servicemesh-leaf1:jaeger
