# Maven Repository #

Releases can be downloaded from our Maven repository for your Maven project. You have to specify in your pom.xml the following configuration:


```
<repository>
        <id>wiquery</id>
        <name>wiquery wicket components</name>
        <url>http://wiquery.googlecode.com/svn/repo/</url>
</repository>
```

Example:

```
<?xml version="1.0" encoding="utf-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

        <modelVersion>4.0.0</modelVersion>

        <!-- Identification -->
        <groupId>org.my.project</groupId>
        <artifactId>myProject</artifactId>
        <packaging>jar</packaging>
        <version>1.0.1</version>

        <name>My project</name>

        <repositories>
                <repository>
                        <id>wiquery</id>
                        <name>wiquery wicket components</name>
                        <url>http://wiquery.googlecode.com/svn/repo/</url>
                </repository>
        </repositories>

        <build>
                <extensions>
                        <extension>
                                <groupId>org.jvnet.wagon-svn</groupId>
                                <artifactId>wagon-svn</artifactId>
                                <version>1.9</version>
                        </extension>
                </extensions>
                <plugins>
                        <plugin>
                                <groupId>org.apache.maven.plugins</groupId>
                                <artifactId>maven-eclipse-plugin</artifactId>
                                <configuration>
                                        <projectNameTemplate>
                                                [artifactId]-[version]
                                        </projectNameTemplate>
                                        <wtpmanifest>true</wtpmanifest>
                                        <wtpapplicationxml>true</wtpapplicationxml>
                                        <wtpversion>1.5</wtpversion>
                                        <downloadSources>true</downloadSources>
                                        <downloadJavadocs>true</downloadJavadocs>
                                </configuration>
                        </plugin>
                        
						...
                </plugins>
        </build>

        <dependencies>
                <dependency>
                        <groupId>log4j</groupId>
                        <artifactId>log4j</artifactId>
                        <version>1.2.14</version>
                </dependency>

				...

        </dependencies>

</project>
```