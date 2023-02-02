/* Generated from 'DBAccess.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


/**
 * Class DBAccess is a singleton that takes care of all queries to the DSD environment.
 */
public class DBAccess{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("order by 1");private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx('(');private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(',');private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("SQLState:");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("Message: ");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx("Vendor:  ");private static final java.lang.String $0="DBAccess.nrx";
/* properties private static */
private static java.sql.Connection jdbcCon;
private static com.rvjansen.DBAccess instance=(com.rvjansen.DBAccess)null;

/**
 * Method DBAccess (is private to enforce the singleton pattern)
 */
@SuppressWarnings("unchecked")
private DBAccess(){super();return;}

/**
 * Method getInstance returns the (only) instance of this class when
 * it initialized, or constructs an instance when it is not
 */
@SuppressWarnings("unchecked")
public static synchronized com.rvjansen.DBAccess getInstance() throws java.lang.ClassNotFoundException{netrexx.lang.Rexx url_;java.sql.SQLException e=null;
if (instance!=null) return instance;
instance=new com.rvjansen.DBAccess();

// Class.forName("org.sqlite.JDBC")
// url_='jdbc:sqlite:dsd.sqb'

url_=netrexx.lang.Rexx.toRexx("jdbc:postgresql://localhost/rvjansen");
java.lang.Class.forName("org.postgresql.Driver");

{try{
jdbcCon=java.sql.DriverManager.getConnection(netrexx.lang.Rexx.toString(url_));}
catch (java.sql.SQLException $1){e=$1;
printException(e);
}} // do

return instance;}


/**
 * Method getPredicatesAndWrite selects all current predicates
 * from the knowledge base (now > eff_dt and end_dt > now) 
 * @param fileName_ is a Rexx indicating the file to be written to
 */
@SuppressWarnings("unchecked")
public synchronized netrexx.lang.Rexx getPredicatesAndWrite(netrexx.lang.Rexx fileName_) throws java.io.IOException{java.io.PrintWriter dest=null;netrexx.lang.Rexx sqlstmt=null;java.sql.Statement stmt=null;java.sql.ResultSet rs=null;java.lang.String predicate=null;java.lang.String subject=null;java.lang.String object=null;netrexx.lang.Rexx line=null;java.sql.SQLException e=null;
{
dest=new java.io.PrintWriter((java.io.Writer)(new java.io.FileWriter(netrexx.lang.Rexx.toString(fileName_))));
}
{try{
sqlstmt=(netrexx.lang.Rexx.toRexx("select predicate, subject, object from predicate ").OpCcblank(null,netrexx.lang.Rexx.toRexx("where now() > eff_dt and end_dt > now() "))).OpCcblank(null,$01);



stmt=this.jdbcCon.createStatement();
rs=stmt.executeQuery(netrexx.lang.Rexx.toString(sqlstmt));

{for(;;){if(!(rs.next()))break;
{try{
predicate=rs.getString(1);
subject=rs.getString(2);
object=rs.getString(3);}
catch (java.lang.NullPointerException $2){
netrexx.lang.RexxIO.Say("Nullpointer in getPredicatesAndWrite()");
}} // do
line=(((netrexx.lang.Rexx.toRexx(predicate).OpCc(null,$02)).OpCc(null,netrexx.lang.Rexx.toRexx(subject))).OpCc(null,$03)).OpCc(null,netrexx.lang.Rexx.toRexx(object));
dest.println((java.lang.Object)line);
}} // do

rs.close();
stmt.close();
dest.close();
return new netrexx.lang.Rexx((byte)0);}
catch (java.sql.SQLException $3){e=$3;
printException(e);
return (netrexx.lang.Rexx)null;
}}} // do

/**
 * Method insertLine ...
 * @param subject_ is a Rexx
 * @param subject_ is a Rexx
 * @param object_ is a Rexx
 */
@SuppressWarnings("unchecked")
public synchronized netrexx.lang.Rexx insertLine(java.sql.PreparedStatement istmt,netrexx.lang.Rexx predicate_,netrexx.lang.Rexx subject_,netrexx.lang.Rexx object_){int rows=0;java.sql.SQLException e=null;
{try{
istmt.setString(1,predicate_.toString());
istmt.setString(2,subject_.toString());
istmt.setString(3,object_.toString());
rows=istmt.executeUpdate();
return new netrexx.lang.Rexx((byte)0);}
catch (java.sql.SQLException $4){e=$4;
printException(e);
return (netrexx.lang.Rexx)null;
}}} // do

@SuppressWarnings("unchecked")
public synchronized java.sql.PreparedStatement prepareInsertStatement(){netrexx.lang.Rexx insert_st=null;java.sql.PreparedStatement istmt=null;java.sql.SQLException e=null;
{try{
insert_st=netrexx.lang.Rexx.toRexx("insert into predicate ( predicate, subject, object ) ").OpCcblank(null,netrexx.lang.Rexx.toRexx("values (?,?,?)"));


istmt=this.jdbcCon.prepareStatement(netrexx.lang.Rexx.toString(insert_st));
return istmt;}
catch (java.sql.SQLException $5){e=$5;
printException(e);
return (java.sql.PreparedStatement)null;
}}} // do

@SuppressWarnings("unchecked")
public synchronized netrexx.lang.Rexx closeInsertStatement(java.sql.PreparedStatement istmt){java.sql.SQLException e=null;
{try{
istmt.close();
return new netrexx.lang.Rexx((byte)0);}
catch (java.sql.SQLException $6){e=$6;
printException(e);
return (netrexx.lang.Rexx)null;
}}} // do

/**
 * Method printException formats the SQL Exception it is given
 * @param e is an SQLException
 */
@SuppressWarnings("unchecked")
public static synchronized void printException(java.sql.SQLException e){
netrexx.lang.RexxIO.Say("SQLException(s) caught !");
{for(;;){if(!((e!=null)))break;
netrexx.lang.RexxIO.Say($04.OpCcblank(null,netrexx.lang.Rexx.toRexx(e.getSQLState())));
netrexx.lang.RexxIO.Say($05.OpCcblank(null,netrexx.lang.Rexx.toRexx(e.getMessage())));
netrexx.lang.RexxIO.Say($06.OpCcblank(null,new netrexx.lang.Rexx(e.getErrorCode())));
netrexx.lang.RexxIO.Say("");
e=e.getNextException();
}}return;}

/**
 * Method close closes the jdbc connection to the database
 */
@SuppressWarnings("unchecked")
public synchronized void close() throws java.sql.SQLException{
this.jdbcCon.close();return;}

/**
 * Method main is the entrypoint when this class is called by the jvm
 * @param args is a String[]
 */
@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]){return;}}
// say 'dbaccess start'
// d=DBAccess.getInstance()
// d.getPredicatesAndWrite('test.pl')    
// say 'dbaccess end'
