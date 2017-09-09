import static com.anselmopfeifer.Utils.*
import static com.anselmopfeifer.servers.backupDb.backupMysql

job('backup-db') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('DATABASE_NAME', null, 'Name the Data Base')
        stringParam('USER', 'root', 'User Name to Access in Data Base')
        stringParam('HOST', 'localhost', 'Host Mysql Server')
        stringParam('PASSWORD', '', 'Password em base64')
    }

    steps {
        if ('\${DATABASE_NAME}') {
            shell("""
${backupMysql('\${DATABASE_NAME}', '\${HOST}', '\${USER}', '\${PASSWORD}')}
""")
        }
    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
