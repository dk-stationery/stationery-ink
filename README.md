# stationery-ink
Distribute Sql base Streaming Aggregation Framework On Apache Storm

##Required System    
HBASE : 0.98.1-cdh5.1.3 above    
PHOENIX : 4.0.0-incubation (custom version) above    
STORM : 0.9.0.1 above    
REDIS    

##Ink features
1. SQL supported. (Tommy's SQL = TSQL)    
2. Esper integration.    
3. Launch Strom topology.    
4. Ink JDBC driver supported.    

##Ink Architecture
1. INK DAEMON : TSQL parsing and Execution DDL, DML query, generation storm topology base on TSQL, jdbc connector.  
2. INK JDBC DRIVER : INK's JDBC driver (type 2)  
3. INK DYNAMIC API : Rest api transported client to Aggerationed dataset by INK.  

![GitHub Logo](/ink.png)

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
> : ex> create stream dmp_app_log ( host STRING PARTITION_KEY , path STRING PARTITION_KEY , payload.message STRING  ) meta (TOPIC 'dmp_app_log');  

11. create source SOURCE_NAME 
> : create source TSQL.  
> : ex> create source kafka meta (CATALOG 'KAFKA', URL '127.0.0.1:2181,127.0.0.2:2181,127.0.0.3:2181,127.0.0.4:2181');  
> : ex> create source phoenix meta (CATALOG 'PHOENIX', URL 'jdbc:phoenix:test-hbase-m1.com,test-hbase-m2.com,test-hbase-m3.com:2181', DRIVER 'org.apache.phoenix.jdbc.PhoenixDriver');  
> : ex> create source rabbitmq meta (CATALOG 'RABBITMQ', URL '127.0.0.1', ID 'test', PW 'testpw', PORT '5672', VHOST 'TEST_VHOST');  

####DML TSQL :  

1. select  :  
> : esper's EPL  
> : ex>  select (case when DMP_LOG.payload.message = 'HBASE_VALIDATE' then
		sendNotiRealtimeReport('disable','noti_group_id','test-hbase-m2','est-m1,srchad-hbase-m2,test-hbase-m3', {'expose', 'bizcashprice', 'indirect_cnt'}, {'expose', 'settlement', 'cts'}, {'PETTER', 'ELIN', 'SUAREZ'}, DMP_LOG.host)
	else 
		sendNoti('bizdt.sa-batch.real','TEST REPORT MONITORING', 'ERROR', DMP_LOG.host,DMP_LOG.path,DMP_LOG.payload.message)
	end) as MM
from 
 	[dmp_app_log:kafka] as DMP_LOG 
where 
	isFiltered(DMP_LOG.payload.message, {'SQL*LOADER-281: WARNING:', 'ERROR ON TABLE', 'MYPEOPLE NOTIFICATION', 'Bad file de', 'retry.RetryInvocationHandler'}) = 'NO_FILTER'
	AND
	isFiltered(DMP_LOG.payload.message, {'HBASE_VALIDATE', 'tommy', '(stderr) SQL*Loader',  'Unexpected error', ' ERROR ', 'Exception', 'Job_Retry'}) = 'FILTER';}


2. insert/ upsert/ upsert increase / delete / update :  
> : generic sql syntax.  
> : ex>  upsert into [TEST_REPORT:phoenix](
	DT
	,MKRSEQ
	,SCORE
) 
values( 
	[:DT]
	,[:MKRSEQ] 
	,[:SCORE] );  

3. lookup :  
> : lookup - generic sql select syntax.  
> : ex>  lookup 
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

