On how to build, run and use :

Using the app, a file containing student details in a specific format can be uploaded and submitted. Details are recorded in the DB.

1) import source code into IDE and do a gradle build to produce zxc-0.0.1-SNAPSHOT.jar in ~build/libs dir.
2) java -jar zxc-0.0.1-SNAPSHOT.jar
3) Open http://localhost:8080/index in browser. Dont do anything yet.
4) Open http://localhost:8080/h2-console/ for H2 in mem DB. Make sure JDBC URL is set to jdbc:h2:mem:testdb.You'll see empty student table.
5) Go to index page and upload the provided "student.txt" file. You'll see the details in the DB tab too.
6) Change the name/age/interest of student in "student.txt" and then upload. Changes visible in DB.

NOTE : (dont change the format in which the details are present in student.txt. Just change the content/values of the keys)  


