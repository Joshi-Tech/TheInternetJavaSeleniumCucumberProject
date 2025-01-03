pipeline {
    agent any
    stages {
        stage("Build") {
            steps { 
                echo "Build stage"
                bat "mvn install" // us sh instead bat if it is on Linux agent
            }
        }
        stage("Test") {
            steps { 
                echo "Test stage"
                bat "mvn test" // us sh instead bat if it is on Linux agent
            }
        }
        stage("Deploy") {
            steps { 
                echo "Deployed stage"
            }
        }
    }
}
