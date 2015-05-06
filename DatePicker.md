# How to use #

See example here: http://wiquery-examples-1-1-x.appspot.com/wicket:bookmarkablePage=:org.odlabs.wiquery.examples.datepicker.DatePickerPage

## XHTML ##

```
<input type="text" wicket:id="datePicker" />
```

## Java ##

```
DatePicker<Date> datePicker = new DatePicker<Date>("datePicker");
datePanel.add(datePicker);
```

# Options #

See http://docs.jquery.com/UI/Datepicker

TODO