
# Quarkus Projects

Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running applications

The application is packageable using `./mvnw package`.
It produces the executable `quarkus-hello-pod-1.0.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/quarkus-hello-pod-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or you can use Docker to build the native executable using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your binary: `./target/quarkus-hello-pod-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image-guide .

## Ref Links

<https://github.com/apache/camel-quarkus/tree/master/integration-tests />
<https://codefresh.io/docker-tutorial/java_docker_pipeline />
<https://github.com/PacktPublishing/Hands-On-Cloud-Native-Applications-with-Java-and-Quarkus />

## Quarkus Commands
```
netstat -an | grep 5005
```
```
-Dquarkus.http.test-port=9091
```
```
ps -o pid,rss,command -p $(pgrep -f chapter02)
```
```
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/chapter03-okd .
```
```
docker build -f src/main/docker/Dockerfile.native -t quarkus/chapter03-okd-native .
```
```
docker run -i --name app --rm -p 8080:8080 quarkus/chapter03-okd
docker run -i --name app --rm -p 8080:8080 quarkus/chapter03-okd-native
```
```
docker ps --format '{{.Image}}'
```

## Maven Commands

<code>./mvnw -Dplugin=io.quarkus:quarkus-maven-plugin help:describe</code>

<code>./mvnw compile quarkus:dev</code>

<code>./mvnw clean -DskipTests package -Pnative</code>

<code>mvn clean -DskipTests package -Pnative -Dnative-image.docker-build</code>

## OCI - Universal Base Images (UBI)
```
Red Hat Universal Base Images (UBI) are OCI-compliant container OS images that include complimentary
runtime languages and other packages that are freely redistributable.
```
## Openshift Binary Build Commands
```
oc new-build --binary --name=quarkus-hello-app -l app=quarkus-hello-app
mvn clean -DskipTests package -Pnative -Dnative-image.docker-build
oc start-build quarkus-hello-app --from-dir=. --follow
oc new-app quarkus-hello-app -l app=quarkus-hello-app
oc expose service quarkus-hello-app
--- Only updates ---
mvn clean -DskipTests package -Pnative -Dnative-image.docker-build
oc start-build quarkus-hello-app --from-dir=. --follow
```

