/* Generated from 'KBClient.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import com.eaio.uuid.UUID;


/**
 * Class KBClient implements the (most of the times local) Client code
 * of the KBServer Knowledge Base Server. 
 */
public class KBClient implements com.rvjansen.KBServerInterface{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("localhost");private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx(":1199");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("rmi://");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("/KBServer");private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("cl(X,");private static final netrexx.lang.Rexx $08=netrexx.lang.Rexx.toRexx(").");private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("domain(X,");private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("nm(");private static final netrexx.lang.Rexx $011=netrexx.lang.Rexx.toRexx(",Y).");private static final netrexx.lang.Rexx $012=netrexx.lang.Rexx.toRexx("nm(X,");private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("desc(X,");private static final netrexx.lang.Rexx $014=new netrexx.lang.Rexx('\'');private static final java.lang.String $0="KBClient.nrx";

/* properties private */
private com.rvjansen.KBServerInterface KBServer;

/* properties constant */
protected static final long serialVersionUID=99192042373734L;
protected static final java.lang.String Y=new java.lang.String("Y");
protected static final java.lang.String X=new java.lang.String("X");
protected static final java.lang.String Z=new java.lang.String("Z");

/**
 * Method KBClient is a constructor that takes an IP address or URL
 * @param loc_ is a Rexx
 */
@SuppressWarnings("unchecked")
public KBClient(netrexx.lang.Rexx loc_){super();
this.connect(loc_);return;}

/**
 * Default constructor connects to the local KBServer
 */
@SuppressWarnings("unchecked")
public KBClient(){super();
this.connect(netrexx.lang.Rexx.toRexx("localhost"));return;}

/**
 * Method connect connects over RMI to the KBServer
 * of which the location is specified in the parameter 
 * @param loc_ is a Rexx
 */
@SuppressWarnings("unchecked")
public void connect(netrexx.lang.Rexx loc_){netrexx.lang.Rexx addr=null;netrexx.lang.Rexx serverAdr;netrexx.lang.Rexx urlstring;java.net.MalformedURLException e1=null;java.lang.Exception e4=null;
/* if the IP address is not specified, set it to localhost */
{try{
addr=netrexx.lang.Rexx.toRexx(java.net.InetAddress.getLocalHost().toString());
addr=addr.substr((addr.pos(new netrexx.lang.Rexx('/'))).OpAdd(null,$01));}
catch (java.net.UnknownHostException $1){
}}
serverAdr=addr;
if (loc_.OpEq(null,$02)) serverAdr=addr;
else serverAdr=loc_;
serverAdr=serverAdr.OpCc(null,$03);
urlstring=($04.OpCc(null,serverAdr)).OpCc(null,$05);
/* then connect to the KBServer or catch the exception(s) */
{try{
this.KBServer=(com.rvjansen.KBServerInterface)(java.rmi.Naming.lookup(netrexx.lang.Rexx.toString(urlstring)));} // server object

catch (java.net.MalformedURLException $2){e1=$2;
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("The URL is not valid:").OpCcblank(null,urlstring));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("MalformedURLException caught: \n").OpCcblank(null,netrexx.lang.Rexx.toRexx(e1.getMessage())));}
catch (java.rmi.RemoteException $3){
netrexx.lang.RexxIO.Say("Server not found.");
{System.exit(0);return;}}
catch (java.lang.Exception $4){e4=$4;
netrexx.lang.RexxIO.Say(((netrexx.lang.Rexx.toRexx("Exception (").OpCcblank(null,new netrexx.lang.Rexx(java.lang.String.valueOf(e4)))).OpCcblank(null,netrexx.lang.Rexx.toRexx(") caught: \n"))).OpCcblank(null,netrexx.lang.Rexx.toRexx(e4.getMessage())));
netrexx.lang.RexxIO.Say(e4.getMessage());
}}
return;}

/**
 * Method request fires off the request to the Knowledge Base Server
 * It returns an ArrayList that can be emtpy, or filled with
 * indexed strings that have key and value as returned by the prolog request  
 */
@SuppressWarnings("unchecked")
public com.rvjansen.KBResponse request(com.rvjansen.KBRequest s) throws java.rmi.RemoteException{
return this.KBServer.request(s);}

/**
 * convenience method to enable firing off a request from a Rexx textline
 * @param s is a Rexx that needs to be valid prolog 
 */
