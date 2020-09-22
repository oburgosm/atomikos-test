= Atomikos test

This branch test a XA transaction with one XA datasource and a Non-XA datsource.
This feature is similar to "Last Resource Gambit" as explained link:https://www.atomikos.com/Documentation/NonXaDataSource[here]

For this purpose,, we van:

* Launch application with `mvn spring-boot:run`
* Access to `http:localhost:8080/swagger-ui/`
* Execute endpoint `/product/{name1}/{name2}`

Then application will fail. We see next logs:

----
--- spring-boot-maven-plugin:2.2.9.RELEASE:run (default-cli) @ atomikos-test ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.9.RELEASE)

2020-09-22 11:43:45.355 DEBUG 7732 --- [           main] com.atomikos.logging.LoggerFactory       : Using Slf4J for logging.
2020-09-22 11:43:45.432  INFO 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds2-xa: init...
2020-09-22 11:43:45.434  INFO 7732 --- [           main] c.atomikos.jdbc.AtomikosDataSourceBean   : ds2-xa: initializing with [ xaDataSourceClassName=org.h2.jdbcx.JdbcDataSource, uniqueResourceName=ds2-xa, maxPoolSize=5, minPoolSize=5, borrowConnectionTimeout=30, maxIdleTime=60, reapTimeout=0, maintenanceInterval=60, initConnectionSql=null, testQuery=null, xaProperties=[URL=jdbc:h2:mem:db2;MODE=Oracle;IGNORECASE=TRUE;DB_CLOSE_ON_EXIT=TRUE;,user=test,password=test], loginTimeout=0, maxLifetime=0, startNewXaBranchFlags=0, propagateJtaTimeoutToXaResource=true, joinExistingXaBranchFlags=2097152, resumeExistingXaBranchFlags=134217728, suspendExistingXaBranchFlags=33554432, endExistingXaBranchFlags=67108864, useDriverBasedConnectionValidation=true, concurrentConnectionValidation=true, supportsTmJoin=true, connectionValidationInterval=0, localTransactionMode=true]
2020-09-22 11:43:45.526  WARN 7732 --- [           main] com.atomikos.publish.EventPublisher      : XAResourceDetectedEvent [uniqueResourceName=ds2-xa, xaClassName=org.h2.jdbcx.JdbcDataSource, resourceType=JDBC]
2020-09-22 11:43:46.057  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : Loaded jar:file:/C:/work/M2_REPO_INDITEX/com/atomikos/transactions/5.0.96/transactions-5.0.96.jar!/transactions-defaults.properties
2020-09-22 11:43:46.066  WARN 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : Thanks for using Atomikos! This installation is not registered yet. 
REGISTER FOR FREE at http://www.atomikos.com/Main/RegisterYourDownload and receive:
- tips & advice 
- working demos 
- access to the full documentation 
- special exclusive bonus offers not available to others 
- everything you need to get the most out of using Atomikos!
Thanks for using Atomikos! This installation is not registered yet. 
REGISTER FOR FREE at http://www.atomikos.com/Main/RegisterYourDownload and receive:
- tips & advice 
- working demos 
- access to the full documentation 
- special exclusive bonus offers not available to others 
- everything you need to get the most out of using Atomikos!
2020-09-22 11:43:46.076  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING core version: 5.0.96
2020-09-22 11:43:46.076  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.tm_unique_name = 192.168.94.239.tm
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.default_jta_timeout = 10000
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.http.filter_requests = true
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.serial_jta_transactions = true
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.oltp_retry_interval = 10000
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.checkpoint_interval = 500
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.force_shutdown_on_vm_exit = false
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.monitoring.logs.format = key-value
2020-09-22 11:43:46.077  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.maven.username = unknown
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.enable_logging = true
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.max_timeout = 300000
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.logcloud_datasource_name = logCloudDS
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.oltp_max_retries = 5
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.licensed = false
2020-09-22 11:43:46.078  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.log_base_dir = C:\TMP\atomikos-test\transaction-logs
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.allow_subtransactions = true
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.log_base_name = tmlog
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.default_max_wait_time_on_shutdown = 9223372036854775807
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.jvm_id = 7732@LES008454
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.monitoring.interval_seconds = 60
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.forget_orphaned_log_entries_delay = 86400000
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.throw_on_heuristic = false
2020-09-22 11:43:46.079  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.threaded_2pc = false
2020-09-22 11:43:46.080  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.recovery_delay = 10000
2020-09-22 11:43:46.080  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : USING: com.atomikos.icatch.max_actives = 50
2020-09-22 11:43:46.083  INFO 7732 --- [           main] c.a.icatch.provider.imp.AssemblerImp     : Using default (local) logging and recovery...
2020-09-22 11:43:46.090 DEBUG 7732 --- [           main] c.a.recovery.fs.FileSystemRepository     : baseDir C:\TMP\atomikos-test\transaction-logs
2020-09-22 11:43:46.090 DEBUG 7732 --- [           main] c.a.recovery.fs.FileSystemRepository     : baseName tmlog
2020-09-22 11:43:46.092 DEBUG 7732 --- [           main] c.a.recovery.fs.FileSystemRepository     : LogFileLock com.atomikos.persistence.imp.LogFileLock@4c0cb4dc
2020-09-22 11:43:47.600 DEBUG 7732 --- [           main] c.a.jdbc.AtomikosNonXADataSourceBean     : ds1-nonxa: getConnection()...
2020-09-22 11:43:47.600  INFO 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds1-nonxa: init...
2020-09-22 11:43:47.601  INFO 7732 --- [           main] c.a.jdbc.AtomikosNonXADataSourceBean     : ds1-nonxa: initializing with [ uniqueResourceName=ds1-nonxa, maxPoolSize=5, minPoolSize=5, borrowConnectionTimeout=30, maxIdleTime=60, reapTimeout=0, maintenanceInterval=60, testQuery=null, driverClassName=org.h2.Driver, user=test, url=jdbc:h2:mem:db1;MODE=Oracle;IGNORECASE=TRUE;DB_CLOSE_ON_EXIT=TRUE; loginTimeout=0, localTransactionMode=true, ignoreJtaTransactions=false]
2020-09-22 11:43:47.618 DEBUG 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds1-nonxa: getConnection()...
2020-09-22 11:43:47.786 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : jtaUnawareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied close
2020-09-22 11:43:48.866 DEBUG 7732 --- [           main] c.a.jdbc.AtomikosNonXADataSourceBean     : ds1-nonxa: getConnection()...
2020-09-22 11:43:48.866 DEBUG 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds1-nonxa: getConnection()...
2020-09-22 11:43:48.866 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : jtaUnawareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied setAutoCommit(true)
2020-09-22 11:43:48.873 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : jtaUnawareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied createStatement
2020-09-22 11:43:48.883 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance stat1: calling proxied close
2020-09-22 11:43:48.995 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : jtaUnawareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied createStatement
2020-09-22 11:43:49.032 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance stat2: calling proxied close
2020-09-22 11:43:49.033 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : jtaUnawareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied close
2020-09-22 11:43:49.126 DEBUG 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds2-xa: getConnection()...
2020-09-22 11:43:49.149 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied close
2020-09-22 11:43:49.221 DEBUG 7732 --- [           main] c.a.j.internal.AbstractDataSourceBean    : ds2-xa: getConnection()...
2020-09-22 11:43:49.222 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied setAutoCommit(true)
2020-09-22 11:43:49.222 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied createStatement
2020-09-22 11:43:49.223 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance stat4: calling proxied close
2020-09-22 11:43:49.278 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied createStatement
2020-09-22 11:43:49.283 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance stat5: calling proxied close
2020-09-22 11:43:49.283 DEBUG 7732 --- [           main] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied close
2020-09-22 11:43:56.616  INFO 7732 --- [     Atomikos:2] c.a.d.xa.XATransactionalResource         : ds2-xa: refreshed XAResource
2020-09-22 11:44:10.625 DEBUG 7732 --- [nio-8080-exec-1] c.a.i.i.CompositeTransactionManagerImp   : createCompositeTransaction ( 10000 ): created new ROOT transaction with id 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.656 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.CompositeTransactionImp   : registerSynchronization ( com.atomikos.icatch.jta.Sync2Sync@16ed252e ) for transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.703 DEBUG 7732 --- [nio-8080-exec-1] c.a.jdbc.AtomikosNonXADataSourceBean     : ds1-nonxa: getConnection()...
2020-09-22 11:44:10.703 DEBUG 7732 --- [nio-8080-exec-1] c.a.j.internal.AbstractDataSourceBean    : ds1-nonxa: getConnection()...
2020-09-22 11:44:10.705 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : jtaAwareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied prepareStatement(insert into Product (id, name) values (null, ?),1)
2020-09-22 11:44:10.707 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.TransactionStateHandler   : addParticipant ( com.atomikos.jdbc.AtomikosNonXADataSourceBean 'ds1-nonxa' [NB: this resource does not support two-phase commit unless configured as readOnly] ) for transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.724 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance prep10: insert into Product (id, name) values (null, ?) {1: '1'}: calling proxied close
2020-09-22 11:44:10.724 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : jtaAwareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied isClosed
2020-09-22 11:44:10.724 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : jtaAwareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: calling proxied close
2020-09-22 11:44:10.727 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.CompositeTransactionImp   : registerSynchronization ( com.atomikos.icatch.jta.Sync2Sync@19166e30 ) for transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.728 DEBUG 7732 --- [nio-8080-exec-1] c.a.j.internal.AbstractDataSourceBean    : ds2-xa: getConnection()...
2020-09-22 11:44:10.729 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied prepareStatement(insert into Product (id, name) values (null, ?),1)
2020-09-22 11:44:10.734 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.TransactionStateHandler   : addParticipant ( XAResourceTransaction: xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31 ) for transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.734 DEBUG 7732 --- [nio-8080-exec-1] c.a.datasource.xa.XAResourceTransaction  : XAResourceTransaction: xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31: about to switch to XAResource xads0: conn0: url=jdbc:h2:mem:db2 user=TEST
2020-09-22 11:44:10.734 DEBUG 7732 --- [nio-8080-exec-1] c.a.datasource.xa.XAResourceTransaction  : XAResource.start ( xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31 , XAResource.TMNOFLAGS ) on resource ds2-xa represented by XAResource instance xads0: conn0: url=jdbc:h2:mem:db2 user=TEST
2020-09-22 11:44:10.735 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.CompositeTransactionImp   : registerSynchronization ( com.atomikos.jdbc.internal.AtomikosJdbcConnectionProxy$JdbcRequeueSynchronization@750c3c1d ) for transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.737 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : atomikosJdbcStatementProxy for vendor instance prep11: insert into Product (id, name) values (null, ?) {1: '2'}: calling proxied close
2020-09-22 11:44:10.737 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied isClosed
2020-09-22 11:44:10.737 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.util.DynamicProxySupport    : atomikosJdbcConnectionProxy (state = sessionHandleState (1 context(s), isTerminated = false) for resource ds2-xa) for vendor instance conn1: url=jdbc:h2:mem:db2 user=TEST: calling proxied close
2020-09-22 11:44:10.738 DEBUG 7732 --- [nio-8080-exec-1] c.a.datasource.xa.XAResourceTransaction  : XAResource.end ( xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31 , XAResource.TMSUCCESS ) on resource ds2-xa represented by XAResource instance xads0: conn0: url=jdbc:h2:mem:db2 user=TEST
2020-09-22 11:44:10.746 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.icatch.jta.Sync2Sync        : beforeCompletion() called on Synchronization: org.hibernate.resource.transaction.backend.jta.internal.synchronization.RegisteredSynchronization@5c624257
2020-09-22 11:44:10.746 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.icatch.jta.Sync2Sync        : beforeCompletion() called on Synchronization: org.hibernate.resource.transaction.backend.jta.internal.synchronization.RegisteredSynchronization@20c2f8e3
2020-09-22 11:44:10.747 DEBUG 7732 --- [nio-8080-exec-1] c.a.icatch.imp.CompositeTransactionImp   : commit() done (by application) of transaction 83c4f43a-b395-4d08-9191-43bff2ebc1dd
2020-09-22 11:44:10.748  WARN 7732 --- [nio-8080-exec-1] c.a.j.internal.AtomikosNonXAParticipant  : com.atomikos.jdbc.AtomikosNonXADataSourceBean 'ds1-nonxa' [NB: this resource does not support two-phase commit unless configured as readOnly]
2020-09-22 11:44:10.750 DEBUG 7732 --- [nio-8080-exec-1] c.a.datasource.xa.XAResourceTransaction  : XAResource.prepare ( xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31 ) returning OK on resource ds2-xa represented by XAResource instance xads0: conn0: url=jdbc:h2:mem:db2 user=TEST
2020-09-22 11:44:10.751 DEBUG 7732 --- [nio-8080-exec-1] c.a.j.i.JtaAwareThreadLocalConnection    : jtaAwareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: transaction aborting - pessimistically closing all pending statements to avoid autoCommit after timeout
2020-09-22 11:44:10.751 DEBUG 7732 --- [nio-8080-exec-1] c.a.j.i.JtaAwareThreadLocalConnection    : jtaAwareThreadLocalConnection (isAvailable = false)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: rolling back on connection...
2020-09-22 11:44:10.752 DEBUG 7732 --- [nio-8080-exec-1] c.a.j.i.JtaAwareThreadLocalConnection    : jtaAwareThreadLocalConnection (isAvailable = true)  for vendor instance conn10: url=jdbc:h2:mem:db1 user=TEST: resetting autoCommit to true
2020-09-22 11:44:10.752 DEBUG 7732 --- [nio-8080-exec-1] c.a.datasource.xa.XAResourceTransaction  : XAResource.rollback ( xid://38336334663433612D623339352D346430382D393139312D343362666632656263316464:3139322E3136382E39342E3233392E746D31 ) on resource ds2-xa represented by XAResource instance xads0: conn0: url=jdbc:h2:mem:db2 user=TEST
2020-09-22 11:44:10.753 DEBUG 7732 --- [nio-8080-exec-1] c.atomikos.recovery.fs.CachedRepository  : Logging: 83c4f43a-b395-4d08-9191-43bff2ebc1dd|TERMINATED|1600767860653|192.168.94.239.tm|

2020-09-22 11:44:10.755 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.icatch.jta.Sync2Sync        : afterCompletion ( STATUS_ROLLEDBACK ) called  on Synchronization: org.hibernate.resource.transaction.backend.jta.internal.synchronization.RegisteredSynchronization@20c2f8e3
2020-09-22 11:44:10.755 DEBUG 7732 --- [nio-8080-exec-1] com.atomikos.icatch.jta.Sync2Sync        : afterCompletion ( STATUS_ROLLEDBACK ) called  on Synchronization: org.hibernate.resource.transaction.backend.jta.internal.synchronization.RegisteredSynchronization@5c624257
2020-09-22 11:44:10.763 ERROR 7732 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.transaction.UnexpectedRollbackException: JTA transaction unexpectedly rolled back (maybe due to a timeout); nested exception is javax.transaction.RollbackException: Prepare failed because one or more resources refused to commit. This transaction has been rolled back instead. The root cause could be either:
1. inability to reach the resource, or
2. a resource-internal cause that we can’t inspect.
Please check the logs for prior errors / warnings that may provide more information.] with root cause

