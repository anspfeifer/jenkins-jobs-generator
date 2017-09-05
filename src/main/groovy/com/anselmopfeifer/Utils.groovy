package com.anselmopfeifer

class Utils {
    static repo_name = 'anspfeifer/jenkins-jobs-generator'
    static url_repo = "git@github.com:${repo_name}"
    static branch = 'dev'
    static defaultChefRevision = 'v0.477'

    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static String getJobDescription() {
        "Gerado por http://github.com/${repo_name} em ${getGenerationDate()}"
    }
}
