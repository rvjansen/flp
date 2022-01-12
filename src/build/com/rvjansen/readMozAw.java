/* Generated from 'readMozAw.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class readMozAw implements... 
 * <BR>
 * Created on: vr, 27, sep 2013 20:38:27 +0200
 */
public class readMozAw extends com.rvjansen.Bint{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("nm(X,\'");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("\').");private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(0);private static final java.lang.String $0="readMozAw.nrx";

/* properties static */
protected static com.rvjansen.KBClient client=setClient();
protected static netrexx.lang.Rexx lemma_type=setUUID(netrexx.lang.Rexx.toRexx("Lemma"));
protected static netrexx.lang.Rexx isclassifiedbylanguage=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'Lemma\'),nm(Y,\'Language Name\')."),new netrexx.lang.Rexx('Y'));
protected static netrexx.lang.Rexx isclassifiedbyPapiamentType=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'pap\'),nm(Y,\'Papiamento local variant\')."),new netrexx.lang.Rexx('Y'));

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readMozAw() throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{super();java.io.BufferedReader in;netrexx.lang.Rexx word_=null;java.util.ArrayList a=null;netrexx.lang.Rexx lemma_uuid=null;com.rvjansen.Fact f=null;

client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));

in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/moz_aw.txt")));
{$1:for(;;){
word_=netrexx.lang.Rexx.toRexx(in.readLine());
if (word_==null) break $1;
word_=word_.changestr(netrexx.lang.Rexx.toRexx("/P"),netrexx.lang.Rexx.toRexx(""));
a=client.request(($01.OpCc(null,word_)).OpCc(null,$02));
if (new netrexx.lang.Rexx(a.size()).OpEqS(null,$03)) {
lemma_uuid=netrexx.lang.Rexx.toRexx(this.newUUID());
// create the lemma
f=new com.rvjansen.Fact(); // the lemma object
f.setPred(this.ob_uuid);
f.setSubj(lemma_uuid);
f.setObj(lemma_type);
f.assertz((com.rvjansen.KBServerInterface)client);

f=new com.rvjansen.Fact(); // its name
f.setPred(this.nm_uuid);
f.setSubj(lemma_uuid);
f.setObj(word_);
f.assertz((com.rvjansen.KBServerInterface)client);

f=new com.rvjansen.Fact(); // the language
f.setPred(isclassifiedbylanguage);
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("3B60C790-22FF-11E3-80E8-E0F847277696"));
f.assertz((com.rvjansen.KBServerInterface)client);

// it is an Aruban Papiamento variant lemma
f=new com.rvjansen.Fact(); // 
f.setPred(isclassifiedbyPapiamentType);
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("3B6D98D0-22FF-11E3-80E8-E0F847277696"));
f.assertz((com.rvjansen.KBServerInterface)client);

// its source system
f=new com.rvjansen.Fact(); // 
f.setPred(netrexx.lang.Rexx.toRexx("39CE19A0-22FF-11E3-B3FD-E0F847277696")); // src system
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("6A35FE10-27A4-11E3-9474-E0F847277696")); // this
f.assertz((com.rvjansen.KBServerInterface)client);
} // if a
}}return;} // loop forever

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{
new com.rvjansen.readMozAw();return;}
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx setUUID(netrexx.lang.Rexx s){
{try{
return client.getIDForName(s);}
catch (java.rmi.RemoteException $2){
netrexx.lang.RexxIO.Say("setting UUID failed");
return netrexx.lang.Rexx.toRexx("");
}}}

@SuppressWarnings("unchecked")
public static com.rvjansen.KBClient setClient(){
return new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx query(netrexx.lang.Rexx s,netrexx.lang.Rexx atom){java.util.ArrayList a=null;netrexx.lang.Rexx rs=null;
{try{
a=client.request(s);
rs=(netrexx.lang.Rexx)(a.get(0));
return rs.getnode(atom).leaf;}
catch (java.rmi.RemoteException $3){
netrexx.lang.RexxIO.Say("querying knowledge base failed");
return netrexx.lang.Rexx.toRexx("");
}}}}
