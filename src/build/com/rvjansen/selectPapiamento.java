/* Generated from 'selectPapiamento.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class selectPapiamento gets the papiamento words from the repository
 * and formats them for the pap-eng dictionary part.  
 * Created on: ma, 30, sep 2013 22:44:16 +0200
 */
public class selectPapiamento{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("\\textbf{");private static final netrexx.lang.Rexx $04=new netrexx.lang.Rexx('}');private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("noun(");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx(").");private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("verb(");private static final netrexx.lang.Rexx $08=netrexx.lang.Rexx.toRexx("adjective(");private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("adverb(");private static final netrexx.lang.Rexx $010=new netrexx.lang.Rexx(' ');private static final netrexx.lang.Rexx $011=new netrexx.lang.Rexx('\u241d');private static final netrexx.lang.Rexx $012=netrexx.lang.Rexx.toRexx("\u03F2 ");private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("cur(");private static final netrexx.lang.Rexx $014=new netrexx.lang.Rexx('c');private static final netrexx.lang.Rexx $015=new netrexx.lang.Rexx('\u03F2');private static final netrexx.lang.Rexx $016=netrexx.lang.Rexx.toRexx("\u03B1 ");private static final netrexx.lang.Rexx $017=netrexx.lang.Rexx.toRexx("aru(");private static final netrexx.lang.Rexx $018=new netrexx.lang.Rexx('.');private static final java.lang.String $0="selectPapiamento.nrx";
protected java.util.TreeMap lista=new java.util.TreeMap();
protected java.util.TreeMap defMap=new java.util.TreeMap();
protected netrexx.lang.Rexx all=new netrexx.lang.Rexx((byte)1);
protected netrexx.lang.Rexx nofont=new netrexx.lang.Rexx((byte)0);
protected com.rvjansen.KBClient client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public selectPapiamento() throws java.io.IOException,java.rmi.RemoteException{super();netrexx.lang.Rexx outFileName;java.io.PrintWriter out;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx rs=null;int total;int totalstart;java.lang.Object uid=null;java.util.Iterator j=null;java.util.TreeSet defSet=null;netrexx.lang.Rexx def=null;netrexx.lang.Rexx lemma=null;java.lang.Object defuid=null;java.util.TreeSet definition=null;
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("selectPapiamento started")));
outFileName=netrexx.lang.Rexx.toRexx("../tex/book/Papiamento-English.tex");
out=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter(netrexx.lang.Rexx.toString(outFileName))))));
out.println("\\twocolumn");
out.println("\\chapter{Papiamento-English}");
out.println("\\small");

a=client.request(netrexx.lang.Rexx.toRexx("pap(X),nm(X,Y)"));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
lista.put((java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('Y')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip()),(java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(a.size()))).OpCcblank(null,netrexx.lang.Rexx.toRexx("Papiamento Lemmata available")));
total=a.size();totalstart=total;

i=lista.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
uid=lista.get((java.lang.Object)rs);
a=client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),def(Synset,Definition).")));
if (new netrexx.lang.Rexx(a.size()).OpEq(null,$01)) total=new netrexx.lang.Rexx(total).OpSub(null,$02).toint();
j=a.iterator();
defSet=new java.util.TreeSet();
{for(;;){if(!(j.hasNext()))break;
def=(netrexx.lang.Rexx)(j.next());
defSet.add((java.lang.Object)(def.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf));
}}
defMap.put(uid,(java.lang.Object)defSet);
}} // loop while i
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(total))).OpCcblank(null,netrexx.lang.Rexx.toRexx("defined lemmata found")));
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(totalstart).OpSub(null,new netrexx.lang.Rexx(total)))).OpCcblank(null,netrexx.lang.Rexx.toRexx("definitions to go.")));
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("Writing Papiamento lexicon to"))).OpCcblank(null,outFileName));

i=lista.keySet().iterator();
{$1:for(;;){if(!(i.hasNext()))break;
lemma=(netrexx.lang.Rexx)(i.next());
defuid=lista.get((java.lang.Object)lemma);
definition=(java.util.TreeSet)(defMap.get(defuid));
if (this.all.toboolean()) ;
else if (new netrexx.lang.Rexx(definition.size()).OpEq(null,$01)) continue $1;
out.print((java.lang.Object)(($03.OpCc(null,lemma)).OpCc(null,$04)));

// parts of speech
if (isTrue(($05.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print(" \\emph{n} ");
if (isTrue(($07.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print(" \\emph{v} ");
if (isTrue(($08.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print(" \\emph{adj} ");
if (isTrue(($09.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print(" \\emph{adv} ");
if (isTrue((netrexx.lang.Rexx.toRexx("interjection(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print(" \\emph{int} ");

// papiamento variants including government lists
if (isTrue((netrexx.lang.Rexx.toRexx("cur_official(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print((java.lang.Object)(((($010.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Lucida Sans Unicode}")))).OpCc(null,$011)).OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Calibri-Italic}")))).OpCc(null,$012)));
else if (isTrue(($013.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print((java.lang.Object)(($014.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Calibri-Italic}")))).OpCc(null,$015)));
if (isTrue((netrexx.lang.Rexx.toRexx("aru_official(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print((java.lang.Object)(((($010.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Lucida Sans Unicode}")))).OpCc(null,$011)).OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Arial Narrow}")))).OpCc(null,$016)));
else if (isTrue(($017.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(defuid)))).OpCc(null,$06))) out.print((java.lang.Object)(($010.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Arial Narrow}")))).OpCc(null,$016)));
printDefinitions(definition,out);
}}
out.close();
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("selectPapiamento ready")));return;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.IOException,java.rmi.RemoteException{
new com.rvjansen.selectPapiamento();return;}

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req) throws java.rmi.RemoteException{
return client.isTrue(req);}

@SuppressWarnings("unchecked")
public void printDefinitions(java.util.TreeSet def,java.io.PrintWriter out){java.util.Iterator i;netrexx.lang.Rexx count;netrexx.lang.Rexx meaning=null;
out.print("\\fontspec{Minion Pro}");
i=def.iterator();count=new netrexx.lang.Rexx((byte)1);
{for(;;){if(!(i.hasNext()))break;
meaning=(netrexx.lang.Rexx)(i.next());
meaning=texSafe(meaning);
if (new netrexx.lang.Rexx(def.size()).OpGt(null,$02)) out.print((java.lang.Object)(count.OpCc(null,$018)));
out.print((java.lang.Object)(meaning.translate(new netrexx.lang.Rexx(' '),new netrexx.lang.Rexx('\u2019')).changestr(new netrexx.lang.Rexx('^'),netrexx.lang.Rexx.toRexx("\\^{}")).strip(new netrexx.lang.Rexx('b'),new netrexx.lang.Rexx('\''))));
count=count.OpAdd(null,$02);
}}
out.println("\\\\");return;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx texSafe(netrexx.lang.Rexx s){
s=s.changestr(new netrexx.lang.Rexx('$'),netrexx.lang.Rexx.toRexx("\\$"));
return s;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx fs(netrexx.lang.Rexx f){
if (this.nofont.toboolean()) return netrexx.lang.Rexx.toRexx("");
else return f;}}
