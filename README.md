# quarkus-protobuf project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## How to generate basic quarkus skeleton project Please open the below link
```shell renderscript
https://code.quarkus.io/
```

## Dependency required
Quarkus gRPC extension dependency
```shell script
<dependency>
<groupId>io.quarkus</groupId>
<artifactId>quarkus-grpc</artifactId>
</dependency>
```
you have generate-code goal of quarkus-maven-plugin enabled in your pom.xml. If you wish to generate code from different proto files for tests, also add the generate-code-tests goal:
```shell script
<plugin>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-maven-plugin</artifactId>
        <version>${quarkus-plugin.version}</version>
        <extensions>true</extensions>
        <executions>
          <execution>
            <goals>
              <goal>build</goal>
              <goal>generate-code</goal>
              <goal>generate-code-tests</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
```
## To generate class from proto file
```shell script
mvn compile
```
## Important Note : Implementing a gRPC service
With Quarkus, implementing a service requires to extend the generated service base implementation and expose it as a @Singleton CDI bean.
Don’t use @ApplicationScoped as the gRPC service implementation cannot be proxied.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/quarkus-protobuf-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Related guides

- REST Client ([guide](https://quarkus.io/guides/rest-client)): Call REST services

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
