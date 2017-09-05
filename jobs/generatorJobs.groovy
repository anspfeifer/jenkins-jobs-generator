import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        cloneWorkspace('generator-data',  'Successful')
    }

    steps {
        sleep(100)
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
            }
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}