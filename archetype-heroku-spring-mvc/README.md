[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy)
# This project is based on an Heroku Embedded Tomcat tutorial.

If you would like to create the application yourself, then follow the Dev Center guide on how to [Create a Java Web Application using Embedded Tomcat](https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat).

# Project information

This project is currently set up w/ the SpringMVC architecture and has an example a few different DAO implementations. 

If you're just getting started, just start with the inMem version that it's currently wired with.

However - the MySQL and Postgres DAO implementations can be connected to some of Heroku's free data persistance addons.

If you do so, you should end up w/ a new config variable associated with your app.

Postgres usually loads something called DATABASE_URL, JawsDB loads one called JAWSDB_URL. Both should look something like the following:

databasetype://thedatabaseuser:thedatabasepassword@thedatabaseserver.compute-1.amazonaws.com:PORT/databaseschema

Split this into 3 new config variables (if you don't want to rewire the examples given):

DB_URL = databasetype://thedatabaseserver.compute-1.amazonaws.com:PORT/databaseschema
DB_USR = thedatabaseuser
DB_PWD = thedatabasepassword

Then, after you connect & create the example tables (commented in mappers!) you can use either the postgres or mysql dao, depending on your preference!