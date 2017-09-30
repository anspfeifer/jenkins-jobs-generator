
import static com.anselmopfeifer.utils.Configuration.*

job('generator-jobs') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github("${repo_name}", "${branch}" )
    }

    steps {
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