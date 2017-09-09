import static com.anselmopfeifer.Utils.*
import static com.anselmopfeifer.servers.backupDb.backupMysql

job('backup-db') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('DATABASE_NAME', '', 'Name the Data Base')
        stringParam('USER', null, 'User Name to Access in Data Base')
        stringParam('HOST', null, 'Host Mysql Server')
        stringParam('PASSWORD', null, 'Password em base64')
    }

    steps {
        shell("""
${backupMysql('\${DATABASE_NAME}', '\${HOST}', '\${USER}', '\${PASSWORD}')}
""")

    }

    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
