/* Generated from 'srepl3.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Binary Comments Compact Decimal Java Logo Replace Strictcase Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * class srepl3 is the most recent incarnation of the commandline interface
 * to the KBServer server application, it enables Prolog queries to
 * the knowledgebase and some extra commands. It is stopped with "halt."
 */






//trace results
public class srepl3{private static final char[] $01={1,10,1,0,0};private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("halt.");private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx('=');private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx(";\000");private static final java.lang.String $0="srepl3.nrx";

/* properties public static */

public static java.lang.String ANSI_RESET="\u001B[0m";
public static java.lang.String ANSI_BLUE="\u001B[34m";
public static java.lang.String ANSI_RED="\u001B[31m";
public static java.lang.String ANSI_YELLOW="\u001B[33m";

/* properties static private */
// jline things
private static org.jline.reader.LineReader reader;
// end of jline things
private static long starttime=(long)0;
private static long stoptime=(long)0;
// instances = Hashtable()
// instance = int 0
private static com.rvjansen.srepl3.FilteringOutputStream filter;
private static java.io.PrintStream printStream;
private static java.lang.String ID=java.lang.Long.toHexString(java.lang.System.currentTimeMillis());
private static java.lang.String nl=java.lang.System.getProperty("line.separator");
private static java.lang.String initialDirectory=java.lang.System.getProperty("user.dir");
private static com.rvjansen.KBClient client;

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.IOException,java.rmi.RemoteException{netrexx.lang.Rexx arg;netrexx.lang.Rexx one=null;com.rvjansen.srepl3 ws;
init();
(new com.rvjansen.srepl3()).logo();
netrexx.lang.RexxIO.Say(ANSI_BLUE+"srepl 3.0 connecting");
arg=new netrexx.lang.Rexx(args);
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[1];netrexx.lang.RexxParse.parse(arg,$01,$1);one=$1[0];}
client=new com.rvjansen.KBClient(one);
netrexx.lang.RexxIO.Say(ANSI_RED+"ready.");
ws=new com.rvjansen.srepl3();
ws.start();return;}

@SuppressWarnings("unchecked")
public static void init() throws java.io.IOException{org.jline.terminal.Terminal terminal;java.lang.String historyFile;
filter=new com.rvjansen.srepl3.FilteringOutputStream((java.io.OutputStream)java.lang.System.out);
printStream=new java.io.PrintStream((java.io.OutputStream)filter);
java.lang.System.setOut(printStream);
terminal=org.jline.terminal.TerminalBuilder.builder().jansi(true).build();
historyFile="srepl3.history";
reader=org.jline.reader.LineReaderBuilder.builder().terminal(terminal).history((org.jline.reader.History)(new org.jline.reader.impl.history.DefaultHistory())).variable(org.jline.reader.LineReader.HISTORY_FILE,(java.lang.Object)historyFile).build();return;}

@SuppressWarnings("unchecked")
public void start() throws java.rmi.RemoteException{
{for(;;){
eval(read());
}}}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx read(){java.lang.String l;java.lang.String prompt=null;java.lang.String rightprompt=null;java.lang.String line;double duration;org.jline.reader.UserInterruptException ux=null;org.jline.reader.EndOfFileException eofx=null;
l="";


line=(java.lang.String)null;
stoptime=java.lang.System.nanoTime();
duration=((double)((stoptime-starttime)))/((double)1000000000); // seconds
rightprompt=netrexx.lang.Rexx.toString((netrexx.lang.Rexx.toRexx(ANSI_BLUE).OpCc(null,(new netrexx.lang.Rexx(duration)).left(new netrexx.lang.Rexx((byte)5)))).OpCc(null,netrexx.lang.Rexx.toRexx(netrexx.lang.Rexx.toRexx(" s").toString())));

prompt=ANSI_BLUE+new netrexx.lang.Rexx('?').toString();
{try{
line=netrexx.lang.Rexx.toString(new netrexx.lang.Rexx(this.reader.readLine(prompt+" ",rightprompt,(java.lang.Character)null,(java.lang.String)null)));}


catch (org.jline.reader.UserInterruptException $2){ux=$2;
;}
catch (org.jline.reader.EndOfFileException $3){eofx=$3;
return netrexx.lang.Rexx.toRexx("eof");
}} // do
return netrexx.lang.Rexx.toRexx(line);}

