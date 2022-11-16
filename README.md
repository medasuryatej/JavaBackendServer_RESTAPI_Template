Required Tools
1.  IntelliJ preferable Ultimate edition
2. MySQL

Tomcat Configuration Steps
1. Edit configurations
2. Add Tomcat Local Server
3. Click fix: (Warning: No artifacts selected for deployment)
4. Select server.war(exploded)
5. Rename the application as /SPM_InfinityTravel  you can name whatever your project name is
6. Apply and save

MySQL Steps
1. Install MySQL (remember the root user and password)
2. Create a database. (In this case 'infinitytravel')
3. Create tables. (In this case 'discount_codes' & 'flights')

Update URL, Password in server/src/main/webapp/META-INF/context.xml

Setting Up MySQL in IntellJ
1. From the right side navbar select Databases menu
2. Click + and select MySQL
3. In the configurations choose localhost, your database name, provide credentials and test the connection
4. Run the files server/src/main/resources/ to establish the schema and sample records

Testing EndPoints
1. http://localhost:8080/SPM_InfinityTravel/api/discounts
2. http://localhost:8080/SPM_InfinityTravel/api/discounts/<discount_id>
3. http://localhost:8080/SPM_InfinityTravel/api/discounts/code/<discount_code>
2. http://localhost:8080/SPM_InfinityTravel/api/flights?src=<srcName>&dest=<destName>