# The Wiquery app maven archetype #

## Introduction ##

In order to ease the creation of WiQuery application, a maven archetype has been developed.
The page presents only how  to use the maven archetype for WiQuery application.
The current version aims the Wiquery 1.0-m1 release.
## Preparation ##

### Tools ###

To begin this tutorial, you'll need the following components to be installed:
  * [Maven 2.0.10](http://maven.apache.org/download.html)
  * Java JDK1.5+

### getting started ###
  1. Download the archetype:

From SVN:
```
svn checkout http://wiquery.googlecode.com/svn/apparchetype/ wiquery-read-only
```

> 2. go in the apparchetype directory and install the archetype in your local repository:

```
mvn install
```

## Start a projet with the archetype ##


mvn archetype:generate -DarchetypeCatalog=local

```
 mvn archetype:generate -DarchetypeCatalog=local
```

You will  be prompted for selecting the archetype and :
  * your groupId
  * your artifactId
  * your version
  * your package

```
[INFO] Scanning for projects...
[INFO] Searching repository for plugin with prefix: 'archetype'.
[INFO] artifact org.apache.maven.plugins:maven-archetype-plugin: checking for updates from central
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Default Project
[INFO]    task-segment: [archetype:generate] (aggregator-style)
[INFO] ------------------------------------------------------------------------
[INFO] Preparing archetype:generate
[INFO] No goals needed for project - skipping
[INFO] Setting property: classpath.resource.loader.class => 'org.codehaus.plexus.velocity.ContextClassLoaderResourceLoader'.
[INFO] Setting property: velocimacro.messages.on => 'false'.
[INFO] Setting property: resource.loader => 'classpath'.
[INFO] Setting property: resource.manager.logwhenfound => 'false'.
[INFO] [archetype:generate]
[INFO] Generating project in Interactive mode
[INFO] No archetype defined. Using maven-archetype-quickstart (org.apache.maven.archetypes:maven-archetype-quickstart:1.0)
Choose archetype:
1: local -> wiqueryapp-archetype (Maven archetype for WiQueryApp)
Choose a number:  (1): 1
Define value for groupId: : test.wiquery
Define value for artifactId: : app
Define value for version:  1.0-SNAPSHOT: : 
Define value for package:  test.wiquery: : 
Confirm properties configuration:
groupId: test.wiquery
artifactId: app
version: 1.0-SNAPSHOT
package: test.wiquery
 Y: : Y
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 29 seconds
[INFO] Finished at: Sat Jul 18 15:59:19 CEST 2009
[INFO] Final Memory: 8M/14M
[INFO] ------------------------------------------------------------------------

```


or you can do it directly :
```
mvn archetype:create -DarchetypeGroupId=org.odlabs.wiquery -DarchetypeArtifactId=wiqueryapp-archetype -DarchetypeVersion=1.0-SNAPSHOT -DgroupId=org.odlabs -DartifactId=quickstart
```


You can now start to develop your Wiquery app.

Think to check the project/pom dependencies and starts working on the WicketApplication Java class.

Enjoy!!