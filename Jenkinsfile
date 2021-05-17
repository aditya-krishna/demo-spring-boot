pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"

        script {
          sh "git diff --quiet HEAD master"
        }
      }
    }
  }
}
