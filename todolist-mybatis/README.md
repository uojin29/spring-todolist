# Basic To-do List App

## What is this?

* This project is designed to help you understand how to use MyBatis with Spring framework.
* It is a basic to-do list app that allows you to add, edit, and delete tasks.

## What do I need?

* Java 11: Some symbols used in this project may not be supported in Java 8.

## How to run this project?

1. Open this project. Working directory should be the root of the project.
2. Run `./mvnw dependency:resolve` to download dependencies.
3. Run `./mvnw spring-boot:run` to run the project.
4. Open `http://localhost:8080` in your browser.
5. You should see the title `Fancy To-Do List` and a form to add a new task.
6. Try adding, editing, and deleting tasks. Deleting tasks is done by checking the checkbox.

This project uses `H2` as the database.
If you want to see the database, you can access the database console at `http://localhost:8080/h2-console`.

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- No password required

## How do I contribute?

* Contribution to improve this project is always welcome !
* You can either open an issue or create a pull request.

If you're creating a pull request, follow these steps:

1. Fork this repository.
2. Create a new branch. Branch names should be descriptive.
3. Commit and push your changes.
4. Create a pull request and wait for the pull request to be reviewed.
5. If the pull request is approved, it will be merged into the main branch.