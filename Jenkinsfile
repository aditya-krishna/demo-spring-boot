import com.cloudbees.groovy.cps.NonCPS

pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        
        notifyBuild()
      }
    }
  }
}

def notifyBuild() {
  def changeSet = getChangeSet()
}

@NonCPS
def getChangeSet() {
  return currentBuild.changeSets.collect { cs ->
    cs.collect { entry ->
        "* ${entry.author.fullName}: ${entry.msg}"
    }.join("\n")
  }.join("\n")
}
