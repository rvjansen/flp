/* Generated from 'Abbreviations.nrx' 7 Jan 2022 20:35:36 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;

public class Abbreviations{private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx((byte)1);private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("ING");private static final netrexx.lang.Rexx $05=new netrexx.lang.Rexx(3);private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx('G');private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("ED");private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx(2);private static final netrexx.lang.Rexx $09=new netrexx.lang.Rexx('0');private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("");private static final java.lang.String $0="Abbreviations.nrx";
/* properties private static */
// elements are String[2] with two elements. First element is the
// full name, second element is the abbreviation.
private static java.util.ArrayList abbreviationsList=new java.util.ArrayList();

/**
 * Default Constructor. Please note that before Abbreviations can
 * use the list of default abbreviations, they have to be set with
 * setAbbreviationsList. Normally, this initialization is done by
 * the BProcess constructor.
 */
@SuppressWarnings("unchecked")
public Abbreviations(){super();
return;}

/**
 * Returns the row index of the searched string.
 * @param s String to return the row index for
 * @return row index (0 based) returns 0 when finding nothing.
 */
@SuppressWarnings("unchecked")
public int searchFor(java.lang.String s){netrexx.lang.Rexx i=null;java.lang.String abbrev[]=null;

{netrexx.lang.Rexx $1=new netrexx.lang.Rexx(this.abbreviationsList.size()).OpSub(null,$01);i=new netrexx.lang.Rexx((byte)0);i:for(;i.OpLtEq(null,$1);i=i.OpAdd(null,new netrexx.lang.Rexx(1))){
abbrev=(java.lang.String[])(this.abbreviationsList.get(i.toint()));
if (abbrev[0].toUpperCase().startsWith(s.toUpperCase())) 
return i.toint();
}}/*i*/ // loop i

return 0;}

/**
 * Returns the row index of the searched string, or -1 if no entry
 * was found. It matches on the exact, case insensitive, string.
 * @param s String to search for.
 * @return row index of the matched string, or -1 if none was
 *         found.
 */
@SuppressWarnings("unchecked")
public static int matchExact(java.lang.String s){netrexx.lang.Rexx i=null;java.lang.String abbrev[]=null;
{netrexx.lang.Rexx $2=new netrexx.lang.Rexx(abbreviationsList.size()).OpSub(null,$01);i=new netrexx.lang.Rexx((byte)0);i:for(;i.OpLtEq(null,$2);i=i.OpAdd(null,new netrexx.lang.Rexx(1))){
abbrev=(java.lang.String[])(abbreviationsList.get(i.toint()));
if (abbrev[0].toUpperCase().equals((java.lang.Object)s)) 
return i.toint();
}}/*i*/

return $01.OpMinus(null).toint();}

/**
 * Creates an abbreviation for the input string <code>s</code>.
 * The rules are taken from the "Governance and Maintenance" draft document
 * as of May 15 2003. <br>
 * <i>Note:</i><br>
 * In spite of what is stated in the Governance and Maintenance document,
 * no 18 character limit is used.
 * <p>
 * The global algorithm used is, for every word (space separated) in the
 * string, to first look into the list of known abbreviations. If
 * one doesn't exist, the rules from the document are applied.
 * <ol><li>Use Abbreviations from the list when available</li>
 *     <li>If a component name contains a data concept then the
 *         appropriate two letter abbreviation is to be used. (This is
 *         in fact handled by the previous rule)</li>
 *     <li>Abbreviations are constructed by remoing all vowels. Leading
 *         vowels are not deleted. (ACCRUAL -> ACCRL). The character
 *         'Y' is considered to be a vowel.</li>
 *     <li>Delete double consonants if the second consonant does not
 *         clearly identify the word. (ACCOUNTING -> ACRTN). This
 *         is a very subjective rule, so we apply it always.</li>
 *     <li>Words ending in "ING" should have the suffix abbreviated to "G"
 *         (<i>implementation note:</i> This should be done before removing
 *         vowels.)</li>
 *     <li>Words ending in "ED" should have the same abbreviations as the
 *         present tense form of the word with "D" added.
 *         (<i>Implementation note:</i> This is very hard to automate, so
 *         we suffice by removing the "E".</li>
 *     <li>All spaces, commas, parentheses, slashes and hyphens are
 *         replaced by underscores</li>
 *     <li>All quotes, apostrophes and leading digits are removed.</li>
 *     <li>Abbreviated Names must be in UPPER CASE</li>
 *     <li>Abbreviated Names must start with a character in the range
 *         [A..Z]</li>
 *     <li>Abbreviated Names cannot start with the string "XML"</li>
 *     <li>Abbrevations should not be deliniated with periods</li>
 * </ol>

 * @param s String to abbreviate
 * @return Abbreviation in upper case for string <code>s</code>.
 */
