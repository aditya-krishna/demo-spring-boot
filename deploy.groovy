pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        disableConcurrentBuilds()
        timestamps()
    }

    parameters {
        string(name: 'DEPLOY_BRANCH', description: 'Branch from which deployment to be done')
        booleanParam(name: 'MERGE_TO_MASTER', defaultValue: false)
    }

    stages {
        stage('MERGE-TO-MASTER') {
            agent any
            
            steps {
                checkout scm
                
                script {
                    echo "Merging code to master"
                    commit_message = "Merge release ${params.IMAGE_VERSION} to master"
                    
                    sh "git checkout master"
                    sh "git merge --no-ff -m $commit_message origin/${params.DEPLOY_BRANCH}~1"
                    sh "git push --all && git push --tags"
                }
            }
        }
    }
}