/* Generated from 'readLemmata.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import com.eaio.uuid.UUID;

/**
 * Class readLemmata reads the language lemma files and stores them in the repository
 * with the appropriate types attached 
 * <BR>
 * Created on: do, 12, sep 2013 20:24:18 +0200
 */
public class readLemmata{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("reading");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx(".tab");private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx('#');private static final char[] $04={2,1,45,10,1,0,2,7,9,108,101,109,109,97,9,10,1,1,1,10,1,2,0};private static final java.lang.String $0="readLemmata.nrx";

/* properties private */
private java.util.TreeMap defMap=new java.util.TreeMap();
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readLemmata() throws java.io.IOException,java.io.FileNotFoundException,java.rmi.RemoteException{super();java.io.PrintWriter out;netrexx.lang.Rexx languages;netrexx.lang.Rexx i=null;netrexx.lang.Rexx lang=null;java.io.BufferedReader in=null;netrexx.lang.Rexx line=null;netrexx.lang.Rexx id=null;netrexx.lang.Rexx type=null;netrexx.lang.Rexx w=null;com.rvjansen.Lemma lemma_=null;

// for all language files:
out=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter("lemmata.prolog")))));
//languages = 'cat cmn dan eng eus fas fin glg ind ita jpn nno nob pol por spa tha zsm'
languages=netrexx.lang.Rexx.toRexx("fra");
{netrexx.lang.Rexx $1=languages.words();i=new netrexx.lang.Rexx((byte)1);i:for(;i.OpLtEq(null,$1);i=i.OpAdd(null,new netrexx.lang.Rexx(1))){
lang=languages.word(i);
netrexx.lang.RexxIO.Say($01.OpCcblank(null,lang));
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader(netrexx.lang.Rexx.toString((netrexx.lang.Rexx.toRexx("../files/sources/wn-data-").OpCc(null,lang)).OpCc(null,$02)))));
line=netrexx.lang.Rexx.toRexx("");
{$2:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $2;
if ((line.left(new netrexx.lang.Rexx((byte)1))).OpEq(null,$03)) continue $2;
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(line,$04,$3);id=$3[0];type=$3[1];w=$3[2];}
w=w.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
id=(type.translate(netrexx.lang.Rexx.toRexx("1234"),netrexx.lang.Rexx.toRexx("nvar"))).OpCc(null,id);
lemma_=new com.rvjansen.Lemma();
lemma_.setLemma_uuid(netrexx.lang.Rexx.toRexx(newUUID()));
lemma_.setLanguage(lang);
lemma_.setChars(w);
lemma_.setSynset(id);
lemma_.setPartOfSpeech(type);
lemma_.persist();
}}
}}/*i*/ // loop i
out.close();return;}

@SuppressWarnings("unchecked")
public static java.lang.String newUUID(){
return (new UUID()).toString().toUpperCase();}


@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.IOException,java.io.FileNotFoundException,java.rmi.RemoteException{
new com.rvjansen.readLemmata();return;}}
