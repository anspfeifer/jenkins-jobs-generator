job('generator-jobs') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github 'anspfeifer/jenkins-jobs-generator'
    }

    steps {
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }

    steps {
        triggerBuild()
    }

    triggers {
        scm('* * * * * ')
    }

    publishers {
        mailer 'anspfeifer@gmail.com'
    }
}