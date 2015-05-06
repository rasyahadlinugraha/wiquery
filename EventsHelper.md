# What is that ? #

Utility class to bind on your JsStatement or JsQuery some javascript listeners

# Methods #

  * bind(EventLabel eventLabel, JsScope jsScope): Binds a handler to one or more events (like click) for each matched element.
  * blur(): Triggers the blur event of each matched element.
  * blur(JsScope jsScope): Bind a function to the blur event of each matched element.
  * change(): Triggers the change event of each matched element.
  * change(JsScope jsScope): Bind a function to the change event of each matched element.
  * click(): Triggers the click event of each matched element.
  * click(JsScope jsScope): Bind a function to the click event of each matched element.
  * dblclick(): Triggers the dblclick event of each matched element.
  * dblclick(JsScope jsScope): Bind a function to the dblclick event of each matched element.
  * die(EventLabel eventLabel, JsScope jsScope): This does the opposite of live, it removes a bound live event.
  * error(): Triggers the error event of each matched element.
  * error(JsScope jsScope): Bind a function to the error event of each matched element.
  * focus(): Triggers the focus event of each matched element.
  * focus(JsScope jsScope): Bind a function to the focus event of each matched element.
  * hover(JsScope over, JsScope out): Simulates hovering (moving the mouse on, and off, an object). This is a custom method which provides an 'in' to a frequent task.
  * keydown(): Triggers the keydown event of each matched element.
  * keydown(JsScope jsScope): Bind a function to the keydown event of each matched element.
  * keypress(): Triggers the keypress event of each matched element.
  * keypress(JsScope jsScope): Bind a function to the keypress event of each matched element.
  * keyup(): Triggers the keyup event of each matched element.
  * keyup(JsScope jsScope): Bind a function to the keyup event of each matched element.
  * live(EventLabel eventLabel, JsScope jsScope): Binds a handler to an event (like click) for all current - and future - matched element.
  * load(JsScope jsScope): Bind a function to the load event of each matched element.
  * mousedown(JsScope jsScope): Bind a function to the mousedown event of each matched element.
  * mouseenter(JsScope jsScope): Bind a function to the mouseenter event of each matched element.
  * mouseleave(JsScope jsScope): Bind a function to the mouseleave event of each matched element.
  * mousemove(JsScope jsScope): Bind a function to the mousemove event of each matched element.
  * mouseout(JsScope jsScope): Bind a function to the mouseout event of each matched element.
  * mouseover(JsScope jsScope): Bind a function to the mouseover event of each matched element.
  * mouseup(JsScope jsScope): Bind a function to the mouseup event of each matched element.
  * one(EventLabel eventLabel, JsScope jsScope): Binds a handler to one or more events to be executed once for each matched element.
  * ready(JsScope jsScope): Binds a function to be executed whenever the DOM is ready to be traversed and manipulated.
  * scroll(JsScope jsScope): Bind a function to the scroll event of each matched element.
  * select(): Triggers the select event of each matched element.
  * select(JsScope jsScope): Bind a function to the select event of each matched element.
  * submit(): Triggers the submit event of each matched element.
  * submit(JsScope jsScope): Bind a function to the submit event of each matched element.
  * toggle(JsScope jsScope, JsScope jsScope2): Toggle among two function calls every other click.
  * toggle(JsScope jsScope, JsScope jsScope2, JsScope... jsScopes): Toggle among two or more function calls every other click.
  * trigger(EventLabel eventLabel): Trigger an event on every matched element.
  * triggerHandler(EventLabel eventLabel): Triggers all bound event handlers on an element (for a specific event type) WITHOUT executing the browser's default actions, bubbling, or live events.
  * triggerHandler(EventLabel eventLabel, CharSequence... data): Triggers all bound event handlers on an element (for a specific event type) WITHOUT executing the browser's default actions, bubbling, or live events.
  * unbind(EventLabel eventLabel, JsScope jsScope): This does the opposite of bind, it removes bound events from each of the matched elements.
  * unload(JsScope jsScope): Bind a function to the unload event of each matched element.
