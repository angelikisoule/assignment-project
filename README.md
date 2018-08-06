# assignment-project

# Docker postgres
docker pull postgres:9.3
docker run --name movie-postgres -p 5532:5432 -e POSTGRES_PASSWORD=postgres -d postgres:9.3

# Database

## Init db
mvn clean install -DskipTests -Dinit.database.skip=false -Ddb.host=localhost -Ddb.port=5532 -Ddb.root.password=postgres -Ddb.module.password=postgres flyway:migrate

## Run flyway on an existing db
mvn clean install -DskipTests -Ddb.module.database.name=movies -Ddb.module.userId=movies_postgres -Ddb.host=localhost -Ddb.port=5532 -Ddb.module.password=postgres flyway:migrate
