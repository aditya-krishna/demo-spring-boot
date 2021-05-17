import com.cloudbees.groovy.cps.NonCPS

pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        
        sh "git diff --quiet HEAD origin/master -- demo-spring-boot  || echo changed"
        
        sh "git diff --quiet HEAD origin/master -- ./ || echo changed2"
      }
    }
  }
}
