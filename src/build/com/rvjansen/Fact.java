/* Generated from 'Fact.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import com.eaio.uuid.UUID;



public class Fact{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx('\'');private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("\'(\'");private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("\',\'");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("\').");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("assertz(\'");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx("\')).");private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("retract(\'");private static final char[] $08={2,1,39,2,3,39,40,39,10,1,0,2,3,39,44,39,10,1,1,2,2,39,41,10,1,2,0};private static final char[] $09={2,1,39,2,2,39,40,10,1,0,2,1,44,10,1,1,2,1,41,10,1,2,0};private static final java.lang.String $0="Fact.nrx";

/* properties indirect */
private netrexx.lang.Rexx pred=netrexx.lang.Rexx.toRexx(""); // predicate
private netrexx.lang.Rexx subj=netrexx.lang.Rexx.toRexx(""); // subject
private netrexx.lang.Rexx obj=netrexx.lang.Rexx.toRexx(""); // object

@SuppressWarnings("unchecked")
public Fact(){super();return;} // default no-args constructor

@SuppressWarnings("unchecked")
public Fact(netrexx.lang.Rexx pred_,netrexx.lang.Rexx subj_,netrexx.lang.Rexx obj_){super();
this.pred=de_apo(pred_);
this.subj=de_apo(subj_);
this.obj=de_apo(obj_);return;}

@SuppressWarnings("unchecked")
public java.lang.String toString(){
return netrexx.lang.Rexx.toString(((((($01.OpCc(null,this.pred)).OpCc(null,$02)).OpCc(null,this.subj)).OpCc(null,$03)).OpCc(null,this.obj)).OpCc(null,$04));}

@SuppressWarnings("unchecked")
public java.lang.String toAssertion(){
return netrexx.lang.Rexx.toString(((((($05.OpCc(null,this.pred)).OpCc(null,$02)).OpCc(null,this.subj)).OpCc(null,$03)).OpCc(null,this.obj)).OpCc(null,$06));}

@SuppressWarnings("unchecked")
public java.lang.String toRetraction(){
return netrexx.lang.Rexx.toString(((((($07.OpCc(null,this.pred)).OpCc(null,$02)).OpCc(null,this.subj)).OpCc(null,$03)).OpCc(null,this.obj)).OpCc(null,$06));}

@SuppressWarnings("unchecked")
public void setPred(netrexx.lang.Rexx arg){
this.pred=de_apo(arg);return;}

@SuppressWarnings("unchecked")
public void setSubj(netrexx.lang.Rexx arg){
this.subj=de_apo(arg);return;}

@SuppressWarnings("unchecked")
public void setObj(netrexx.lang.Rexx arg){
this.obj=de_apo(arg);return;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx de_apo(netrexx.lang.Rexx arg){
if (arg==null) 
{
netrexx.lang.RexxIO.Say("nullpointer in Fact.de_apo");
return netrexx.lang.Rexx.toRexx("");
}
arg=arg.strip(new netrexx.lang.Rexx('b'),new netrexx.lang.Rexx('\"'));
arg=arg.strip(new netrexx.lang.Rexx('b'),new netrexx.lang.Rexx('\''));
return arg;}

/**
 * write the current Fact to the specified output handle
 */
@SuppressWarnings("unchecked")
public void write(java.io.PrintWriter out){
out.println(this.toString());return;}

/**
 * persist the current Fact to the specified output handle
 * (persisting is pedantic for writing) 
 */
@SuppressWarnings("unchecked")
public void persist(java.io.PrintWriter out){
out.println(this.toString());return;}

@SuppressWarnings("unchecked")
public void assertz(com.rvjansen.KBServerInterface api) throws java.rmi.RemoteException{
api.request(new com.rvjansen.KBRequest(netrexx.lang.Rexx.toRexx(this.toAssertion())));return;}

@SuppressWarnings("unchecked")
public void retract(com.rvjansen.KBServerInterface api) throws java.rmi.RemoteException{
api.request(new com.rvjansen.KBRequest(netrexx.lang.Rexx.toRexx(this.toRetraction())));return;}

/**
 * read the fact from inputhandle and parse up into components
 */

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx read(java.io.BufferedReader in) throws java.io.IOException{netrexx.lang.Rexx line;netrexx.lang.Rexx pred_=null;netrexx.lang.Rexx subj_=null;netrexx.lang.Rexx obj_=null;
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) return (netrexx.lang.Rexx)null;
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(line,$08,$1);pred_=$1[0];subj_=$1[1];obj_=$1[2];}
this.setPred(pred_.strip());
this.setSubj(subj_.strip());
this.setObj(obj_.strip());
return new netrexx.lang.Rexx((byte)1);}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx readFix(java.io.BufferedReader in) throws java.io.IOException{netrexx.lang.Rexx line;netrexx.lang.Rexx pred_=null;netrexx.lang.Rexx subj_=null;netrexx.lang.Rexx obj_=null;
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) return (netrexx.lang.Rexx)null;
{netrexx.lang.Rexx $2[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(line,$09,$2);pred_=$2[0];subj_=$2[1];obj_=$2[2];}
this.setPred(pred_.strip());
this.setSubj(subj_.strip());
this.setObj(obj_.strip());
return new netrexx.lang.Rexx((byte)1);}public netrexx.lang.Rexx getPred(){return pred;}public netrexx.lang.Rexx getSubj(){return subj;}public netrexx.lang.Rexx getObj(){return obj;}}

