import static com.anselmopfeifer.Utils.*

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        git("${url_repo}", "${branch}" )
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