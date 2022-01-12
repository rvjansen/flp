/* Generated from 'selectLanguages.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class selectLanguages implements the bilingual lexica.
 * <BR>
 * Created on: ma, 14, okt 2013 15:31:06 +0200
 */
public class selectLanguages{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx(").");private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(2);private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("processing");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx(".tex");private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx('}');private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("tha");private static final netrexx.lang.Rexx $08=netrexx.lang.Rexx.toRexx("fin");private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("zsm");private static final netrexx.lang.Rexx $010=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $011=netrexx.lang.Rexx.toRexx("\\textbf{");private static final netrexx.lang.Rexx $012=netrexx.lang.Rexx.toRexx("noun(");private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("verb(");private static final netrexx.lang.Rexx $014=netrexx.lang.Rexx.toRexx("adjective(");private static final netrexx.lang.Rexx $015=netrexx.lang.Rexx.toRexx("adverb(");private static final netrexx.lang.Rexx $016=new netrexx.lang.Rexx(' ');private static final netrexx.lang.Rexx $017=new netrexx.lang.Rexx('\u241d');private static final netrexx.lang.Rexx $018=netrexx.lang.Rexx.toRexx("\u03F2 ");private static final netrexx.lang.Rexx $019=netrexx.lang.Rexx.toRexx("cur(");private static final netrexx.lang.Rexx $020=new netrexx.lang.Rexx('c');private static final netrexx.lang.Rexx $021=new netrexx.lang.Rexx('\u03F2');private static final netrexx.lang.Rexx $022=netrexx.lang.Rexx.toRexx("\u03B1 ");private static final netrexx.lang.Rexx $023=netrexx.lang.Rexx.toRexx("aru(");private static final netrexx.lang.Rexx $024=netrexx.lang.Rexx.toRexx("\\\\");private static final netrexx.lang.Rexx $025=netrexx.lang.Rexx.toRexx("-pap.tex");private static final netrexx.lang.Rexx $026=netrexx.lang.Rexx.toRexx("\\chapter{");private static final netrexx.lang.Rexx $027=netrexx.lang.Rexx.toRexx("} ");private static final netrexx.lang.Rexx $028=netrexx.lang.Rexx.toRexx("cmn");private static final netrexx.lang.Rexx $029=netrexx.lang.Rexx.toRexx("fas");private static final netrexx.lang.Rexx $030=netrexx.lang.Rexx.toRexx("jpn");private static final java.lang.String $0="selectLanguages.nrx";
/* properties private */
private com.rvjansen.KBClient client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));
private java.util.TreeMap lista=new java.util.TreeMap();
private java.util.TreeMap defMap=new java.util.TreeMap();

private netrexx.lang.Rexx nofont=new netrexx.lang.Rexx((byte)0);
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public selectLanguages() throws java.rmi.RemoteException,java.io.IOException{super();java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx rs=null;java.lang.Object uid=null;java.util.Iterator j=null;java.util.TreeSet defSet=null;netrexx.lang.Rexx def=null;netrexx.lang.Rexx languages;netrexx.lang.Rexx ii=null;netrexx.lang.Rexx language=null;java.util.TreeMap reversedMap=null;netrexx.lang.Rexx lf=null;netrexx.lang.Rexx language_fullname=null;netrexx.lang.Rexx count=null;java.io.PrintWriter out=null;netrexx.lang.Rexx lemma=null;java.util.TreeSet rsSet=null;netrexx.lang.Rexx trans=null;netrexx.lang.Rexx transl=null;
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("selectLanguages started.")));
// select papiamento and available glosses
client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));
a=client.request(netrexx.lang.Rexx.toRexx("pap(X),nm(X,Y)"));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
lista.put((java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('Y')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip()),(java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(a.size()))).OpCcblank(null,netrexx.lang.Rexx.toRexx("Papiamento lemmata available")));

i=lista.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
uid=lista.get((java.lang.Object)rs);
a=client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),def(Synset,Definition).")));
j=a.iterator();
defSet=new java.util.TreeSet();
{for(;;){if(!(j.hasNext()))break;
def=(netrexx.lang.Rexx)(j.next());
defSet.add((java.lang.Object)(def.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf));
}}
defMap.put(uid,(java.lang.Object)defSet);
}}