@SuppressWarnings("unchecked")
public java.util.ArrayList request(netrexx.lang.Rexx s) throws java.rmi.RemoteException{com.rvjansen.KBRequest r;com.rvjansen.KBResponse response;
r=new com.rvjansen.KBRequest(s);
response=this.request(r);
if (new netrexx.lang.Rexx(response.isResult()).OpEq(null,$06)) return (java.util.ArrayList)null;
return response.getResponse();}

/**
 * convenience method to enable firing off a request from a Rexx textline
 * @param s is a Rexx that needs to be valid prolog 
 */
@SuppressWarnings("unchecked")
public java.util.ArrayList query(netrexx.lang.Rexx s) throws java.rmi.RemoteException{com.rvjansen.KBRequest r;com.rvjansen.KBResponse response;
r=new com.rvjansen.KBRequest(s);
response=this.request(r);
if (new netrexx.lang.Rexx(response.isResult()).OpEq(null,$06)) return (java.util.ArrayList)null;
return response.getResponse();}

// method isCurrent(s=KBRequest) signals RemoteException returns boolean
//   return this.KBServer.isCurrent(s)

// method checkPoint(s) signals RemoteException, IOException
//   this.KBServer.checkPoint(s)

// method checkPoint() signals RemoteException, IOException
//   this.checkPoint(newUUID())


// method obviate(s=KBRequest) signals RemoteException returns boolean
//   return this.KBServer.obviate(s)

/**
 * Method getSchemesForTaxon looks which schemes classify a concept
 * by checking all partitioning relationships to it 
 * @param id is a Rexx that contains a valid quoted uuid
 * @return ArrayList containing Rexx 
 */
@SuppressWarnings("unchecked")
public java.util.ArrayList getSchemesForTaxon(netrexx.lang.Rexx id) throws java.rmi.RemoteException{java.util.ArrayList l;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx row=null;netrexx.lang.Rexx key=null;
id=checkID(id);
l=new java.util.ArrayList();
a=this.request(($07.OpCc(null,id)).OpCc(null,$08));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
row=(netrexx.lang.Rexx)(i.next());
{int $7=0;java.util.Vector $6=new java.util.Vector(100,0);synchronized(row){java.util.Enumeration $5=row.keys();for(;;){if(!$5.hasMoreElements())break;$6.addElement($5.nextElement());if(!row.testnode((netrexx.lang.Rexx)($6.elementAt($7)))){$6.removeElementAt($7);continue;}$7++;}}key:for(;;){if(--$7<0)break;key=(netrexx.lang.Rexx)$6.elementAt($7);
l.add((java.lang.Object)(row.getnode(key).leaf));
}}/*key*/
}}
return l;}

/**
 * Method getDomainsForScheme lists all domains for a scheme
 * (not ordered yet)
 * @param id is a Rexx
 * @return ArrayList containing indexed strings that have keys and values
 */
@SuppressWarnings("unchecked")
public java.util.ArrayList getDomainsForScheme(netrexx.lang.Rexx id) throws java.rmi.RemoteException{java.util.ArrayList l;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx row=null;netrexx.lang.Rexx key=null;
id=checkID(id);
l=new java.util.ArrayList();
a=this.request(($09.OpCc(null,id)).OpCc(null,$08));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
row=(netrexx.lang.Rexx)(i.next());
{int $10=0;java.util.Vector $9=new java.util.Vector(100,0);synchronized(row){java.util.Enumeration $8=row.keys();for(;;){if(!$8.hasMoreElements())break;$9.addElement($8.nextElement());if(!row.testnode((netrexx.lang.Rexx)($9.elementAt($10)))){$9.removeElementAt($10);continue;}$10++;}}key:for(;;){if(--$10<0)break;key=(netrexx.lang.Rexx)$9.elementAt($10);
l.add((java.lang.Object)(row.getnode(key).leaf));
}}/*key*/
}}
return l;}

/**
 * Method getNameForID returns the current name associated with a uuid
 * @param id is a Rexx
 */
@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getNameForID(netrexx.lang.Rexx id) throws java.rmi.RemoteException{java.util.ArrayList a;netrexx.lang.Rexx val;
id=checkID(id);
a=this.request(($010.OpCc(null,id)).OpCc(null,$011));
if (a==null) return netrexx.lang.Rexx.toRexx("");
if (new netrexx.lang.Rexx(a.size()).OpEq(null,$06)) netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("KBClient: no current Name for:"))).OpCcblank(null,id));
if (new netrexx.lang.Rexx(a.size()).OpGt(null,$01)) netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("KBClient: more then one current Name for:"))).OpCcblank(null,id));
val=(netrexx.lang.Rexx)(a.get(0));
return val.getnode(new netrexx.lang.Rexx('Y')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip();}

