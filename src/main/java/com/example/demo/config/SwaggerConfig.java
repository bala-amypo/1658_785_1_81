# ===============================
# Server Configuration
# ===============================
server.port=9183

# ===============================
# Spring Application
# ===============================
spring.application.name=digital-asset-management

# ===============================
# Database Configuration (H2 - safe default)
# ===============================
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# ===============================
# Swagger / OpenAPI (springdoc)
# ===============================
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha

# ===============================
# Logging
# ===============================
logging.level.org.springframework=INFO
logging.level.com.example.demo=DEBUG
