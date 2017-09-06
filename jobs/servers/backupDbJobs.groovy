import static com.anselmopfeifer.Utils.*
import static com.anselmopfeifer.servers.backupDb.backupMysql

job('backup-db') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    def command =
    parameters{
        stringParam('NAME', '', 'Version chef Release')
        booleanParam('EXECUTE', true, 'Execute chef provision')
    }

    steps {
        shell ("""
        ${backupMysql()}
                """)
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
