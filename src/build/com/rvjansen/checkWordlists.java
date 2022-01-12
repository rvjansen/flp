/* Generated from 'checkWordlists.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
public class checkWordlists{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("nm(X,\'");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("\').");private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(0);private static final java.lang.String $0="checkWordlists.nrx";@SuppressWarnings("unchecked")
public static void main(java.lang.String $0s[]) throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{com.rvjansen.KBClient client;java.io.BufferedReader in;netrexx.lang.Rexx word_=null;java.util.ArrayList a=null;java.util.Iterator i=null;netrexx.lang.Rexx rs=null;netrexx.lang.Rexx j=null;client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));

in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/moz_aw.txt")));
{$1:for(;;){
word_=netrexx.lang.Rexx.toRexx(in.readLine());
if (word_==null) break $1;
word_=word_.changestr(netrexx.lang.Rexx.toRexx("/P"),netrexx.lang.Rexx.toRexx(""));
a=client.request(($01.OpCc(null,word_)).OpCc(null,$02));
if (new netrexx.lang.Rexx(a.size()).OpEqS(null,$03)) netrexx.lang.RexxIO.Say(word_.OpCcblank(null,netrexx.lang.Rexx.toRexx("not in repository")));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
{int $4=0;java.util.Vector $3=new java.util.Vector(100,0);synchronized(rs){java.util.Enumeration $2=rs.keys();for(;;){if(!$2.hasMoreElements())break;$3.addElement($2.nextElement());if(!rs.testnode((netrexx.lang.Rexx)($3.elementAt($4)))){$3.removeElementAt($4);continue;}$4++;}}j:for(;;){if(--$4<0)break;j=(netrexx.lang.Rexx)$3.elementAt($4);
// say rs[j]
}}/*j*/
}}
}}return;}private checkWordlists(){return;}}
