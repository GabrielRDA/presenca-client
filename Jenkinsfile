pipeline {
    agent any
    
    stages {
        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }
        
        stage('Build') {
            steps {
                bat 'mvn package'
            }
        }
    }
}
