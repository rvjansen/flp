/* Generated from 'readErkaneEngPap.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class readErkaneEngPap implements... 
 * <BR>
 * Created on: ma, 23, sep 2013 19:10:54 +0200
 */
public class readErkaneEngPap extends com.rvjansen.Bint{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("draw");private static final char[] $02={2,1,58,10,1,0,1,10,1,1,0};private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx(",Y)");private static final netrexx.lang.Rexx $05=new netrexx.lang.Rexx(0);private static final char[] $06={2,1,124,10,1,0,1,10,1,1,0};private static final netrexx.lang.Rexx $07=new netrexx.lang.Rexx('?');private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx('y');private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("nm(X,\'");private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("\'),");private static final netrexx.lang.Rexx $011=netrexx.lang.Rexx.toRexx("(X)");private static final netrexx.lang.Rexx $012=netrexx.lang.Rexx.toRexx("\')");private static final java.lang.String $0="readErkaneEngPap.nrx";
/* properties private */

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readErkaneEngPap() throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{super();java.io.BufferedReader in;netrexx.lang.Rexx eng_word;netrexx.lang.Rexx line=null;netrexx.lang.Rexx rest=null;netrexx.lang.Rexx lemma_uuid=null;netrexx.lang.Rexx synsets=null;netrexx.lang.Rexx ii=null;java.util.Iterator j=null;netrexx.lang.Rexx synset=null;java.util.TreeSet papSet=null;netrexx.lang.Rexx w=null;netrexx.lang.Rexx wi=null;java.util.Iterator i=null;netrexx.lang.Rexx papWord_=null;netrexx.lang.Rexx paplemma_uuid=null;netrexx.lang.Rexx iii=null;java.util.Iterator defiter=null;netrexx.lang.Rexx txt=null;netrexx.lang.Rexx def=null;netrexx.lang.Rexx addit=null;netrexx.lang.Rexx paplemmata=null;netrexx.lang.Rexx current_pap_uuid=null;com.rvjansen.Fact f=null;
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/erengpap.txt")));
//start position
eng_word=netrexx.lang.Rexx.toRexx("");
{boolean $1=true;$2:for(;;){if($1){$1=false;}else{if(eng_word.OpEq(null,$01))break;}
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $2;
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$02,$3);eng_word=$3[0];rest=$3[1];}
}}

{$4:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $4;
{netrexx.lang.Rexx $5[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$02,$5);eng_word=$5[0];rest=$5[1];}

// check if exists in english wordnet
//say '>>>>'
lemma_uuid=checkRepositoryForLanguage(eng_word,netrexx.lang.Rexx.toRexx("eng"));
if (lemma_uuid.OpEq(null,$03)) 
{
//	  say eng_word 'is not in repository as English'
lemma_uuid=checkRepository(eng_word);
if (lemma_uuid.OpEq(null,$03)) ;
else 
; //say eng_word lemma_uuid 
} // if do

// find gloss/synset relationships for these uuids
synsets=netrexx.lang.Rexx.toRexx("");
{netrexx.lang.Rexx $6=lemma_uuid.words();ii=new netrexx.lang.Rexx((byte)1);ii:for(;ii.OpLtEq(null,$6);ii=ii.OpAdd(null,new netrexx.lang.Rexx(1))){
j=this.client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,lemma_uuid.word(ii))).OpCc(null,$04)).iterator();
{for(;;){if(!(j.hasNext()))break;
synset=(netrexx.lang.Rexx)(j.next());
synsets=synsets.OpCcblank(null,synset.getnode(new netrexx.lang.Rexx('Y')).leaf);
}}
}}/*ii*/

netrexx.lang.RexxIO.Say(eng_word);

//say 'synsets: ' synsets


