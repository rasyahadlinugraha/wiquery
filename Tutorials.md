# Introduction #

This section provides some tutorials to use wiQuery or to create some wiQuery components / behaviors.


# WiQuery Accordion Tutorial - from Nivedan Nadaraj #

The  objective of the blog is to address how the Wiqery Accordion can be built dynamically. There has been an  earlier post in Wiquery on the same but I thought it would nice to add a little more and also provide a maven project for download: http://wiquery.googlecode.com/files/wiaccordion.zip.

The Problem:

When I first looked at the Wiquery Accordion control it looked great but I could not find a way to quickly build the accordion dynamically. To keep the story to the point, I checked with Julien Roche and he provided some insights on how it can be built.

Possible Solution:

# Use a repeater like org.apache.wicket.markup.html.list.ListView to render the Accordion so that the markup of the Accordion is generated appropriately.

# Use the wicket:container tag to keep the generated markup clean

# Use a Label control that will represent the section name. Technically the ListItem of the ListView will contain the Label.

# Finally the data source can be retrieved from a back-end database table. Assuming that the persistence layer is implemented and returns a List

&lt;String&gt;

..


For the sake of a simple example, we build this Accordion on a Page. The accordion can be added into  a Panel as well.

The HTML mark up of the Accordion is a follows.

```
<html>

  <head>

    <title>Example Wiquery Accordion</title>

      </head>

        <body>

          <div wicket:id=”wiAccordion”>

            <wicket:container wicket:id=”accordionListView”>

             <h3><a href=”#div”><wicket:container wicket:id=”sectionNameLbl” ></wicket:container></a><h3>

                <div id=”content”>

                            <p> Place any content here or add a custom component built using a panel </p>

                </div>
              </wicket:container>

           </div>

        </body>

</html>
```


On the Java side of things, we create an instance of the Wiquery Accordion control.

```
Accordion accordion = new Accordion(“wiAccordion”);

//A private method that returns a list of Strings getSections

List<String> carModelList = getSections();

 

ListView accordionListView = new ListView("accordionListView", carModelList)

{

              @Override

              protected void populateItem(ListItem listItem){

                            String sectionName = (String) listItem.getModelObject();

                            listItem.setRenderBodyOnly(true);

                            listItem.add(

new Label("sectionNameLbl",sectionName).setRenderBodyOnly(true));

              }

  };
```


Within the ListView's overriden populateItem() we set the Section name with the value in the carModelList into the Label. The ListItem.setRenderBodyOnly is set to true, which I found that when added renders the control without any issue. Although this can be avoid when using the wicket:container, I was not successful using it. I have also used the same set() on the Label, which is not necessary unless you want to get rid of span tags on the final rendered markup.


Add the ListView instance into the accordion as a child.

```
  accordion.add(  accordionListView);

  add(accordion);//Finally add it to the Page
```

Note that the for clarity I have used the accordionListView as the identifier on the markup to give an idea that it is a repeater that renders the items of the accordion(sections).The section name is rendered by the Model linked to the Label control, which is the ListItem of the ListView.


The use of wicket:container is to keep the markup cleaner or remove excess markup.


The project provided displays the accordion on the HomePage. The Webapplication extends the WiqueryWebApplication.


I hope this example was useful for  those of us who want to use the Wiquery Accordion control in a more dynamic way instead of creating the full mark up on the html end. I am sure there are better ways to achieve the same, please do share it with me.


I would like to thank the Wiquery team members for the response and their thoughts that that contributed to this example.