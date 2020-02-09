## Generate Projects
mvn archetype:generate -DgroupId=com.packtpub.apps.quarkus -DartifactId=chapter

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

## Jaeger Service
```
docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one
```
## Setting Up Keycloak
```
docker run --rm --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8180 -it quay.io/keycloak/keycloak:7.0.1 -b 0.0.0.0 -Djboss.http.port=8180 -Dkeycloak.profile.feature.upload_scripts=enabled
```

## Maven Commands

<code>./mvnw -Dplugin=io.quarkus:quarkus-maven-plugin help:describe</code>

<code>./mvnw compile quarkus:dev</code>

<code>./mvnw clean -DskipTests package -Pnative</code>

<code>./mvnw package -Pnative -Dquarkus.native.container-build=true</code>

## OCI - Universal Base Images (UBI)
```
Red Hat Universal Base Images (UBI) are OCI-compliant container OS images that include complimentary
runtime languages and other packages that are freely redistributable.
```
## Openshift Binary Build Commands
```
minishift oc-env 
oc new-build --binary --name=quarkus-hello-app -l app=quarkus-hello-app
mvn clean -DskipTests package -Pnative -Dquarkus.native.container-build=true
oc start-build quarkus-hello-app --from-dir=. --follow
oc new-app quarkus-hello-app -l app=quarkus-hello-app
oc expose service quarkus-hello-app
oc scale --replicas=10 dc/quarkus-hello-app
--- Only updates ---
mvn clean -DskipTests package -Pnative -Dquarkus.native.container-build=true
oc start-build quarkus-hello-app --from-dir=. --follow
```

## Imperative style Code
```text
Statement by statement
URL url = new URL('http://acme.com');
BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream());
...
```
## Reactive style Code
```text
Processes incoming events over the event loop

1. Responsive
2. Resilient
3. Elastic
4. Message-driven
-- Callback concept --
the running thread is released while connection with
the HTTP server is being established, then when the
response comes, we can reached it sooner
```

```
vertx.createHttpClient().getNow(80, "acme.com", "", response -> {
    response.bodyHandler(out::println);
});
```