pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage('Compile Stage') {
            steps {
                echo 'Hello, Compile'
                withMaven(maven : 'maven3.6.3'){
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage('Build Stage') {
            steps {
                echo 'Hello, Maven'
                withMaven(maven : 'maven3.6.3'){
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Deploy Stage') {
            steps {
                echo 'Hello, Deployment.'
                sh 'java -version'
            }
        }
    }
}