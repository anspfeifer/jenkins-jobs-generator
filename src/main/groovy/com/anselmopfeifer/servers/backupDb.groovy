package com.anselmopfeifer.servers

import com.anselmopfeifer.Utils

static final String backupMysql(database_name, host, user, password) {
    def util = new Utils()
    user = '--user=root'
    host = '--host=127.0.0.1'

    if (util.getVersionMysql != '5.7') {
        user = '--user root'
    }

    def dump = "mysqldump ${host} -${user} --password=${password} ${database_name} > ${database_name}-${util.date}.sql"

    return dump
}