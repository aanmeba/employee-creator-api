# Employee Creator - Backend

- [Go to Employee Creater - Frontend repo](https://github.com/aanmeba/employee-creator-client)

## Requirement

We need a web application to create, list, modify and delete employees. The application should consist of a spring RESTful API and a React Typescript frontend. The schema for the employee is left to the criteria of the candidate.

## Technology / Documentation Recommendations

### Frontend

- Vite with react-ts
- Use SCSS instead of CSS, npm install sass
- Use React Query for API calls
  - https://react-query-v3.tanstack.com/ - Making API calls
- React Form Hook for form validation & submission
  - https://react-hook-form.com/get-started
- Use HTML attributes to required / validate fields before writing your own validation
- Typescript React Cheatsheet
  - https://react-typescript-cheatsheet.netlify.app/docs/basic/getting-started/basic_type_exampleReact Cheat Sheet
- Use Axios over fetch in the frontend for testing mocks
- React Router for routes
  - https://reactrouter.com/en/main/start/tutorial
- Mock Axios Calls
  - https://stackoverflow.com/questions/70450576/how-to-test-react-component-with-axios-request-in-useeffect

### Backend

- Dependencies
  - Spring Web,
  - Validation I/O
  - Spring Testing
  - Spring Data JPA
  - MySQL Driver
  - Spring Devtools
- application.properties starter:

```
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=root
spring.datasource.password=MyPass
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.generate-ddl=true
```

- Testing
  - https://spring.io/guides/gs/testing-web/
  - https://www.baeldung.com/spring-mock-rest-template
- Logging
  - https://www.baeldung.com/spring-boot-logging
- CORS Errors
  - https://www.baeldung.com/spring-cors
- API Semantics
  - https://www.uniprot.org/help/rest-api-headers
  - https://restfulapi.net/resource-naming/
