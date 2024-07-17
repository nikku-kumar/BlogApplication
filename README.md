BlogApplication
# Blog Application with User Roles and Authentication

This is a web application for managing blog posts with user roles and authentication. The application allows users to register, log in, and manage blog posts based on their assigned roles (Admin or Viewer).

## Technologies Used
- **Java**: Core programming language for the application.
- **JSP (JavaServer Pages)**: For rendering dynamic web content on the client side.
- **Servlets**: For handling HTTP requests and responses.
- **MySQL**: Relational database management system for storing application data.
- **HTML/CSS**: For structuring and styling the web pages.

## Features

### User Roles
- **Admin**: Can create, update, and delete blog posts.
- **Viewer**: Can view and search blog posts.

### Functionality
- **User Registration**: Allows users to register with details including name, email, password, and role.
- **User Login**: Authenticates users based on email and password.
- **Session Management**: Maintains user sessions using cookies or session attributes.
- **Admin Dashboard**: Accessible only to Admin users for managing blog posts.
  - **Create**: Add new blog posts with title, content, and optional images/videos.
  - **Read**: Retrieve and display existing blog posts.
  - **Update**: Modify existing blog posts.
  - **Delete**: Remove blog posts from the database.
- **Viewer Interface**: Allows viewers to browse, search, and view blog posts.
  - **Search**: Search blog posts by title or date.
  - **Pagination and Sorting**: Display search results with pagination and sorting options.

### Security
- **Password Hashing**: Securely store user passwords using hashing algorithms like BCrypt.
- **Input Validation**: Prevent SQL injection attacks using prepared statements and input validation.

## Setup Instructions
1. **Clone the repository**:
   ```sh
   git clone https://github.com/nikku-kumar/BlogApplication.git
