job('NodeJS example') {
    scm {
        git('https://github.com/hajachn/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
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
        shell("npm install")
    }
}
