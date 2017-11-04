package com.anselmopfeifer.servers

import com.anselmopfeifer.utils.Configuration

static final String backupMysql(database_name, host, user, password) {
    def configs = new Configuration()
    user = "--user=${user}"
    if (configs.getVersionMysql != '5.7') {
        user = "--user ${user}"
    }

    def dump = "mysqldump --host=${host} ${user} --password=${password} ${database_name} > ${database_name}-${configs.date}.sql"

    return dump

}