/**
 * Method getIDForName returns the current id associated with a name
 * @param id is a Rexx
 */
@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getIDForName(netrexx.lang.Rexx name_) throws java.rmi.RemoteException{java.util.ArrayList a;netrexx.lang.Rexx val;
name_=checkID(name_);
a=this.request(($012.OpCc(null,name_)).OpCc(null,$08));
if (a==null) return netrexx.lang.Rexx.toRexx("");
if (new netrexx.lang.Rexx(a.size()).OpEq(null,$06)) {
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("KBClient: no current ID for:"))).OpCcblank(null,name_));
return netrexx.lang.Rexx.toRexx("");
}
if (new netrexx.lang.Rexx(a.size()).OpGt(null,$01)) netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("KBClient: more then one current ID for:"))).OpCcblank(null,name_));
val=(netrexx.lang.Rexx)(a.get(0)); // there should be one current name for an object id
return val.getnode(new netrexx.lang.Rexx('X')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip();}

/**
 * Method getDescriptorsForID returns the set of descriptor relationships
 * to an object, as in the DESC/SCHEME dichotomy 
 * @param id is a Rexx
 */
@SuppressWarnings("unchecked")
public java.util.ArrayList getDescriptorsForID(netrexx.lang.Rexx id) throws java.rmi.RemoteException{java.util.ArrayList l;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx val=null;
id=checkID(id);
l=new java.util.ArrayList();
a=this.request(($013.OpCc(null,id)).OpCc(null,$08));
if (a==null) return l;
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
val=(netrexx.lang.Rexx)(i.next());
l.add((java.lang.Object)(val.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
return l;}

@SuppressWarnings("unchecked")
public java.util.TreeMap getIDDomainsForSchemeName(netrexx.lang.Rexx s) throws java.rmi.RemoteException{java.util.TreeMap t;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx val=null;
s=checkID(s);
t=new java.util.TreeMap();
a=this.request((netrexx.lang.Rexx.toRexx("domain(X,Y),nm(Y,\'").OpCc(null,s)).OpCc(null,netrexx.lang.Rexx.toRexx("\'),nm(X,Z).")));
if (a==null) return t;
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
val=(netrexx.lang.Rexx)(i.next());
t.put((java.lang.Object)(val.getnode(new netrexx.lang.Rexx('X')).leaf),(java.lang.Object)(val.getnode(new netrexx.lang.Rexx('Z')).leaf));
}}
return t;}

@SuppressWarnings("unchecked")
public java.util.TreeMap getNameDomainsForSchemeName(netrexx.lang.Rexx s) throws java.rmi.RemoteException{java.util.TreeMap t;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx val=null;
t=new java.util.TreeMap();
a=this.request((netrexx.lang.Rexx.toRexx("domain(X,Y),nm(Y,\'").OpCc(null,s)).OpCc(null,netrexx.lang.Rexx.toRexx("\'),nm(X,Z).")));
if (a==null) return t;
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
val=(netrexx.lang.Rexx)(i.next());
t.put((java.lang.Object)(val.getnode(new netrexx.lang.Rexx('Z')).leaf),(java.lang.Object)(val.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
return t;}

@SuppressWarnings("unchecked")
public java.util.TreeMap getShortNameDomainsForSchemeName(netrexx.lang.Rexx s) throws java.rmi.RemoteException{java.util.TreeMap t;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx val=null;
t=new java.util.TreeMap();
a=this.request((netrexx.lang.Rexx.toRexx("domain(X,Y),abbr(Y,\'").OpCc(null,s)).OpCc(null,netrexx.lang.Rexx.toRexx("\'),abbr(X,Z).")));
if (a==null) return t;
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
val=(netrexx.lang.Rexx)(i.next());
t.put((java.lang.Object)(val.getnode(new netrexx.lang.Rexx('Z')).leaf),(java.lang.Object)(val.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
return t;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx checkID(netrexx.lang.Rexx id){
if ((id.left(new netrexx.lang.Rexx((byte)1))).OpNotEq(null,$014)) id=($014.OpCc(null,id)).OpCc(null,$014);
return id;}

@SuppressWarnings("unchecked")
public static java.lang.String newUUID(){
return (new UUID()).toString().toUpperCase();}

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req) throws java.rmi.RemoteException{
return KBServer.isTrue(req);}}
