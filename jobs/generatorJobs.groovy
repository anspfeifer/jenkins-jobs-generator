job('generator-jobs') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace('generator-data', 'Successful')
    }

    steps {
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }

    steps {
        gradle{
            tasks('generatorView')
        }
    }

    triggers {
        githubPush()
    }

    publishers {
        mailer 'anspfeifer@gmail.com'
    }
}

queue('generator-jobs')

job('generator-view') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace('generator-data', 'Successful')
    }

    steps {
        gradle{
            tasks('generatorView')
        }
    }

    triggers {
        githubPush()
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
queue('generator-view')