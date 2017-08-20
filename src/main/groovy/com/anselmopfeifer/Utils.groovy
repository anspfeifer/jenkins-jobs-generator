package com.anselmopfeifer

class Utils {

    static defaultChefRevision = 'v0.477'

    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static String getJobDescription() {
        "Gerado por http://github.com/anspfeifer/jenkins-jobs-generator em ${getGenerationDate()}"
    }
}
