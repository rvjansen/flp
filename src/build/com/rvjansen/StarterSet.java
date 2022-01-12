/* Generated from 'StarterSet.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class StarterSet writes the metamodel starterset to a file
 * <BR>
 * Created on: di, 10, sep 2013 14:00:10 +0200
 */
public class StarterSet extends com.rvjansen.Bint{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("\t\'");private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("\'(X,Y).");private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("\tob(X,\'");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("\').");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("\'(X,Z).");private static final java.lang.String $0="StarterSet.nrx";

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public StarterSet() throws java.io.IOException,java.rmi.RemoteException{super();java.io.PrintWriter code;com.rvjansen.Fact f;netrexx.lang.Rexx domains;java.lang.String metadata_scope;

// we write a related code file and add object to the online repository
code=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter("code.prolog")))));

// the top of the ontology
// 'object object is of type object'
code.println("% ob/2 finds everything that is an object, regardless (not constrained to) of type");
code.println("% it returns the Object UUID and the Object Type UUID");
code.println("ob(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.ob_uuid)).OpCc(null,$02)));
code.println("");

// add 'object'
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(this.ob_uuid);
f.setObj(this.ob_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add descriptor relationships
// primary name
f=new com.rvjansen.Fact();
f.setPred(this.descriptor);
f.setSubj(this.nm_uuid);
f.setObj(this.ob_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// primary english name of primary name
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.nm_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("primary name"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// primary english name of object instance
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.ob_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("Object"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// abbr
f=new com.rvjansen.Fact();
f.setPred(this.descriptor);
f.setSubj(this.abbr_uuid);
f.setObj(this.ob_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// primary english name of abbr
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.abbr_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("abbreviated name"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// english def
f=new com.rvjansen.Fact();
f.setPred(this.descriptor);
f.setSubj(this.def_uuid);
f.setObj(this.ob_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// primary english name of def
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.def_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("definition"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// generate prolog shortcut
code.println("nm(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.nm_uuid)).OpCc(null,$02)));

// generate prolog shortcut
code.println("abbr(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.abbr_uuid)).OpCc(null,$02)));

// generate prolog shortcut
code.println("def(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.def_uuid)).OpCc(null,$02)));

// generate prolog shortcut
code.println("%descriptor describes object");
code.println("desc(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.descriptor)).OpCc(null,$02)));

// add 'scheme'
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(this.scheme_uuid);
f.setObj(this.scheme_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add name of scheme scheme
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.scheme_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("Scheme"));
f.assertz((com.rvjansen.KBServerInterface)this.client);


// the prolog code for the cl predicate
code.println("% classifies: classifier classified");
code.println("% classification classifies object");
code.println("cl(X,Y) :-");
code.println((java.lang.Object)(($01.OpCc(null,this.cl_uuid)).OpCc(null,$02)));
code.println("");

// the prolog code for the scheme predicate
code.println("% classification classifies object");
code.println("scheme(X) :-");
code.println((java.lang.Object)(($03.OpCc(null,this.scheme_uuid)).OpCc(null,$04)));
code.println("");

// the prolog code for the domain predicate
code.println("% domain/2 is used to find the domains of a scheme -> domain(X,UUID)");
code.println("% also, finds the scheme of a domain -> domain(UUID,Y)");
code.println("domain(X,Z) :-");
code.println((java.lang.Object)((netrexx.lang.Rexx.toRexx("\tscheme(Z),\'").OpCc(null,this.domain_uuid)).OpCc(null,$05)));
code.println("");

// the prolog code for the supertype predicate
code.println("% supertp/3 finds the super type(s) of a concept. it does this by");
code.println("% finding the subject type(s) of the partitioning relationship type(s)");
code.println("supertp(X,Y,Z) :-");
code.println("\tdomain(X,Y),cl(Y,Z).");
code.println("");

// the prolog code for the attributes (attrs) predicate
code.println("% attrs/4 is a shortcut to get to the local classification relationships/attributes of a type");
code.println("% (the type needs to go in X)");
code.println("attrs(N,X,Y,Z) :-");
code.println("\tnm(X,N),cl(Y,X),nm(Y,Z).");

// scheme primary object type
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("Involved Party:A party involved in a process");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("Classification:The reduction of a range to known items");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("Resource Item:A general resource used in a process");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("Location:A specific place in space");
domains.getnode(new netrexx.lang.Rexx((byte)5)).leaf=netrexx.lang.Rexx.toRexx("Event:A specific point in time");
domains.getnode(new netrexx.lang.Rexx((byte)6)).leaf=netrexx.lang.Rexx.toRexx("Arrangement:A contract executed between involved parties");
domains.getnode(new netrexx.lang.Rexx((byte)7)).leaf=netrexx.lang.Rexx.toRexx("Condition:A condition to an Arrangement");

// scope contains object relationship
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(this.scope_uuid);
f.setObj(this.scope_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// name of scope contains object relationship
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(this.scope_uuid);
f.setObj(netrexx.lang.Rexx.toRexx("Scope contains Object"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// metadata scope object
metadata_scope=newUUID();
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(metadata_scope));
f.setObj(this.scope_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// metadata scope object name
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(metadata_scope));
f.setObj(netrexx.lang.Rexx.toRexx("Metamodel Scope"));
f.assertz((com.rvjansen.KBServerInterface)this.client);

addScheme(this.ob_uuid,netrexx.lang.Rexx.toRexx("Primary Ontology Type"),domains,netrexx.lang.Rexx.toRexx(metadata_scope));
code.close();

// add scheme source system
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("metamodel:The model of the model");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("(multi-) wordnet:The semantically interlinked dictionary from Princeton");
addScheme(this.ob_uuid,netrexx.lang.Rexx.toRexx("Source System"),domains,netrexx.lang.Rexx.toRexx(metadata_scope));

// add scheme source file
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("metamodel - starterset");

addScheme(this.ob_uuid,netrexx.lang.Rexx.toRexx("Source System"),domains,netrexx.lang.Rexx.toRexx(metadata_scope));return;}

// this.client.checkpoint()


@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.io.IOException,java.rmi.RemoteException{
new com.rvjansen.StarterSet();return;}}
