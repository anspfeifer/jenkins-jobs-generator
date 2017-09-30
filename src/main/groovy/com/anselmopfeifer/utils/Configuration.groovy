package com.anselmopfeifer.utils

class Configuration {

    static String REPO_NAME = 'anspfeifer/jenkins-jobs-generator'
    static String BRANCH = 'dev'
    static String CHEF_VERSION = 'v0.477'

    static getPasswordMysql = '123'
    static getVersionMysql = '5.7'
    static date = System.getProperty("generationDate")?:new Date().format('yyyy-mm-dd-hh-mm')


    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static String getJobDescription() {
        "Gerado por http://${REPO_NAME}, branch: ${BRANCH} em ${getGenerationDate()}"
    }

}