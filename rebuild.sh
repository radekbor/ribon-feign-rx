mvn -f ./admin/ clean install
mvn -f ./books/ clean install
mvn -f ./customers/ clean install
mvn -f ./gateway/ clean install
docker-compose up --force-recreate --build