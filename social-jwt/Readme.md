#### Lab 1: Secure a REST API with JWT Authentication

#### <bold> Scenario: </bold>You're building a REST API for a social media platform. Users need to be authenticated securely before accessing their profiles or posting content.

## Tasks:

- Implement JWT authentication in your Spring Boot application.
- Users log in with username and password, receiving a JWT token upon successful authentication.
- Secure API endpoints by requiring a valid JWT token in the authorization header.
- Implement logic to validate and decode JWT tokens within controllers.

#### Using an in memory user to achieve this

```
- payload (json)

{
    "email": "dickson",
    "password": "password"
}
```

#### Response

```
{
    "token": "",
    "email": {
        "password": null,
        "username": "dickson",
        "authorities": [
            {
                "authority": "read"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    }
}j
```
