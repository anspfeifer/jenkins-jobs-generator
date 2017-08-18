# Jenkins Job Generator

# Jenkins Job DSL Gradle Example 

An example [Job DSL](https://github.com/jenkinsci/job-dsl-plugin) project that uses Gradle for building and testing. Check out [this presentation](https://www.youtube.com/watch?v=SSK_JaBacE0) for a walkthrough of this example (starts around 14:00). 

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

# Script Examples

* [Example 1](jobs/example1Jobs.groovy) - shows basic folder/job creation
* [Example 2](jobs/example2Jobs.groovy) - shows how to create a set of jobs for each github branch, each in its own folder
* [Example 3](jobs/example3Jobs.groovy) - shows how to use the configure block
* [Example 4](jobs/example4Jobs.groovy) - shows a way to reuse job definitions for jobs that differ only with a few properties
* [Example 5](jobs/example5Jobs.groovy) - shows how to pull out common components into static methods
* [Example 6](jobs/example6Jobs.groovy) - shows how to include script resources from the workspace
* [Example 7](jobs/example7Jobs.groovy) - shows how to create jobs using builders
* [Example 8](jobs/example8Jobs.groovy) - shows how to use DSL extensions provided by other plugins

## Testing

`./gradlew test` runs the specs.

[JobScriptsSpec](src/test/groovy/com/dslexample/JobScriptsSpec.groovy) 
will loop through all DSL files and make sure they don't throw any exceptions when processed. All XML output files are written to `build/debug-xml`. 
This can be useful if you want to inspect the generated XML before check-in.

## Seed Job

You can create the example seed job via the Rest API Runner (see below) using the pattern `jobs/seed.groovy`.

Or manually create a job with the same structure:

* Invoke Gradle script
   * Use Gradle Wrapper: `true`
   * Tasks: `clean test`
* Process Job DSLs
   * DSL Scripts: `jobs/**/*Jobs.groovy`
   * Additional classpath: `src/main/groovy`
* Publish JUnit test result report
   * Test report XMLs: `build/test-results/**/*.xml`