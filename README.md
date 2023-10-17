# waa-lab8

Create a Spring Boot Web Project with following features

1. Create a UserController which can register a new User with email, password, roles

2. Create a BookController which has CRUD operations

3. Add Spring security features which use JWT authentication system which means in your configuration you can no longer use http.basic() or http.formLogin:

3.1 All authenticated users can get books

3.2 Only Admin can update, delete, create a new Book

3.3 all users(unauthenticated, authenticated) can register new user
