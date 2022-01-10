/* Generated from 'readCurOfficial.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class readCurOfficial adds the offcial Cur wordlist to the repository
 * <BR>
 * Created on: wo, 25, sep 2013 14:32:56 +0200
 */
public class readCurOfficial extends com.rvjansen.Bint{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(0);private static final java.lang.String $0="readCurOfficial.nrx";
/* properties private */
private java.util.TreeMap wordsMap=new java.util.TreeMap();

/* properties static */
protected static com.rvjansen.KBClient client=setClient();
protected static netrexx.lang.Rexx lemma_type=setUUID(netrexx.lang.Rexx.toRexx("Lemma"));
protected static netrexx.lang.Rexx isclassifiedbylanguage=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'Lemma\'),nm(Y,\'Language Name\')."),new netrexx.lang.Rexx('Y'));
protected static netrexx.lang.Rexx isclassifiedbyPapiamentType=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'pap\'),nm(Y,\'Papiamento local variant\')."),new netrexx.lang.Rexx('Y'));
protected static java.util.TreeMap partsofspeech=setSchemeDomains("Parts of Speech");
protected static netrexx.lang.Rexx isclassifiedbypartsofspeech=query(netrexx.lang.Rexx.toRexx("cl(Y,_X),nm(_X,\'Lemma\'),nm(Y,\'Parts of Speech\')."),new netrexx.lang.Rexx('Y'));
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readCurOfficial() throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{super();java.io.BufferedReader in;netrexx.lang.Rexx line=null;netrexx.lang.Rexx word_=null;netrexx.lang.Rexx p_o_s=null;netrexx.lang.Rexx partOfSpeech=null;java.util.Iterator i;netrexx.lang.Rexx lemma_uuid=null;com.rvjansen.Fact f=null;
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/curacao_official.txt")));
{$1:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $1;
word_=line.word(new netrexx.lang.Rexx((byte)1));
word_=word_.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
p_o_s=netrexx.lang.Rexx.toRexx("");
{/*select*/
if ((line.wordpos(netrexx.lang.Rexx.toRexx("(v.)"))).OpGt(null,$01))p_o_s=netrexx.lang.Rexx.toRexx("verb");
else if ((line.wordpos(netrexx.lang.Rexx.toRexx("(atv.)"))).OpGt(null,$01))p_o_s=netrexx.lang.Rexx.toRexx("adverb");
else if ((line.wordpos(netrexx.lang.Rexx.toRexx("(ath.)"))).OpGt(null,$01))p_o_s=netrexx.lang.Rexx.toRexx("adjective");
else if ((line.wordpos(netrexx.lang.Rexx.toRexx("(int.)"))).OpGt(null,$01))p_o_s=netrexx.lang.Rexx.toRexx("interjection");
else if ((line.wordpos(netrexx.lang.Rexx.toRexx("(sus.)"))).OpGt(null,$01))p_o_s=netrexx.lang.Rexx.toRexx("noun");
else{
;}
} // select
partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)p_o_s));
this.wordsMap.put((java.lang.Object)word_,(java.lang.Object)partOfSpeech);
}}

i=this.wordsMap.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
word_=(netrexx.lang.Rexx)(i.next());
lemma_uuid=netrexx.lang.Rexx.toRexx(this.newUUID());
partOfSpeech=(netrexx.lang.Rexx)(this.wordsMap.get((java.lang.Object)word_));
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

f=new com.rvjansen.Fact(); // its part-of-speech type
f.setPred(isclassifiedbypartsofspeech);
f.setSubj(lemma_uuid);
f.setObj(partOfSpeech);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// it is an Curacao Papiamento variant lemma
f=new com.rvjansen.Fact(); // 
f.setPred(isclassifiedbyPapiamentType);
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("3B6D23A0-22FF-11E3-80E8-E0F847277696"));
f.assertz((com.rvjansen.KBServerInterface)client);

// classified by Papiamento official spelling
f=new com.rvjansen.Fact(); // 
f.setPred(netrexx.lang.Rexx.toRexx("3B6E3510-22FF-11E3-80E8-E0F847277696")); // pap off sp
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("3B6FBBB0-22FF-11E3-80E8-E0F847277696")); // curacao off sp
f.assertz((com.rvjansen.KBServerInterface)client);

// its source system
f=new com.rvjansen.Fact(); // 
f.setPred(netrexx.lang.Rexx.toRexx("39CE19A0-22FF-11E3-B3FD-E0F847277696")); // src system
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("265B9250-2771-11E3-9107-E0F847277696")); // this
f.assertz((com.rvjansen.KBServerInterface)client);

}}return;} // loop while i

/**
 * Method setUUID is a static initializer
 * @param s is a Rexx
 */
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx setUUID(netrexx.lang.Rexx s){
{try{
return client.getIDForName(s);}
catch (java.rmi.RemoteException $2){
netrexx.lang.RexxIO.Say("setting UUID failed");
return netrexx.lang.Rexx.toRexx("");
}}}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{
new com.rvjansen.readCurOfficial();return;}

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
}}}

@SuppressWarnings("unchecked")
public static java.util.TreeMap setSchemeDomains(java.lang.String s){
{try{
return client.getNameDomainsForSchemeName(netrexx.lang.Rexx.toRexx(s));}
catch (java.rmi.RemoteException $4){
netrexx.lang.RexxIO.Say("returning scheme domaines failed");
return new java.util.TreeMap();
}}}}

