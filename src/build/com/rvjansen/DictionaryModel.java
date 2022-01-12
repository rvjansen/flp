/* Generated from 'DictionaryModel.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;
/**
 * Class DictionaryModel implements the repository model for a dictionary
 * <BR>
 * Created on: wo, 11, sep 2013 19:54:43 +0200
 */
public class DictionaryModel extends com.rvjansen.Bint{private static final java.lang.String $0="DictionaryModel.nrx";

/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public DictionaryModel() throws java.rmi.RemoteException{super();netrexx.lang.Rexx scopeUUID;netrexx.lang.Rexx classification_uuid;netrexx.lang.Rexx domains;netrexx.lang.Rexx lemma_uuid;netrexx.lang.Rexx verb_uuid;netrexx.lang.Rexx noun_uuid;netrexx.lang.Rexx pap_uuid;
// add the scope for the dictionary
scopeUUID=this.addScope(netrexx.lang.Rexx.toRexx("Dictionary"));
classification_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("Classification"));

// add the subtypes of Classification
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("SynSet: a synonym set, the meaning of a word");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("Lemma: a word as represented in a Dictionary");
// add the scheme
this.addScheme(classification_uuid,netrexx.lang.Rexx.toRexx("Classification Type"),domains,scopeUUID);

// add schemes to lemma
lemma_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("Lemma"));

// add the synset descriptor
addDescriptor(lemma_uuid,netrexx.lang.Rexx.toRexx("synset number"),scopeUUID);

// parts of speech
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("noun:Nouns are a part of speech typically denoting a person, place, thing, animal or idea. In linguistics, a noun is a member of a large, open lexical category whose members can occur as the main word in the subject of a clause, the object of a verb, or the object of a preposition.");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("verb:A verb is a word (part of speech) that in syntax conveys an action (bring, read, walk, run, learn), an occurrence (happen, become), or a state of being (be, exist, stand). In the usual description of English, the basic form, with or without the particle to, is the infinitive.");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("adjective:an adjective is a describing word; the main syntactic role of which is to qualify a noun or noun phrase, giving more information about the object signified");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("adverb:typically modify verbs (or verb phrases), adjectives (or adjectival phrases), or other adverbs (or adverbial phrases). However, adverbs also sometimes qualify noun phrases (only the boss; quite a lovely place); pronouns and determiners (almost all); prepositional phrases (halfway through the movie); or whole sentences, to provide contextual comment or indicate an attitude");
domains.getnode(new netrexx.lang.Rexx((byte)5)).leaf=netrexx.lang.Rexx.toRexx("pronoun:a pronoun is a word or form that substitutes for a noun or noun phrase");
domains.getnode(new netrexx.lang.Rexx((byte)6)).leaf=netrexx.lang.Rexx.toRexx("preposition:Prepositions (or more generally adpositions, see below) are a grammatically distinct class of words whose most central members characteristically express spatial or temporal relations (such as the English words in, under, toward, before) or serve to mark various syntactic functions and semantic roles (such as the English words of, for).");
domains.getnode(new netrexx.lang.Rexx((byte)7)).leaf=netrexx.lang.Rexx.toRexx("conjunction:connects two words, sentences, phrases or clauses. A discourse connective is a conjunction joining sentences. This definition may overlap with that of other parts of speech, so what constitutes a \"conjunction\" must be defined for each language. In general, a conjunction is an invariable grammatical particle, and it may or may not stand between the items it conjoins.");
domains.getnode(new netrexx.lang.Rexx((byte)8)).leaf=netrexx.lang.Rexx.toRexx("interjection:an interjection or exclamation may be a word used to express an emotion or sentiment on the part of the speaker (although most interjections have clear definitions). Filled pauses such as uh, er, um are also considered interjections. Interjections are often placed at the beginning of a sentence.");
domains.getnode(new netrexx.lang.Rexx((byte)9)).leaf=netrexx.lang.Rexx.toRexx("article:The articles in English are the definite article the and the indefinite articles a and an (and sometimes some). Use of the definite article implies that the speaker assumes the listener knows the identity of the referent (because it is obvious, because it is common knowledge, or because it was mentioned in the same sentence or an earlier sentence). Use of an indefinite article implies that the speaker assumes the listener does not have to know the identity of the referent. In some noun phrases no article is used.");
this.addScheme(lemma_uuid,netrexx.lang.Rexx.toRexx("Parts of Speech"),domains,scopeUUID);

// add verb type
verb_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("verb"));
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("intransitive:");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("linking:");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("transitive:");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("to be verb:");
this.addScheme(verb_uuid,netrexx.lang.Rexx.toRexx("Verb Type"),domains,scopeUUID);

