job('NodeJS Docker example') {
    scm {
        git('git://github.com/hajachn/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Haja')
            node / gitConfigEmail('haja@zoozocloud.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('hajachn/nodejs')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
