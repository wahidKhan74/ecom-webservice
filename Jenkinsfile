pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
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
                    docker image build -t ecom-webservice .
                '''
            }
        }

        stage('Deploy Stage') {
            steps {
                echo 'Hello, Docker Deployment.'
                sh '''
                 (if  [ $(docker ps -a | grep ecom-webservice | cut -d " " -f1) ]; then \
                        echo $(docker rm -f ecom-webservice); \
                        echo "---------------- successfully removed ecom-webservice ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run --restart always --name ecom-webservice -port 8082:8081 -d ecom-webservice
            '''
            }
        }
    }
}