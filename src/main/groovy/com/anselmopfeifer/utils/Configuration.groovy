package com.anselmopfeifer.utils

class Configuration {

    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static List<Environments> getEnvs(){
        System.getenv(getEnvs().BRANCH)
        System.getenv(getEnvs().REPO_NAME)
    }

    static String getJobDescription() {
        "Gerado por http://${getEnvs().REPO_NAME} em ${getGenerationDate()}"
    }

}


//static final repo_name = 'anspfeifer/jenkins-jobs-generator'
//static final url_repo = "git@github.com:${repo_name}"
//static final branch = 'dev'
//static final defaultChefRevision = 'v0.477'
//
//static getPasswordMysql = '123'
//static getVersionMysql = '5.7'
//
//static date = System.getProperty("generationDate")?:new Date().format('yyyy-mm-dd-hh-mm')
//
//static getGenerationDate() {
//    System.getProperty("generationDate")?:new Date()
//}
//
//static String getJobDescription() {
//    "Gerado por http://github.com/${repo_name} em ${getGenerationDate()}"
//}
