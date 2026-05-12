pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    environment {
        DOCKER_USER = 'abdulsamie313'
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Build Backend Services') {
            steps {
                echo 'Building user-service'
                dir('user-service') {
                    sh 'mvn clean package'
                }

                echo 'Building notification-service'
                dir('notification-service') {
                    sh 'mvn clean package -DskipTests'
                }

                echo 'Building analytics-service'
                dir('analytics-service') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker build -t $DOCKER_USER/user-service:$IMAGE_TAG ./user-service'
                sh 'docker build -t $DOCKER_USER/notification-service:$IMAGE_TAG ./notification-service'
                sh 'docker build -t $DOCKER_USER/analytics-service:$IMAGE_TAG ./analytics-service'
                sh 'docker build -t $DOCKER_USER/event-driven-ui:$IMAGE_TAG ./event-driven-ui'
            }
        }

        stage('Push Docker Images') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USERNAME',
                        passwordVariable: 'DOCKER_PASSWORD'
                    )
                ]) {
                    sh '''
                    echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

                    docker push $DOCKER_USER/user-service:$IMAGE_TAG
                    docker push $DOCKER_USER/notification-service:$IMAGE_TAG
                    docker push $DOCKER_USER/analytics-service:$IMAGE_TAG
                    docker push $DOCKER_USER/event-driven-ui:$IMAGE_TAG
                    '''
                }
            }
        }

        stage('Deploy With Docker Compose') {
            steps {
        echo 'Deploying full platform with Docker Compose'
        sh '''
        docker-compose -f docker-compose.yml down
        docker-compose -f docker-compose.yml up -d --build
        '''
            }
        }

        stage('Verify Containers') {
            steps {
                sh 'docker ps'
            }
        }
    }
}