# Impact

### Consumer Driven Contracts

---

## Motivation

Current Consumer Driven Contract (CDC) frameworks lack flexibility and feature richness that large organizations need to for successful adoption. Relationships between services rarely fit the idealized model required by these frameworks — API calls are often destructive or non-idempotent, tests often require startup/teardown operations. Our aim is to offer an enterprise grade CDC solution that works in the real world. 

Consumer driven contracts capture the nuances of relationships between services. As a secondary motivation, Impact should offer detailed insight into these relationships.

---

## High-Level Goals

- Maximize usability early on
    - build a functional web console fully capable of creating, managing, and testing contracts
    - only after creating an MVP console should libraries be created
    This ensures that there is always *some* way for a team to create contracts
- Capture Everything
    - a major value-add for teams will be providing detailed insights into how services interact on an organizational level
- Strict adherence to the [Robustness Principle](https://en.wikipedia.org/wiki/Robustness_principle)
- Consumers must be explicit in what they expect and accept
- Should offer startup/teardown options for testing contracts
    - work with destructive/non-idempotent APIs
- Flexible run environment
- Flexible workflow
	- handling test failures
- Built with the entire organization in mind
	- concept of teams and their interactions
	- should be easy to use for both developers and project owners
- Communicative
	- webhooks
	- email server integration
	
## Future Goals

- Extensible
    - language/framework specific integrations
- SaaS option
- Authentication integration
- Ecosystem
	- integration with jenkins/travis/etc
- Control flows:
	- CDC generated API keys — requiring a contract for API access
    - consumer-driven vs producer-driven contracts

---

## Current Workflow

Initially we would like to build out core API and a fully functional web console.
Users should be able to create contracts, define acceptable requests and responses, and run tests within the console.
This will allow teams to utilize Impact as soon as possible, without having to wait for an SDK that works with their stack.

---

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
