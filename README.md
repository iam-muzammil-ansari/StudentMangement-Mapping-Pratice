# Student Management Mapping Practice

## Table of Contents
- [Frameworks and Language Used](#frameworks-and-language-used)
- [Data Flow](#data-flow)
- [Data Structure Used](#data-structure-used)
- [Project Summary](#project-summary)
- [Getting Started](#getting-started)
- [Testing Endpoints](#testing-endpoints)
- [License](#license)

## Frameworks and Language Used
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL

## Data Flow

### Controller
- AddressController
  - `addAddress`: Adds an address to the database.
  - `getAddressByZipCode`: Retrieves an address by zip code.
  - `updateAddressInfoByCountry`: Updates address information based on the country.
  - `removeAllAddressById`: Deletes an address by ID.

- BookController
  - `addBook`: Adds a book to the database.
  - `getBookByBookAuthor`: Retrieves books by book author.
  - `updateBookInfoByBookAuthor`: Updates book information based on the book author.
  - `removeAllBooksByBookAuthor`: Deletes all books by book author.

- CourseController
  - `addCourse`: Adds a course to the database.
  - `getCourseByCourseId`: Retrieves a course by course ID.
  - `updateCourseInfoByCourseName`: Updates course information based on the course name.
  - `removeAllCoursesByCourseDuration`: Deletes all courses by course duration.

- LaptopController
  - `addLaptop`: Adds a laptop to the database.
  - `getLaptopByBrand`: Retrieves laptops by brand.
  - `updateLaptopInfoByBrand`: Updates laptop information based on the brand.
  - `removeAllLaptopByBrand`: Deletes all laptops by brand.

- StudentController
  - `addStudent`: Adds a student to the database.
  - `getStudentByName`: Retrieves a student by name.
  - `updateStudentInfoByDept`: Updates student information based on the department.
  - `removeAllStudentsByDept`: Deletes all students by department.

### Services
- AddressService: Provides business logic for address-related operations.
- BookService: Provides business logic for book-related operations.
- CourseService: Provides business logic for course-related operations.
- LaptopService: Provides business logic for laptop-related operations.
- StudentService: Provides business logic for student-related operations.

### Repository
- IAddressRepo: Repository interface for Address entity, handles address-related database operations.
- IBookRepo: Repository interface for Book entity, handles book-related database operations.
- ICourseRepo: Repository interface for Course entity, handles course-related database operations.
- ILaptopRepo: Repository interface for Laptop entity, handles laptop-related database operations.
- IStudentRepo: Repository interface for Student entity, handles student-related database operations.

### Database Design
The project uses MySQL as the database management system.

## Data Structure Used
- Enumerations:
  - Branch: Represents different branches of study.
  - Brand: Represents different laptop brands.
  - DeptType: Represents different types of departments.

- Entities:
  - Address: Represents an address with various fields such as addressId, addressLandmark, addressZipCode, addressDistrict, addressState, and country.
  - Book: Represents a book with fields like bookId, bookName, bookTitle, bookAuthor, bookDescription, bookPrice, and a foreign key reference to the Student entity.
  - Course: Represents a course with fields like courseId, courseName, courseTitle, courseDescription, courseDuration, and a many-to-many relationship with the Student entity.
  - Laptop: Represents a laptop with fields like laptopId, laptopName, laptopBrand, laptopPrice, and a one-to-one relationship with the Student entity.
  - Student: Represents a student with fields like studentId, studentName, studentAge, studentPhoneNumber, studentBranch, studentDepartment, and a one-to-one relationship with the Address entity.

## Project Summary
The Student Management Mapping Practice project is developed using Spring Boot and Spring Data JPA. It provides a set of RESTful APIs for managing students, addresses, books, courses, and laptops. The project follows the MVC architecture pattern, with separate controllers, services, and repositories for each entity. The entities are persisted in a MySQL database using Hibernate as the ORM framework.

## Getting Started
To run the project locally, follow these steps:
1. Clone the repository to your local machine from [Student Management Mapping Practice](https://github.com/ayaan097/StudentMangement-Mapping-Pratice.git)
2. Set up a MySQL database and update the database configuration in the `application.properties` file.
3. Build the project using a Java IDE or the command line.
4. Run the main class `StudentManagementMappingPracticeApplication.java` to start the application.
5. The application will start running on the specified port (default is 8080).

## Testing Endpoints
You can test the RESTful APIs using tools like Postman or by accessing the endpoints directly in a web browser. The available endpoints and their corresponding HTTP methods are:

- Address Endpoints:
  - POST /address: Add an address
  - GET /address?code={zipCode}: Get address by zip code
  - PUT /address?country={country}&state={state}: Update address information by country
  - DELETE /address?addressId={addressId}: Remove an address by ID

- Book Endpoints:
  - POST /book: Add a book
  - GET /books?bookAuthor={bookAuthor}: Get books by book author
  - PUT /book?bookAuthor={bookAuthor}&price={price}: Update book information by book author
  - DELETE /books?bookAuthor={bookAuthor}: Remove all books by book author

- Course Endpoints:
  - POST /course: Add a course
  - GET /course?courseId={courseId}: Get course by course ID
  - PUT /course?courseName={courseName}&duration={duration}: Update course information by course name
  - DELETE /courses?duration={duration}: Remove all courses by course duration

- Laptop Endpoints:
  - POST /laptop: Add a laptop
  - GET /laptops?brand={brand}: Get laptops by brand
  - PUT /laptop?brand={brand}&price={price}: Update laptop information by brand
  - DELETE /laptops?brand={brand}: Remove all laptops by brand

- Student Endpoints:
  - POST /student: Add a student
  - GET /student?studentName={studentName}: Get student by name
  - PUT /student?deptType={deptType}&branch={branch}: Update student information by department
  - DELETE /students?deptType={deptType}: Remove all students by department

## License
This project is licensed under the [MIT License](LICENSE).
