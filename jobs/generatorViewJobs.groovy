import static com.anselmopfeifer.Utils.*

job('generator-view') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github("${repo_name}", "${branch}" )
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