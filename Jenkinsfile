pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }

    stage("Fix the permission issue") {
            steps {
                sh "sudo chown root:jenkins /run/docker.sock"
            }

    }
    
    stages {
        stage('Compile Stage') {
            steps {
                echo '::::: Hello, Compile  :::::'
                withMaven(maven : 'maven3.6.3'){
                    sh 'mvn clean compile'
                }
            }
        }
        
        stage('Mvn Build Stage') {
            steps {
                echo '::::: Hello, Maven    :::::'
                withMaven(maven : 'maven3.6.3'){
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build Stage') {
            steps {
                echo ':::::  Hello, Docker Build Stage   :::::'
                sh '''
                    sudo -s
                    docker image build -t ecom-webservice .
                '''
            }
        }

        stage('Deploy Stage') {
            steps {
                echo 'Hello, Docker Deployment.'
                
            }
        }
    }
}