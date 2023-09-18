# Project Setup and Configuration Guide

This guide provides step-by-step instructions for setting up and running your project, configuring IntelliJ IDEA for
debugging, accessing PostgreSQL through pgAdmin, and adding additional tools like Redis or Kafka in the future.

## Project Setup

1. **Clone the Repository**: Start by cloning the project repository to your local machine:

   ```bash
   git clone <repository-url>
   cd <project-directory>
   ```

2. **Docker Setup**: Ensure that you have Docker installed on your machine.
3. **Project Build**: Build a project locally, using Gradle. Gradle -> basic-multiproject -> tasks -> build -> bootJar.
   Make sure the .jar file appears in the spring-module-1 -> build -> libs directory.
4. **Start the Project**: Run the following command to start the project using Docker Compose:

   ```bash
   docker compose up --build
   ```

   This command will create and start containers for PostgreSQL, pgAdmin, and the Spring application. Wait for the
   containers to start and the Spring application to be ready.
   To start the project without pgadmin, use the command
   ```bash
   docker compose up spring-module-1 --build
   ```
5. **Access the Spring Application**: You can access the Spring application
   at [http://localhost:8080/api/users/hello](http://localhost:8080/api/users/hello). The application should be up and
   running.
6. In UserController there are several other endpoints demonstrating interaction with the database, which can be tested
   via Postman. Open the UserController class to get information about the endpoints.

## IntelliJ IDEA Configuration for Debugging

1. **Open the Project in IntelliJ IDEA**: Open IntelliJ IDEA and import the project by selecting the project directory.

2. **Configure Debugging**:
    - Go to "Run" > "Edit Configurations" in IntelliJ IDEA.
    - Click the "+" button and select "Remote" from the list.
    - Configure the remote debugging settings as follows:
        - Name: Give it a name (e.g., Remote Debug).
        - Host: `localhost`
        - Port: `5005` (default for remote debugging as per your Docker configuration).

3. **Start Debugging**:
    - Run your newly created "Remote Debug" configuration.
    - IntelliJ IDEA will connect to the running Docker container, allowing you to set breakpoints and debug your Java
      code.

## Accessing PostgreSQL Through pgAdmin

1. **Access pgAdmin Interface**:
    - Open a web browser and go to [http://localhost:5050](http://localhost:5050).
    - Log in using the following credentials:
        - Email: `admin@admin.com`
        - Password: `root`

2. **Add PostgreSQL Server**:
    - In pgAdmin, click on "Add New Server" in the top-left corner.
    - Provide a name for the server (e.g., My PostgreSQL).
    - In the "Connection" tab, enter the following details:
        - Host name/address: `java_db`
        - Port: `5432`
        - Maintenance database: `postgres`
        - Username: `postgres`
        - Password: `postgres`
    - Click "Save" to add the server.

3. **Access PostgreSQL Databases**:
    - You can now access and manage your PostgreSQL databases through the pgAdmin interface.

## Adding Additional Tools (e.g., Redis or Kafka)

To add additional tools like Redis or Kafka to your Docker Compose setup, follow these steps:

1. **Update `docker-compose.yml`**:
    - Edit the `docker-compose.yml` file to include service definitions for Redis or Kafka as needed. Ensure you specify
      the appropriate image, ports, and environment variables.

2. **Add Configuration to Your Application**:
    - If your Spring application needs to connect to Redis or Kafka, update its configuration to include the necessary
      connection details and dependencies.

3. **Rebuild and Restart Containers**:
    - Run the following command to rebuild and restart your containers, including the new services:

   ```bash
   docker compose up --build
   ```

   This will incorporate the changes you made in the `docker-compose.yml` file.

With these instructions, you should be able to set up your project, configure IntelliJ IDEA for debugging, access
PostgreSQL through pgAdmin, and extend your Docker Compose setup with additional tools in the future.