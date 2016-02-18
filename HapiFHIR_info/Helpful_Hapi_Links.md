#Helpful links and info with HapiFHIR.
* [java docs for 
resources](http://jamesagnew.github.io/hapi-fhir/apidocs-dstu2/index.html)
* [java docs in general for the DSTU2 
model](http://jamesagnew.github.io/hapi-fhir/apidocs-dstu2/index.html) I 
don't believe we will need much from anything other than the resource 
portion at this point.
* [HapiFHIR releases](https://github.com/jamesagnew/hapi-fhir/releases)

#How to add HapiFHIR to Netbeans
* First download the correct files from the Hapi FHIR releases link, 
they download as all jar files.
* In netbeans start a new project.
* click tools at the top and go to libraries
* Next click New Library... at the bottom left of the window.
* Give it a name, I just called it HapiFHIR
* Next, locate the library you just made in the explorer window above 
the New Library... button and select it.
* Make sure you are on the classpath tab.
* Click add JAR/Folder on the right of the window.
* Navigate to the folder containing the JAR files you downloaded and add 
them all to the library.
* After you click ok, you should see the library with the jar file in 
the project explorer's lilbrary tab on the right. All imports and 
classes should be available to us.
