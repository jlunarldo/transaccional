# Etapa 1: Build con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Directorio de trabajo
WORKDIR /app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compilar el proyecto y generar el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con solo Java
FROM eclipse-temurin:21-jdk AS runtime

# Directorio dentro del contenedor
WORKDIR /app

# Copiar el .jar desde la etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Puerto según tu aplicación
EXPOSE 9001

# Iniciar la aplicación con perfil develop
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=develop"]
