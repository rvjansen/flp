/* Generated from 'readSynsets.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class readSynsets stores the synsets and their english definitions in the knowledgebase
 * <BR>
 * Created on: zo, 22, sep 2013 19:29:05 +0200
 */
public class readSynsets extends com.rvjansen.Bint{private static final char[] $01={2,2,103,40,2,1,44,10,1,0,2,2,41,46,10,1,1,0};private static final java.lang.String $0="readSynsets.nrx";

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public readSynsets() throws java.rmi.RemoteException,java.io.FileNotFoundException,java.io.IOException{super();netrexx.lang.Rexx synset_uuid;netrexx.lang.Rexx scopeUUID;netrexx.lang.Rexx hasSynSet;java.io.BufferedReader in;netrexx.lang.Rexx line;netrexx.lang.Rexx id=null;netrexx.lang.Rexx def=null;java.lang.String n=null;com.rvjansen.Fact f=null;

synset_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("SynSet"));
scopeUUID=this.client.getIDForName(netrexx.lang.Rexx.toRexx("Dictionary"));
hasSynSet=this.addDescriptor(synset_uuid,netrexx.lang.Rexx.toRexx("synset number"),scopeUUID);

in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("../files/sources/wn_g.pl")));
line=netrexx.lang.Rexx.toRexx("");
{$1:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $1;
{netrexx.lang.Rexx $2[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$2);id=$2[0];def=$2[1];}
n=newUUID();

def=def.translate(new netrexx.lang.Rexx('\u2019'),new netrexx.lang.Rexx('\''));

// add the synset object
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(synset_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add its wordnet synset number
f=new com.rvjansen.Fact();
f.setPred(hasSynSet);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(id);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add its english definition
f=new com.rvjansen.Fact();
f.setPred(this.def_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(def);
f.assertz((com.rvjansen.KBServerInterface)this.client);


}}


return;}



@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException,java.io.FileNotFoundException,java.io.IOException{
new com.rvjansen.readSynsets();return;}}

