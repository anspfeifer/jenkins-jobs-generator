
class Utils {

    static defaultChefRevision = 'v0.477'

    static getGenerationDate() {
        System.getProperty("generationDate")?:new Date()
    }

    static String getJobDescription() {
        "Gerado por <a href='http://github.com/anspfeifer/jenkins-jobs-generator'>github.com/anspfeifer/jenkins-jobs-generator</a> em ${getGenerationDate()}"
    }
}
