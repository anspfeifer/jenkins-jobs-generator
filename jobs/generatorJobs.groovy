import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace ('generator-data', 'any')
    }

    steps {
        sleep(100)
        dsl {
            removeAction('DISABLE')
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
            }
        remoteTrigger('generator-data')
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}