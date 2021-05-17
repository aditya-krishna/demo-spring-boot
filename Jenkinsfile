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
  
  currentBuild.changeSets.find { change ->
    change.items.find { item ->
      item.affectedFiles.find { file ->
        echo "${file.editType.name} ${file.path}"
        
        if(file.path.contains('demo-spring-boot/src/test')) {
          value = true
        }
        
        return value
      }
      
      return value
    }
    
    return value
  }
  
  return value
}
