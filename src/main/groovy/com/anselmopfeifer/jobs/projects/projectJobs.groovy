package com.anselmopfeifer.jobs.projects

freeStyleJob('create-project-jobs') {
    logRotator(-1, 10)
    jdk('Java 8')

    steps {
        shell(
                """
ls -la
pwd
date
echo "Hello Project"
"""
        )
    }
}