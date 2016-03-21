## Frontend Development:

### Set up the development environment:
- npm & node.js > 4.0
- [jspm](http://jspm.io/docs/index.html) installed globally
- from root of project run `npm i` and `jspm i`

#### To run the app 
run `./gradlew run`
static content is served at http://localhost:8080

#### To use live editing
run `gulp serve`
live edits can be viewed at http://localhost:3001

#### To build the bundled webapp:
run `gulp ts`
the production code can be tested at http://localhost:8080/index-bundled.html

## Docker Development:

### Building the Docker Image
run `gradle build` to generate the .jar
run `docker build -t impact .` to generate the docker image

### Running the Docker Image
the docker image can optionally be run against a PostgreSQL or MySQL database

#### H2
the image can be run independently, which will default to an H2 database

run `docker run --rm -p 8080:8080 impact`

#### Postgres
to run against a Postgres image (for testing):

run `docker run -d --name postgres -e POSTGRES_DB=impact postgres`

then run ```docker run -itp 8080:8080 --name impact --link postgres \
    -e DB_URL=jdbc:postgresql://postgres:5432/impact \
    -e SPRING_PROFILES_ACTIVE=postgres impact```
    
#### MySQL
to run against a MySQL image

run `docker run -d --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=impact mysql`

then run ```docker run -itp 8080:8080 --name impact --link mysql \
    -e DB_URL=jdbc:mysql://mysql:3306/impact \
    -e SPRING_PROFILES_ACTIVE=mysql impact```
