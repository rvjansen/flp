/* Generated from 'tree.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

//trace results
public class tree{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("--");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("Object");private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(2);private static final java.lang.String $0="tree.nrx";
/**
 * Prints the Tree starting from an arbitrary top level taxon
 * what is the strategy: start with X (Taxon ('8701860C-F92A-495B-A0BF-C76316DE647C'))
 * see what Y classifies X
 * for every Y : list its domains (none if it is no scheme)
 * see what classifies Y
 * recurse until model data exhausted.
 */
/* properties private */
private com.rvjansen.KBClient client;
private netrexx.lang.Rexx level=new netrexx.lang.Rexx((byte)1);

/**
 * Method treeTest is the constructor
 * @param id is a Rexx that indicates the top of the tree
 */
@SuppressWarnings("unchecked")
public tree(netrexx.lang.Rexx id) throws java.rmi.RemoteException{super();
this.client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx("")); // defaults to localhost
this.recurseThroughModel(id);return;}

/**
 * Method recurseThroughModel recurses through the model data
 * @param id is a Rexx that contains the uuid of the taxon to be processed
 */
@SuppressWarnings("unchecked")
public void recurseThroughModel(netrexx.lang.Rexx id) throws java.rmi.RemoteException{java.util.ArrayList b;java.util.Iterator j;netrexx.lang.Rexx idd=null;java.util.ArrayList a;java.util.Iterator i;
netrexx.lang.RexxIO.Say((($01.copies(this.level).OpCcblank(null,id)).OpCcblank(null,$02)).OpCcblank(null,client.getNameForID(id)));
b=client.getDescriptorsForID(id);
j=b.iterator();
{for(;;){if(!(j.hasNext()))break;
idd=(netrexx.lang.Rexx)(j.next());
netrexx.lang.RexxIO.Say((($01.copies(this.level).OpCcblank(null,idd)).OpCcblank(null,netrexx.lang.Rexx.toRexx("is described by"))).OpCcblank(null,client.getNameForID(idd)));
}}
a=client.getSchemesForTaxon(id);
i=a.iterator();
{for(;;){if(!(i.hasNext()))break;
id=(netrexx.lang.Rexx)(i.next());
netrexx.lang.RexxIO.Say((($01.copies(this.level).OpCcblank(null,id)).OpCcblank(null,netrexx.lang.Rexx.toRexx("is classified by"))).OpCcblank(null,client.getNameForID(id)));
b=client.getDomainsForScheme(id);
j=b.iterator();
{for(;;){if(!(j.hasNext()))break;
id=(netrexx.lang.Rexx)(j.next());
//	say id "Domain" client.getNameForID(id)
this.level=this.level.OpAdd(null,$03);
recurseThroughModel(id);
this.level=this.level.OpSub(null,$03);
}}
}}return;} // loop while i

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException{
new com.rvjansen.tree(netrexx.lang.Rexx.toRexx("8701860C-F92A-495B-A0BF-C76316DE647C"));return;}} // taxon
