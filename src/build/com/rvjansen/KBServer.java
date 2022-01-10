/* Generated from 'KBServer.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import org.apache.log4j.PropertyConfigurator;import org.apache.log4j.Logger;import com.eaio.uuid.UUID;






public class KBServer extends java.rmi.server.UnicastRemoteObject implements com.rvjansen.KBServerInterface{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("written");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("consult(\'");private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("\').");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("loaded");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("Using:");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx("JVM");private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("NetRexx");private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx(":1199");private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("rmi://");private static final netrexx.lang.Rexx $011=netrexx.lang.Rexx.toRexx("/KBServer");private static final netrexx.lang.Rexx $012=netrexx.lang.Rexx.toRexx(") caught:");private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("Request");private static final netrexx.lang.Rexx $014=netrexx.lang.Rexx.toRexx("started");private static final char[] $015={2,8,97,115,115,101,114,116,122,40,2,1,40,10,1,0,2,1,44,10,1,1,2,2,41,46,10,1,2,0};private static final netrexx.lang.Rexx $016=new netrexx.lang.Rexx('.');private static final java.lang.String $0="KBServer.nrx";
/* properties private */
private com.rvjansen.DBAccess db;

/* properties constant */
protected static final long serialVersionUID=991920422323L;
protected static final org.apache.log4j.Logger logger_=Logger.getLogger(com.rvjansen.KBServer.class.getName()); // instantiate a logger called log4j.logger.KBserver
/**
 * Method KBserver constructs the Knowledge Base.
 * It first writes the facts.prolog file from persistent storage (here: dbms table)
 * Then it fires up the prolog engine by consulting the load.pl file
 * and checks for a result. After that it returns to main that will wait
 * for incoming requests over the RMI port.
 *
 * In relaxed mode, it can write out the prolog database to disk using the checkpoint() call,
 * while in production mode, it implements integrity by writing an update first to the dbms storage,
 * and only asserting after a succesful commit. When the subsequent assertion fails, the tuple is
 * deleted so the prolog database is matched. In production mode the startup has to be from a
 * serialized database table.       
 */
@SuppressWarnings("unchecked")
public KBServer() throws java.lang.ClassNotFoundException,java.io.IOException,java.lang.InterruptedException,java.rmi.RemoteException{super();com.rvjansen.TimeIt t;netrexx.lang.Rexx factsFileName;org.jpl7.Query q;
// load the prolog part including data and code
t=new com.rvjansen.TimeIt();
factsFileName=netrexx.lang.Rexx.toRexx("factsTest.pl");
db=com.rvjansen.DBAccess.getInstance();
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("writing predicates file")));
db.getPredicatesAndWrite(factsFileName);
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,$01)).OpCcblank(null,factsFileName));
java.lang.Thread.sleep(1000);
PropertyConfigurator.configure("log4j.properties");
logger_.info((java.lang.Object)("KBserver Constructing Repository: start load"));
// q = Query("consult('hbom-load.pl')")
// if q.hasSolution() then 
// else say "Problem in loading facts.pl with hbom-load.pl"

q=new org.jpl7.Query(netrexx.lang.Rexx.toString(($02.OpCc(null,factsFileName)).OpCc(null,$03)));
if (q.hasSolution()) netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,factsFileName)).OpCcblank(null,$04));
else netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Problem in loading").OpCcblank(null,factsFileName));

q=new org.jpl7.Query("consult(\'dynamics.prolog\').");
if (q.hasSolution()) netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("dynamics.prolog loaded")));
else netrexx.lang.RexxIO.Say("Problem in loading dynamics.prolog");

q=new org.jpl7.Query("consult(\'code.prolog\').");
if (q.hasSolution()) netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("code.prolog loaded")));
else netrexx.lang.RexxIO.Say("Problem in loading code.prolog.");

netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("Control is being given to KBServer.")));
logger_.info((java.lang.Object)(netrexx.lang.Rexx.toRexx("KBServer load took").OpCcblank(null,t.getDiff())));return;}


/**
 * Method main establishes the RMI server part of this application
 * and constructs the Knowledge Base. We have a non standard RMI port
 * (1199) because we might not be able to control the J2EE container.   
 * @param args is a String[]
 */
