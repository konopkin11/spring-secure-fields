
# Spring secure fields
Just look at core folder. Three files and you can protect your DAO or DTO by user permissions. It won't break project's inside work because it checks fields when it serializes.

## Examples
```java
@JsonFilter("AllowedFilter")
public class User {
    @Allowed(authorities = {"CAN_READ_ADMIN", "CAN_READ_USER"})
    private String email;
    @Allowed(authorities = {"CAN_READ_ADMIN"})
    private String password;
    @Allowed(authorities = {"CAN_READ_USER"})
    private String onlyUserData;
    @Allowed(authorities = {"CAN_READ_ADMIN"})
    private String onlyAdminData;
```
### Request with "CAN_READ_ADMIN" authority

`GET /users/`

    curl -i -H 'Accept: application/json' http://localhost:8080/users/

### Response
```
[
  { "email":"test@gmail.com", "password":"encoded", "onlyAdminData":"data" },    
  { "email":"test1@gmail.com", "password":"encoded", "onlyAdminData":"data" }
]
```

### Request with "CAN_READ_USER" authority

`GET /users/`

    curl -i -H 'Accept: application/json' http://localhost:8080/users/

### Response
```
[
  { "email":"test@gmail.com", "onlyUserData":"data" },    
  { "email":"test1@gmail.com", "onlyUserData":"data" }
]
```
