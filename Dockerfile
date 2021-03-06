##########################################################################################
#   Xebia Project
##########################################################################################

#Base Container contains java
FROM java:8

#determines the application will be exposed to the world
EXPOSE 8080

#adding target folder to workspace location
ADD target/xebia-project-0.0.1-SNAPSHOT.jar

#Entrypoint
ENTRYPOINT ["java","-jar","xebia-project-0.0.1-SNAPSHOT.jar"]
