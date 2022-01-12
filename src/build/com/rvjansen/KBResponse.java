/* Generated from 'KBResponse.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class KBResponse implements... 
 * <BR>
 * Created on: za, 20, feb 2010 17:25:29 +0100
 */
public class KBResponse implements java.io.Serializable{private static final java.lang.String $0="KBResponse.nrx";
/* properties indirect */
private boolean result=new netrexx.lang.Rexx(1).toboolean();
private java.util.ArrayList response=new java.util.ArrayList();

/* properties constant */
protected static final long serialVersionUID=991920422323224356L;

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public KBResponse(){super();return;}

@SuppressWarnings("unchecked")
public KBResponse(java.util.ArrayList a){super();
this.response=a;return;}

@SuppressWarnings("unchecked")
public KBResponse(boolean b){super();
this.result=b;return;}

@SuppressWarnings("unchecked")
public int size(){
return response.size();}

@SuppressWarnings("unchecked")
public java.lang.String toString(){
return response.toString();}public boolean isResult(){return result;}public void setResult(boolean $1){result=$1;return;}public java.util.ArrayList getResponse(){return response;}public void setResponse(java.util.ArrayList $2){response=$2;return;}}

