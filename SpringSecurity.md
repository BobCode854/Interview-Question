# Spring Security (2 Hours)

---

## OAuth
- Spring Cloud Security
- Microservices me security kahan define karte hain
- Required dependencies

---

# Spring Security

Spring Security is a **powerful and customizable authentication and authorization framework** that protects Java applications.

It handles security concerns such as:

- User authentication
- Role-based access control
- Session management
- Protection against common security threats

In Spring Security:

- **Authentication** is handled by `AuthenticationManager` and filters like `UsernamePasswordAuthenticationFilter`.
- **Authorization** is enforced by roles and authorities through annotations like:

```java
@PreAuthorize("hasRole('ADMIN')")
```

Spring Security stores authenticated user information in a **SecurityContext** that contains an `Authentication` object representing the user identity and authorities. :contentReference[oaicite:0]{index=0}

---

# Types of Authentication

### 1. Knowledge-Based Authentication
Something the user **knows**

Examples:

- Password
- PIN
- Security question answers

---

### 2. Possession-Based Authentication
Something the user **has**

Examples:

- Access Tokens
- Key Cards
- OTP / Text message on phone

---

### 3. Knowledge + Possession (Multi-Factor Authentication)

Examples:

- AWS login
- VDI login
- Banking authentication

---

# OAuth

OAuth is an **open standard protocol for authorization (not authentication)**.

It allows applications to access resources on behalf of a user **without sharing the user's credentials**.

---

# Spring Security 6 Changes

Major changes in **Spring Security 6**:

- Uses **Jakarta packages**
- `WebSecurityConfigurerAdapter` is removed
- Uses **SecurityFilterChain Bean configuration**
- Lambda-based **DSL (Domain Specific Language)**
- Better integration with **OAuth2 Resource Server**
- Built-in **JWT Decoder support**

---

# Spring Security 6 Request Flow

```
Client
   ↓
SecurityContextPersistenceFilter
   ↓
Authentication Filters
   ↓
ExceptionTranslationFilter
   ↓
FilterSecurityInterceptor
   ↓
Controller
```

---

# UserDetails and UserDetailsService

### UserDetails

`UserDetails` is a **core interface in Spring Security that represents user information used for authentication and authorization**. :contentReference[oaicite:1]{index=1}

It acts like a **blueprint of the logged-in user**.

Example methods:

- `getUsername()`
- `getPassword()`
- `getAuthorities()`
- `isAccountNonLocked()`

---

### UserDetailsService

`UserDetailsService` is an interface responsible for **loading user data during authentication**. :contentReference[oaicite:2]{index=2}

Main method:

```java
UserDetails loadUserByUsername(String username)
```

---

### Simple Explanation

```
UserDetails = What Spring Security knows about your user
```

---

### Flow

```
Database
   ↓
Repository
   ↓
UserDetailsService
   ↓
loadUserByUsername(username)
   ↓
Fetch data from DB
   ↓
Return UserDetails object
```

---

# How Authentication Works

1. User submits login credentials.
2. `UsernamePasswordAuthenticationFilter` captures them.
3. Spring Security calls `UserDetailsService.loadUserByUsername()`
4. User details are fetched from DB.
5. Password is verified using `PasswordEncoder`.
6. On success, the `UserDetails` is stored in **SecurityContext**.

---

# Roles vs Authorities

### Authorities

Fine-grained permissions.

Examples:

```
READ_PRIVILEGE
WRITE_PRIVILEGE
DELETE_PRIVILEGE
```

---

### Roles

High-level grouping of authorities.

Examples:

```
ROLE_ADMIN
ROLE_USER
```

Example:

```
ROLE_ADMIN
 ├── READ
 ├── WRITE
 └── UPDATE
```

---

# SecurityContext

`SecurityContext` stores the **authentication details of the currently authenticated user**.

It contains:

```
Authentication Object
   ├── Principal (User)
   ├── Credentials
   └── Authorities
```

