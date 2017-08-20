package com.anselmopfeifer.view

import hudson.model.ListView
import jenkins.model.Jenkins
import java.util.regex.Pattern

def shell = new GroovyShell()
views = shell.evaluate(new File(viewScriptFile).text)

views.children().each {
    validateView(it)
}

def jenkinsViews = Jenkins.instance.views.findAll {
    it.displayName != 'All' && it.displayName != 'Home'
}

jenkinsViews.each {
    println "remove view ${it.displayName}"
    Jenkins.instance.deleteView(it)
}

views.children().each {
    createView(Jenkins.instance, it)
}

Jenkins.instance.save()

def validateView(view) {
    if (view.attributes().regex || view.attributes().jobList) {
        if (view.attributes().jobList) {
            view.attributes().jobList.each {
                if (!Jenkins.instance.getJob(it)) {
                    throw new IllegalArgumentException("job ${it} does not exist")
                }
            }
        }
    } else {
        view.children().each {
            validateView(it)
        }
    }
}

def createView(owner, view) {
    if (view.attributes().regex || view.attributes().jobList) {
        createListView(owner, view)
    } else {
        createNestedView(owner, view)
    }
}

def createListView(owner, view) {
    def listView = new ListView(view.name(), owner)
    if (view.attributes().regex) {
        listView.includeRegex = view.attributes().regex
        listView.includePattern = Pattern.compile(view.attributes().regex)
    }
    if (view.attributes().jobList) {
        view.attributes().jobList.each {
            listView.add(Jenkins.instance.getJob(it))
        }
    }
    println "create view ${listView.displayName}"
    owner.addView(listView)
}

def createNestedView(owner, view) {
    def nestedView = new hudson.plugins.nested_view.NestedView(view.name())
    nestedView.owner = owner
    view.children().each {
        createView(nestedView, it)
    }
    println "create view ${nestedView.displayName}"
    owner.addView(nestedView)
}