com.atomikos.icatch.RollbackException: Prepare failed because one or more resources refused to commit. This transaction has been rolled back instead. The root cause could be either:
1. inability to reach the resource, or
2. a resource-internal cause that we can’t inspect.
Please check the logs for prior errors / warnings that may provide more information.
	at com.atomikos.icatch.imp.ActiveStateHandler.prepare(ActiveStateHandler.java:215) ~[transactions-5.0.96.jar:na]
	at com.atomikos.icatch.imp.CoordinatorImp.prepare(CoordinatorImp.java:539) ~[transactions-5.0.96.jar:na]
	at com.atomikos.icatch.imp.CoordinatorImp.terminate(CoordinatorImp.java:709) ~[transactions-5.0.96.jar:na]
	at com.atomikos.icatch.imp.CompositeTransactionImp.commit(CompositeTransactionImp.java:279) ~[transactions-5.0.96.jar:na]
	at com.atomikos.icatch.jta.TransactionImp.commit(TransactionImp.java:168) ~[transactions-jta-5.0.96.jar:na]
	at com.atomikos.icatch.jta.TransactionManagerImp.commit(TransactionManagerImp.java:428) ~[transactions-jta-5.0.96.jar:na]
	at com.atomikos.icatch.jta.UserTransactionManager.commit(UserTransactionManager.java:172) ~[transactions-jta-5.0.96.jar:na]
	at org.springframework.transaction.jta.JtaTransactionManager.doCommit(JtaTransactionManager.java:1035) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.processCommit(AbstractPlatformTransactionManager.java:743) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:711) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.commitTransactionAfterReturning(TransactionAspectSupport.java:633) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:386) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:118) ~[spring-tx-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749) ~[spring-aop-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691) ~[spring-aop-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at com.bracso.test.atomikos.service.ProductController$$EnhancerBySpringCGLIB$$e1b23bf3.insert2Products(<generated>) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:105) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:878) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:792) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:626) ~[tomcat-embed-core-9.0.37.jar:4.0.FR]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:733) ~[tomcat-embed-core-9.0.37.jar:4.0.FR]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:373) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1589) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628) ~[na:na]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
----
