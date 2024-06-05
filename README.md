# "How can a CI/CD workflow be effectively implemented using Jenkins for web applications?"
This is the question I will try to solve with this repository. Project is done for my planned upcoming bachelor thesis with the research question above.  <br>
For the sake of content, this frontend app will be a Gallery of Thomas' Art and Paintings. (https://www.instagram.com/tomcii/)

Structure of the project:

# Frontend
The repository for the backend is here: https://github.com/Tomciii/CI-CD-Pipeline-Frontend
The repository consists of a Angular Frontend project including a Jenkinsfile. The frontend should be containerized via Docker.

The content will be:
- A Home page
- A Gallery Page
- An About Page
- An Admin Page

# Backend
This repository is a gradle mirror of this repository: The repository for the backend is here: https://github.com/Tomciii/CI-CD-Pipeline-Backend
The backend will grab images from the MariaDB server.

For the sake of sciene, we will compare the build times of gradle with maven in a Jenkins environment

# Jenkins
A local Jenkins running on port 8080 will be used for the CI/CD.  <br>
Jenkins.war runnable via cmd command ```java -jar jenkins.war``` <br>
2 Separate Jenkinsfiles for the backend and frontend are set up

# Apache Web Server:
Also locally running, an Apache Web Server will deploy the frontend, triggered by the local Jenkins.  <br>
The services are required to be running for the deployment to work properly. <br>
Master Branch: Apache Service running locally on ```127.0.0.1:80``` <br>
Every Other Branch: Apache Service running locally on ```127.0.0.1:81``` <br>

# Tomcat Backend Server:
Also locally running, the Apache Tomcat Server deploys the backend application. <br>
The deployed .war file is running locally on ```localhost:8085/application/```

# MariaDB Repository
Images from the Backend are stored in a MariaDB repository <br>
The MariaDB server is running on ```192.168.0.120:3307/rfid```
