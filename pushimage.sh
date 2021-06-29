#!/bin/sh 
docker tag servicemesh-leaf1:latest docker.io/sholly/servicemesh-leaf1:netpolicy
docker push docker.io/sholly/servicemesh-leaf1:netpolicy
