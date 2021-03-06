/* Generated from 'Bint.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;import com.eaio.uuid.UUID;

/**
 * Class Bint implements the Batch Interface for Knowledge Base Operations
 * Its naming is a tip of the hat to the previous Bint DSL
 * Created on: wo, 11, sep 2013 18:29:12 +0200
 */
public class Bint{private static final char[] $01={2,1,58,10,1,0,1,10,1,1,0};private static final java.lang.String $0="Bint.nrx";

/* properties inheritable */
protected com.rvjansen.KBClient client;
// for historical reasons, use these uuids
// new set can be generated by replacing these with newUUID()
protected netrexx.lang.Rexx ob_uuid=netrexx.lang.Rexx.toRexx("8701860C-F92A-495B-A0BF-C76316DE647C");
protected netrexx.lang.Rexx nm_uuid=netrexx.lang.Rexx.toRexx("ADFD9D7F-A05F-4DB3-8B40-C7813D3900DC");
protected netrexx.lang.Rexx abbr_uuid=netrexx.lang.Rexx.toRexx("1117CCE0-1A5D-11E3-8B81-0A0027000000");
protected netrexx.lang.Rexx def_uuid=netrexx.lang.Rexx.toRexx("2120B840-1A5D-11E3-9BFD-0A0027000000");
protected netrexx.lang.Rexx cl_uuid=netrexx.lang.Rexx.toRexx("9A2CD86A-FF9F-415C-9DED-1D86CB6710E9");
protected netrexx.lang.Rexx scheme_uuid=netrexx.lang.Rexx.toRexx("E138A197-7645-4B90-A6EB-B9C61DBA08D1");
protected netrexx.lang.Rexx domain_uuid=netrexx.lang.Rexx.toRexx("400B08AB-786D-45D4-AFD7-34933CA6131F");
protected netrexx.lang.Rexx descriptor=netrexx.lang.Rexx.toRexx("89184770-1A5C-11E3-9DFC-0A0027000000");
protected netrexx.lang.Rexx scope_uuid=netrexx.lang.Rexx.toRexx("A912E940-1AF7-11E3-96BD-0A0027000000");

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public Bint(){super();
this.client=new com.rvjansen.KBClient(netrexx.lang.Rexx.toRexx(""));return;} // defaults to localhost

/**
 * Method addScope adds a Scope Object to the repository
 * @param scopeName_ is a Rexx containing the name of the scope
 * @returns the UUID of the new Scope 
 */
@SuppressWarnings("unchecked")
public netrexx.lang.Rexx addScope(netrexx.lang.Rexx scopeName_) throws java.rmi.RemoteException{java.lang.String new_scope_uuid;com.rvjansen.Fact f;
// scope object
new_scope_uuid=newUUID();
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scope_uuid));
f.setObj(this.scope_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// scope object name
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scope_uuid));
f.setObj(scopeName_);
f.assertz((com.rvjansen.KBServerInterface)this.client);

return netrexx.lang.Rexx.toRexx(new_scope_uuid);}


@SuppressWarnings("unchecked")
public void addObject(netrexx.lang.Rexx objectType_,netrexx.lang.Rexx objectName_,netrexx.lang.Rexx scope_){return;}

// add the object and its type

// add it to the scope

// add its primary name

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx addDescriptor(netrexx.lang.Rexx object_,netrexx.lang.Rexx descriptor_name,netrexx.lang.Rexx scope_) throws java.rmi.RemoteException{java.lang.String n;com.rvjansen.Fact f;
n=newUUID();

// add the descriptor object
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(this.descriptor);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add the descriptor name
f=new com.rvjansen.Fact();
f.setPred(this.nm_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(descriptor_name);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add the descriptor to the object
f=new com.rvjansen.Fact();
f.setPred(this.descriptor);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(object_);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add to scope
f=new com.rvjansen.Fact(); // scope includes descriptor
f.setPred(this.scope_uuid);
f.setSubj(scope_); // scope
f.setObj(netrexx.lang.Rexx.toRexx(n)); // descriptor
f.assertz((com.rvjansen.KBServerInterface)this.client);

return netrexx.lang.Rexx.toRexx(n);}


/**
 * Method addScheme adds a scheme to a classification including domain values
 * @param ob is a Rexx representing the id of the object being classified
 * @param schemeName is a Rexx representing the name of the new scheme
 * @param domains is a Rexx array which contains the names of the domains of the scheme
 * @param scope is a Rexx 
 */
@SuppressWarnings("unchecked")
public void addScheme(netrexx.lang.Rexx ob,netrexx.lang.Rexx schemeName,netrexx.lang.Rexx domains,netrexx.lang.Rexx scope) throws java.rmi.RemoteException{java.lang.String new_scheme_uuid;com.rvjansen.Fact f;netrexx.lang.Rexx i=null;netrexx.lang.Rexx desc=null;netrexx.lang.Rexx nm=null;netrexx.lang.Rexx def=null;

// add a scheme object of type scheme
new_scheme_uuid=newUUID(); // the uuid of the scheme instance 

f=new com.rvjansen.Fact(); // the scheme 
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scheme_uuid));
f.setObj(this.scheme_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // add its primary name
f.setPred(this.nm_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scheme_uuid));
f.setObj(schemeName);
f.assertz((com.rvjansen.KBServerInterface)this.client);

