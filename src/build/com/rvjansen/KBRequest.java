/* Generated from 'KBRequest.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class KBRequest implements... 
 * <BR>
 * Created on: za, 20, feb 2010 17:23:43 +0100
 */
public class KBRequest implements java.io.Serializable{private static final java.lang.String $0="KBRequest.nrx";
/* properties indirect */
private netrexx.lang.Rexx request;

/* properties constant */
protected static final long serialVersionUID=99192042232348439L;

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public KBRequest(){super();return;}

@SuppressWarnings("unchecked")
public KBRequest(netrexx.lang.Rexx s){super();
this.request=s;return;}

@SuppressWarnings("unchecked")
public java.lang.String toString(){
return request.toString();}public netrexx.lang.Rexx getRequest(){return request;}public void setRequest(netrexx.lang.Rexx $1){request=$1;return;}}

