/* Generated from 'GuiUtils.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class GuiUtils implements... 
 * <BR>
 * Created on: vr, 11, okt 2013 21:42:20 +0200
 */
public class GuiUtils{private static final char[] $01={2,1,39,10,1,0,2,1,39,10,1,1,0};private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx('\'');private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx('\n');private static final java.lang.String $0="GuiUtils.nrx";
/* properties private */
private com.rvjansen.KBClient client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public GuiUtils(){super();return;}

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req) throws java.rmi.RemoteException{
return client.isTrue(req);}

@SuppressWarnings("unchecked")
public java.lang.String getDefinitionForLemma(java.lang.Object uid){netrexx.lang.Rexx rs;netrexx.lang.Rexx line=null;netrexx.lang.Rexx id=null;java.util.ArrayList a=null;java.util.Iterator j=null;netrexx.lang.Rexx def=null;
rs=netrexx.lang.Rexx.toRexx("");
{try{
line=netrexx.lang.Rexx.toRexx(uid.toString());
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$1);id=$1[1];}
id=($02.OpCc(null,id)).OpCc(null,$02);
a=client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,id)).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),def(Synset,Definition).")));
j=a.iterator();
{for(;;){if(!(j.hasNext()))break;
def=(netrexx.lang.Rexx)(j.next());
rs=(((def.getnode(netrexx.lang.Rexx.toRexx("Number")).leaf).OpCcblank(null,def.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf)).OpCcblank(null,def.getnode(netrexx.lang.Rexx.toRexx("Synset")).leaf)).OpCcblank(null,$03);
}}}
catch (java.rmi.RemoteException $2){
netrexx.lang.RexxIO.Say("exception in getDefinitionForLemma");
return "";
}} // do
return netrexx.lang.Rexx.toString(rs);}

@SuppressWarnings("unchecked")
public java.util.List getDefinitionsForLemma(java.lang.Object uid){java.util.ArrayList al;netrexx.lang.Rexx line=null;netrexx.lang.Rexx id=null;java.util.ArrayList a=null;java.util.Iterator j=null;netrexx.lang.Rexx def=null;
al=new java.util.ArrayList();
{try{
line=netrexx.lang.Rexx.toRexx(uid.toString());
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$3);id=$3[1];}
id=($02.OpCc(null,id)).OpCc(null,$02);
a=client.request((netrexx.lang.Rexx.toRexx("lemmasynset(").OpCc(null,id)).OpCc(null,netrexx.lang.Rexx.toRexx(",Number),synsetnumber(Synset,Number),def(Synset,Definition).")));
j=a.iterator();
{for(;;){if(!(j.hasNext()))break;
def=(netrexx.lang.Rexx)(j.next());
al.add((java.lang.Object)(def.getnode(netrexx.lang.Rexx.toRexx("Definition")).leaf.translate(netrexx.lang.Rexx.toRexx("  "),netrexx.lang.Rexx.toRexx("[]"))));
}}}
catch (java.rmi.RemoteException $4){
netrexx.lang.RexxIO.Say("exception in getDefinitionForLemma");
return (java.util.List)al;
}} // do
return (java.util.List)al;}

@SuppressWarnings("unchecked")
public void linkDefinitions(java.lang.Object pap,java.lang.String def){netrexx.lang.Rexx line=null;netrexx.lang.Rexx current_pap_uuid=null;netrexx.lang.Rexx defuuid=null;netrexx.lang.Rexx synsetnumber=null;com.rvjansen.Fact f=null;
{try{
line=netrexx.lang.Rexx.toRexx(pap.toString());
{netrexx.lang.Rexx $5[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$5);current_pap_uuid=$5[1];}
current_pap_uuid=($02.OpCc(null,current_pap_uuid)).OpCc(null,$02);
defuuid=new netrexx.lang.Rexx(def);
synsetnumber=defuuid.word(new netrexx.lang.Rexx((byte)1));
defuuid=defuuid.right(new netrexx.lang.Rexx((byte)40));
/* add synset number to lemma uuid */
f=new com.rvjansen.Fact(); // its synset
f.setPred(netrexx.lang.Rexx.toRexx("3B365C30-22FF-11E3-80E8-E0F847277696"));
f.setSubj(current_pap_uuid);
f.setObj(synsetnumber);
f.assertz((com.rvjansen.KBServerInterface)this.client);}
catch (java.rmi.RemoteException $6){
netrexx.lang.RexxIO.Say("exception in linkDefinitions");
}}return;} // do

@SuppressWarnings("unchecked")
public void setDefinitionsList(javax.swing.DefaultListModel j,java.lang.String uid){java.util.Iterator i;netrexx.lang.Rexx def=null;
uid=netrexx.lang.Rexx.toString((netrexx.lang.Rexx.toRexx(uid)).reverse().left(new netrexx.lang.Rexx((byte)38)).reverse());
i=getDefinitionsForLemma((java.lang.Object)uid).iterator();
{for(;;){if(!(i.hasNext()))break;
def=(netrexx.lang.Rexx)(i.next());
j.addElement((java.lang.Object)(def.toString()));
}}return;}}

