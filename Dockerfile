# Etapa 1: Construcción (Build) usando Maven oficial
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copiamos el archivo de configuración y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos usando el Maven que ya está instalado en la imagen
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiamos el archivo .jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Comando para arrancar la API
ENTRYPOINT ["java", "-jar", "app.jar"]
