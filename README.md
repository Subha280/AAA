# AAA
PROJECT Autonomiae Amittit Auream

Please read the following Instructions before executing the project

1.This project is developed using Eclipse IDE for Java Developers, Version 2018-09 (4.9.0) , https://www.eclipse.org/
2.It uses Java Version 3.141.59 .https://www.seleniumhq.org/download/. The required JAR files(Initializing Java home path, Selenium JARs ) are added to the external library 
3.This uses TestNG Testing Framework. The inputs are given using DataParameterization.
4.All the Screenshots are captured in PNG format and saved in a folder.
5.Reports are generated using TestNG XML.
6.Project is shared in Github repository.


CHANGES TO THE CODE DONE:
1.I have modified CSS in the pages to make the screens fit to the page.

CODE:
This project contains 3 java classfiles.
Takescreenshot.java - has predefined methods for taking screenshots and it is called by other classes whenever needed.
TestNG.java - This class has tests based on the page home.html , which verifies navigation between screens, displaying Titles, and input datas are 
provided using Dataprovider method().
Contactpage.java - This class gets input from an external excel sheet and it is based on contact.html.
