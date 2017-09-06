import static com.anselmopfeifer.Utils.*

job('backup-db') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('NAME', '', 'Version chef Release')
        booleanParam('EXECUTE', true, 'Execute chef provision')
    }

    steps {
        shell ("""
echo "Executed Chef Provision"
                """)
            }
        }
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
