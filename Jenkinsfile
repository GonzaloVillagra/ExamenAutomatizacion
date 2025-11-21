pipeline {
    agent any

    tools {
        maven 'maven'
    }
    stages {
        stage('Build') {
            steps {
                echo '--- [CI] Iniciando Build ---'
                bat 'mvn clean package -DskipTests'
            }
        }
                stage('Unit Tests') {
                    steps {
                        echo '--- [CI] Ejecutando Pruebas Unitarias ---'
                        bat 'mvn test -Dtest=!RunCucumberTest'
                    }
                    post {
                        always {
                            junit '**/target/surefire-reports/*.xml'
                        }
                    }
                }
                stage('Acceptance Tests') {
                    steps {
                        echo '--- [CD] Ejecutando Pruebas de Aceptación (Cucumber) ---'
                        bat 'mvn test -Dtest=RunCucumberTest'
                    }
                }
        stage('Deploy to Staging') {
            steps {
                echo '--- [CD] Desplegando a Staging ---'
                bat 'if not exist C:\\temp\\deploy_staging mkdir C:\\temp\\deploy_staging'
                bat 'copy target\\*.jar C:\\temp\\deploy_staging\\'
                echo 'Despliegue exitoso en ambiente de prueba.'
            }
        }
    }
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