f=new com.rvjansen.Fact(); // add it to the scope -- scope includes scheme
f.setPred(this.scope_uuid);
f.setSubj(scope);
f.setObj(netrexx.lang.Rexx.toRexx(new_scheme_uuid));
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add classification relationship scheme classifies object
f=new com.rvjansen.Fact();
f.setPred(this.cl_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scheme_uuid)); // scheme
f.setObj(ob); // classifies object
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add the classification relationship object
// for if ever we need a relationship to it
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(new_scheme_uuid)); // instance
f.setObj(this.cl_uuid); // classification relationship type
f.assertz((com.rvjansen.KBServerInterface)this.client);

{int $3=0;java.util.Vector $2=new java.util.Vector(100,0);synchronized(domains){java.util.Enumeration $1=domains.keys();for(;;){if(!$1.hasMoreElements())break;$2.addElement($1.nextElement());if(!domains.testnode((netrexx.lang.Rexx)($2.elementAt($3)))){$2.removeElementAt($3);continue;}$3++;}}i:for(;;){if(--$3<0)break;i=(netrexx.lang.Rexx)$2.elementAt($3);
desc=domains.getnode(i).leaf;
{netrexx.lang.Rexx $4[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(desc,$01,$4);nm=$4[0];def=$4[1];}
this.addDomainToScheme(netrexx.lang.Rexx.toRexx(new_scheme_uuid),nm,def,scope);
}}/*i*/return;}

/**
 * Method addDomainToScheme adds a Domain value to a Scheme
 * @param domainName_ is a Rexx
 * @param domainName_ is a Rexx
 * @param scope_ is a Rexx
 */
@SuppressWarnings("unchecked")
public void addDomainToScheme(netrexx.lang.Rexx scheme_,netrexx.lang.Rexx domainName_,netrexx.lang.Rexx def_,netrexx.lang.Rexx scope_) throws java.rmi.RemoteException{java.lang.String n;com.rvjansen.Fact f;
n=newUUID();

// the object is type domain object
f=new com.rvjansen.Fact();
f.setPred(this.ob_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(this.domain_uuid);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// the domain is domain in scheme relationship
f=new com.rvjansen.Fact();
f.setPred(this.domain_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(scheme_);
f.assertz((com.rvjansen.KBServerInterface)this.client);

//its name
f=new com.rvjansen.Fact(); // add its primary name
f.setPred(nm_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(domainName_);
f.assertz((com.rvjansen.KBServerInterface)this.client);

//its abbreviated name
f=new com.rvjansen.Fact(); // add its primary name
f.setPred(abbr_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(netrexx.lang.Rexx.toRexx(com.rvjansen.Abbreviations.abbreviate(netrexx.lang.Rexx.toString(domainName_))));
f.assertz((com.rvjansen.KBServerInterface)this.client);

//its definition
f=new com.rvjansen.Fact();
f.setPred(def_uuid);
f.setSubj(netrexx.lang.Rexx.toRexx(n));
f.setObj(def_);
f.assertz((com.rvjansen.KBServerInterface)this.client);

// add to scope
f=new com.rvjansen.Fact(); // scope includes domain
f.setPred(this.scope_uuid);
f.setSubj(scope_);
f.setObj(netrexx.lang.Rexx.toRexx(n));
f.assertz((com.rvjansen.KBServerInterface)this.client);return;}

/**
 * Method newUUID constructs a new UUID
 * @return String containing ...
 */
@SuppressWarnings("unchecked")
public static java.lang.String newUUID(){
return (new UUID()).toString().toUpperCase();}}


