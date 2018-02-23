# JAVA-iAMCORE-EPITA

Welcome to IAMCore project:IDENTITY MANAGEMENT SYSTEM

It is an interactive console application that allows you to create, delete, modify identities. Read to the User Guide.pdf for further help.
This application was build using JDK 1.8

Simply launch the database and this java program. After connecting to the database, you need to provide user information to authenticate as an admin. After which, you are free to manage the database of user identities.

Step to run the application

Setup the database:

Download apache derby client
Create an instance of derby name it instance name =iamcore with username="admin" and password="admin".
run /db-derby-10.13.1.1-bin/bin/startNetworkServer
Go to epita_iamcore/src/fr/epita/iam/config/config.properties edit user value with the user name you used to create your derby schema Do the same with password, the name if instance if you used your own values
Go to epita_iamcore/sql run create_tables.sql on your instance iamcore
Run the application:

Go to epita_iamcore/src/fr/epita/iam/launcher execute ConsoleLauncher.java
Developers:
Go to iam_core/javadoc for documentation
