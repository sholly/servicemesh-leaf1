#!/bin/sh 
 docker run -d -p 8081:8081 --network meshtest -e  SPRING_PROFILES_ACTIVE=docker \
 --rm --name servicemesh-leaf1 servicemesh-leaf1
