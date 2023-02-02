/* Generated from 'parseNL.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

public class parseNL{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx('=');private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx(";\000");private static final char[] $03={2,20,60,76,101,109,109,97,32,119,114,105,116,116,101,110,70,111,114,109,61,34,2,1,34,10,1,0,0};private static final char[] $04={2,8,115,121,110,115,101,116,61,34,2,1,34,10,1,0,0};private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx("eng");private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("synset:");private static final netrexx.lang.Rexx $08=netrexx.lang.Rexx.toRexx("\').");private static final java.lang.String $0="parseNL.nrx";

@SuppressWarnings("unchecked")
public static void showResults(java.util.List a){java.util.Iterator i;netrexx.lang.Rexx rs=null;netrexx.lang.Rexx j=null;
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
{int $3=0;java.util.Vector $2=new java.util.Vector(100,0);synchronized(rs){java.util.Enumeration $1=rs.keys();for(;;){if(!$1.hasMoreElements())break;$2.addElement($1.nextElement());if(!rs.testnode((netrexx.lang.Rexx)($2.elementAt($3)))){$2.removeElementAt($3);continue;}$3++;}}j:for(;;){if(--$3<0)break;j=(netrexx.lang.Rexx)$2.elementAt($3);
netrexx.lang.RexxIO.Say(((j.OpCc(null,$01)).OpCc(null,rs.getnode(j).leaf)).OpCc(null,$02));
}}/*j*/
netrexx.lang.RexxIO.Say("");
}}
netrexx.lang.RexxIO.Say(a.size());return;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{com.rvjansen.KBClient client;java.io.BufferedReader in;netrexx.lang.Rexx line=null;netrexx.lang.Rexx lemma=null;netrexx.lang.Rexx synset=null;netrexx.lang.Rexx type=null;
client=new com.rvjansen.KBClient();
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources_raw/odwn_orbn_gwg-LMF_1.2.xml")));
{$4:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $4;
{netrexx.lang.Rexx $5[]=new netrexx.lang.Rexx[1];netrexx.lang.RexxParse.parse(line,$03,$5);lemma=$5[0];}
{netrexx.lang.Rexx $6[]=new netrexx.lang.Rexx[1];netrexx.lang.RexxParse.parse(line,$04,$6);synset=$6[0];}
if (lemma.OpNotEq(null,$05)) netrexx.lang.RexxIO.Say(lemma);
if (synset.OpNotEq(null,$05)) {
if ((synset.left(new netrexx.lang.Rexx((byte)3))).OpNotEq(null,$06)) continue $4;
type=synset.substr(new netrexx.lang.Rexx((byte)17),new netrexx.lang.Rexx((byte)1));
synset=synset.substr(new netrexx.lang.Rexx((byte)8),new netrexx.lang.Rexx((byte)8));
synset=(type.translate(netrexx.lang.Rexx.toRexx("1234"),netrexx.lang.Rexx.toRexx("nvar"))).OpCc(null,synset);
netrexx.lang.RexxIO.Say($07.OpCcblank(null,synset));
showResults((java.util.List)(client.query((netrexx.lang.Rexx.toRexx("synsetnumber(Y,\'").OpCc(null,synset)).OpCc(null,$08))));
}
}}return;}private parseNL(){return;}}
