# assignment-project

#Docker postger
docker pull postgres
docker run --name movie-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres

#migration script
