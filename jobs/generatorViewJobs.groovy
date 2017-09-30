import static com.anselmopfeifer.utils.Configuration.*

job('generator-view') {
    description getJobDescription()
    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github("${REPO_NAME}", "${BRANCH}" )
    }

    steps {
        gradle{
            tasks('generatorViews')
        }
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}