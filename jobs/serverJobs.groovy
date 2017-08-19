import static Utils.*

jobFactory.freeStyleJob('shell-script-job') {
    
    logRotator (-1, 10)
    jdk ('Java 8')

}
