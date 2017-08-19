import static Utils.*

jobFactory.freeStyleJob('shell-script-job') {
    description getJobDescription()
    logRotator (-1, 10)
    jdk ('Java 8')

    parameters{
        stringParam('BRANCH', '', "Branch do qual sera obtido o post script")
    }
    scm {
        git('repo', 'branch')
    }

}
