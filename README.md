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
job-dsl
permissive-script-security // configureSecurity/ Enable script security for Job DSL scripts (OFF)

build-flow-plugin
simple-build-for-pipeline
github
github-pullrequest
conditional-buildstep
build-flow-plugin
```

