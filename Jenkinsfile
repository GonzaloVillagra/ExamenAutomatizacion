pipeline {
    agent any

    tools {
        // Asegúrate de que en "Global Tool Configuration" de Jenkins
        // agregaste Maven con el nombre 'maven' (minúsculas)
        maven 'maven'
    }

    stages {
        // Etapa 1: Construcción (Build)
        stage('Build') {
            steps {
                echo '--- Iniciando etapa de Build ---'
                // CAMBIO: Usamos 'bat' en lugar de 'sh' para Windows
                bat 'mvn clean package -DskipTests'
            }
        }

        // Etapa 2: Pruebas Unitarias (Unit Tests)
        stage('Unit Tests') {
            steps {
                echo '--- Ejecutando Pruebas Unitarias ---'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        // Etapa 3: Pruebas de Integración
        stage('Integration Tests') {
            steps {
                echo '--- Ejecutando Pruebas de Integración ---'
                bat 'mvn verify -DskipUnitTests=true'
            }
        }
    }
}