/* Generated from 'DefinitionListModel.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


public class DefinitionListModel extends javax.swing.AbstractListModel implements javax.swing.ComboBoxModel{private static final char[] $01={2,1,39,10,1,0,2,1,39,10,1,1,0};private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx('\'');private static final java.lang.String $0="DefinitionListModel.nrx";

/* properties public */
public java.util.ArrayList DefinitionWords=new java.util.ArrayList();
public java.lang.String selection;

/* properties private */
private com.rvjansen.KBClient client;

@SuppressWarnings("unchecked")
public DefinitionListModel(){super();
client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));return;}

@SuppressWarnings("unchecked")
public java.lang.Object getElementAt(int index){
return DefinitionWords.get(index);}

@SuppressWarnings("unchecked")
public int getSize(){
return DefinitionWords.size();}

@SuppressWarnings("unchecked")
public void setSelectedItem(java.lang.Object anItem){
selection=netrexx.lang.Rexx.toString((netrexx.lang.Rexx)anItem);return;} //to select and register an item from the pull down list

// Methods implemented from the interface ComboBoxModel
@SuppressWarnings("unchecked")
public java.lang.Object getSelectedItem(){
return (java.lang.Object)selection;} // to add the selection to the combo box

@SuppressWarnings("unchecked")
public void setDefinitions(java.lang.Object uid){netrexx.lang.Rexx line=null;netrexx.lang.Rexx id=null;java.util.ArrayList a=null;java.util.Iterator j=null;netrexx.lang.Rexx def=null;
this.DefinitionWords.clear();
{try{
line=netrexx.lang.Rexx.toRexx(uid.toString());
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$1);id=$1[1];}
id=($02.OpCc(null,id)).OpCc(null,$02);
a=client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,id)).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),def(Synset,Definition).")));
j=a.iterator();
{for(;;){if(!(j.hasNext()))break;
def=(netrexx.lang.Rexx)(j.next());
this.DefinitionWords.add((java.lang.Object)((def.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf).OpCcblank(null,def.getnode(netrexx.lang.Rexx.toRexx("Synset")).leaf)));
}}}
catch (java.rmi.RemoteException $2){
netrexx.lang.RexxIO.Say("exception in setDefinitions");
}}return;}} // do

