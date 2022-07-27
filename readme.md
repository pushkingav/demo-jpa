### Spring Data JPA demo app

This app is intended to test how Spring Data JPA works.

We have 2 entities: a University and a Student.
There is a relationship between them: one university may have many students.

Test main method saves 1 university and 4 students.
Then it retrieves the university and students from the database.

Used default H2 in-memory implementation.