// loop over languages TODO loop over the domains of the scheme
languages=netrexx.lang.Rexx.toRexx("cat cmn dan eng eus fas fin fra glg ind ita jpn nno nob pol por spa tha zsm");
{netrexx.lang.Rexx $1=languages.words();ii=new netrexx.lang.Rexx((byte)1);ii:for(;ii.OpLtEq(null,$1);ii=ii.OpAdd(null,new netrexx.lang.Rexx(1))){
language=languages.word(ii);
reversedMap=new java.util.TreeMap();
a=client.request((netrexx.lang.Rexx.toRexx("def(X,Y),nm(X,").OpCc(null,language)).OpCc(null,$01));
lf=(netrexx.lang.Rexx)(a.get(0));
language_fullname=lf.getnode(new netrexx.lang.Rexx('Y')).leaf.strip(new netrexx.lang.Rexx('b'),new netrexx.lang.Rexx('\''));
{/*select*/
if ((language_fullname.words()).OpEq(null,$02))language_fullname=language_fullname.upper(new netrexx.lang.Rexx((byte)1),new netrexx.lang.Rexx((byte)1));
else if ((language_fullname.words()).OpEq(null,$03))language_fullname=(language_fullname.word(new netrexx.lang.Rexx((byte)1)).upper(new netrexx.lang.Rexx((byte)1),new netrexx.lang.Rexx((byte)1))).OpCcblank(null,language_fullname.word(new netrexx.lang.Rexx((byte)2)).upper(new netrexx.lang.Rexx((byte)1),new netrexx.lang.Rexx((byte)1)));
else{
;}
}

netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,$04)).OpCcblank(null,language_fullname));
count=new netrexx.lang.Rexx((byte)0);
out=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter(netrexx.lang.Rexx.toString((netrexx.lang.Rexx.toRexx("../tex/book/pap-").OpCc(null,language)).OpCc(null,$05)))))));
out.println("\\twocolumn");
out.println((java.lang.Object)((netrexx.lang.Rexx.toRexx("\\chapter{Papiamento-").OpCc(null,language_fullname)).OpCc(null,$06)));
out.println("\\small");
{/*select*/
if (language.OpEq(null,$07))out.println("\\raggedright");
else if (language.OpEq(null,$08))out.println("\\raggedright");
else if (language.OpEq(null,$09))out.println("\\raggedright");
else{
;}
}
i=lista.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
lemma=(netrexx.lang.Rexx)(i.next());
uid=lista.get((java.lang.Object)lemma);
a=client.request((((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),lemmasynset(X,Number),"))).OpCc(null,language)).OpCc(null,netrexx.lang.Rexx.toRexx("(X),nm(X,Translation).")));
// only print when we found translations
if ((a!=null)||new netrexx.lang.Rexx(a.size()).OpGt(null,$010)) {
j=a.iterator();
rsSet=new java.util.TreeSet();
{for(;;){if(!(j.hasNext()))break;
trans=(netrexx.lang.Rexx)(j.next());
rsSet.add((java.lang.Object)(trans.getnode(netrexx.lang.Rexx.toRexx("Translation")).leaf));
reversedMap.put((java.lang.Object)(trans.getnode(netrexx.lang.Rexx.toRexx("Translation")).leaf),(java.lang.Object)lemma);
}}
if (new netrexx.lang.Rexx(rsSet.size()).OpGt(null,$010)) 
{
count=count.OpAdd(null,$02);
out.print("\\fontspec{Minion Pro}");
out.print((java.lang.Object)(($011.OpCc(null,lemma)).OpCc(null,$06)));
// parts of speech
if (isTrue(($012.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print(" \\emph{n} ");
if (isTrue(($013.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print(" \\emph{v} ");
if (isTrue(($014.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print(" \\emph{adj} ");
if (isTrue(($015.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print(" \\emph{adv} ");
if (isTrue((netrexx.lang.Rexx.toRexx("interjection(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print(" \\emph{int} ");

// papiamento variants including government lists
if (isTrue((netrexx.lang.Rexx.toRexx("cur_official(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print((java.lang.Object)(((($016.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Lucida Sans Unicode}")))).OpCc(null,$017)).OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Calibri-Italic}")))).OpCc(null,$018)));
else if (isTrue(($019.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print((java.lang.Object)(($020.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Calibri-Italic}")))).OpCc(null,$021)));
if (isTrue((netrexx.lang.Rexx.toRexx("aru_official(").OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print((java.lang.Object)(((($016.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Lucida Sans Unicode}")))).OpCc(null,$017)).OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Arial Narrow}")))).OpCc(null,$022)));
else if (isTrue(($023.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(uid)))).OpCc(null,$01))) out.print((java.lang.Object)(($016.OpCc(null,fs(netrexx.lang.Rexx.toRexx("\\fontspec{Arial Narrow}")))).OpCc(null,$022)));
selectFont(language,out);
out.println((java.lang.Object)(((netrexx.lang.Rexx.toRexx(rsSet.toString())).translate(netrexx.lang.Rexx.toRexx("    "),netrexx.lang.Rexx.toRexx("][#\'")).changestr(new netrexx.lang.Rexx('^'),netrexx.lang.Rexx.toRexx("\\^{}")).changestr(netrexx.lang.Rexx.toRexx("\\234\\"),netrexx.lang.Rexx.toRexx("oe"))).OpCcblank(null,$024)));
}
}
}} // loop while i
out.close();
netrexx.lang.RexxIO.Say(((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,count)).OpCcblank(null,netrexx.lang.Rexx.toRexx("lemmata with translation for"))).OpCcblank(null,language_fullname));

// reverse processing starts here

netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("processing reverse list for"))).OpCcblank(null,language_fullname));
count=new netrexx.lang.Rexx((byte)0);
out=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter(netrexx.lang.Rexx.toString((netrexx.lang.Rexx.toRexx("../tex/book/").OpCc(null,language)).OpCc(null,$025)))))));
out.println("\\twocolumn");
out.println((java.lang.Object)(($026.OpCc(null,language_fullname)).OpCc(null,netrexx.lang.Rexx.toRexx("-Papiamento}"))));
out.println("\\small");
{/*select*/
if (language.OpEq(null,$07))out.println("\\raggedright");
else if (language.OpEq(null,$08))out.println("\\raggedright");
else if (language.OpEq(null,$09))out.println("\\raggedright");
else{
;}
}
i=reversedMap.keySet().iterator();
{for(;;){if(!(i.hasNext()))break;
lemma=(netrexx.lang.Rexx)(i.next());

transl=(netrexx.lang.Rexx)(reversedMap.get((java.lang.Object)lemma));

count=count.OpAdd(null,$02);
selectFont(language,out);
lemma=lemma.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\''));
out.print((java.lang.Object)(($011.OpCc(null,lemma.translate(netrexx.lang.Rexx.toRexx("    "),netrexx.lang.Rexx.toRexx("][#\'")).changestr(new netrexx.lang.Rexx('^'),netrexx.lang.Rexx.toRexx("\\^{}")).changestr(netrexx.lang.Rexx.toRexx("\\234\\"),netrexx.lang.Rexx.toRexx("oe")))).OpCcblank(null,$027)));
// parts of speech
// if isTrue("noun("uid").") then out.print(' \\emph{n} ')
// if isTrue("verb("uid").") then out.print(' \\emph{v} ')
// if isTrue("adjective("uid").") then out.print(' \\emph{adj} ')
// if isTrue("adverb("uid").") then out.print(' \\emph{adv} ')
// if isTrue("interjection("uid").") then out.print(' \\emph{int} ')

// -- papiamento variants including government lists
// if isTrue("cur_official("uid").") then out.print(' 'fs('\\fontspec{Lucida Sans Unicode}')'\u241d'fs('\\fontspec{Calibri-Italic}')'ϲ ')
// else if isTrue("cur("uid").") then out.print( 'c'fs('\\fontspec{Calibri-Italic}')'ϲ')
// if isTrue("aru_official("uid").") then out.print(' 'fs('\\fontspec{Lucida Sans Unicode}')'\u241d'fs('\\fontspec{Arial Narrow}')'α ')
// else if isTrue("aru("uid").") then out.print(' 'fs('\\fontspec{Arial Narrow}')'α ')
out.print("\\fontspec{Minion Pro}");
out.println((java.lang.Object)((transl.translate(netrexx.lang.Rexx.toRexx("    "),netrexx.lang.Rexx.toRexx("][#\'")).changestr(new netrexx.lang.Rexx('^'),netrexx.lang.Rexx.toRexx("\\^{}")).changestr(netrexx.lang.Rexx.toRexx("\\234\\"),netrexx.lang.Rexx.toRexx("oe"))).OpCcblank(null,$024)));
}}
out.close();
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("ended reversed lemmata for"))).OpCcblank(null,language_fullname));

}}/*ii*/
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("selectLanguages ended.")));return;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException,java.io.IOException{
new com.rvjansen.selectLanguages();return;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx fs(netrexx.lang.Rexx f){
if (this.nofont.toboolean()) return netrexx.lang.Rexx.toRexx("");
else return f;}

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req) throws java.rmi.RemoteException{java.util.ArrayList a;
a=client.request(req);
if (a==null) return false;
if (new netrexx.lang.Rexx(a.size()).OpEq(null,$02)) return true;
else return false;}

@SuppressWarnings("unchecked")
public void selectFont(netrexx.lang.Rexx l,java.io.PrintWriter o){
{/*select*/
if (l.OpEq(null,$028))o.print("\\fontspec{Songti SC}");
else if (l.OpEq(null,$029))o.print("\\fontspec{XB Zar}");
else if (l.OpEq(null,$07))o.print("\\fontspec{Tahoma}");
else if (l.OpEq(null,$030))o.print("\\fontspec{PMingLiU}");
else{
o.print("\\fontspec{Minion Pro}");}
}return;}}