@SuppressWarnings("unchecked")
public static java.lang.String abbreviate(java.lang.String s){netrexx.lang.Rexx r;int row;java.lang.String abbrev[]=null;netrexx.lang.Rexx retVal;netrexx.lang.Rexx i=null;netrexx.lang.Rexx j=null;netrexx.lang.Rexx w=null;netrexx.lang.Rexx wright=null;netrexx.lang.Rexx start=null;netrexx.lang.Rexx tmp=null;netrexx.lang.Rexx firstCons=null;

r=netrexx.lang.Rexx.toRexx(s);
r=r.upper();
r=r.changestr(new netrexx.lang.Rexx('-'),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx('('),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx(')'),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx(','),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx(':'),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx(';'),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx('%'),new netrexx.lang.Rexx(' '));
r=r.changestr(new netrexx.lang.Rexx('.'),new netrexx.lang.Rexx(' '));
r=r.space();

/* first try to match the whole string */
row=matchExact(r.toString());
if (new netrexx.lang.Rexx(row).OpGt(null,$01.OpMinus(null))) 
{
abbrev=(java.lang.String[])(abbreviationsList.get(row));
/*  return abbreviationsArray[row, 1] */
return abbrev[1];
} // if do

retVal=netrexx.lang.Rexx.toRexx("");
/* then try to match as large a part of the string as possible */
{netrexx.lang.Rexx $3=r.words();i=new netrexx.lang.Rexx((byte)1);i:for(;i.OpLtEq(null,$3);i=i.OpAdd(null,new netrexx.lang.Rexx(1))){
row=$01.OpMinus(null).toint();
{netrexx.lang.Rexx $4=$01.OpMinus(null);boolean $5=$4.OpGtEq(null,$03);j=(r.words()).OpPlus(null);j:for(;$5?j.OpLtEq(null,$02):j.OpGtEq(null,$02);j=j.OpAdd(null,$4)){
row=matchExact(netrexx.lang.Rexx.toString(r.subword(i,j)));
if (new netrexx.lang.Rexx(row).OpGt(null,$01.OpMinus(null))) 
{ // found an exact match
abbrev=(java.lang.String[])(abbreviationsList.get(row));
retVal=retVal.OpCcblank(null,netrexx.lang.Rexx.toRexx(abbrev[1]));
// update i to reflect the number of words matched
i=i.OpAdd(null,r.subword(i,j).words()).OpSub(null,$01);
break j;
} // if do
}}/*j*/ // loop j

if (new netrexx.lang.Rexx(row).OpGt(null,$01.OpMinus(null))) 
continue i; // we found an exact match
else /* create our own abbreviation */
{
w=r.word(i);
{/*select*/
if ((w.right(new netrexx.lang.Rexx((byte)3))).OpEq(null,$04))
{
/* replace suffix "ING" with "G" */
w=(w.left((w.length()).OpSub(null,$05))).OpCc(null,$06);
}
else if ((w.right(new netrexx.lang.Rexx((byte)2))).OpEq(null,$07)&(w.length()).OpGt(null,$08))
{
/* replace suffix "ED" with "" */
w=w.left((w.length()).OpSub(null,$08));
}
else{
;}
}
/* remove all vowels, except leading ones */
wright=w.right((w.length()).OpSub(null,$01));
wright=wright.changestr(new netrexx.lang.Rexx('A'),netrexx.lang.Rexx.toRexx(""));
wright=wright.changestr(new netrexx.lang.Rexx('E'),netrexx.lang.Rexx.toRexx(""));
wright=wright.changestr(new netrexx.lang.Rexx('I'),netrexx.lang.Rexx.toRexx(""));
wright=wright.changestr(new netrexx.lang.Rexx('O'),netrexx.lang.Rexx.toRexx(""));
wright=wright.changestr(new netrexx.lang.Rexx('U'),netrexx.lang.Rexx.toRexx(""));
wright=wright.changestr(new netrexx.lang.Rexx('Y'),netrexx.lang.Rexx.toRexx(""));

w=(w.left(new netrexx.lang.Rexx((byte)1))).OpCc(null,wright);

/* remove all illegal characters */
w=w.changestr(new netrexx.lang.Rexx('\"'),netrexx.lang.Rexx.toRexx(""));
w=w.changestr(new netrexx.lang.Rexx('\''),netrexx.lang.Rexx.toRexx(""));

/* remove leading digits */
if ($09.sequence(new netrexx.lang.Rexx('9')).pos(w.left(new netrexx.lang.Rexx((byte)1))).OpGt(null,$03)) 
w=w.right((w.length()).OpSub(null,$01));

/* replace forward and backward slashes by spaces */
w=w.changestr(new netrexx.lang.Rexx('/'),new netrexx.lang.Rexx(' '));
w=w.changestr(new netrexx.lang.Rexx('\\'),new netrexx.lang.Rexx(' '));

/* 	  /\* strip delineating periods *\/ */
/* 	  w = w.strip('B','.') */

/* delete double consonants */
/* first check to see if the first character is a consonant */
if (netrexx.lang.Rexx.toRexx("AEIOU").pos(w.left(new netrexx.lang.Rexx((byte)1))).OpGt(null,$03)) 
start=new netrexx.lang.Rexx((byte)2);
else 
start=new netrexx.lang.Rexx((byte)1);

tmp=w.left(start);

firstCons=w.substr(start,new netrexx.lang.Rexx((byte)1));
{netrexx.lang.Rexx $6=w.length();j=start.OpAdd(null,$01).OpPlus(null);j:for(;j.OpLtEq(null,$6);j=j.OpAdd(null,new netrexx.lang.Rexx(1))){
if (w.substr(j,new netrexx.lang.Rexx((byte)1)).equals((java.lang.Object)firstCons)) 
continue j;

tmp=tmp.OpCc(null,w.substr(j,new netrexx.lang.Rexx((byte)1)));
firstCons=w.substr(j,new netrexx.lang.Rexx((byte)1));
/* 	    if j+1 < w.length() then */
/* 	      firstCons = w.substr(j+1, 1) */
}}/*j*/ // loop j
retVal=retVal.OpCcblank(null,tmp);

} // else do
}}/*i*/ // loop i

/* remove surplus spaces */
retVal=retVal.space();
/* changes all spaces to underscores */
retVal=retVal.changestr(new netrexx.lang.Rexx(' '),new netrexx.lang.Rexx('_'));
return netrexx.lang.Rexx.toString(retVal);}

