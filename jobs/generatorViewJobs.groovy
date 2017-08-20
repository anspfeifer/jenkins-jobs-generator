job('generator-view') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace('generator-data', 'Successful')
    }

    steps {
        gradle{
            tasks('generatorViews')
        }
    }

    triggers {
        githubPush()
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}