// add noun type
noun_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("noun"));
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("proper noun:");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("common noun:");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("collective noun:");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("countable noun:");
domains.getnode(new netrexx.lang.Rexx((byte)5)).leaf=netrexx.lang.Rexx.toRexx("uncountable noun:");
domains.getnode(new netrexx.lang.Rexx((byte)6)).leaf=netrexx.lang.Rexx.toRexx("concrete noun:");
domains.getnode(new netrexx.lang.Rexx((byte)7)).leaf=netrexx.lang.Rexx.toRexx("abstract noun:");
this.addScheme(noun_uuid,netrexx.lang.Rexx.toRexx("Noun Type"),domains,scopeUUID);

// gender classifies noun
noun_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("noun"));
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("masculin:");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("feminin:");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("neuter:");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("animate:");
domains.getnode(new netrexx.lang.Rexx((byte)5)).leaf=netrexx.lang.Rexx.toRexx("inanimate:");
this.addScheme(noun_uuid,netrexx.lang.Rexx.toRexx("Noun Gender"),domains,scopeUUID);


// language - follows iso 639-3
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("als:albanian");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("cat:catalunyan");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("cmn:chinese");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("dan:danish");
domains.getnode(new netrexx.lang.Rexx((byte)5)).leaf=netrexx.lang.Rexx.toRexx("eng:english");
domains.getnode(new netrexx.lang.Rexx((byte)6)).leaf=netrexx.lang.Rexx.toRexx("eus:basque");
domains.getnode(new netrexx.lang.Rexx((byte)7)).leaf=netrexx.lang.Rexx.toRexx("fas:farsi");
domains.getnode(new netrexx.lang.Rexx((byte)8)).leaf=netrexx.lang.Rexx.toRexx("fin:finnish");
domains.getnode(new netrexx.lang.Rexx((byte)9)).leaf=netrexx.lang.Rexx.toRexx("fra:french");
domains.getnode(new netrexx.lang.Rexx((byte)10)).leaf=netrexx.lang.Rexx.toRexx("glg:galician");
domains.getnode(new netrexx.lang.Rexx((byte)11)).leaf=netrexx.lang.Rexx.toRexx("heb:hebrew");
domains.getnode(new netrexx.lang.Rexx((byte)12)).leaf=netrexx.lang.Rexx.toRexx("ind:bahasa indonesian");
domains.getnode(new netrexx.lang.Rexx((byte)13)).leaf=netrexx.lang.Rexx.toRexx("ita:italian");
domains.getnode(new netrexx.lang.Rexx((byte)14)).leaf=netrexx.lang.Rexx.toRexx("jpn:japan");
domains.getnode(new netrexx.lang.Rexx((byte)15)).leaf=netrexx.lang.Rexx.toRexx("nno:norwegian nynorsk");
domains.getnode(new netrexx.lang.Rexx((byte)16)).leaf=netrexx.lang.Rexx.toRexx("nob:norwegian bokm\u00E5l");
domains.getnode(new netrexx.lang.Rexx((byte)17)).leaf=netrexx.lang.Rexx.toRexx("pol:polish");
domains.getnode(new netrexx.lang.Rexx((byte)18)).leaf=netrexx.lang.Rexx.toRexx("por:portuguese");
domains.getnode(new netrexx.lang.Rexx((byte)19)).leaf=netrexx.lang.Rexx.toRexx("spa:spanish");
domains.getnode(new netrexx.lang.Rexx((byte)20)).leaf=netrexx.lang.Rexx.toRexx("tha:thai");
domains.getnode(new netrexx.lang.Rexx((byte)21)).leaf=netrexx.lang.Rexx.toRexx("zsm:standard malay");
domains.getnode(new netrexx.lang.Rexx((byte)22)).leaf=netrexx.lang.Rexx.toRexx("pap:papiamento");
this.addScheme(lemma_uuid,netrexx.lang.Rexx.toRexx("Language Name"),domains,scopeUUID);

// abc variant classifies papiamento
pap_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("pap"));
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("Aruba variant:Aruba usage");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("Bonaire variant:Boneiru usage");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("Cura\u00E7ao variant:Korsou usage");
this.addScheme(pap_uuid,netrexx.lang.Rexx.toRexx("Papiamento local variant"),domains,scopeUUID);

// official variant classifies papiamento
pap_uuid=this.client.getIDForName(netrexx.lang.Rexx.toRexx("pap"));
domains=netrexx.lang.Rexx.toRexx("");
domains.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx("Aruba Official Spelling:The official spelling of Aruba Papiamento following the governmental list");
domains.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx("Bonaire Official Spelling:The official spelling of Antillean Papiamen following the lista FPI");
domains.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx("Cura\u00E7ao Official Spelling:The official spelling of Antillean Papiamentu following the lista FPI");
domains.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx("Proposed Merged Spelling:An unofficial attempt to merge the divergent orthographies");

this.addScheme(pap_uuid,netrexx.lang.Rexx.toRexx("Papiamento Official Spelling"),domains,scopeUUID);return;}

// this.client.checkpoint()

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.rmi.RemoteException{
new com.rvjansen.DictionaryModel();return;}}


