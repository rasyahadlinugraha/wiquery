# Introduction #

This tutorial will teach you how to install and use WiQuery 1.2.3 in 5 minutes, with a classic "Hello world" example.

## Tools ##

To begin this tutorial, you'll need the following components to be installed:
  * [Maven 2.x or 3.x](http://maven.apache.org/download.html)
  * Java JDK1.5+

## Version of Wicket ##

Each WiQuery version is built with the latest Wicket version: 1.4.17.

## Starting a Wicket project ##

First of all, we need to start a Wicket project. To do this quickly, we'll use maven archetypes, already ready to use with your Maven 2 installation.

### Create the project with Maven 2 ###

Go to your home directory (or in any directory you want to work in) and type the command below:

```
mvn archetype:create -DarchetypeGroupId=org.apache.wicket -DarchetypeArtifactId=wicket-archetype-quickstart -DarchetypeVersion=1.4.17 -DgroupId=org.odlabs -DartifactId=quickstart -DinteractiveMode=false
```

You should see the following output:

```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESSFUL
[INFO] ------------------------------------------------------------------------
```

### Check that your Wicket project works well ###

Change to the quickstart directory.

Before adding WiQuery to this project, let's check that the created project works by typing the command below:

```
mvn jetty:run
```

Maven 2 should output some logs and the message:

```
[INFO] Started Jetty Server
```

Then, connect to localhost:8080/quickstart. The following contents should appear:

![http://wiquery.googlecode.com/files/check-wicket-works.png](http://wiquery.googlecode.com/files/check-wicket-works.png)

# Use WiQuery #

## Add WiQuery repository ##

You must add the following server repository link into your
pom.xml file:

```
<repositories>
     <repository>
         <id>wiquery-maven-repo</id>
         <name>WiQuery repository</name>
         <url>https://wiquery.googlecode.com/svn/repo/</url>
     </repository>
</repositories>
```

## Add a dependency to the quickstart application ##

  * To do this, get back in the quickstart application and edit the pom.xml file to add the following lines:

```
<dependency>
     <groupId>org.odlabs.wiquery</groupId>
     <artifactId>wiquery</artifactId>
     <version>1.2.3</version>
</dependency>
```

  * Then, restart the jetty server to check that everything worked fined:

```
mvn jetty:run
```

# The Hello World example #

Let's do the HelloWorld example with WiQuery's modal window.

## Enable WiQuery ##

Since the 1.0.2, wiQuery uses the IInitializer to register itself into your Wicket application

## Add markup for the modal window ##

In this tutorial, we will use the inline modal window (e.g., a modal window displaying content already loaded in the current page). This modal window will be opened when the "dblclick" event happends on a button.

  * Edit the markup file HomePage.html to have the following code:

```
<html>
    <head>
        <title>WiQuery Quickstart Archetype Homepage</title>
    </head>
    <body>
        <button wicket:id="open-dialog">Open dialog !</button>
             
        <p wicket:id="dialog">
        	Hello world, yes we can !
        </p>
    </body>
</html>
```

  * Add the modal window in HomePage.java:

```
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.odlabs.wiquery.ui.dialog.Dialog;

public class HomePage extends WebPage {

	public HomePage(final PageParameters parameters) {

            final Dialog dialog = new Dialog("dialog");
            add(dialog);

        }
}

```

  * Add the event to trigger the modal window:

```
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.odlabs.wiquery.ui.dialog.Dialog;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.javascript.JsScope;
public class HomePage extends WebPage {

	public HomePage(final PageParameters parameters) {

        final Dialog dialog = new Dialog("dialog");
        add(dialog);
        
        Button button = new Button("open-dialog");
        button.add(new WiQueryEventBehavior(new Event(MouseEvent.DBLCLICK) {
		
			@Override
			public JsScope callback() {
				return JsScope.quickScope(dialog.open().render());
			}
		
		}));
        add(button);
    }
}
```

  * You should see a button. If you double click on this button, a modal window should open:

![http://wiquery.googlecode.com/files/modal-quickstart.png](http://wiquery.googlecode.com/files/modal-quickstart.png)

That's it, you have coded your first WiQuery application !

# How does it works ? #

WiQuery eases jQuery / jQuery UI JavaScript integration:
  * WiQuery imports needed JavaScript / CSS resources
  * WiQuery wrapps all jQuery events, that's why we are able to detect a double click event
  * You just have to extend WiQueryWebApplication or to add a listener to your application.

Let's check the generated source:

```
<html>
    <head>
        <title>Wicket Quickstart Archetype Homepage</title>
    <script type="text/javascript" src="resources/org.odlabs.wiquery.core.commons.CoreJavaScriptResourceReference/jquery/jquery-1.4.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference/fusion/ui.all.css" />
<script type="text/javascript" src="resources/org.odlabs.wiquery.ui.core.CoreUIJavaScriptResourceReference/ui.core.js"></script>
<script type="text/javascript" src="resources/org.odlabs.wiquery.ui.dialog.Dialog/ui.dialog.js"></script>
<script type="text/javascript" src="resources/org.odlabs.wiquery.ui.draggable.DraggableJavaScriptResourceLocator/ui.draggable.js"></script>
<script type="text/javascript" src="resources/org.odlabs.wiquery.ui.resizable.ResizableJavaScriptResourceReference/ui.resizable.js"></script>
<script type="text/javascript">$(document).ready(function() {
			$('#dialog1').dialog({autoOpen:false,
position:'center'});
});</script><script type="text/javascript">$(document).ready(function() {
			$('#open_dialog2').bind('dblclick', function() {
	$('#dialog1').dialog('open');
});
});</script></head>
    <body>
        <button wicket:id="open-dialog" name="open-dialog" id="open_dialog2">Open dialog !</button>
             
        <p wicket:id="dialog" id="dialog1">
        	Hello world, yes we can !
        </p>
    </body>
</html>
```

WiQuery automatically generates a "dom ready" event with your code inside. As you can see, the JavaScript code needed to create a modal window is generated:
```
$(document).ready(function() {
  $('#dialog1').dialog({autoOpen:false, position:'center'});
});
```

To manage events, WiQuery defines JsScope, a class to represent a JavaScript closure (e.g. an anonymous function with its own scope). Think that when your write:
```
JsScope.quickScope("alert('foo')");
```
... you generate the following JavaScript code:

```
function() {
alert('foo');
}


```