# Introduction #

This tutorial will teach you how to install and use WiQuery 1.5 in 5 minutes, with a classic "Hello world" example.

## Tools ##

To begin this tutorial, you'll need the following components to be installed:
  * [Maven 2.x or 3.x](http://maven.apache.org/download.html)
  * Java JDK1.5+

## Version of Wicket ##

Each WiQuery version is built with the latest Wicket version: 1.5.

## Starting a Wicket project ##

First of all, we need to start a Wicket project. To do this quickly, we'll use maven archetypes, already ready to use with your Maven 2 installation.

### Create the project with Maven 2 ###

Go to your home directory (or in any directory you want to work in) and type the command below:

```
mvn archetype:generate -DarchetypeGroupId=org.apache.wicket -DarchetypeArtifactId=wicket-archetype-quickstart -DarchetypeVersion=1.5-SNAPSHOT -DgroupId=org.odlabs -DartifactId=quickstart -DarchetypeRepository=https://repository.apache.org/content/repositories/snapshots/ -DinteractiveMode=false
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

![http://wiquery.googlecode.com/files/check-wicket15-works.png](http://wiquery.googlecode.com/files/check-wicket15-works.png)

# Use WiQuery #

## Add WiQuery repository ##

You must add the following server repository link into your
pom.xml file:

```
<repositories>
...
     <repository>
         <id>wiquery-maven-repo</id>
         <name>WiQuery repository</name>
         <url>https://wiquery.googlecode.com/svn/repo/</url>
     </repository>
...
</repositories>
```

## Add a dependency to the quickstart application ##

  * To do this, get back in the quickstart application and edit the pom.xml file to add the following lines:

```
<dependency>
     <groupId>org.odlabs.wiquery</groupId>
     <artifactId>wiquery-jquery-ui</artifactId>
     <version>1.5.0</version>
</dependency>
```

  * Then, restart the jetty server to check that everything worked fined:

```
mvn jetty:run
```

# The Hello World example #

Let's do the HelloWorld example with WiQuery's modal window. It is probably easier to do this in an IDE like Eclipse. For eclipse you need to run the following command before you can import the project:

```
mvn eclipse:eclipse
```

This will set everything right for Eclipse. Every time you edit the pom.xml you need to run this command so Eclipse knows about the change. When using an IDE you can use the Start class to run/debug as Java Application, this will do the same as `mvn jetty:run` but it will allow you to debug.

## Enable WiQuery ##

Once WiQuery is on your classpath WiQuery is enabled and working. Several features are configurable through the WiQuerySettings class.

## Add markup for the modal window ##

In this tutorial, we will use the inline modal window (e.g., a modal window displaying content already loaded in the current page). This modal window will be opened when the "dblclick" event happends on a button.

  * Edit the markup file HomePage.html to have the following code:

```
<!DOCTYPE html>
<html xmlns:wicket="http://wicket.apache.org">
    <head>
        <meta charset="utf-8" />
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

  * Edit the java file HomePage.java to have the following code:

```
package org.odlabs;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.odlabs.wiquery.core.events.Event;
import org.odlabs.wiquery.core.events.MouseEvent;
import org.odlabs.wiquery.core.events.WiQueryEventBehavior;
import org.odlabs.wiquery.core.javascript.JsScope;
import org.odlabs.wiquery.ui.dialog.Dialog;

public class HomePage extends WebPage
{

	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters)
	{

		final Dialog dialog = new Dialog("dialog");
		add(dialog);

		Button button = new Button("open-dialog");
		button.add(new WiQueryEventBehavior(new Event(MouseEvent.CLICK)
		{
			private static final long serialVersionUID = 1L;

			@Override
			public JsScope callback()
			{
				return JsScope.quickScope(dialog.open().render());
			}

		}));
		add(button);
	}
}

```

  * You should see a button. When inspecting the source of the page you will also see a div, which is the dialog. When you double click on this button, a modal window should open:

![http://wiquery.googlecode.com/files/modal-quickstart.png](http://wiquery.googlecode.com/files/modal-quickstart.png)

That's it, you have coded your first WiQuery application !

# How does it works ? #

WiQuery eases jQuery / jQuery UI JavaScript integration:
  * WiQuery imports needed JavaScript / CSS resources.
  * WiQuery wrapps all jQuery events, that's why we are able to detect a click event.

Let's check the generated source:

```

<html xmlns:wicket="http://wicket.apache.org">
    <head>
        <meta charset="utf-8" />
        <title>WiQuery Quickstart Archetype Homepage</title>
    <script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.core.resources.CoreJavaScriptResourceReference/jquery-1.6.3-ver-1316720045559.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.widget.WidgetJavaScriptResourceReference/jquery.ui.widget-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.mouse.MouseJavaScriptResourceReference/jquery.ui.mouse-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.position.PositionJavaScriptResourceReference/jquery.ui.position-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.core.CoreUIJavaScriptResourceReference/jquery.ui.core-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.button.ButtonJavaScriptResourceReference/jquery.ui.button-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.draggable.DraggableJavaScriptResourceReference/jquery.ui.draggable-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.resizable.ResizableJavaScriptResourceReference/jquery.ui.resizable-ver-1316720044100.js"></script>
<script type="text/javascript" src="wicket/resource/org.odlabs.wiquery.ui.dialog.DialogJavaScriptResourceReference/jquery.ui.dialog-ver-1316720044100.js"></script>
<link rel="stylesheet" type="text/css" href="wicket/resource/org.odlabs.wiquery.ui.themes.WiQueryCoreThemeResourceReference/uilightness/jquery-ui-1.8.16.custom-ver-1316720044100.css" />
<script type="text/javascript" id="wiquery-gen-1316720478231">
/*<![CDATA[*/
(function($) {

$(document).ready(function() {
		$('#open_dialog1').bind('click', function() {
	$('#dialog2').dialog('open');
});
	$('#dialog2').dialog({autoOpen: false, position: 'center'});

});

})(jQuery);

/*]]>*/
</script>
</head>
    <body>
        <button wicket:id="open-dialog" name="open-dialog" id="open_dialog1">Open dialog !</button>
             
        <p wicket:id="dialog" id="dialog2">
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