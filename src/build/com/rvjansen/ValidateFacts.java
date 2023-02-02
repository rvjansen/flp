/* Generated from 'ValidateFacts.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */public class ValidateFacts{private static final java.lang.String $0="ValidateFacts.nrx";private static final netrexx.lang.Rexx $01=new netrexx.lang.Rexx('(');

/* properties inheritable */

@SuppressWarnings("unchecked")
public ValidateFacts(){super();
(new netrexx.lang.RexxIO()).File(netrexx.lang.Rexx.toRexx("./facts.pl")).forEachline((netrexx.lang.LineHandler)(this.new docid()));return;}

@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]){
new ValidateFacts();return;}

class docid implements netrexx.lang.LineHandler{private final transient java.lang.String $0="ValidateFacts.nrx";
@SuppressWarnings("unchecked")
public void handle(netrexx.lang.Rexx in){
if ((in.substr(new netrexx.lang.Rexx((byte)39),new netrexx.lang.Rexx((byte)1),new netrexx.lang.Rexx((byte)1))).OpEqS(null,$01)) netrexx.lang.RexxIO.Say(in);
if ((in.left(new netrexx.lang.Rexx((byte)11))).OpEqS(null,netrexx.lang.Rexx.toRexx(":- dynamic\'"))) netrexx.lang.RexxIO.Say(in);return;}public docid(){return;}}}


