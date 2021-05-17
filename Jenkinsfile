pipeline {
  agent any
  
  stages {
    stage('Build') {
      steps {
        echo "${GIT_BRANCH}"
        echo "${GIT_COMMIT}"
        
        script {
          changeSet = currentBuild.rawBuild.changeSets
          for (int i = 0; i < changeSet.size(); i++) {
            entries = changeSet[i].items;
            for (int j = 0; j < entries.length; j++) {
              entry = entries[j]
              
              files = entry.affectedFiles
              
              for (int k = 0; k < files.size(); k++) {
                    file = files[k]
                    echo "${file.editType.name} ${file.path}"
              }
            }
          }
        }
      }
    }
  }
}
