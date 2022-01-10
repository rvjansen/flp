/* Generated from 'ModelObject.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class ModelObject implements... 
 * <BR>
 * Created on: zo, 13, okt 2013 18:37:36 +0200
 */
public class ModelObject implements java.lang.Comparable{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(1);private static final java.lang.String $0="ModelObject.nrx";
/* properties indirect */
private netrexx.lang.Rexx iD;
private netrexx.lang.Rexx name;

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public ModelObject(){super();
return;}

@SuppressWarnings("unchecked")
public ModelObject(java.lang.String id_,java.lang.String name_){super();
this.setID(netrexx.lang.Rexx.toRexx(id_));
this.setName(netrexx.lang.Rexx.toRexx(name_));return;}

@SuppressWarnings("unchecked")
public java.lang.String toString(){
return netrexx.lang.Rexx.toString(this.getName());}

@SuppressWarnings("unchecked")
public int compareTo(java.lang.Object o){com.rvjansen.ModelObject ro;
ro=(com.rvjansen.ModelObject)o;
if ((ro.getName()).OpGt(null,this.getName())) return 1;
if ((ro.getName()).OpLt(null,this.getName())) return $01.OpMinus(null).toint();
if ((ro.getName()).OpEq(null,this.getName())) return 0;
return 0;}public netrexx.lang.Rexx getID(){return iD;}public void setID(netrexx.lang.Rexx $1){iD=$1;return;}public netrexx.lang.Rexx getName(){return name;}public void setName(netrexx.lang.Rexx $2){name=$2;return;}}

