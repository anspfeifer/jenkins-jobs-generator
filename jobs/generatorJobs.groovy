import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github 'anspfeifer/jenkins-jobs-generator'
    }

    steps {
        sleep(1000)
        dsl {
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