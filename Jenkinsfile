pipeline {
    agent any

    environment {
            CATALINA_HOME = 'C:/Program Files/Apache Software Foundation/Tomcat 10.1'
        }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
    stage('Check Tomcat / Build') {
      steps {
        parallel(
          a: {
           script {
                          def apiUrl = 'http://localhost:8085/application/public/api/getAllArt'

                          def response = sh(script: "curl -sS ${apiUrl}", returnStatus: true)

                          if (response == 0) {
                              echo "API Endpoint ${apiUrl} returned a successful response."
                          } else {
                              echo "Tomcat not started."

                                try {
                                  mail to: 'Tomciiart@gmail.com',
                                  subject: "Jenkins Job ${env.JOB_NAME} - Tomcat Server Not Running",
                                  body: "The Tomcat Server is not up and running. \n\nCheck the build at ${env.BUILD_URL}"
                                    } catch(Exception e) {
                                          echo 'Could not send out mail'
                                          }

                                       }
                                   }
          },
          b: {
           script {
                           echo 'Starting Build'
                               sh './gradlew clean build --build-cache'
                           }
          }
        )
      }
    }

         stage('Send Mail') {
            steps {
                script {
                try {
                  mail to: 'Tomciiart@gmail.com',
                  subject: "Jenkins Job ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}",
                  body: "The Jenkins job has completed.\n\nCheck the build at ${env.BUILD_URL}"
                } catch(Exception e) {
                  echo 'Could not send out mail'
                }
                }
            }
         }
    }

    post {
        success {
            echo 'Build succeeded.'
        }
        failure {
            echo 'Build failed. '
        }
    }
}