@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.lang.ClassNotFoundException,java.io.IOException,java.lang.InterruptedException,java.rmi.RemoteException{java.lang.Exception e=null;com.rvjansen.KBServer listener;netrexx.lang.Rexx addr=null;
netrexx.lang.RexxIO.Say("");
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("KBServer starting.")));
logger_.info((java.lang.Object)("KBServer starting."));
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,$05));
netrexx.lang.RexxIO.Say("");
netrexx.lang.RexxAddress.exec("/bin/sh","swipl --version",1);
netrexx.lang.RexxAddress.exec("/bin/sh","psql --version",1);
netrexx.lang.RexxIO.Say(($06.OpCcblank(null,netrexx.lang.Rexx.toRexx(java.lang.System.getProperty("java.runtime.version")))).OpCcblank(null,netrexx.lang.Rexx.toRexx(java.lang.System.getProperty("java.vendor"))));
netrexx.lang.RexxIO.Say($07.OpCcblank(null,(new org.netrexx.process.NrVersion()).getFullVersion()));
netrexx.lang.RexxIO.Say((new org.netrexx.process.NrVersion()).getPipesVersion());
netrexx.lang.RexxIO.Say("");
{try{
java.rmi.registry.LocateRegistry.createRegistry(1199);}
catch (java.lang.Exception $1){e=$1;
e.printStackTrace();
logger_.error((java.lang.Object)(e.getMessage()));
{System.exit(0);return;}
}}
listener=new com.rvjansen.KBServer();
{try{
addr=netrexx.lang.Rexx.toRexx(java.net.InetAddress.getLocalHost().toString());
addr=addr.substr((addr.pos(new netrexx.lang.Rexx('/'))).OpAdd(null,$08));}
catch (java.net.UnknownHostException $2){
addr=netrexx.lang.Rexx.toRexx("127.0.0.1");
}}
addr=addr.OpCc(null,$09);
{try{
java.rmi.Naming.rebind(netrexx.lang.Rexx.toString(($010.OpCc(null,addr)).OpCc(null,$011)),(java.rmi.Remote)listener); // bind Listener
logger_.info((java.lang.Object)("Control is being given to KBServer."));}
catch (java.lang.Exception $3){e=$3;
logger_.error((java.lang.Object)((netrexx.lang.Rexx.toRexx("Exception (").OpCcblank(null,new netrexx.lang.Rexx(java.lang.String.valueOf(e)))).OpCcblank(null,$012)));
logger_.error((java.lang.Object)(e.getMessage()));
}}

{for(;;){
java.lang.Thread.sleep(10000000); // keep the server alive
}}}

/**
 * Method request is the gateway to the clients. It receives a prolog query and
 * returns an Array of Rexx packaged in a KBResponse that comprises the result set 
 * @param s is a Rexx containing the query
 * @return ArrayList containing the resultset
 */
@SuppressWarnings("unchecked")
public synchronized com.rvjansen.KBResponse request(com.rvjansen.KBRequest s){java.util.ArrayList rs;org.jpl7.Query q=null;netrexx.lang.Rexx in=null;netrexx.lang.Rexx predicate=null;netrexx.lang.Rexx subject=null;netrexx.lang.Rexx object=null;java.sql.PreparedStatement istmt=null;netrexx.lang.Rexx row=null;java.util.Map r=null;java.util.Iterator i=null;java.lang.Object key=null;com.rvjansen.KBResponse response=null;
rs=new java.util.ArrayList();
{try{
q=new org.jpl7.Query(netrexx.lang.Rexx.toString(s.getRequest()));
logger_.trace((java.lang.Object)(($013.OpCcblank(null,s.getRequest())).OpCcblank(null,$014)));
if ((s.getRequest().pos(netrexx.lang.Rexx.toRexx("assertz"))).OpEq(null,$08)) 
{
in=s.getRequest();
{netrexx.lang.Rexx $4[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(in,$015,$4);predicate=$4[0];subject=$4[1];object=$4[2];}
object=object.OpCc(null,$016);
// do the database insert
istmt=db.prepareInsertStatement();
db.insertLine(istmt,predicate,subject,object);
db.closeInsertStatement(istmt);
// log the assert to the logfile
logger_.info((java.lang.Object)(s.getRequest()));
} // if do
if ((s.getRequest().pos(netrexx.lang.Rexx.toRexx("retract"))).OpEq(null,$08)) 
{
// in = s.getRequest()
// parse in predicate'('subject','object
logger_.info((java.lang.Object)(s.getRequest()));
}
{for(;;){if(!(q.hasNext()))break;
row=netrexx.lang.Rexx.toRexx("");
r=q.next();
i=r.keySet().iterator();
{for(;;){if(!(i.hasNext()))break; // we need to do this because jpl.Atom is not serializable
key=i.next();
row.getnode(netrexx.lang.Rexx.toRexx(key.toString())).leaf=netrexx.lang.Rexx.toRexx(r.get(key).toString());
}}
rs.add((java.lang.Object)row);
}} // loop while q
q.close();
response=new com.rvjansen.KBResponse(rs);
logger_.trace((java.lang.Object)("Request ended"));
return response;}
catch (org.jpl7.PrologException $5){
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Error: an exception occurred for ").OpCcblank(null,new netrexx.lang.Rexx(java.lang.String.valueOf(s))));
q.close();
logger_.trace((java.lang.Object)("Request ended"));
return new com.rvjansen.KBResponse();
}}} // do


/**
 * method newUUID produces a new time-based uuid
 */
@SuppressWarnings("unchecked")
public static java.lang.String newUUID(){
return (new UUID()).toString().toUpperCase();}

/**
 * method checkPoint writes out the current set of facts and then adds in the single quotes that
 * the engine seems to lose along the way
 * @param time_s is a timestamp to be infixed into the saved checkpoint file.
 */
// method checkPoint(time_s)
//   do
//     q = Query("tell('facts.pl').")
//     loop while q.hasNext()
//     	r = q.nextsolution()
//     	say r
//     end
//     q = Query("listing.")
//     loop while q.hasNext()
//     	r = q.nextsolution()
//     	say r
//     end
//     q = Query('told.')
//     loop while q.hasNext()
//     	r = q.nextsolution()
//     	say r
//     end
//     catch PrologException
//     say 'exception in checkpoint'
//   end -- do

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req){org.jpl7.Query q=null;
{try{
q=new org.jpl7.Query(netrexx.lang.Rexx.toString(req));
return q.hasSolution();}
catch (org.jpl7.PrologException $6){
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Error: an exception occurred for ").OpCcblank(null,req));
q.close();
}} // do
return false;}}
