FROM openjdk:17-slim
WORKDIR /app
COPY .. /app
RUN /app/gradlew :product-application:bootJar
RUN /app/gradlew :order-application:bootJar
RUN /app/gradlew :payment-application:bootJar
RUN /app/gradlew :shipping-application:bootJar

