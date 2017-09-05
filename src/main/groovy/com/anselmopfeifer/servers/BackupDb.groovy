package com.anselmopfeifer.servers

import com.anselmopfeifer.Utils

class BackupDb {
    static util = new Utils()

    static String getTypeDatabase(type) {
        if (type == 'mysql') {
            return 'mysql'
        } else if (type == 'postgres') {
            return 'postgres'
        } else if (type == 'mongo') {
            return 'mongo'
        }
    }

    static String backupMysql() {
        
        def user = '-u root'

        if (util.getVersionMysql == '5.5') {
            user = '-uroot'
        }

        def dump = "mysql ${user} -p${util.getPasswordMysql} --host"
    }
}
