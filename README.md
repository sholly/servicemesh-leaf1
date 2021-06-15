build docker image: 
`docker build -t servicemesh-leaf1 . `

running: 

first create network: 
`docker network create meshtest`

Run with 'docker' profile and meshtest network
```
docker run -it -p 8081:8081 --network meshtest -e  SPRING_PROFILES_ACTIVE=docker\
 --rm --name servicemesh-leaf1 servicemesh-leaf1
```