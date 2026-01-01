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
    }
}
