package com.anselmopfeifer

class Utils {
    static final repo_name = 'anspfeifer/jenkins-jobs-generator'
    static final url_repo = "git@github.com:${repo_name}"
    static final branch = 'dev'
    static final defaultChefRevision = 'v0.477'

    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static String getJobDescription() {
        "Gerado por http://github.com/${repo_name} em ${getGenerationDate()}"
    }
}
