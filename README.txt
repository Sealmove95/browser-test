For selecting target browser you should change property target.browser in pom.xml.
Supported browsers are: Firefox, Chrome(default)
You can change target browser in pom.xml amd launch test with command:
mvn install
Or you can specified browser through command line parameter:
mvn install "-Dtarget.browser=firefox"
