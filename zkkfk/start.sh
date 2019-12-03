#!/usr/bin/env bash
docker network create --gateway 172.19.1.1 --subnet 172.19.1.0/24 zkkfk
COMPOSE_PROJECT_NAME=zk-kfk docker-compose up -d
