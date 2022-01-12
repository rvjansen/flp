/* Generated from 'InsertPredicates.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


/**
 *  class InsertPredicates takes the predicates from a file and
 *  inserts them into the database table predicate
 */
public class InsertPredicates{private static final char[] $01={1,10,1,0,0};private static final java.lang.String $0="InsertPredicates.nrx";private static final char[] $02={2,1,40,10,1,0,2,1,44,10,1,1,1,10,1,2,0};

/* properties inheritable */
protected com.rvjansen.DBAccess d;
protected java.sql.PreparedStatement istmt;

/**
 * Method InsertPredicates ...
 */
@SuppressWarnings("unchecked")
public InsertPredicates(netrexx.lang.Rexx fileName) throws java.lang.ClassNotFoundException{super();
netrexx.lang.RexxIO.Say(fileName);
d=com.rvjansen.DBAccess.getInstance();
istmt=d.prepareInsertStatement();
(new netrexx.lang.RexxIO()).File(fileName).forEachline((netrexx.lang.LineHandler)(this.new handler()));
d.closeInsertStatement(istmt);return;}

/**
 * Method main instantiates the object
 * @param args is a String[]
 */
@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.lang.ClassNotFoundException{netrexx.lang.Rexx fileName=null;
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[1];netrexx.lang.RexxParse.parse(netrexx.lang.Rexx.toRexx(args[0]),$01,$1);fileName=$1[0];}
new com.rvjansen.InsertPredicates(fileName);return;}

class handler implements netrexx.lang.LineHandler{private final transient java.lang.String $0="InsertPredicates.nrx";
@SuppressWarnings("unchecked")
public void handle(netrexx.lang.Rexx in){netrexx.lang.Rexx predicate=null;netrexx.lang.Rexx subject=null;netrexx.lang.Rexx object=null;
if ((in.left(new netrexx.lang.Rexx((byte)11))).OpEqS(null,netrexx.lang.Rexx.toRexx(":- dynamic\'"))) return;
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(in,$02,$1);predicate=$1[0];subject=$1[1];object=$1[2];}
InsertPredicates.this.d.insertLine(InsertPredicates.this.istmt,predicate,subject,object);return;}public handler(){return;}}}



