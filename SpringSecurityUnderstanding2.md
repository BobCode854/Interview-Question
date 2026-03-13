# Spring Security + OAuth2 + JWT in Microservices

Complete guide for securing **Spring Boot Microservices** using **Spring Security 6, OAuth2, JWT, API Gateway, and Authorization Server**.

---

# 1. Why Security is Important in Microservices

In a **monolithic application**, security is usually handled in a single backend.

In **microservices architecture**, we may have:

- 10+ services
- multiple clients (Web / Mobile / 3rd party)
- services calling other services

So we need **centralized authentication and token-based authorization**. OAuth2 solves this problem by introducing an **Authorization Server that issues tokens used by services to validate requests**. :contentReference[oaicite:0]{index=0}

---

# 2. Microservices Security Architecture

Typical production architecture:

```
                 ┌──────────────┐
                 │   React UI   │
                 └──────┬───────┘
                        │
                        ▼
                 ┌──────────────┐
                 │  API Gateway │
                 │(Spring Cloud)│
                 └──────┬───────┘
                        │
        ┌───────────────┼────────────────┐
        ▼               ▼                ▼
 ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
 │ Order MS    │ │ Payment MS  │ │ Product MS  │
 │ResourceSrv  │ │ResourceSrv  │ │ResourceSrv  │
 └──────┬──────┘ └──────┬──────┘ └──────┬──────┘
        │               │                │
        └───────────────┼────────────────┘
                        ▼
               ┌────────────────┐
               │ Authorization  │
               │ Server         │
               │ (Keycloak/Okta)│
               └────────────────┘
```

Explanation:

| Component | Role |
|---|---|
| API Gateway | Entry point for client requests |
| Authorization Server | Issues OAuth2 tokens |
| Resource Server | Microservices validating token |
| JWT Token | Used to authorize requests |

Each microservice validates the JWT token before executing business logic. :contentReference[oaicite:1]{index=1}

---

# 3. OAuth2 Roles

OAuth2 defines four roles:

| Role | Description |
|---|---|
| Resource Owner | User |
| Client | Application requesting access |
| Authorization Server | Issues access token |
| Resource Server | API storing protected data |

---

# 4. OAuth2 Authorization Flow

Example: **Login with Google**

```
User
 │
 ▼
Client Application (Twitter)
 │
 │ Authorization Request
 ▼
Authorization Server (Google)
 │
 │ Access Token
 ▼
Client Application
 │
 │ Bearer Token
 ▼
Resource Server (API)
```

Steps:

1. User clicks **Login with Google**
2. Client redirects to Authorization Server
3. User authenticates
4. Authorization Server issues **Authorization Code**
5. Client exchanges code for **Access Token**
6. Client calls API with **Bearer Token**

---

# 5. OAuth2 Grant Types

| Grant Type | Use Case |
|---|---|
| Authorization Code | Web apps |
| Authorization Code + PKCE | Mobile / SPA |
| Client Credentials | Service-to-service |
| Device Code | Smart devices |

---

# 6. JWT (JSON Web Token)

JWT is a **compact token used to securely transfer information between client and server**.

Structure:

```
Header.Payload.Signature
```

Example:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkthcmFuIn0
.
signature
```

---

## Header

Contains:

```
{
 "alg":"HS256",
 "typ":"JWT"
}
```

---

## Payload

Contains **claims**

Types:

| Claim Type | Description |
|---|---|
| Registered | iss, sub, exp |
| Public | Standard fields |
| Private | Custom data |

Example:

```
{
 "sub":"user123",
 "roles":["ADMIN"],
 "scope":"read write"
}
```

---

## Signature

Generated using:

```
Base64(Header) + Base64(Payload) + Secret
```

Purpose:

- Ensures token integrity
- Prevents tampering

---

# 7. Spring Security Architecture

Every request passes through the **Security Filter Chain**.

```
Client Request
     │
     ▼
SecurityFilterChain
     │
     ▼
Authentication Filter
     │
     ▼
AuthenticationManager
     │
     ▼
