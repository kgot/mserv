node {
    def mvnHome
    timestamps {
        stage('Preparation') {
            git branch: 'mysql', url: 'https://github.com/kgot/mserv.git'
            // Get the Maven tool.
            mvnHome = tool 'M3'
        }
        stage('Build') {
            // Run the maven build
            if (isUnix()) sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
            else bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
        stage('Results') {
            junit '**/target/surefire-reports/TEST-*.xml'
            archive 'target/*.jar'
        }
        stage('SonarQube analysis') {
            withSonarQubeEnv('My SonarQube Server') {
                // requires SonarQube Scanner for Maven 3.2+
                sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
            }
        }
    }
}