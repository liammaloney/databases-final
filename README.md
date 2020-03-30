# Final Project for CSI2132

## Authors
- Vidulash Rajaratnam 8190398
- Liam Maloney 8129429
- Zhen Wang 300057304

##Setup

This project requires that the user write an `application.properties` file and leave it in the top level directory in this project. The following is the format for the file:
```
db.driver = org.postgresql.Driver
db.url = jdbc:postgresql://DATABASE.URL:PORT/DATABASE
db.username = ThisIsAUsername
db.password = Password123
db.query = select ATTRIBUTE from SCHEMANAME.TABLENAME
```

This works with any query type but functionality is currently limited to running the query specified in the properties file.
