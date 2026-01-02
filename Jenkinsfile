pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('Mini_project-crudOperation_paging') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('Mini_project-crudOperation_paging') {
                    bat 'docker build -t my-spring-app:latest .'
                }
            }
        }
    }
}
