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
                dir('spring-web') {     // 👈 folder containing pom.xml
                    bat 'mvn clean install'
                }
            }
        }
    }
}
