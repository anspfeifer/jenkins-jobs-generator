import static com.anselmopfeifer.utils.Configuration.getEnvs
import static com.anselmopfeifer.utils.Configuration.getJobDescription

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github("${getEnvs().REPO}", '')
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