pipeline {
  agent any
  
  stages {
        stage('Build') {
          steps {
            echo "${GIT_BRANCH}"
            echo "${GIT_COMMIT}"
            
            script {
              changeLogSets = currentBuild.changeSets
              
              echo "${changeLogSets}"
            }
          }
        }
  }
}
