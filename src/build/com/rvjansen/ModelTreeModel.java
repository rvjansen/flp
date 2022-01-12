/* Generated from 'ModelTreeModel.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class ModelTreeModel implements... 
 * <BR>
 * Created on: zo, 13, okt 2013 18:18:31 +0200
 */
public class ModelTreeModel implements javax.swing.tree.TreeModel{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(0);private static final java.lang.String $0="ModelTreeModel.nrx";
/* properties private */
private com.rvjansen.KBClient client;
private java.util.TreeMap modelMap=new java.util.TreeMap();
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public ModelTreeModel(){super();
this.client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));return;} // defaults to localhost

@SuppressWarnings("unchecked")
public java.lang.Object getRoot(){com.rvjansen.ModelObject m;java.util.ArrayList a;
m=new com.rvjansen.ModelObject("\'8701860C-F92A-495B-A0BF-C76316DE647C\'","Object");
a=new java.util.ArrayList();
a.add((java.lang.Object)("dummy for treeroot"));
modelMap.put((java.lang.Object)m,(java.lang.Object)a);
return (java.lang.Object)m;}

@SuppressWarnings("unchecked")
public int getChildCount(java.lang.Object mob){java.util.ArrayList obArray=null;com.rvjansen.ModelObject m=null;java.util.ArrayList a=null;java.util.Iterator i=null;netrexx.lang.Rexx idd=null;com.rvjansen.ModelObject ob=null;java.util.ArrayList b=null;java.util.Iterator j=null;java.util.ArrayList c=null;java.util.Iterator k=null;
{try{
obArray=new java.util.ArrayList();
m=(com.rvjansen.ModelObject)mob;
{try{
a=client.getDescriptorsForID(m.getID());
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
idd=(netrexx.lang.Rexx)(i.next());
ob=new com.rvjansen.ModelObject(netrexx.lang.Rexx.toString(idd),netrexx.lang.Rexx.toString(netrexx.lang.Rexx.toRexx("is described by").OpCcblank(null,client.getNameForID(idd))));
obArray.add((java.lang.Object)ob);
}}}
catch (java.lang.NullPointerException $1){
a=new java.util.ArrayList();
}} // do
{try{
b=client.getSchemesForTaxon(m.getID());
j=b.iterator();
{for(;;){if(!(j.hasNext()))break;
idd=(netrexx.lang.Rexx)(j.next());
ob=new com.rvjansen.ModelObject(netrexx.lang.Rexx.toString(idd),netrexx.lang.Rexx.toString(netrexx.lang.Rexx.toRexx("is classified by").OpCcblank(null,client.getNameForID(idd))));
obArray.add((java.lang.Object)ob);
}}}
catch (java.lang.NullPointerException $2){
b=new java.util.ArrayList();
}} // do
{try{
c=client.getDomainsForScheme(m.getID());
k=c.iterator();
{for(;;){if(!(k.hasNext()))break;
idd=(netrexx.lang.Rexx)(k.next());
ob=new com.rvjansen.ModelObject(netrexx.lang.Rexx.toString(idd),netrexx.lang.Rexx.toString(client.getNameForID(idd)));
obArray.add((java.lang.Object)ob);
}}}
catch (java.lang.NullPointerException $3){
c=new java.util.ArrayList();
}} // do -- if do

modelMap.put((java.lang.Object)m,(java.lang.Object)obArray);
return new netrexx.lang.Rexx(a.size()).OpAdd(null,new netrexx.lang.Rexx(b.size())).OpAdd(null,new netrexx.lang.Rexx(c.size())).toint();}
catch (java.rmi.RemoteException $4){
netrexx.lang.RexxIO.Say("remoteexception in ModelTreeModel.getChildCount");
return 0;
}}} // do

@SuppressWarnings("unchecked")
public java.lang.Object getChild(java.lang.Object parent,int index){java.util.ArrayList rs;
rs=(java.util.ArrayList)(modelMap.get(parent));
return (java.lang.Object)((com.rvjansen.ModelObject)(rs.get(index)));}

@SuppressWarnings("unchecked")
public int getIndexOfChild(java.lang.Object parent,java.lang.Object child){com.rvjansen.ModelObject p;com.rvjansen.ModelObject c;java.util.ArrayList a;java.util.Iterator i;netrexx.lang.Rexx counter;com.rvjansen.ModelObject l=null;
p=(com.rvjansen.ModelObject)parent;
c=(com.rvjansen.ModelObject)child;
a=(java.util.ArrayList)(modelMap.get((java.lang.Object)p));
i=a.iterator();
counter=new netrexx.lang.Rexx((byte)0);
{for(;;){if(!(i.hasNext()))break;
l=(com.rvjansen.ModelObject)(i.next());
if (l.equals(c)) return counter.toint();
counter=counter.OpAdd(null,$01);
}}
return 0;}

@SuppressWarnings("unchecked")
public boolean isLeaf(java.lang.Object node){
return new netrexx.lang.Rexx(getChildCount(node)).OpEqS(null,$02);}

@SuppressWarnings("unchecked")
public void addTreeModelListener(javax.swing.event.TreeModelListener t){return;}

@SuppressWarnings("unchecked")
public void removeTreeModelListener(javax.swing.event.TreeModelListener t){return;}

@SuppressWarnings("unchecked")
public void valueForPathChanged(javax.swing.tree.TreePath path,java.lang.Object newValue){return;}

@SuppressWarnings("unchecked")
public boolean isTrue(netrexx.lang.Rexx req) throws java.rmi.RemoteException{java.util.ArrayList a;
a=client.request(req);
if (a==null) return false;
if (new netrexx.lang.Rexx(a.size()).OpEq(null,$01)) return true;
else return false;}}

