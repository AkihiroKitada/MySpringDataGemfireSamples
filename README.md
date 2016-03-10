Spring Data Gemfire - Apache Geode Cache Listener Client Sample
===============================================================

This sample application demonstrates using Spring Data Gemfire for Apache Geode in a standalone Java application with a cache client and a single client region with a simple CacheListener.

You can run the application with the following steps.

1. Download Geode binary and unzip/untar at the preferable directory. 
2. Open your console, set environment variable like the following according to your environment.
 - export JAVA_HOME=/path/to/JDK8_root
 - export PATH=$JAVA_HOME/bin:/pat/to/Geode_root/bin:$PATH
3. Go to /[project root] and start a locator and two servers like the following
 - sh ./startLocator.sh
 - sh ./startCS1.sh
 - sh ./startCS2.sh
4. Start a client application (CacheListenerVisualizer) from IDE
5. From your console, start gfsh with interactive mode like the following.
 - gfsh
6. Execute some command and put something data like the following. You can see the client application respond according to your put command execute.

	    _________________________     __
	   / _____/ ______/ ______/ /____/ /
	  / /  __/ /___  /_____  / _____  / 
	 / /__/ / ____/  _____/ / /    / /  
	/______/_/      /______/_/    /_/    v1.0.0-incubating.M1
	   
    Monitor and Manage GemFire
    gfsh>connect --locator=localhost[55221]
    Connecting to Locator at [host=localhost, port=55221] ..
    Connecting to Manager at [host=localhost, port=1099] ..
	Successfully connected to: [host=localhost, port=1099]
	
	gfsh>list members
	 Name   | Id
	------- | --------------------------------------------
	locator | localhost(locator:2324:locator)<ec><v0>:1024
	server1 | localhost(server1:2368)<ec><v3>:1025
	server2 | localhost(server2:2387)<ec><v4>:1026
	
	gfsh>put --key=key1 --value=value1 --region=myRegion
	Result      : true
	Key Class   : java.lang.String
	Key         : key1
	Value Class : java.lang.String
	Old Value   : <NULL>
	
	
	gfsh>put --key=key2 --value=value2 --region=myRegion
	Result      : true
	Key Class   : java.lang.String
	Key         : key2
	Value Class : java.lang.String
	Old Value   : <NULL>
	
	
	gfsh>put --key=key2 --value=value2_2 --region=myRegion
	Result      : true
	Key Class   : java.lang.String
	Key         : key2
	Value Class : java.lang.String
	Old Value   : value2
	
	
	gfsh>put --key=key3 --value=value3 --region=myRegion
	Result      : true
	Key Class   : java.lang.String
	Key         : key3
	Value Class : java.lang.String
	Old Value   : <NULL>
	
	gfsh>quit
	
7. Stop the servers and the locator like the following from your console.
 - sh ./stopCS2.sh
 - sh ./stopCS1.sh
 - sh ./stopLocator.sh

* If you see the following message when starting your locator, ...

	Please use "connect --locator=192.168.1.100[55221]" to connect Gfsh to the 	locator.
then you may have to add the following line at /etc/hosts according to your environment to start a locator and servers with using gfsh

	[your machine IP address] localhost
	ex) 192.168.1.100	localhost 

--------------------------------------------------------------------------------

For help please take a look at the Spring Data Gemfire documentation:

http://projects.spring.io/spring-data-gemfire/