Spring Security provides access using:

```java
SecurityContextHolder.getContext()
```

---

# Method-Level Security

Method-level security allows controlling access to **specific methods**.

Common annotations:

```
@PreAuthorize
@PostAuthorize
@Secured
@RolesAllowed
```

Example:

```java
@PreAuthorize("hasRole('ADMIN')")
```

---

# Spring Security Filters

Spring Security uses a **Filter Chain** to process incoming HTTP requests.

Common filters:

| Filter | Purpose |
|------|------|
| `UsernamePasswordAuthenticationFilter` | Handles login requests |
| `BasicAuthenticationFilter` | Handles HTTP Basic authentication |
| `JwtAuthenticationFilter` | Validates JWT tokens |
| `SecurityContextPersistenceFilter` | Manages security context |

---

# Handling Concurrent Logins

Limit concurrent sessions:

```java
http.sessionManagement(session -> session
        .maximumSessions(1)
        .expiredUrl("/login?expired"));
```

---

### SessionCreationPolicy Options

| Policy | Description |
|------|------|
| ALWAYS | Always create session |
| IF_REQUIRED | Create session if needed |
| NEVER | Do not create but use existing |
| STATELESS | No session (used for JWT APIs) |

---

# AuthenticationManager

`AuthenticationManager` processes authentication requests.

It delegates authentication logic to **AuthenticationProvider**.

```
AuthenticationManager
        ↓
AuthenticationProvider
        ↓
UserDetailsService
        ↓
Database
```

---

# OAuth2 Flow Example

Example: **Login with Google on Twitter**

1️⃣ Client (Twitter) requests authorization from **Resource Owner (User)**.

2️⃣ User grants permission.

3️⃣ Client sends authorization grant to **Authorization Server**.

Example Authorization Servers:

- OKTA
- Auth0
- Keycloak

4️⃣ Authorization Server returns **Access Token**.

5️⃣ Client uses Access Token to access **Resource Server** (Google/Facebook).

---

# OAuth2 Components

| Component | Description |
|------|------|
| Resource Owner | User |
| Client | Application requesting access |
| Resource Server | API storing user data |
| Authorization Server | Issues access tokens |

---

# OAuth2 Grants

OAuth2 provides several grant types:

- Client Credentials
- Authorization Code
- Authorization Code + PKCE
- Device Code

---

# JWT (JSON Web Token)

JWT is a **compact token used to securely transfer information between client and server**.

Structure:

```
Header.Payload.Signature
```

---

### Header

Contains:

- Token Type: JWT
- Signing Algorithm: SHA256 / RSA

---

### Payload

Contains **claims** (user information).

Types of claims:

- Registered
- Public
- Private

---

### Signature

Generated using:

```
Encoded Header + Encoded Payload + Secret Key
```

Purpose:

- Ensures **token integrity**
- Prevents tampering

---

### Important Points

- JWT is **cryptographically signed**
- Cannot be modified by client
- Often used as **OAuth2 access token format**

---

# OKTA Setup

Dependency:

```
okta-spring-boot-starter
```

---

### Steps

1. Go to OKTA Dashboard
2. Create Application
3. Select

```
Application → Create App Integration
```

Choose:

- API Services
- OpenID Connect

---

### After creation you get

```
Client ID
Client Secret
Issuer URI
```

You may also create **Custom Scopes**.

---

# Architecture

```
UI Application
       ↓
     OKTA
       ↓
Backend Protected API
```

---

# Token Generation

Call token endpoint:

```
POST
IssuerURI/v1/token
```

Authentication:

```
username : client_id
password : client_secret
```

Body (`x-www-form-urlencoded`):

```
grant_type = client_credentials
scope = custom_scope
```

---

# Accessing Protected APIs

After receiving token:

```
Authorization: Bearer <token>
```

Then you can access protected backend APIs.

---
