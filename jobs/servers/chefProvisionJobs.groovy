import static com.anselmopfeifer.Utils.*

jobFactory.freeStyleJob('chef-provision-job') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('VERSION', 'master', 'Version chef Release')
    }

    steps {
        shell ("""
echo ${getJobDescription()}
echo date
""")
    }

    triggers {
        scm 'H/5 * * * *'
    }

    publishers {
        // email 'anspfeifer@gmail.com'
    }

}
