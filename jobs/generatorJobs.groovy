import static com.anselmopfeifer.Utils.getJobDescription

job('generator-jobs') {

    logRotator (-1, 10)

    jdk ('Java 8')

    scm {
        github 'anspfeifer/jenkins-jobs-generator'
    }

    steps {
        dsl {
            external 'jobs/**/*Jobs.groovy'
            additionalClasspath 'src/main/groovy'
        }
    }

    steps {
        groovyCommand('generatorView.groovy')
    }

    triggers {
        githubPush()
    }

    publishers {
        // email 'anspfeifer@gmail.com'
    }
}