papSet=new java.util.TreeSet();
// split out papiamento words; for word, do
if ((rest.pos(new netrexx.lang.Rexx('|'))).OpGt(null,$05)) {
{for(;;){if(!rest.OpNotEq(null,$03))break;
{netrexx.lang.Rexx $7[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(rest,$06,$7);w=$7[0];rest=$7[1];}
{netrexx.lang.Rexx $8=w.words();wi=new netrexx.lang.Rexx((byte)1);wi:for(;wi.OpLtEq(null,$8);wi=wi.OpAdd(null,new netrexx.lang.Rexx(1))){
papSet.add((java.lang.Object)(w.word(wi).translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx(',')).strip()));
}}/*wi*/
}}
}
else {
{netrexx.lang.Rexx $9=rest.words();wi=new netrexx.lang.Rexx((byte)1);wi:for(;wi.OpLtEq(null,$9);wi=wi.OpAdd(null,new netrexx.lang.Rexx(1))){
papSet.add((java.lang.Object)(rest.word(wi).translate(netrexx.lang.Rexx.toRexx(""),new netrexx.lang.Rexx(',')).strip()));
}}/*wi*/
}
i=papSet.iterator();
{$10:for(;;){if(!(i.hasNext()))break;
papWord_=(netrexx.lang.Rexx)(i.next());
if (netrexx.lang.Rexx.toRexx("1.2.3.4.5.6.7.8.9.").pos(papWord_).OpGt(null,$05)) continue $10;
paplemma_uuid=checkRepositoryForLanguage(papWord_,netrexx.lang.Rexx.toRexx("pap"));
//	say papWord_ paplemma_uuid
if (paplemma_uuid.OpNotEq(null,$03)) {
{netrexx.lang.Rexx $11=synsets.words();iii=new netrexx.lang.Rexx((byte)1);iii:for(;iii.OpLtEq(null,$11);iii=iii.OpAdd(null,new netrexx.lang.Rexx(1))){
defiter=this.client.request((netrexx.lang.Rexx.toRexx("synsetnumber(Synset,").OpCc(null,synsets.word(iii))).OpCc(null,netrexx.lang.Rexx.toRexx("),def(Synset,Definition)."))).iterator();
{for(;;){if(!(defiter.hasNext()))break;
txt=(netrexx.lang.Rexx)(defiter.next());
def=txt.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf;
netrexx.lang.RexxIO.Say((papWord_.OpCcblank(null,def)).OpCcblank(null,$07));
addit=netrexx.lang.RexxIO.Ask();
if (addit.OpEq(null,$08)) { // add to repository
netrexx.lang.RexxIO.Say(synsets.word(iii));
netrexx.lang.RexxIO.Say(paplemma_uuid);
// for every uuid lemma do
{netrexx.lang.Rexx $12=paplemma_uuid.words();paplemmata=new netrexx.lang.Rexx((byte)1);paplemmata:for(;paplemmata.OpLtEq(null,$12);paplemmata=paplemmata.OpAdd(null,new netrexx.lang.Rexx(1))){
current_pap_uuid=paplemma_uuid.word(paplemmata);
/* add synset number to lemma uuid */
f=new com.rvjansen.Fact(); // its synset
f.setPred(netrexx.lang.Rexx.toRexx("3B365C30-22FF-11E3-80E8-E0F847277696"));
f.setSubj(current_pap_uuid);
f.setObj(synsets.word(iii));
f.assertz((com.rvjansen.KBServerInterface)this.client);
}}/*paplemmata*/
}
}}
}}/*iii*/
}
}}


// flag as cur
// add source system relationship


//say'<<<<'
netrexx.lang.RexxIO.Say("");

}}
return;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx checkRepositoryForLanguage(netrexx.lang.Rexx word_,netrexx.lang.Rexx lang_) throws java.rmi.RemoteException{netrexx.lang.Rexx lemma_uuid;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx r=null;
word_=word_.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
lemma_uuid=netrexx.lang.Rexx.toRexx("");
a=this.client.request(((($09.OpCc(null,word_)).OpCc(null,$010)).OpCc(null,lang_)).OpCc(null,$011));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
r=(netrexx.lang.Rexx)(i.next());
lemma_uuid=lemma_uuid.OpCcblank(null,r.getnode(new netrexx.lang.Rexx('X')).leaf);
}}
return lemma_uuid;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx checkRepository(netrexx.lang.Rexx word_) throws java.rmi.RemoteException{netrexx.lang.Rexx lemma_uuid;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx r=null;
word_=word_.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));
lemma_uuid=netrexx.lang.Rexx.toRexx("");
a=this.client.request(($09.OpCc(null,word_)).OpCc(null,$012));
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
r=(netrexx.lang.Rexx)(i.next());
lemma_uuid=lemma_uuid.OpCcblank(null,r.getnode(new netrexx.lang.Rexx('X')).leaf);
}}
return lemma_uuid;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.FileNotFoundException,java.io.IOException,java.rmi.RemoteException{
new com.rvjansen.readErkaneEngPap();return;}}
