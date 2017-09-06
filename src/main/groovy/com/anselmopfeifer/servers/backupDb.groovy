package com.anselmopfeifer.servers

import com.anselmopfeifer.Utils

static final String backupMysql() {
    def util = new Utils()
    def user = '--user=root'
    def host = '--host=127.0.0.1'

    if (util.getVersionMysql != '5.7') {
        user = '--user root'
    }

    def dump = "mysqldump ${host} -${user} --password=${util.getPasswordMysql} > dump-${util.date}.sql"

    return dump
}