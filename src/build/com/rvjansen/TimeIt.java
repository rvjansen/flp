/* Generated from 'TimeIt.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * * class timeit is a small program for supporting benchmarking tools
 * * and applications. It runs its commandline argument and displays the
 * * time difference between start and end in milliseconds, seconds and
 * * minutes
 * */
public class TimeIt{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("running");private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(1000);private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("seconds (");private static final netrexx.lang.Rexx $04=new netrexx.lang.Rexx(60000);private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("minutes)");private static final java.lang.String $0="TimeIt.nrx";

/* properties indirect */
private int st1;
private int st2;

@SuppressWarnings("unchecked")
public TimeIt(){super();
this.st1=(int)(java.lang.System.currentTimeMillis());
return;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.IOException,java.lang.InterruptedException{com.rvjansen.TimeIt t;java.lang.Process child;java.io.BufferedReader in;java.lang.String line;
t=new com.rvjansen.TimeIt();
netrexx.lang.RexxIO.Say($01.OpCcblank(null,netrexx.lang.Rexx.toRexx(args[0])));
t.st1=(int)(java.lang.System.currentTimeMillis());
child=java.lang.Runtime.getRuntime().exec(args[0]);
in=new java.io.BufferedReader((java.io.Reader)(new java.io.InputStreamReader(child.getInputStream())));

line=in.readLine();
{for(;;){if(!(line!=null))break;
netrexx.lang.RexxIO.Say(line);
line=in.readLine();
}}

child.waitFor();
t.st2=(int)(java.lang.System.currentTimeMillis());
netrexx.lang.RexxIO.Say(((((new netrexx.lang.Rexx(t.st2).OpSub(null,new netrexx.lang.Rexx(t.st1)).OpCcblank(null,netrexx.lang.Rexx.toRexx("millisecs ="))).OpCcblank(null,((new netrexx.lang.Rexx(t.st2).OpSub(null,new netrexx.lang.Rexx(t.st1)))).OpDiv(null,$02))).OpCcblank(null,$03)).OpCcblank(null,((new netrexx.lang.Rexx(t.st2).OpSub(null,new netrexx.lang.Rexx(t.st1)))).OpDiv(null,$04))).OpCcblank(null,$05));
return;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDiff(){netrexx.lang.Rexx tDelta;
this.st2=(int)(java.lang.System.currentTimeMillis());
tDelta=new netrexx.lang.Rexx(this.st2).OpSub(null,new netrexx.lang.Rexx(this.st1));
return netrexx.lang.Rexx.toRexx(com.rvjansen.Datum.getDisplayTime(tDelta.tolong()));}

/**
 *   * Displays the difference in readable format
 *   */
@SuppressWarnings("unchecked")
public void sayDiff(){
this.st2=(int)(java.lang.System.currentTimeMillis());
netrexx.lang.RexxIO.Say(((((new netrexx.lang.Rexx(this.st2).OpSub(null,new netrexx.lang.Rexx(this.st1)).OpCcblank(null,netrexx.lang.Rexx.toRexx("millisecs ="))).OpCcblank(null,((new netrexx.lang.Rexx(this.st2).OpSub(null,new netrexx.lang.Rexx(this.st1)))).OpDiv(null,$02))).OpCcblank(null,$03)).OpCcblank(null,((new netrexx.lang.Rexx(this.st2).OpSub(null,new netrexx.lang.Rexx(this.st1)))).OpDiv(null,$04))).OpCcblank(null,$05));return;}

@SuppressWarnings("unchecked")
public void reset(){
this.st1=(int)(java.lang.System.currentTimeMillis());return;}public int getSt1(){return st1;}public void setSt1(int $1){st1=$1;return;}public int getSt2(){return st2;}public void setSt2(int $2){st2=$2;return;}}
