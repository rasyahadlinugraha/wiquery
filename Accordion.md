# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/?wicket:bookmarkablePage=:org.odlabs.wiquery.examples.accordion.AccordionPage

## XHTML ##

```
<div wicket:id="accordion">
   <h3><a href="#div1">Section 1</a></h3>
  <div id="div1">
	<p>
           Mauris mauris ante, blandit et, ultrices a, susceros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum  
           a velit eu ante scelerisque vulputate.
       </p>
  </div>
  <h3><a href="#div2">Section 2</a></h3>
  <div id="div2">
	<p>
          Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet,    
          mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna. 
       </p>
  </div>
</div>
```

## Java ##

```
Accordion  accordion = new Accordion("accordion");
add(accordion);
```

# Options #

See http://docs.jquery.com/UI/Accordion

TODO