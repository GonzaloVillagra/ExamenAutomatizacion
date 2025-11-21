pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        // --- CI STAGES (Actividad 2) ---
        stage('Build') {
            steps {
                echo '--- [CI] Iniciando Build ---'
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Unit Tests') {
            steps {
                echo '--- [CI] Ejecutando Pruebas Unitarias ---'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                echo '--- [CI] Ejecutando Pruebas de Integración ---'
                bat 'mvn verify -DskipUnitTests=true'
            }
        }

        // --- CD STAGES (Actividad 3) ---

        // 1. Pruebas de Aceptación (Cucumber)
        stage('Acceptance Tests') {
            steps {
                echo '--- [CD] Ejecutando Pruebas de Aceptación (Cucumber) ---'
                // Ejecuta la clase RunCucumberTest que creamos antes
                bat 'mvn test -Dtest=RunCucumberTest'
            }
        }

        // 2. Despliegue a Ambiente de Pruebas
        stage('Deploy to Staging') {
            steps {
                echo '--- [CD] Desplegando a Staging ---'
                // Simulamos un despliegue copiando el jar a una carpeta temp
                // Usamos "mkdir ... || ver>nul" para que no falle si la carpeta ya existe
                bat 'if not exist C:\\temp\\deploy_staging mkdir C:\\temp\\deploy_staging'
                bat 'copy target\\*.jar C:\\temp\\deploy_staging\\'
                echo 'Despliegue exitoso en ambiente de prueba.'
            }
        }
    }

    // Mecanismo de Rollback Automático
    post {
        failure {
            echo '--- [FALLO] El Pipeline ha fallado. Ejecutando Rollback... ---'
            bat 'rollback.bat'
        }
        success {
            echo '--- [EXITO] Pipeline completado correctamente. ---'
        }
    }
}