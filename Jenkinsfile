pipeline {
    agent any

    tools {
        // Asegúrate de tener configurada la herramienta Maven en Jenkins
        // Si no, puedes usar el wrapper './mvnw' si lo tienes, o 'maven' si está en el PATH
        maven 'maven'
    }

    stages {
        // Etapa 1: Construcción (Build)
        // Compila el código pero salta los tests para ser más rápido inicialmente
        stage('Build') {
            steps {
                echo '--- Iniciando etapa de Build ---'
                sh 'mvn clean package -DskipTests'
            }
        }

        // Etapa 2: Pruebas Unitarias (Unit Tests)
        // Ejecuta tests rápidos de lógica aislada
        stage('Unit Tests') {
            steps {
                echo '--- Ejecutando Pruebas Unitarias ---'
                sh 'mvn test'
            }
            post {
                always {
                    // Genera reporte de JUnit para que Jenkins lo muestre
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        // Etapa 3: Pruebas de Integración
        // Se ejecuta solo si las unitarias pasaron. Usa el plugin failsafe.
        stage('Integration Tests') {
            steps {
                echo '--- Ejecutando Pruebas de Integración ---'
                sh 'mvn verify -DskipUnitTests=true'
            }
        }
    }
}