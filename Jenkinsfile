import com.cloudbees.groovy.cps.NonCPS

pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        
        sh "git diff --quiet HEAD origin/master -- demo-spring-boot"
        
        sh "git diff --quiet HEAD origin/master -- ."
        
        script {
          getChanges()
        }
      }
    }
  }
}
