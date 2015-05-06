# What is that ? #

Utility class to bind on your JsStatement or JsQuery some jQuery method to search elements

# Methods #

  * eq(int position): reduce the set of matched elements to the one at the specified index.
  * filter(String expression): reduce the set of matched elements to those that match the selector or pass the function's test.
  * not(String expression): remove elements from the set of matched elements.
  * slice(int start): reduce the set of matched elements to a subset specified by a range of indices.
  * slice(int start, int end): reduce the set of matched elements to a subset specified by a range of indices.
  * add(String expression): add elements to the set of matched elements.
  * children(String expression): get the children of each element in the set of matched elements, optionally filtered by a selector.
  * contents(String expression): get the children of each element in the set of matched elements, including text and comment nodes.
  * find(String expression): get the descendants of each element in the current set of matched elements, filtered by a selector.
  * next(String expression): get the immediately following sibling of each element in the set of matched elements. If a selector is provided, it retrieves the next sibling only if it matches that selector.
  * nextAll(String expression): get all following siblings of each element in the set of matched elements, optionally filtered by a selector.
  * parent(String expression): get the parent of each element in the current set of matched elements, optionally filtered by a selector.
  * parents(String expression): get the ancestors of each element in the current set of matched elements, optionally filtered by a selector.
  * prev(String expression): get the immediately preceding sibling of each element in the set of matched elements, optionally filtered by a selector.
  * prevAll(String expression): get all preceding siblings of each element in the set of matched elements, optionally filtered by a selector.
  * siblings(String expression): get the siblings of each element in the set of matched elements, optionally filtered by a selector.
