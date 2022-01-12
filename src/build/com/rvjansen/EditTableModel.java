/* Generated from 'EditTableModel.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class EditTableModel implements... 
 * <BR>
 * Created on: vr, 18, okt 2013 14:04:23 +0200
 */
public class EditTableModel extends javax.swing.table.AbstractTableModel{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(2);private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("cur(");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx(").");private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx('C');private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("aru(");private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx('A');private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("GS C");private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("GS A");private static final netrexx.lang.Rexx $011=new netrexx.lang.Rexx(3);private static final java.lang.String $0="EditTableModel.nrx";
/* properties private */
private com.rvjansen.PapWordsListModel p;
private com.rvjansen.GuiUtils ut;
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public EditTableModel(){super();
return;}

@SuppressWarnings("unchecked")
public EditTableModel(com.rvjansen.PapWordsListModel p_,com.rvjansen.GuiUtils ut_){super();
p=p_;
ut=ut_;return;}

@SuppressWarnings("unchecked")
public int getRowCount(){
return p.PapWords.size();}

@SuppressWarnings("unchecked")
public int getColumnCount(){
return 4;}

// method getColumnClass(column=int) returns Class
//   if column=3 then return JComboBox.class
//   return String.class

@SuppressWarnings("unchecked")
public java.lang.String getColumnName(int column){
{/*select*/
if (new netrexx.lang.Rexx(column).OpEq(null,$01))return "A/C";
else if (new netrexx.lang.Rexx(column).OpEq(null,$02))return "Official";
else if (new netrexx.lang.Rexx(column).OpEq(null,$03))return "Lemma";
else{
return "";}
}}

@SuppressWarnings("unchecked")
public java.lang.Object getValueAt(int row,int column){netrexx.lang.Rexx uid=null;netrexx.lang.Rexx rs=null;netrexx.lang.Rexx lemma=null;java.util.List a=null;
{try{
{/*select*/
if (new netrexx.lang.Rexx(column).OpEq(null,$01)){
uid=(netrexx.lang.Rexx)(p.PapWords.get(row));
uid=uid.reverse().left(new netrexx.lang.Rexx((byte)38)).reverse();
rs=netrexx.lang.Rexx.toRexx("");
if (ut.isTrue(($04.OpCc(null,uid)).OpCc(null,$05))) rs=rs.OpCc(null,$06);
if (ut.isTrue(($07.OpCc(null,uid)).OpCc(null,$05))) rs=rs.OpCc(null,$08);
return (java.lang.Object)rs;
} // when column
else if (new netrexx.lang.Rexx(column).OpEq(null,$02)){
uid=(netrexx.lang.Rexx)(p.PapWords.get(row));
uid=uid.reverse().left(new netrexx.lang.Rexx((byte)38)).reverse();
rs=netrexx.lang.Rexx.toRexx("");
if (ut.isTrue((netrexx.lang.Rexx.toRexx("cur_official(").OpCc(null,uid)).OpCc(null,$05))) rs=rs.OpCc(null,$09);
if (ut.isTrue((netrexx.lang.Rexx.toRexx("aru_official(").OpCc(null,uid)).OpCc(null,$05))) rs=rs.OpCc(null,$010);
return (java.lang.Object)rs;
}
else if (new netrexx.lang.Rexx(column).OpEq(null,$03)){
uid=(netrexx.lang.Rexx)(p.PapWords.get(row));
uid=uid.reverse().left(new netrexx.lang.Rexx((byte)38)).reverse();
lemma=(netrexx.lang.Rexx)(p.PapWords.get(row));
lemma=lemma.reverse().substr(new netrexx.lang.Rexx((byte)40)).reverse();
return (java.lang.Object)lemma;
}
else if (new netrexx.lang.Rexx(column).OpEq(null,$011)){
uid=(netrexx.lang.Rexx)(p.PapWords.get(row));
uid=uid.reverse().left(new netrexx.lang.Rexx((byte)38)).reverse();
a=ut.getDefinitionsForLemma((java.lang.Object)uid);
return (java.lang.Object)a;
}
else{
return new java.lang.Object();}
}} // select
catch (java.rmi.RemoteException $1){
return new java.lang.Object();
}}}}
