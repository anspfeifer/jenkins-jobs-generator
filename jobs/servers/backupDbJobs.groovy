import static com.anselmopfeifer.Utils.*
import static com.anselmopfeifer.servers.backupDb.backupMysql

job('backup-db') {

    description getJobDescription()

    logRotator (-1, 10)

    jdk ('Java 8')

    parameters{
        stringParam('DATABASE_NAME', null, 'Name the Data Base')
        stringParam('USER', '', 'User Name to Access in Data Base')
        stringParam('HOST', 'localhost', 'Host Mysql Server')
        stringParam('PASSWORD', '', 'Password em base64')
    }
def database = ${DATABASE_NAME}
    steps {
        if (database) {
            shell("""
${backupMysql(database, '\${HOST}', '\${USER}', '\${PASSWORD}')}
""")
        }
    }


    publishers {
        //mailer 'anspfeifer@gmail.com'
    }
}
