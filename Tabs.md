# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.tabs.TabsPage

## XHTML ##

```
<div wicket:id="tabs"> 
    <ul> 
	<li><a href="#tab1">Tab 1</a></li> 
	<li><a href="#tab2">Tab 2</a></li>  
    </ul> 
    <div id="tab1"> 
        <h4>Tab 1</h4> 
	    <p> 
	            Lorem ipsum dolor sit amet, consectetur adipiscing elit.  
	            Morbi facilisis porta nisi. 
            </p> 
    </div> 
    <div id="tab2"> 
        <h4>Tab 2</h4> 
	    <p> 
	            Lorem ipsum dolor sit amet, consectetur adipiscing elit.  
	            Morbi facilisis porta nisi. 
            </p> 
    </div> 
</div>
```

## Java ##

```
Tabs tabs = new Tabs("tabs");
```

# Options #

See http://docs.jquery.com/UI/Tabs

TODO