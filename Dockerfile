FROM eclipse-temurin:17

WORKDIR /app

COPY . .

# ✅ GIVE PERMISSION
RUN chmod +x mvnw

# ✅ BUILD PROJECT
RUN ./mvnw clean package -DskipTests

# ✅ RUN JAR
CMD ["java", "-jar", "target/AES-Project-0.0.1-SNAPSHOT.jar"]