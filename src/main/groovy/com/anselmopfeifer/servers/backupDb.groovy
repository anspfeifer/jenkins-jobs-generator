package com.anselmopfeifer.servers

import com.anselmopfeifer.Utils

static final String backupMysql(database_name, host, user, password) {
    def util = new Utils()
    user = "--user=${user}"

    if (util.getVersionMysql != '5.7') {
        user = "--user ${user}"
    }

    def dump = "mysqldump --host=${host} ${user} --password=${password} ${database_name} > ${database_name}-${util.date}.sql"

    return dump
}