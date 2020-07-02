#!/usr/bin/env bash

set -euo pipefail
which psql > /dev/null || (echo "Please ensure that postgres client is in your PATH" && exit 1)

if docker ps | grep pg-docker; then docker stop pg-docker; fi

mkdir -p $HOME/docker/volumes/postgres
rm -rf $HOME/docker/volumes/postgres/data

docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5332:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql postgres
sleep 3
export PGPASSWORD=postgres
psql -p 5332 -U postgres -d dev -h localhost -f schema.sql
psql -p 5332 -U postgres -d dev -h localhost -f data.sql