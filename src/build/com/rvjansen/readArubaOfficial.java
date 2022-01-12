/* Generated from 'readArubaOfficial.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class readArubaOfficial adds the offcial Aruba wordlist to the repository
 * <BR>
 * Created on: wo, 25, sep 2013 14:32:56 +0200
 */
public class readArubaOfficial extends com.rvjansen.Bint{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(0);private static final char[] $02={2,1,91,10,1,0,2,1,93,10,1,1,0};private static final char[] $03={1,10,1,0,0};private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("");private static final java.lang.String $0="readArubaOfficial.nrx";
/* properties private */
private java.util.TreeMap wordsMap=new java.util.TreeMap();
private java.util.TreeMap wordIDMap=new java.util.TreeMap();

/* properties static */
protected static com.rvjansen.KBClient client=setClient();
protected static netrexx.lang.Rexx lemma_type=setUUID(netrexx.lang.Rexx.toRexx("Lemma"));
protected static netrexx.lang.Rexx isclassifiedbylanguage=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'Lemma\'),nm(Y,\'Language Name\')."),new netrexx.lang.Rexx('Y'));
protected static netrexx.lang.Rexx isclassifiedbyPapiamentType=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'pap\'),nm(Y,\'Papiamento local variant\')."),new netrexx.lang.Rexx('Y'));
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readArubaOfficial() throws java.rmi.RemoteException,java.io.FileNotFoundException,java.io.IOException{super();netrexx.lang.Rexx scopeUUID;netrexx.lang.Rexx see;java.io.BufferedReader in;netrexx.lang.Rexx line=null;netrexx.lang.Rexx lemma=null;netrexx.lang.Rexx alternate=null;netrexx.lang.Rexx word_=null;java.util.Iterator i;netrexx.lang.Rexx lemma_uuid=null;com.rvjansen.Fact f=null;java.lang.Object alternate_=null;java.lang.String temp=null;

// define a scheme on Lemma for 'see lemma...'

scopeUUID=this.client.getIDForName(netrexx.lang.Rexx.toRexx("Dictionary"));
see=this.addDescriptor(lemma_type,netrexx.lang.Rexx.toRexx("see Lemma"),scopeUUID);

in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/aruba_official.txt")));
{$1:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $1;
if ((line.pos(new netrexx.lang.Rexx('['))).OpGt(null,$01)) {
{netrexx.lang.Rexx $2[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$02,$2);lemma=$2[0];alternate=$2[1];}
lemma=lemma.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
lemma=lemma.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
this.wordsMap.put((java.lang.Object)lemma,(java.lang.Object)alternate);
this.wordsMap.put((java.lang.Object)alternate,(java.lang.Object)lemma);
}
else {
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[1];netrexx.lang.RexxParse.parse(line,$03,$3);word_=$3[0];}
word_=word_.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
this.wordsMap.put((java.lang.Object)word_,(java.lang.Object)"");
}
}}

i=this.wordsMap.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
word_=(netrexx.lang.Rexx)(i.next());
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

// classified by Papiamento official spelling
f=new com.rvjansen.Fact(); // 
f.setPred(netrexx.lang.Rexx.toRexx("3B6E3510-22FF-11E3-80E8-E0F847277696")); // pap off sp
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("3B70CD20-22FF-11E3-80E8-E0F847277696")); // aruba off sp
f.assertz((com.rvjansen.KBServerInterface)client);

// its source system
f=new com.rvjansen.Fact(); // 
f.setPred(netrexx.lang.Rexx.toRexx("39CE19A0-22FF-11E3-B3FD-E0F847277696")); // src system
f.setSubj(lemma_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("BADF8F00-26BB-11E3-BECE-E0F847277696")); // this
f.assertz((com.rvjansen.KBServerInterface)client);

this.wordIDMap.put((java.lang.Object)(word_.toString()),(java.lang.Object)(lemma_uuid.toString()));
}} // loop while i

// now set the see ... relationship
i=this.wordsMap.keySet().iterator();
{$4:for(;;){if(!(i.hasNext()))break;
word_=(netrexx.lang.Rexx)(i.next());
alternate_=this.wordsMap.get((java.lang.Object)word_);
if (alternate_!="") {
f=new com.rvjansen.Fact(); // 
f.setPred(see); // the see ... Lemma predicate
f.setSubj(netrexx.lang.Rexx.toRexx((java.lang.String)(this.wordIDMap.get((java.lang.Object)(word_.toString())))));
temp=(java.lang.String)(this.wordIDMap.get((java.lang.Object)(alternate_.toString())));
if ((temp==null)||netrexx.lang.Rexx.toRexx(temp).OpEq(null,$04)) continue $4;
f.setObj(netrexx.lang.Rexx.toRexx((java.lang.String)(this.wordIDMap.get((java.lang.Object)(alternate_.toString())))));
f.assertz((com.rvjansen.KBServerInterface)client);
}
}}return;}


/**
 * Method setUUID is a static initializer
 * @param s is a Rexx
 */
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx setUUID(netrexx.lang.Rexx s){
{try{
return client.getIDForName(s);}
catch (java.rmi.RemoteException $5){
netrexx.lang.RexxIO.Say("setting UUID failed");
return netrexx.lang.Rexx.toRexx("");
}}}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException,java.io.FileNotFoundException,java.io.IOException{
new com.rvjansen.readArubaOfficial();return;}

@SuppressWarnings("unchecked")
public static com.rvjansen.KBClient setClient(){
return new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx query(netrexx.lang.Rexx s,netrexx.lang.Rexx atom){java.util.ArrayList a=null;netrexx.lang.Rexx rs=null;
{try{
a=client.request(s);
rs=(netrexx.lang.Rexx)(a.get(0));
return rs.getnode(atom).leaf;}
catch (java.rmi.RemoteException $6){
netrexx.lang.RexxIO.Say("querying knowledge base failed");
return netrexx.lang.Rexx.toRexx("");
}}}}

