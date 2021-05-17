test_data = ''

pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        script {
          test_data = notifyBuild()
        }
      }
    }
  }
}

def notifyBuild() {
  return getChangeSet()
}

@NonCPS
def getChangeSet() {
  return currentBuild.changeSets.collect { cs ->
    cs.collect { entry ->
        "* ${entry.author.fullName}: ${entry.msg}"
    }.join("\n")
  }.join("\n")
}
