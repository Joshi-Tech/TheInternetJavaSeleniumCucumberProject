pipeline {
    agent any
    stages {
        stage("Build") {
            steps { // Missing 'steps' block added
                echo "Build stage"
                sh "mvn install" // Corrected to execute Maven command
            }
        }
        stage("Test") {
            steps { // Missing 'steps' block added
                echo "Test stage"
                sh "mvn test" // Corrected to execute Maven command
            }
        }
        stage("Deploy") {
            steps { // Missing 'steps' block added
                echo "Deployed stage"
            }
        }
    }
}
