# OSM Data Reader (Nepal)

######Please note that this is a work in progress and not a finished project.

## Description:
This project reads the geo data from various sources. As well as 
provides an interface to manage and refine thus read data.

The backend of the application is build using Java 10 and Spring Boot.
Thus it provides many different purposed api endpoints. Those endpoints
can be checkout on the swagger UI located at: http://localhost:9090/swagger-ui.html#/

The application provides following docker containers:
1. Postgres Database with `postgis` enabled.
2. Admin interface to work with database.
3. `osm2pgsql` container to import `.pbf` file which can be downloaded from https://download.geofabrik.de/. The downloaded data can be imported to the `postgres` database on the another container.

## Requirements:
1. Java 10.
2. Docker and docker-compose
3. node js & npm
4. The application is built using the `arch` linux, but all the docker images are based on `debian`. So is only tested on the linux system. 

## Installation
1. Install all the dependencies as mentioned on the requirements.
2. Clone thi repository: `git clone https://github.com/bpawan/osm-reader.git`.
3. Change directory to `osm-reader`: `cd osm-reader`.
4. Run the containers: `docker-compose up -d`

## Usage
1. First you will need to import the osm data, You can do that with the following steps:
    1. Download the `.pbf` file from geofabrik website. e.g (https://download.geofabrik.de/asia/nepal-latest.osm.pbf).
    2. copy the downloaded file into the `data` folder.
    3. Run `docker-compose run osm2pgsql bash` to run the importer container.
    4. Once inside the container run `osm2pgsql -c -d gis --slim -Uroot -Hpostgis -dnepaldata -W /tmp/<downloaded_filemane>.pbf`.
    This will create as database named `nepaldata`. Please note you can change the name of the database as you like.
    5. This should take a while and once it is done you will have all the data imported into the postgres database.
    6. Use the url http://localhost:8888/?pgsql=postgis&username=root&db=nepaldata&ns=public&sql= (password is `root`) to login to admin interface and execute `CREATE EXTENSION hstore;` to enable hstore extension for postgres.
2. Now you can run the backend application `mvn spring-boot:run`.
3. To run the frontend application. Please follow the following steps:
    1. Change directory to `frontend/osm_frontend` i.e. `cd frontend/osm_reader`.
    2. Now run `npm install`.
    3. Run `npm start` to start to node server (note that this will launch app in dev mode, since live mode is not yet ready).
    
4. Once you reach this point you should be able start developing it.

Few things:
1. Api base url http://localhost:9090
2. Swagger ui: http://localhost:9090/swagger-ui.html#/
3. Frontend Application: http://localhost:3000
4. Database administration: http://localhost:8888/ (user: `root`, pass: `root`, db: `nepaldata`, System: `PostgreSQL`, server: `postgis`).
    
## TODO
1. Write an automated script to import osm data including the downloading of data file.
2. Write a dockerfile for `posgtres` so that `hstore` is already enabled.
3. Solve the awkward error thrown by Hibernate on Java 11.
