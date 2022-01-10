/* Generated from 'commonSet.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class commonSet implements... 
 * <BR>
 * Created on: Sun, 27, Mar 2016 16:24:17 +0200
 */
public class commonSet{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("(X),");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("(Z).");private static final java.lang.String $0="commonSet.nrx";
/* properties private */
private java.util.TreeMap lista=new java.util.TreeMap();
private com.rvjansen.KBClient client;
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public commonSet() throws java.rmi.RemoteException{super();java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx rs=null;java.util.TreeSet common_set;netrexx.lang.Rexx languages;netrexx.lang.Rexx ii=null;netrexx.lang.Rexx language=null;
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,netrexx.lang.Rexx.toRexx("commonSet started.")));

// select papiamento
client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));
a=client.request(netrexx.lang.Rexx.toRexx("pap(X),nm(X,Y)"));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
lista.put((java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('Y')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip()),(java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('X')).leaf));
}}
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(a.size()))).OpCcblank(null,netrexx.lang.Rexx.toRexx("Papiamento lemmata available")));

a=client.request(netrexx.lang.Rexx.toRexx("B=Y,nm(X,Y),nm(Z,B),aru_official(X),cur_official(Z)."));
common_set=new java.util.TreeSet();
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
common_set.add((java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('B')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip()));
}}
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())).OpCcblank(null,new netrexx.lang.Rexx(a.size()))).OpCcblank(null,netrexx.lang.Rexx.toRexx("common spellings available between aru_official and cur_official")));
//say common_set

netrexx.lang.RexxIO.Say("----------------> pap");
languages=netrexx.lang.Rexx.toRexx("cat cmn dan eng eus fas fin fra glg ind ita jpn nno nob pol por spa tha zsm");
{netrexx.lang.Rexx $1=languages.words();ii=new netrexx.lang.Rexx((byte)1);ii:for(;ii.OpLtEq(null,$1);ii=ii.OpAdd(null,new netrexx.lang.Rexx(1))){
language=languages.word(ii);
compareVocabulary(netrexx.lang.Rexx.toRexx("pap"),language);
}}/*ii*/
netrexx.lang.RexxIO.Say("----------------> cur_official");
languages=netrexx.lang.Rexx.toRexx("cat cmn dan eng eus fas fin fra glg ind ita jpn nno nob pol por spa tha zsm");
{netrexx.lang.Rexx $2=languages.words();ii=new netrexx.lang.Rexx((byte)1);ii:for(;ii.OpLtEq(null,$2);ii=ii.OpAdd(null,new netrexx.lang.Rexx(1))){
language=languages.word(ii);
compareVocabulary(netrexx.lang.Rexx.toRexx("cur_official"),language);
}}/*ii*/
netrexx.lang.RexxIO.Say("----------------> aru_official");
languages=netrexx.lang.Rexx.toRexx("cat cmn dan eng eus fas fin fra glg ind ita jpn nno nob pol por spa tha zsm");
{netrexx.lang.Rexx $3=languages.words();ii=new netrexx.lang.Rexx((byte)1);ii:for(;ii.OpLtEq(null,$3);ii=ii.OpAdd(null,new netrexx.lang.Rexx(1))){
language=languages.word(ii);
compareVocabulary(netrexx.lang.Rexx.toRexx("aru_official"),language);
}}/*ii*/return;}


@SuppressWarnings("unchecked")
public void compareVocabulary(netrexx.lang.Rexx language_code1,netrexx.lang.Rexx language_code2) throws java.rmi.RemoteException{java.util.ArrayList a;java.util.TreeSet lang_list;java.util.Iterator i;netrexx.lang.Rexx rs=null;
a=client.request((((netrexx.lang.Rexx.toRexx("B=Y,nm(X,Y),nm(Z,B),").OpCc(null,language_code1)).OpCc(null,$01)).OpCc(null,language_code2)).OpCc(null,$02));
lang_list=new java.util.TreeSet();
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
rs=(netrexx.lang.Rexx)(i.next());
lang_list.add((java.lang.Object)(rs.getnode(new netrexx.lang.Rexx('B')).leaf.translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx('\'')).strip()));
}}
netrexx.lang.RexxIO.Say(new netrexx.lang.Rexx(lang_list.size()).OpCcblank(null,language_code2));return;}
//say lang_list


// 

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException{com.rvjansen.commonSet c;
c=new com.rvjansen.commonSet();return;}}
