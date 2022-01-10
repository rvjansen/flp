/* Generated from 'Lemma.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class Lemma implements a Lemma, the atomic unit of a Dictionary
 * <BR>
 * Created on: di, 17, sep 2013 18:30:40 +0200
 */
public class Lemma extends com.rvjansen.Bint implements java.lang.Comparable{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx('n');private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx('a');private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx('v');private static final netrexx.lang.Rexx $04=new netrexx.lang.Rexx('r');private static final netrexx.lang.Rexx $05=new netrexx.lang.Rexx('s');private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx(1);private static final java.lang.String $0="Lemma.nrx";

/* properties indirect */
private netrexx.lang.Rexx chars;
private netrexx.lang.Rexx lemma_uuid;
private netrexx.lang.Rexx synset;

/* properties private */
private netrexx.lang.Rexx language;
private netrexx.lang.Rexx partOfSpeech;

/* properties static */
protected static com.rvjansen.KBClient client=setClient();
protected static java.util.TreeMap languages=setSchemeDomains("Language Name");
protected static java.util.TreeMap partsofspeech=setSchemeDomains("Parts of Speech");
protected static netrexx.lang.Rexx synsetnumber=setUUID(netrexx.lang.Rexx.toRexx("synset number"));
protected static netrexx.lang.Rexx lemma_type=setUUID(netrexx.lang.Rexx.toRexx("Lemma"));
protected static netrexx.lang.Rexx isclassifiedbylanguage=query(netrexx.lang.Rexx.toRexx("cl(Y,X),nm(X,\'Lemma\'),nm(Y,\'Language Name\')."),new netrexx.lang.Rexx('Y'));
protected static netrexx.lang.Rexx isclassifiedbypartsofspeech=query(netrexx.lang.Rexx.toRexx("cl(Y,_X),nm(_X,\'Lemma\'),nm(Y,\'Parts of Speech\')."),new netrexx.lang.Rexx('Y'));

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public Lemma(){super();return;}

@SuppressWarnings("unchecked")
public static com.rvjansen.KBClient setClient(){
return new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx query(netrexx.lang.Rexx s,netrexx.lang.Rexx atom){java.util.ArrayList a=null;netrexx.lang.Rexx rs=null;
{try{
a=client.request(s);
rs=(netrexx.lang.Rexx)(a.get(0));
return rs.getnode(atom).leaf;}
catch (java.rmi.RemoteException $1){
netrexx.lang.RexxIO.Say("querying knowledge base failed");
return netrexx.lang.Rexx.toRexx("");
}}}
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
public static java.util.TreeMap setSchemeDomains(java.lang.String s){
{try{
return client.getNameDomainsForSchemeName(netrexx.lang.Rexx.toRexx(s));}
catch (java.rmi.RemoteException $3){
netrexx.lang.RexxIO.Say("returning scheme domaines failed");
return new java.util.TreeMap();
}}}

@SuppressWarnings("unchecked")
public void setPartOfSpeech(netrexx.lang.Rexx s){
{/*select*/
if (s.OpEq(null,$01))this.partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)(netrexx.lang.Rexx.toRexx("noun"))));
else if (s.OpEq(null,$02))this.partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)(netrexx.lang.Rexx.toRexx("adjective"))));
else if (s.OpEq(null,$03))this.partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)(netrexx.lang.Rexx.toRexx("verb"))));
else if (s.OpEq(null,$04))this.partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)(netrexx.lang.Rexx.toRexx("adverb"))));
else if (s.OpEq(null,$05))this.partOfSpeech=(netrexx.lang.Rexx)(partsofspeech.get((java.lang.Object)(netrexx.lang.Rexx.toRexx("adjective")))); // adjective satellite
else{
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("could not identify part-of-speech").OpCcblank(null,s));}
}return;}

@SuppressWarnings("unchecked")
public void setLanguage(netrexx.lang.Rexx s){
this.language=(netrexx.lang.Rexx)(languages.get((java.lang.Object)s));
if (this.language==null) netrexx.lang.RexxIO.Say("language lookup failed");return;}

@SuppressWarnings("unchecked")
public int compareTo(java.lang.Object l){
{/*select*/
if ((((com.rvjansen.Lemma)l).getChars()).OpGt(null,this.getChars()))return 1;
else if ((((com.rvjansen.Lemma)l).getChars()).OpLt(null,this.getChars()))return $06.OpMinus(null).toint();
else{
return 0;}
}}

@SuppressWarnings("unchecked")
public void persist() throws java.rmi.RemoteException{com.rvjansen.Fact f;
f=new com.rvjansen.Fact(); // the lemma object
f.setPred(this.ob_uuid);
f.setSubj(lemma_uuid);
f.setObj(lemma_type);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // its name
f.setPred(this.nm_uuid);
f.setSubj(lemma_uuid);
f.setObj(chars);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // the language
f.setPred(isclassifiedbylanguage);
f.setSubj(lemma_uuid);
f.setObj(language);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // its part-of-speech type
f.setPred(isclassifiedbypartsofspeech);
f.setSubj(lemma_uuid);
f.setObj(partOfSpeech);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // its synset
f.setPred(synsetnumber);
f.setSubj(lemma_uuid);
f.setObj(synset);
f.assertz((com.rvjansen.KBServerInterface)this.client);return;}

@SuppressWarnings("unchecked")
public void write(java.io.PrintWriter of){com.rvjansen.Fact f;
f=new com.rvjansen.Fact(); // the lemma object
f.setPred(this.ob_uuid);
f.setSubj(lemma_uuid);
f.setObj(lemma_type);
f.write(of);

f=new com.rvjansen.Fact(); // its name
f.setPred(this.nm_uuid);
f.setSubj(lemma_uuid);
f.setObj(chars);
f.write(of);

f=new com.rvjansen.Fact(); // the language
f.setPred(isclassifiedbylanguage);
f.setSubj(lemma_uuid);
f.setObj(language);
f.write(of);

f=new com.rvjansen.Fact(); // its part-of-speech type
f.setPred(isclassifiedbypartsofspeech);
f.setSubj(lemma_uuid);
f.setObj(partOfSpeech);
f.write(of);

f=new com.rvjansen.Fact(); // its synset
f.setPred(synsetnumber);
f.setSubj(lemma_uuid);
f.setObj(synset);
f.write(of);return;}


@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]){
new com.rvjansen.Lemma();
netrexx.lang.RexxIO.Say(languages);return;}public netrexx.lang.Rexx getChars(){return chars;}public void setChars(netrexx.lang.Rexx $4){chars=$4;return;}public netrexx.lang.Rexx getLemma_uuid(){return lemma_uuid;}public void setLemma_uuid(netrexx.lang.Rexx $5){lemma_uuid=$5;return;}public netrexx.lang.Rexx getSynset(){return synset;}public void setSynset(netrexx.lang.Rexx $6){synset=$6;return;}}
