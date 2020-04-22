# java-server

A program that can run either an echo server or a http server.

## Dependencies

This is a Java v14 project using Maven v4.0.0

## Setup

### Clone down the project

```shell
git clone https://github.com/karl-thomas/java-server.git
```

### Build the project

```shell
mvn package
```

## Running the Project

In order to run the project successfully, you need to supply command line arguments when running the Main class.

The first argument is for the port, and the second is for denoting between running an `echo` server, or a `http` server.

### Echo

To run the echo server you could run

```shell
java -jar target/java-server-1.0-SNAPSHOT.jar 5000 echo
```

This will start an echo server on port 5000, and it will echo back anything that you sent to it.

### HTTP

To run the HTTP server you could run

```shell
java -jar target/java-server-1.0-SNAPSHOT.jar 5000 http
```

This command will start an HTTP server on port 5000. This server currently only has a single route, which is a GET request to /simple_get and it will respond with a 200 OK with no body.

## Testing

To test the project run

```shell
mvn verify
```

This will run the Unit and the integration tests. The integration tests are run using failsafe, in order to only run the unit tests you can run

```shell
mvn verify -DskipITs
```

So far I have not found a consistent way to only run the acceptance tests, as they need a server running in order for them to work you cannot just run the tests in isolation. This is less impactful then not being able to skip them in order for faster unit testing though.
