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

##Example
