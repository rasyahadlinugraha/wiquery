# What is that ? #

Utility class to simplify the basic javascript statement, like JSON, array, literal whit quotes ....

# Methods #

  * array(CharSequence... args) : javascript array statement
  * doubleQuotes(CharSequence stringToDoubleQuote), doubleQuotes(CharSequence stringToDoubleQuote, boolean escapeDoubleQuote): literal with double quotes
  * quotes(CharSequence stringToQuote), quotes(CharSequence stringToQuote, boolean escapeQuote): literal with quotes
  * escapeDoubleQuote(CharSequence stringToDoubleQuote), escapeQuote(CharSequence stringToQuote): escape double quote or simple quote into the String object
  * implode: converts the given array of EventLabel to a String
  * json(Serializable jsonObject): try to convert your java object as JSON