@SuppressWarnings("unchecked")
public void eval(netrexx.lang.Rexx line) throws java.rmi.RemoteException{java.util.ArrayList a=null;java.util.Iterator i=null;netrexx.lang.Rexx rs=null;netrexx.lang.Rexx j=null;
starttime=java.lang.System.nanoTime();
{/*select*/
if (line.OpEq(null,$02)){ // when halt., then halt.
netrexx.lang.RexxIO.Say("Exiting.");
{System.exit(0);return;}
}
// when line.pos('checkpoint.') then client.checkPoint()
else{ // execute the request
a=client.request(line);
if (a==null) {
netrexx.lang.RexxIO.Say("false.");
return;
}
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
{int $6=0;java.util.Vector $5=new java.util.Vector(100,0);synchronized(rs){java.util.Enumeration $4=rs.keys();for(;;){if(!$4.hasMoreElements())break;$5.addElement($4.nextElement());if(!rs.testnode((netrexx.lang.Rexx)($5.elementAt($6)))){$5.removeElementAt($6);continue;}$6++;}}j:for(;;){if(--$6<0)break;j=(netrexx.lang.Rexx)$5.elementAt($6);
netrexx.lang.RexxIO.Say(((j.OpCc(null,$03)).OpCc(null,rs.getnode(j).leaf)).OpCc(null,$04));
}}/*j*/
netrexx.lang.RexxIO.Say("");
}}
netrexx.lang.RexxIO.Say(a.size());}
}return;}


@SuppressWarnings("unchecked")
public void logo(){
netrexx.lang.RexxIO.Say(ANSI_YELLOW+"Prolog Workspace for Dictionary");return;}

public srepl3(){return;}static class FilteringOutputStream extends java.io.OutputStream{private final transient java.lang.String $0="srepl3.nrx";

protected java.util.Hashtable status;
protected java.io.OutputStream old;

@SuppressWarnings("unchecked")
public FilteringOutputStream(java.io.OutputStream previous){super();
old=previous;return;}

@SuppressWarnings("unchecked")
public synchronized void push(){java.lang.Object o;
if (status==null) 
status=new java.util.Hashtable();

o=status.get((java.lang.Object)(java.lang.Thread.currentThread()));
if (o==null) 
status.put((java.lang.Object)(java.lang.Thread.currentThread()),(java.lang.Object)(new java.lang.Integer(1)));
else 
status.put((java.lang.Object)(java.lang.Thread.currentThread()),(java.lang.Object)(new java.lang.Integer((((java.lang.Integer)o).intValue())+1)));return;}

@SuppressWarnings("unchecked")
public void pop(){java.lang.Integer o;
o=(java.lang.Integer)(status.get((java.lang.Object)(java.lang.Thread.currentThread())));
if ((o.intValue())==1) 
status.remove((java.lang.Object)(java.lang.Thread.currentThread()));
else 
status.put((java.lang.Object)(java.lang.Thread.currentThread()),(java.lang.Object)(new java.lang.Integer((o.intValue())-1)));return;}

@SuppressWarnings("unchecked")
public void write(int b) throws java.io.IOException{
if ((status==null)||((!(status.containsKey((java.lang.Object)(java.lang.Thread.currentThread())))))) 
old.write(b);return;}

@SuppressWarnings("unchecked")
public void flush() throws java.io.IOException{
if ((status==null)||((!(status.containsKey((java.lang.Object)(java.lang.Thread.currentThread())))))) 
old.flush();return;}}}

