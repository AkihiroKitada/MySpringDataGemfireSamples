#! /bin/sh
gfsh -e "connect --locator=localhost[55221]" -e "start server --name=server2 --dir=server2 --spring-xml-location=sdg-server.xml --classpath=../src/main/resources/META-INF/spring/gemfire"
