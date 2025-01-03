pipeline {
    agent any
    environment {
        REPO_URL = 'https://github.com/Joshi-Tech/TheInternetJavaSeleniumCucumberProject.git'
    }
    stages {
        stage("Checkout QA") {
            steps {
                echo "Checking out QA branch"
                git branch: 'qa', url: "${REPO_URL}"
            }
        }
        stage("Test QA") {
            steps {
                echo "Running tests on QA branch"
                bat "mvn test" // Use 'sh' instead of 'bat' if it's a Linux agent
            }
        }
        stage("Merge QA to Main") {
            when {
                expression {
                    // Only merge if the QA tests passed
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo "Merging QA branch into Main"
                script {
                    sh '''
                    git config user.name "Jenkins"
                    git config user.email "jenkins@example.com"
                    git checkout main
                    git pull origin main
                    git merge qa
                    git push origin main
                    '''
                }
            }
        }
        stage("Checkout Main") {
            steps {
                echo "Checking out Main branch"
                git branch: 'main', url: "${REPO_URL}"
            }
        }
        stage("Test Main") {
            steps {
                echo "Running tests on Main branch"
                bat "mvn test" // Use 'sh' instead of 'bat' if it's a Linux agent
            }
        }
    }
    post {
        always {
            echo "Pipeline finished"
        }
        success {
            echo "All stages completed successfully!"
        }
        failure {
            echo "Pipeline failed. Please check the logs."
        }
    }
}
