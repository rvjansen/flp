/* Generated from 'PapWordsListModel.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


public class PapWordsListModel extends javax.swing.AbstractListModel implements javax.swing.ComboBoxModel{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(1);private static final java.lang.String $0="PapWordsListModel.nrx";

/* properties public */
public java.util.ArrayList PapWords=new java.util.ArrayList();
public java.lang.String selection;

@SuppressWarnings("unchecked")
public PapWordsListModel(){super();com.rvjansen.KBClient client=null;java.util.Iterator i=null;netrexx.lang.Rexx w=null;
{try{
client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));
i=client.request(netrexx.lang.Rexx.toRexx("pap(X),nm(X,Y).")).iterator();
{for(;;){if(!(i.hasNext()))break;
w=(netrexx.lang.Rexx)(i.next());
PapWords.add((java.lang.Object)((w.getnode(new netrexx.lang.Rexx('Y')).leaf.strip(new netrexx.lang.Rexx('b'),new netrexx.lang.Rexx('\''))).OpCcblank(null,w.getnode(new netrexx.lang.Rexx('X')).leaf)));
}}}
catch (java.rmi.RemoteException $1){
{System.exit(0);return;}
}}
java.util.Collections.sort((java.util.List)PapWords);return;}

@SuppressWarnings("unchecked")
public java.lang.Object getElementAt(int index){
return PapWords.get(index);}

@SuppressWarnings("unchecked")
public int getSize(){
return PapWords.size();}

@SuppressWarnings("unchecked")
public void setSelectedItem(java.lang.Object anItem){
selection=netrexx.lang.Rexx.toString((netrexx.lang.Rexx)anItem);return;} //to select and register an item from the pull down list

// Methods implemented from the interface ComboBoxModel
@SuppressWarnings("unchecked")
public java.lang.Object getSelectedItem(){
return (java.lang.Object)selection;} // to add the selection to the combo box

@SuppressWarnings("unchecked")
public int lookup(java.lang.String s){netrexx.lang.Rexx sr;netrexx.lang.Rexx count;java.util.Iterator i;netrexx.lang.Rexx r=null;
sr=netrexx.lang.Rexx.toRexx(s);
count=new netrexx.lang.Rexx((byte)0);
i=PapWords.iterator();
{for(;;){if(!(i.hasNext()))break;
r=(netrexx.lang.Rexx)(i.next());
if ((r.left(new netrexx.lang.Rexx(s.length()))).OpEq(null,netrexx.lang.Rexx.toRexx(s))) {
return count.toint();
}
count=count.OpAdd(null,$01);
}} // loop while i
return 0;}}
