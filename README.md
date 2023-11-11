# allyeozoong - BackEnd
This project is a submission for a SW hackathon.

# Overview



## Getting Started

To run this project locally, follow the steps below.

### Prerequisites

Ensure you have the following installed:

- A FrameWork to excecute JAVA(like IntelliJ)
- MySQL Version: 11.1.2-MariaDB Client Version: 15.2

### Installation

1. Clone this repository:

    ```bash
    git clone https://github.com/your-username/your-project.git
    cd your-project
    ```

2. Install the necessary dependencies: <br/>
   The dependencies are used by default in the project, so if you've cloned it, there's no need to add them separately.
    ```bash
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
    ```

### Set Up Environment Variables
Please update the data source to your own database address.
```yaml
spring:
  datasource:
    url: jdbc:mysql://your-database-url:3306/your-database-name
    username: your-username
    password: your-password
```
