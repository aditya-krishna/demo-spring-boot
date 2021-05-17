test_data = ''

pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        script {
          changeRequiresTerraformDeployment()
        }
      }
    }
  }
}

def changeRequiresTerraformDeployment() {
  currentBuild.changeSets.each { change ->
    change.items.each { item ->
      item.affectedFiles.each { file ->
        echo "${file.editType.name} ${file.path}"
      }
    }
  }
}
