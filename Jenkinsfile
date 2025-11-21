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

        // Etapa 2: Pruebas Unitarias
                stage('Unit Tests') {
                    steps {
                        echo '--- [CI] Ejecutando Pruebas Unitarias ---'
                        // Excluimos RunCucumberTest para que no falle aquí
                        bat 'mvn test -Dtest=!RunCucumberTest'
                    }
                    post {
                        always {
                            junit '**/target/surefire-reports/*.xml'
                        }
                    }
                }

                // ... (Integration Tests queda igual) ...

                // Etapa 4: Pruebas de Aceptación
                stage('Acceptance Tests') {
                    steps {
                        echo '--- [CD] Ejecutando Pruebas de Aceptación (Cucumber) ---'
                        // Aquí sí forzamos que corra RunCucumberTest
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