pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        script {
          tf_deployment_required =  changeRequiresTerraformDeployment()
          
          echo "${tf_deployment_required}"
        }
      }
    }
  }
}

def changeRequiresTerraformDeployment() {
  value = false
  
  currentBuild.changeSets.each { change ->
    change.items.each { item ->
      item.affectedFiles.each { file ->
        echo "${file.editType.name} ${file.path}"
        
        if(file.path.contains('demo-spring-boot/src/test')) {
          value = true
          break
        }
      }
    }
  }
  
  return value
}
