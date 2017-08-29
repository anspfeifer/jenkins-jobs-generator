import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github ('anspfeifer/jenkins-jobs-generator', 'dev')
    }

    steps {
        sleep(100)
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
            }
        remoteTrigger('generator-data')
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}