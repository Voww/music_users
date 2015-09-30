# music_users
KhNURE Oracle academy complex task from Java Programmer courses.

# 1. Introduction.

Music Users Database project is developed as coursework for completion of Oracle academy Programmer courses. 
The project represents Java developer's skills in Java core, Java classes and interfaces, JDBC, SQL, HTML,
servlets, localization, design-patterns and data processing using object-oriented approach. The project's database 
is developed to demonstrate 1:1, 1:M, M:M data relationships, 1-st, 2-nd and 3-rd normal forms of 
a databases architecture.

The Music Users database describes a list of music listeners (users) registered on a web-site. Each user has
such parameters as Login, Password and Email. The user is assigned with his own address and a list of
beloved music styles. Users can access different web-pages depending on their access rights.

A text of the task and source codes are located at a git-hub repository URL https://github.com/Voww/music_users .

#2. System requirements.

The Music Users Database project was developed under certain system conditions and software which finally 
define minimal system requirements to your server. To run the project you will have to be installed 
software below listed:

* Java runtime environment JRE 1.7.0_45 or higher;
* MySQL Server 5.7 or higher;
* Web-server apache-tomcat-8.0.23 or higher.

The next software might be installed optionally:

* JDK 1.7.0_45 or higher;
* MySQL workbench 6.3 or compatible;
* IDE environment IntelliJ IDEA 14.1.4 or compatible.

#3. Installation.

To pick up the project on your web-server, please follow these installation instructions.

* Download on your local machine the Music Users source code or web-archive 'music_users.war'
from a git-hub repository link: https://github.com/Voww/music_users.
* Create at the MySQL database a new database 'music_users' and a new user 'tomcat' with password 'tacmot' 
having administration rights on the 'music_users' database.
* Open path .\music_users\src\main\resources\ and find a file named 'music_users_db_install.sql'. 
Execute the sql-script from console or using MySQL workbench or IDE. 
* Verify the database installation typing in a MySQL console USE music_users; (Enter) 
SHOW TABLES FROM music_users; (Enter). If the database installed correct, your will obtain the such list 
of tables: address, music, role, user, user_address, user_music, user_role.
* Deploy the 'music_users.war' to your Tomcat server or compile the source code from command line 
or using IDE tools and deploy a new web-archive.
* Open an url http://yourHostName/music_users/ (http://localhost:8080/music_users/ by default).
If you see a text 'Music Users index page' it means the war-file is deployed correctly and 
the Music Users project is ready to use.

#4. Common project description.

The Music Users database describes a list of music listeners (users) registered on a web-site. Each user has
such parameters as Login, Password and Email. The user is assigned with his own address and a list of
beloved music styles. Users can access different web-pages depending on their access rights.

There are three access levels at Music Users database: 

* admin (administrator);
* mandator;
* user.

The 'administrator' has full access to the database information and can edit other users accounts 
and privileges status. The 'mandator' has limited access to the database information and can view other 
users accounts and privileges status without their changes. The 'user' can see and edit only his own account
information. Also he can add a new music style.

Open an url http://yourHostName/music_users/ where you can see a registration form. You are a first user
visiting 'Music Users index page'. Register a new user by typing his Login, Password and Email. The first user 
who has registered at the music users web-page becomes an administrator. The second and the next registered
users becomes simple users. The administrator can change other users privileges to 'mandator' or 'admin'.

Each user can have only one address and one role but it can be assigned with several music styles.
Fields 'registration date' and 'rating' are calculated automatically and could not be edited.

#5. Administrator's section description.

After logging in an administrator redirects to a main admin's page http://yourHostName/music_users/AdminWorks .
There are situated buttons 'User table', 'Role table', 'Address table', 'Music table'.

By clicking 'User table' you can see a list of registered users. To view user's detailed parameters press 
'details' button. To edit a user's data press 'edit' button. To delete a user press 'delete' button. 
To insert a new user enter user's data and press 'insert' button. To return back to the main admin page
press 'Backward' button.

By clicking 'Role table' you can see a list of registered roles. To view users list assigned with a selected 
role press 'details' button. To edit a role data press 'edit' button. To delete a role press 'delete' button. 
To insert a new role enter role data and press 'insert' button. To return back to the main admin page press
'Backward' button.

By clicking 'Address table' you can see a list of registered addresses. To view a user assigned with a 
selected address press 'details' button. To edit an address data press 'edit' button. To delete an address
press 'delete' button. To insert a new address enter address data and press 'insert' button. To return 
back to the main admin page press 'Backward' button.

By clicking 'Music table' you can see a list of registered music styles. To view users list assigned with a 
selected music style press 'details' button. To edit a music style data press 'edit' button. To delete a
music style press 'delete' button. To insert a new music style enter music data and press 'insert' button.
To return back to the main admin page press 'Backward' button.

#6. Mandator's section description.

After logging in a mandator redirects to a main mandator's page http://yourHostName/music_users/MandatorWorks .
There are situated buttons 'User table', 'Role table', 'Address table', 'Music table'.

By clicking 'User table' you can see a list of registered users. To view user's detailed parameters press 
'details' button. To return back to the main mandator page press 'Backward' button.

By clicking 'Role table' you can see a list of registered roles. To view users list assigned with a selected 
role press 'details' button. To return back to the main mandator page press 'Backward' button.

By clicking 'Address table' you can see a list of registered addresses. To view a user assigned with a 
selected address press 'details' button. To return back to the main mandator page press 'Backward' button.

By clicking 'Music table' you can see a list of registered music styles. To return back to the main mandator
 page press 'Backward' button.
 
#7. User's section description.
 
After logging in a user redirects to a main user's page http://yourHostName/music_users/UserWorks .
There is situated detailed information about the user being logged in: 'User', 'Role', 'Address', 
'Music styles'.
 
To edit a user's data press 'edit' button. To delete a user press 'delete' button (you will be logged off
automatically). 
 
To edit an address data press 'edit' button. To delete an address press 'delete' button. To insert a 
new address enter address data and press 'insert' button. To select beloved music styles click one or 
several checkboxes at music list.  To insert a new music style enter music data and press 'insert' button.
 
Role and existing Music data are not editable from User section.

#8. Summary

Music Users Database project is a free distributed software and can be used by students of programming 
specialities for studying or testing purposes. The project development continues, so new releases could be 
deployed in a brief time at a git-hub repository link https://github.com/Voww/music_users .

 

