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

    static final getRepo(repo, branch) {
        this.getRepo =
    }
}

