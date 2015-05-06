[[Wish List](Hielkes.md)]

## WiQuery 1.3 ##
- Fix resource management according to wicket 1.5 framework.
- Cleanup header contributing so it is easier to read what it actually does (currently there are too many if elses), use subclassing to split merged resources, ajax contributing, etc.
- Provide a better solution to options. Current options model is easy to use for small frameworks but a good framework for plugins with alot of options this is no good. Perhaps some form of abstract framework with json.
- More examples or implement more plugins and make examples using those? Topicus has numerous custom wiquery plugins. perhaps we can use some of those?

## WiQuery 1.2 ##
Keep this version as the main release until 1.3 has been properly tested.

## WiQuery 1.1 ##
Leave as is, only perform bugfixes.


[[Wish List:](Old.md)]

# wiQuery 1.0.2 #

- Fix [issue 60](https://code.google.com/p/wiquery/issues/detail?id=60) (apply richard's patch ?)

- Offer more wiQuery options for the configuration. Like [issue 67](https://code.google.com/p/wiquery/issues/detail?id=67): an option to specify if we use minified script (or compress on the fly) or not.  And [issue 89](https://code.google.com/p/wiquery/issues/detail?id=89), where the user can specify the jquery version to inject into the CoreJavascriptResourceReference

- Extract the plugins from the core api into an external project (or remove it). See [issue 74](https://code.google.com/p/wiquery/issues/detail?id=74) (http://code.google.com/p/wiquery/issues/detail?id=74)

- Merge the jweekend examples with the wiQuery examples ?

- See for the jquery namespaces conflict ? Check if the issue is still available and in which cases ([issue 34](https://code.google.com/p/wiquery/issues/detail?id=34))

# wiQuery 1.1.experiment #

- Create a github project with all the current ui themes (jquery ui 1.8.4)

- look on the css / js merger (test and improve it)

- Improve the examples (see Ernesto examples, with a jQuery UI theme, plugins samples and with the code explorer)

-Re-factor Options class to allow the use of IModels for property values. This would allow components (e.g. Dialog) to be more compatible with Wicket as well as use dynamic values for properties. Make options a wicket model so that Wicket itself takes care of detaching? Recursive detaching of IModel values for Option properties?

- Re-factor AJAX behavior event usage pattern. Right now it is
```
new XXXAjaxBehavior(EnumXXX.EVENT1, EnumXXX.EVENT2) {
   onEvent1() {
   }

   onEvent2() {
   }

   ....
   onEventN() {
   }
} 
```
which is a bit odd because you have methods onEventX() event if you are not using them. Replace it with a pattern
```
new XXXAjaxBehavior().addYYYEventHandler(
 new IXXXEventHandler() {
    onOvent() {
    } 
 }
); 
```
So that only needed events should be added.

- Provide versions of widgets that generate "in-line" JavaScripts. Current versions of widgets use Wicket machinery for contributing JS so widgets are not usable in components like jqGrid that not use Wicket's AJAX to retrieve server side content.

-Provide a list of new widgets and features to implement?

- More documentations