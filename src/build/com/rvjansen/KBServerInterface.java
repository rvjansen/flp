/* Generated from 'KBServerInterface.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


public interface KBServerInterface extends java.rmi.Remote{static final java.lang.String $0="KBServerInterface.nrx";

@SuppressWarnings("unchecked")
public abstract com.rvjansen.KBResponse request(com.rvjansen.KBRequest s) throws java.rmi.RemoteException;
// method isCurrent(s=KBRequest) signals RemoteException returns boolean
// method obviate(s=KBRequest) signals RemoteException returns boolean
// method checkPoint(s) signals RemoteException, IOException
@SuppressWarnings("unchecked")
public abstract boolean isTrue(netrexx.lang.Rexx s) throws java.rmi.RemoteException;}

