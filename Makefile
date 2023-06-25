install:
	mvn clean install
run:
	mvn spring-boot:run

db_start:
	docker-compose up -d

db_stop:
	docker-compose down