# Jenkins Job Generator - DSL Gradle 

## File structure

    .
    ├── jobs                    # DSL script files
    ├── resources               # resources for DSL scripts
    ├── src
    │   ├── main
    │   │   ├── groovy          # support classes
    │   │   └── resources
    │   │       └── idea.gdsl   # IDE support for IDEA
    │   └── test
    │       └── groovy          # specs
    └── build.gradle            # build file

## plugins:
```
conditional-buildstep
build-flow-plugin
job-dsl
simple-build-for-pipeline
github
github-pullrequest
permissive-script-security // configureSecurity/ Enable script security for Job DSL scripts (OFF)
build-flow-plugin
github-oauth
