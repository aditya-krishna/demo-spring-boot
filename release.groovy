pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        disableConcurrentBuilds()
        timestamps()
    }

    parameters {
        string(name: 'RELEASE_BRANCH', description: 'Branch from which release to be done')
        string(name: 'RELEASE_VERSION', description: 'Version to be released')
    }

    stages {
        stage('RELEASE') {
            agent any

            steps {
                checkout scm

                sh "mvn -B -DreleaseVersion=${params.RELEASE_VERSION} -DautoVersionSubmodules=true -Darguments='-Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dmaven.deploy.skip=true' release:clean release:prepare"
                sh "mvn -B -Darguments='-Dmaven.test.skip=true -Dmaven.javadoc.skip=true -Dmaven.deploy.skip=true' release:perform"

                script {
                    echo "Merging code to develop branch"
                    
                    commit_message = "Merge ${params.RELEASE_BRANCH} into develop"
                    
                    sh "git checkout develop"
                    sh "git merge --no-ff -m '$commit_message' ${params.RELEASE_BRANCH}"
                    sh "git push --all && git push --tags"
                }
            }
        }
    }
}
