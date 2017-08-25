import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace('generator-data')
    }

    steps {
        sleep(100)
        dsl {
            removeAction('DISABLE')
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
            }
    }

    triggers {
        scm('* * * * * ')
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}