/**
 * Returns the value of the abbreviations array that is found at position
 * <code>i</code> and <code>j</code>.
 * @param i row number (zero based) of the object to return from the
 *        array.
 * @param j column number (zero based) of the object to return from
 *        the array. The first column is the whole word (or set of
 *        words) and the second column is the matching
 *        abbreviation.
 * @return object of type String with either the whole word (<code>j = 0
 *         </code>), or the matching abbreviation (<code>j = 1</code>).
 */
@SuppressWarnings("unchecked")
public java.lang.Object getValueAt(int i,int j){java.lang.String retVal[];
retVal=(java.lang.String[])(this.abbreviationsList.get(i));
return (java.lang.Object)retVal[j];}

/**
 * Sets the value of either the abbreviation or the abbreviated
 * term. If the requested row and of column cannot be found, it
 * fails silently, without any updates.
 * <p><b>Note:</b></p>
 * <p>This method only updates the internal cache of Abbreviations.
 * It does <em>not</em> update the data base.
 * @param val String that replaces the current value.
 * @param row int zero based index of the row
 * @param col 0 is the abbreviation, 1 is the term.
 * @return boolean indicating success. 
 * @see com.abnamro.midms.modelbase.editor.AbbreviationsTableModel
 */
@SuppressWarnings("unchecked")
public boolean setValueAt(java.lang.String val,int row,int col){java.lang.String r[];
if (((new netrexx.lang.Rexx(row).OpGt(null,new netrexx.lang.Rexx(this.abbreviationsList.size()))|new netrexx.lang.Rexx(row).OpLt(null,$03))|new netrexx.lang.Rexx(col).OpGt(null,$01))|new netrexx.lang.Rexx(col).OpLt(null,$03)) 
return false;

if (val==null) 
val="";

// shall we disallow empty values? Perhaps only for the AAB BDWM
// terms.
if (new netrexx.lang.Rexx(col).OpEq(null,$01)&netrexx.lang.Rexx.toRexx(val).OpEq(null,$010)) 
return false;

r=(java.lang.String[])(this.abbreviationsList.get(row));
r[col]=val;
return true;}

/**
 * @return the length of the abbreviations array
 */
@SuppressWarnings("unchecked")
public int size(){
return this.abbreviationsList.size();}

@SuppressWarnings("unchecked")
public void setAbbreviationsList(java.util.ArrayList al){
this.abbreviationsList=al;
return;}

@SuppressWarnings("unchecked")
public java.util.ArrayList getAbbreviationsList(){
return this.abbreviationsList;}}