UserDetailsService
     │
     ▼
Database
```

Spring Security provides authentication, authorization, session management, and protection against attacks such as CSRF. :contentReference[oaicite:2]{index=2}

---

# 8. Spring Security Filter Chain

Important filters:

| Filter | Purpose |
|---|---|
UsernamePasswordAuthenticationFilter | Login processing |
BasicAuthenticationFilter | HTTP Basic |
JwtAuthenticationFilter | Token validation |
SecurityContextPersistenceFilter | Manage security context |

---

# 9. Spring Security 6 Changes

Major changes in **Spring Boot 3 / Security 6**:

- Uses **Jakarta packages**
- Removed `WebSecurityConfigurerAdapter`
- Uses `SecurityFilterChain`
- Lambda-based DSL configuration
- Built-in OAuth2 resource server support

---

# 10. Spring Security Configuration (Spring Boot 3)

Example configuration:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

http
.csrf(csrf -> csrf.disable())

.authorizeHttpRequests(auth -> auth
.requestMatchers("/public/**").permitAll()
.anyRequest().authenticated()
)

.oauth2ResourceServer(oauth ->
oauth.jwt()
);

return http.build();
}
}
```

---

# 11. JWT Resource Server Configuration

Dependency:

```
spring-boot-starter-oauth2-resource-server
```

application.yml

```yaml
spring:
 security:
  oauth2:
   resourceserver:
    jwt:
     issuer-uri: https://dev-123.okta.com/oauth2/default
```

---

# 12. API Gateway Security

Gateway responsibilities:

- Validate token
- Route request to service
- Forward JWT

```
Client
  │
  ▼
API Gateway
  │
  │ Token Relay
  ▼
Microservices
```

---

# 13. Service-to-Service Security

For microservices communication:

```
Service A → Service B
```

Use:

```
Client Credentials Grant
```

Flow:

```
Service A → Authorization Server → Access Token → Service B
```

---

# 14. Method-Level Security

Enable:

```java
@EnableMethodSecurity
```

Example:

```java
@PreAuthorize("hasRole('ADMIN')")
public void deleteUser(){
}
```

Other annotations:

- `@PostAuthorize`
- `@Secured`
- `@RolesAllowed`

---

# 15. Roles vs Authorities

| Concept | Example |
|---|---|
Authority | READ_PRIVILEGE |
Authority | WRITE_PRIVILEGE |
Role | ROLE_ADMIN |
Role | ROLE_USER |

Role = **Collection of Authorities**

---

# 16. SecurityContext

Spring Security stores authentication info inside:

```
SecurityContextHolder
```

Contains:

```
Authentication
 ├── Principal
 ├── Credentials
 └── Authorities
```

---

# 17. Interview Questions

### Q1 What is Spring Security?

Framework that provides **authentication, authorization and protection against attacks**.

---

### Q2 Difference between Authentication and Authorization?

Authentication → Who you are  
Authorization → What you can access

---

### Q3 Why OAuth2 in microservices?

- Central authentication
- Token based security
- Stateless architecture

---

### Q4 Why JWT used?

- Stateless
- Self-contained token
- Scalable for microservices

---

### Q5 What is Resource Server?

Service that **hosts protected resources and validates access tokens**.

---

# 18. Tools Used in Production

Common Authorization Servers:

- Keycloak
- Okta
- Auth0
- AWS Cognito

---

# 19. Real Production Architecture

```
React UI
   │
   ▼
API Gateway
   │
   ▼
Authorization Server (Keycloak)
   │
   ▼
Microservices
   ├── Order Service
   ├── Payment Service
   └── Inventory Service
```

---

# 20. Best Practices

✔ Use **JWT access tokens**  
✔ Use **API Gateway security**  
✔ Keep tokens short-lived (15-30 min)  
✔ Use **Refresh tokens**  
✔ Implement **Role-based access control**

---

# 21. Summary

Spring Security + OAuth2 provides:

- Centralized authentication
- Token based authorization
- Scalable microservices security
- Stateless APIs

---

