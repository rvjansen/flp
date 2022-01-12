/* Generated from 'getUUID.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import com.eaio.uuid.UUID;


public class getUUID{private static final java.lang.String $0="getUUID.nrx";@SuppressWarnings("unchecked")
public static void main(java.lang.String $0s[]){com.eaio.uuid.UUID u;com.eaio.uuid.UUID w;u=new UUID();
w=UUID.nilUUID();
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(u.toString())).upper());
netrexx.lang.RexxIO.Say((new netrexx.lang.Rexx(w.toString())).upper());return;}private getUUID(){return;}}

