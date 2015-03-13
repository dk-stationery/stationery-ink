# stationery-ink
Distributed real-time streaming aggregation framework using the SQL-based 'Apache Storm'

##System Requirements   
HBASE : 0.98.1-cdh5.1.3 above    
PHOENIX : 4.0.0-incubation (custom version) above    
STORM : 0.9.0.1 above    
REDIS    

##Ink Features
1. SQL support. (Tommy's SQL = TSQL)    
2. CEP Framework Esper integration.    
3. Storm topology optimizer automatically generated and executed   
4. Ink JDBC driver support.    
5. UDF function support.  
6. Stream partition computation support.  
7. Multi tenants support.

##Terms and concepts used in Ink
1. STREAM : The format of the log of the streaming format that is infinitely delivery. Concepts such as table schema of the RDBMS.
2. SOURCE : Metadata that defines the access connection that can access information on the STREAM.
3. WINDOW : Concept to be aggregated to define the scope of the streaming data to the streaming time and the size.

##Ink Architecture
1. INK DAEMON : Optimayijing the TSQL received from the user, performs, and serves to create a running topology storm, Communicate with Ink JDBC driver.  
2. INK JDBC DRIVER : Driver that can be used by the driver in the third-party program Ink (type 2)  
3. INK DYNAMIC API : The result of performing the Ink you can get passed through the Rest api.  

![GitHub Logo](/ink.png)

Summation : Connecting the streaming data defined in STREAM, based on the information of the meta data in the SOURCE, passing under the framework that is driven off the crossbar, the streaming data to the query definition as defined in TSQL delivered.

##Getting started
####Install the required system
1. Install Apache Storm.    
: > Reference : https://storm.apache.org/    
2. Install Hbase.    
: > Reference : http://hbase.apache.org/    
3. Install Apache Phoenix.    
: > Reference : http://phoenix.apache.org/    
4. Install Redis.    
: > Reference : http://www.redis.io/    
5. Install Ink-api.    
: > The clone the source code from github address, https://github.com/tommy-kwon/stationery-ink.git    
: > 'mvn package -DskipTests' Execution.    
: > 'stationery-ink-api/target' that was built in the folder 'stationery-ink-api-1.0-SNAPSHOT.jar' must copy the api server side.    
In the api server 'nohup java -Dserver.port = 8080 -Dconfig = config-production.yml -Dlog4j.loglevel = INFO -server -Xmx2g -Xms2g -XX: PermSize = 512m -XX: MaxPermSize = 512m -XX: + UseParallelOldGC - jar stationery-ink-api.jar >> /daum/logs/ink-api.log 2> & 1 & ' command is carried out should drive the API server.    

###### config-production.yml
		phoenix:
    			driverClassName: org.apache.phoenix.jdbc.PhoenixDriver
    			url: phoenix connection url (Ex. jdbc:phoenix:dmp-hbase-m2.h.test.com,dmp-hbase-m1.h.test.com,dmp-hbase-m3.h.test.com:2181)
    			initPoolSize: 30
    			maxPoolSize: 150
    			minPoolSize: 10

		auth:
    			api:
        			id: api user id (ex.test_user)
        			password: api password (ex.test_pw)

		redis:
    			host: Redis connection url (Ex. cache40.rc2.test.cc,cache42.rc2.test.cc,cache176.rc2.test.cc,cache177.rc2.test.cc,cache178.rc2.test.cc)
    			password: Redis password (Ex. test_redis_pw)

6. Install Ink-daemon.    
: > 'stationery-ink-daemon/target' that was built in the folder 'stationery-ink-daemon-1.0-SNAPSHOT.jar' must copy the daemon server side.  
: > 'nohup java -Dserver.port=9292 -Dconfig=config-production.yml -Dlog4j.loglevel=INFO -server -Xmx2g -Xms2g -XX:PermSize=512m -XX:MaxPermSize=512m -XX:+UseParallelOldGC -jar stationery-ink-daemon.jar >> /daum/logs/ink-daemon.log  2>&1 &' command is carried out should drive the DAEMON server.   
###### config-production.yml
		inkconfig:
    			filepath: Setting the file path of the ink framework (ex. /inkconfig.production.properties)

		phoenix:
    			driverClassName: org.apache.phoenix.jdbc.PhoenixDriver
    			url: phoenix connection url (Ex. jdbc:phoenix:dmp-hbase-m2.h.test.com,dmp-hbase-m1.h.test.com,dmp-hbase-m3.h.test.com:2181)
    			initPoolSize: 1
    			maxPoolSize: 10
    			minPoolSize: 1

		auth:
    			api:
        			id: daemon user id (ex.test_user)
        			password: daemon password (ex.test_pw)

		redis:
    			host: Redis connection url (Ex. cache40.rc2.test.cc,cache42.rc2.test.cc,cache176.rc2.test.cc,cache177.rc2.test.cc,cache178.rc2.test.cc)
    			password: Redis password (Ex. test_redis_pw)

		daemon_id:
    			name: Current ink-daemon unique name (ex. TEST)

		multi_tenants:
    			-  name: 'USE command' using a different server when accessing other ink-daemon server daemon_id (ex. TEST2)
       			url: Access to the other daemon server url (ex. http://{IP ADDRESS}:{PORT:defalut:9292}/sql/run)   

###### inkconfig.production.properties
		IS_LOCAL: N (whether you are running local storm)
		WORKER_CNT: 1 (Number of basic ink runs Storm Walker)
		SPOUT_THREAD_CNT: 1 (LOG collection, the default number of threads)
		ESPER_THREAD_CNT: 1 (SELECT query, the default number of threads)
		LOOKUP_THREAD_CNT: 1 (LOOKUP query, the default number of threads)
		OUTPUT_THREAD_CNT: 1 (INSERT, UPSERT, UPDATE, DELETE query, the default number of threads)
		IS_DEBUG: Y (Whether the output logging in debug mode)
		COMMIT_INTERVAL: 5 (INSERT, UPSERT, UPDATE, DELETE query he default Commit interval)
		STORM_MESSAGE_TIMEOUT_SEC : 30
		STORM_MAXSPOUTPENDING_NUM : 1
		STORM_BATCH_SIZE : 10485760
		STORM_CLIENT_FILEPATH : /daum/program/ink-stormclient/ (Location of deployment JAR to use the Storm)
		STORM_CLIENT_MAIN_CLASS : org.tommy.stationery.ink.stormclient.StormClient
		STORM_CLIENT_JAR : stationery-ink-stormclient.jar (The name of the JAR for deployment)
		STORM_HOME : /daum/program/storm/ (The home directory of the STORM program)
		STORM_RUN_LOG_FULLPATH : /daum/logs/ink/run.log (STORM LOG settings directory)
		STORM_URL : 10.11.99.149:8080 (STORM cluster URL of the web page)
		REGIST_JOB : Y (When you do get in INK, a TSQL query is performed whether to store the metadata store)
		DUMP_FLUSH_API_URL : 127.0.0.1:9292/dump/api/flush (Dump api URL to confirm the results of the performed job at INK)
		DUMP_CLEAR_API_URL : 127.0.0.1:9292/dump/api/clear (Dump api URL to confirm the results of the performed job at INK)
		DUMP_API_URL : 127.0.0.1:9292/dump/api/dump (Dump api URL to confirm the results of the performed job at INK)

7. Install Ink-stormclient.  
: > 'stationery-ink-stormclient/target' that was built in the folder 'stationery-ink-stormclient-1.0-SNAPSHOT.jar' must copy the daemon server side.    


##TSQL Commands
####DDL TSQL : 

1. show cluster :   
> : Storm cluster current status infomation, topology information getting TSQL.  
> : ex> show cluster;  

2. show jobs | job JOB_NAME :  
> : job information stored in metastore getting TSQL.  
> : ex> show jobs; OR show job testjob;  

3. show streams | stream STREAM_NAME :   
> : stream information stored in metastore getting TSQL.  
> : ex> show streams; OR show stream teststream;  

4. show sources | source SOURCE_NAME :  
> : source information stored in metastore getting TSQL.  
> : ex> show sources; OR show source testsource;  

5. drop job JOB_NAME :  
> : removing job stored in metastore TSQL.  
> : ex> drop job testjob;  

6. drop stream STREAM_NAME :  
> : removing stream stored in metastore TSQL.  
> : ex> drop stream teststream;  

7. drop source SOURCE_NAME :  
> : removing source stored in metastore TSQL.  
> : ex> drop source testsource;  

8. kill job JOB_NAME :  
> : shutdown job in apache storm cluster TSQL.  
> : ex> kill job testjob;  
 
9. snapshot job JOB_NAME :  
> : display resultset job executed to TSQL.  
> : ex> snapshot job testjob;  

10. create stream STREAM_NAME (STREAM_COLUMN STRING|INTEGER|LONG|FLOAT|DOUBLE (PARTITION_KEY) (COMMENT), ...)  meta (TOPIC 'STREAM_QUEUE_CHANNEL_NAME') :  
> : create stream TSQL.  
> : ex> 

		create stream dmp_app_log ( 
			host STRING PARTITION_KEY 
			, path STRING PARTITION_KEY 
			, payload.message STRING  ) meta (TOPIC 'dmp_app_log');  

11. create source SOURCE_NAME 
> : create source TSQL.  
> : ex> 

		create source kafka meta (
			CATALOG 'KAFKA'
			, URL '127.0.0.1:2181,127.0.0.2:2181,127.0.0.3:2181,127.0.0.4:2181');
			
> : ex> 

		create source phoenix meta (
			CATALOG 'PHOENIX'
			, URL 'jdbc:phoenix:test-hbase-m1.com,test-hbase-m2.com,test-hbase-m3.com:2181'
			, DRIVER 'org.apache.phoenix.jdbc.PhoenixDriver');
			
> : ex> 

		create source rabbitmq meta (
			CATALOG 'RABBITMQ'
			, URL '127.0.0.1'
			, ID 'test'
			, PW 'testpw'
			, PORT '5672'
			, VHOST 'TEST_VHOST'); 
			
11. use NAME : 
> : other ink daemon use.
> : ex> use SA;

####DML TSQL :  

1. select  :  
> : esper's EPL  
> : ex>  

		select 
			DMP_LOG.host
			,DMP_LOG.path
			,DMP_LOG.payload.message
		from 
 			[dmp_app_log:kafka] as DMP_LOG 
		where 
			DMP_LOG.payload.message is not null;


2. insert/ upsert/ upsert increase / delete / update :  
> : generic sql syntax.  
> : ex>  

		upsert into [TEST_REPORT:phoenix](
			DT
			,MKRSEQ
			,SCORE
		) values( 
			[:DT]
			,[:MKRSEQ] 
			,[:SCORE] );  

3. lookup :  
> : lookup - generic sql select syntax.  
> : ex>  

		lookup 
			EXPOSELOG_MKR as MKRSEQ
			, MATCHLOG_ATP as AREATYPE
		from 
			[test_click:phoenix]
		where
			PAYLOAD_CTSA = '[:ACCOUNTID]' AND PAYLOAD_CTSU = '[:UNIQUE_ID]';  


#### SET TSQL :  

1. set JOB_NAME='TEXT' :  
> : launch storm topology job. at JOB_NAME name   

2. set WORKER_CNT='NUMERIC' :  
> : storm topology process cnt (default: 1) 

3. set SPOUT_THREAD_CNT='NUMERIC' :  
> : spout's thread cnt  (default: 1) 

4. set ESPER_THREAD_CNT='NUMERIC' :  
> : esper's thread cnt  (default: 1) 

5. set LOOKUP_THREAD_CNT='NUMERIC' :  
> : lookup's thread cnt  (default: 1)

6. set OUTPUT_THREAD_CNT='NUMERIC' :  
> : output's thread cnt  (default: 1)

7. set IS_DEBUG='Y' | 'N' :  
> : debug mode   (default: N)

8. set COMMIT_INTERVAL='NUMERIC' :  
> : output sql commit interval (default: 5)  


#EXAMPLE TSQL
ex> 


		set JOB_NAME='INK_TEST';
		set WORKER_CNT='14';
		set SPOUT_THREAD_CNT='9';
		set ESPER_THREAD_CNT='9';
		set LOOKUP_THREAD_CNT='9';
		set OUTPUT_THREAD_CNT='18';
		set COMMIT_INTERVAL='5';
		set STORM_MAXSPOUTPENDING_NUM='9';
		select 
			incom_date.substring(0, 10) as _DT
			,account_id as ACCOUNTID
			,(case when (indirect_unique_id <> null) then direct_unique_id else indirect_unique_id end) as UNIQUE_ID
			, dir_amount as DIRECTAMT
			, dir_cnt as DIRECTCNT
			, in_amount as INDIRECTAMT
			, in_cnt as INDIRECTCNT
		from 
			[test:rabbitmq];
			
		lookup 
			LOG_MKR as MKRSEQ
			, LOG_ATP as AREATYPE
		from 
			[test_click:phoenix]
		where
			PAYLOAD_CTSA = '[:ACCOUNTID]' AND PAYLOAD_CTSU = '[:UNIQUE_ID]';
		
		upsert into [TEST_REPORT:phoenix](
			DT
			,MKRSEQ
			,AREATYPE
			,DIRECTCNT
			,DIRECTAMT
			,INDIRECTCNT
			,INDIRECTAMT
		) 
		increase values( 
			[:_DT]
			,[:MKRSEQ] 
			,'[:AREATYPE]'
			,[:DIRECTCNT] 
			,[:DIRECTAMT] 
			,[:INDIRECTCNT] 
			,[:INDIRECTAMT] 
		);

#INK JDBC DRIVER EXAMPLE - SQuirrelSQL
: > Caution!!!! In order to use the INK JDBC driver from the bus kworeol, Squirrel in the ';' Others do not use the separator character set (ex. Tommy, ;;;;) should be set to perform a multi-query.
Squirrel program ';' Sueopda run in a multi-query because the query to be run separately to distinguish the characters. (Statement separator)  

![GitHub Logo](/screenshot3.png)
![GitHub Logo](/screenshot2.png)
![GitHub Logo](/screenshot8.png)
![GitHub Logo](/screenshot4.png)
![GitHub Logo](/screenshot5.png)
![GitHub Logo](/screenshot6.png)
![GitHub Logo](/screenshot7.png)
![GitHub Logo](/screenshot1.png)
