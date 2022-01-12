/* Generated from 'Datum.nrx' 11 Jan 2022 20:04:03 [v4.02] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Trace2 UTF8 Verbose3 */package com.rvjansen;


/**
 * * Implements a lot of useful functions and methods on dates.
 * * Especially those that deal with timestamps.
 * * 20061110: after ten years, split it in static and instance functionality
 * * to make it of more use when re-using for non-current dates
 * * 20111011: after another 4 years, make sure the static functions are called statically 
 * */
public class Datum{private static final char[] $01={2,1,32,10,1,0,1,10,1,1,0};private static final netrexx.lang.Rexx $02=netrexx.lang.Rexx.toRexx("\\yr");private static final netrexx.lang.Rexx $03=netrexx.lang.Rexx.toRexx("\\mo");private static final netrexx.lang.Rexx $04=netrexx.lang.Rexx.toRexx("\\dy");private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("\\hr");private static final netrexx.lang.Rexx $06=netrexx.lang.Rexx.toRexx("\\min");private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("\\sec");private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx('1');private static final netrexx.lang.Rexx $09=new netrexx.lang.Rexx('2');private static final netrexx.lang.Rexx $010=new netrexx.lang.Rexx('3');private static final netrexx.lang.Rexx $011=new netrexx.lang.Rexx('4');private static final netrexx.lang.Rexx $012=new netrexx.lang.Rexx('5');private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("\'de");private static final netrexx.lang.Rexx $014=netrexx.lang.Rexx.toRexx("**");private static final netrexx.lang.Rexx $015=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $016=netrexx.lang.Rexx.toRexx("Sat");private static final netrexx.lang.Rexx $017=netrexx.lang.Rexx.toRexx("Sun");private static final netrexx.lang.Rexx $018=new netrexx.lang.Rexx(1000);private static final netrexx.lang.Rexx $019=new netrexx.lang.Rexx(60);private static final netrexx.lang.Rexx $020=new netrexx.lang.Rexx(24);private static final netrexx.lang.Rexx $021=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $022=netrexx.lang.Rexx.toRexx("second");private static final netrexx.lang.Rexx $023=new netrexx.lang.Rexx('s');private static final netrexx.lang.Rexx $024=netrexx.lang.Rexx.toRexx("minute");private static final netrexx.lang.Rexx $025=netrexx.lang.Rexx.toRexx("and");private static final netrexx.lang.Rexx $026=netrexx.lang.Rexx.toRexx("hour");private static final netrexx.lang.Rexx $027=new netrexx.lang.Rexx(',');private static final netrexx.lang.Rexx $028=netrexx.lang.Rexx.toRexx("day");private static final netrexx.lang.Rexx $029=netrexx.lang.Rexx.toRexx("");private static final netrexx.lang.Rexx $030=netrexx.lang.Rexx.toRexx("millisecs");private static final netrexx.lang.Rexx $031=netrexx.lang.Rexx.toRexx("Previous:");private static final netrexx.lang.Rexx $032=netrexx.lang.Rexx.toRexx("Next:");private static final java.lang.String $0="Datum.nrx";

/* properties indirect */
private java.util.Date today;
private java.util.Calendar cal;

/**
 *   * Default constructor, initializes with the current date.
 *   */
@SuppressWarnings("unchecked")
public Datum(){super();
today=new java.util.Date();
cal=(java.util.Calendar)(new java.util.GregorianCalendar());
cal.setTime(today);return;}

/**
 *   * Uses java.text.DateFormat.parse to parse the parameter into a
 *   * date.
 *   */
@SuppressWarnings("unchecked")
public Datum(netrexx.lang.Rexx string) throws java.text.ParseException{super();java.text.SimpleDateFormat df;
//  setLenient(0)
df=new java.text.SimpleDateFormat("dd/MM/yy");
today=df.parse(netrexx.lang.Rexx.toString(string));
cal=(java.util.Calendar)(new java.util.GregorianCalendar());
cal.setTime(today);return;}

/**
 *   * Uses java.text.DateFormat.parse to parse the parameter into a
 *   * date.
 *   */
@SuppressWarnings("unchecked")
public Datum(java.lang.String s) throws java.text.ParseException{super();java.text.SimpleDateFormat df;
df=new java.text.SimpleDateFormat("dd/MM/yy");
today=df.parse(s);
cal=(java.util.Calendar)(new java.util.GregorianCalendar());
cal.setTime(today);
return;}

@SuppressWarnings("unchecked")
public Datum(java.util.Date d){super();
today=d;
cal=(java.util.Calendar)(new java.util.GregorianCalendar());
cal.setTime(today);return;}

@SuppressWarnings("unchecked")
public void clearTime(){
this.cal.set(java.util.Calendar.HOUR,0);
this.cal.set(java.util.Calendar.MINUTE,0);
this.cal.set(java.util.Calendar.SECOND,0);return;}

@SuppressWarnings("unchecked")
public boolean equals(com.rvjansen.Datum x){
return (this.getDateLocal()).OpEq(null,x.getDateLocal());}

@SuppressWarnings("unchecked")
public boolean before(com.rvjansen.Datum x){
return cal.before((java.lang.Object)x.cal);}

@SuppressWarnings("unchecked")
public boolean after(com.rvjansen.Datum x){
return cal.after((java.lang.Object)x.cal);}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyyMMddHHmmssSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getDateStamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyyMMdd");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getInstanceDateStamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyyMMdd");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getTime(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("HHmmssSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getTimeZoneLongID(){java.util.GregorianCalendar cl;
cl=new java.util.GregorianCalendar();
return netrexx.lang.Rexx.toRexx(cl.getTimeZone().getID().toString());}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getTimeZoneShortID(){java.util.GregorianCalendar cl;
cl=new java.util.GregorianCalendar();
return netrexx.lang.Rexx.toRexx(cl.getTimeZone().getDisplayName(false,java.util.SimpleTimeZone.SHORT).toString());}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getLogTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getISODate(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy-MM-dd");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getUTCLogTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
df.setTimeZone((java.util.TimeZone)(new java.util.SimpleTimeZone(0,"UTC")));
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getDisplayTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("EE dd-MMM-yyyy HH:mm:ss");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

/**
 *   * Method getRtfTimestamp ...
 *   */
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getRtfTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx tmp;netrexx.lang.Rexx year=null;netrexx.lang.Rexx month=null;netrexx.lang.Rexx day=null;netrexx.lang.Rexx hour=null;netrexx.lang.Rexx minute=null;netrexx.lang.Rexx second=null;
df=new java.text.SimpleDateFormat("yyyy MM dd HH mm ss");
tmp=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(tmp,$01,$1);year=$1[0];tmp=$1[1];}
{netrexx.lang.Rexx $2[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(tmp,$01,$2);month=$2[0];tmp=$2[1];}
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(tmp,$01,$3);day=$3[0];tmp=$3[1];}
{netrexx.lang.Rexx $4[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(tmp,$01,$4);hour=$4[0];tmp=$4[1];}
{netrexx.lang.Rexx $5[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(tmp,$01,$5);minute=$5[0];second=$5[1];}
return (((((((((($02.OpCc(null,year)).OpCc(null,$03)).OpCc(null,month)).OpCc(null,$04)).OpCc(null,day)).OpCc(null,$05)).OpCc(null,hour)).OpCc(null,$06)).OpCc(null,minute)).OpCc(null,$07)).OpCc(null,second);}

/**
 *   * Method getLogTimestamp ...
 *   * @param dt is a Date
 *   */
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getLogTimestamp(java.util.Date dt){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(dt));
return longdate;}

@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getFileBackupTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("dd-MM-yyyy-HHmm");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

/**
 *   * this method formats the timestamp in a way suitable for the DBMS
 *   * Timestamp format. Be very careful not to use this when now() or
 *   * CURRENT TIMESTAMP is appropriate, because you can be bitten by
 *   * client/server clock skew.
 *     */
@SuppressWarnings("unchecked")
public static netrexx.lang.Rexx getDBMSTimestamp(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDayOfWeekInMonth(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("EEEE F \'in\' MMMM",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDayOfWeekInThreeChars(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("EE",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate.upper();}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDayOfWeekLocal(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("EEEE");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDayOfWeekInMonthLocal(){java.text.SimpleDateFormat df;netrexx.lang.Rexx n;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("F");
n=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
{/*select*/
if (n.OpEq(null,$08))n=netrexx.lang.Rexx.toRexx("eerste");
else if (n.OpEq(null,$09))n=netrexx.lang.Rexx.toRexx("tweede");
else if (n.OpEq(null,$010))n=netrexx.lang.Rexx.toRexx("derde");
else if (n.OpEq(null,$011))n=netrexx.lang.Rexx.toRexx("vierde");
else if (n.OpEq(null,$012))n=netrexx.lang.Rexx.toRexx("vijfde"); // does this happen?
else{throw new netrexx.lang.NoOtherwiseException();}} // select
df=new java.text.SimpleDateFormat(netrexx.lang.Rexx.toString(($013.OpCcblank(null,n)).OpCcblank(null,netrexx.lang.Rexx.toRexx("\'EEEE \'in\' MMMM"))));
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));

return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDateLocal(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("dd-MM-yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(today));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDateLocalWithSlashesAndStarsInYearNotY2KCompatible(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("dd/MM/");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate.OpCc(null,$014);}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDateLocalWithSlashes(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("dd/MM/yy");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getDateLocalWithSlashesAndFourDigitYear(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("dd/MM/yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getMonthLocal(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("MMMM");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getYear(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getJulianDate(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyD");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getJulianDateForDate(java.util.Date d){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yyD");
longdate=netrexx.lang.Rexx.toRexx(df.format(d));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getJulianDateWithDot(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("yy\'.\'D");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getNextDay(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,1);
df=new java.text.SimpleDateFormat("dd-MM-yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getNextDayWithSlashes(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,1);
df=new java.text.SimpleDateFormat("dd/MM/yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public java.util.Date getNextDate(){
cal.add(java.util.Calendar.DATE,$015.OpPlus(null).toint());
return cal.getTime();}

/**
 *   * Method getPreviousDate ...
 *   * @param numberOfDays is a int
 *   * @return Date containing ...
 *   */
@SuppressWarnings("unchecked")
public java.util.Date getPreviousDate(int numberOfDays){
cal.add(java.util.Calendar.DATE,new netrexx.lang.Rexx(numberOfDays).OpMinus(null).toint());
return cal.getTime();}

/**
 *   * Method getPreviousDate ...
 *   * @return Date containing ...
 *   */
@SuppressWarnings("unchecked")
public java.util.Date getPreviousDate(){
return this.getPreviousDate(1);}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getPreviousDay(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,$015.OpMinus(null).toint());
df=new java.text.SimpleDateFormat("dd-MM-yyyy");
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getPreviousDayInNetview6000LogFormat(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,$015.OpMinus(null).toint());
df=new java.text.SimpleDateFormat("EE MMM dd",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getPreviousDayInApacheLogFormat(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,$015.OpMinus(null).toint());
df=new java.text.SimpleDateFormat("dd/MMM/yyyy",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getPreviousDayInTouchFormat(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
cal.add(java.util.Calendar.DATE,$015.OpMinus(null).toint());
df=new java.text.SimpleDateFormat("yyyyMMdd0000",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public long getTimeLong(){
return today.getTime();}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx isWeekend(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("EE",java.util.Locale.US);
longdate=netrexx.lang.Rexx.toRexx(df.format(cal.getTime()));
if (longdate.OpEq(null,$016)|longdate.OpEq(null,$017)) return new netrexx.lang.Rexx('Y');
else return new netrexx.lang.Rexx('N');}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getWeekNumber(){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
df=new java.text.SimpleDateFormat("w");
longdate=netrexx.lang.Rexx.toRexx(df.format(this.cal.getTime()));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getWeekNumberForDate(java.util.Date d){java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
// @rjw@
df=new java.text.SimpleDateFormat("w");
longdate=netrexx.lang.Rexx.toRexx(df.format(d));
return longdate;}

@SuppressWarnings("unchecked")
public netrexx.lang.Rexx getLastDayofMonth(){
return new netrexx.lang.Rexx(cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH));}

@SuppressWarnings("unchecked")
public void setLenient(boolean i){
cal.setLenient(i);return;}

/**
 *   * Takes a time in milliseconds and returns it in a more readable
 *   * form.
 *   * @param tDelta time in milliseconds, like the return value from
 *   *        System.currentTimeMillis()
 *   */
@SuppressWarnings("unchecked")
public static java.lang.String getDisplayTime(long tDelta){netrexx.lang.Rexx tSeconds;netrexx.lang.Rexx tMinutes;netrexx.lang.Rexx tHours;netrexx.lang.Rexx tDays;netrexx.lang.Rexx ReturnText;netrexx.lang.Rexx ReturnTextNew=null;
tSeconds=new netrexx.lang.Rexx(tDelta).OpDiv(null,$018);
tMinutes=tSeconds.OpDivI(null,$019);
tHours=tMinutes.OpDivI(null,$019);
tDays=tHours.OpDivI(null,$020);
tSeconds=tSeconds.OpSub(null,tMinutes.OpMult(null,$019));
tMinutes=tMinutes.OpSub(null,tHours.OpMult(null,$019));
tHours=tHours.OpSub(null,tDays.OpMult(null,$020));
ReturnText=netrexx.lang.Rexx.toRexx("");

if (((tSeconds.OpGtEq(null,$015)))|((tSeconds.OpGt(null,$021)&((tMinutes.OpGt(null,$021)|tHours.OpGt(null,$021)))))) 
{
ReturnText=(ReturnText.OpCcblank(null,(tSeconds).format((netrexx.lang.Rexx)null,new netrexx.lang.Rexx((byte)2)))).OpCcblank(null,$022);
if (tSeconds.OpGt(null,$015)) 
ReturnText=ReturnText.OpCc(null,$023);
}
if (tMinutes.OpGt(null,$021)) 
{
ReturnTextNew=tMinutes.OpCcblank(null,$024);
if (tMinutes.OpGt(null,$015)) 
ReturnTextNew=ReturnTextNew.OpCc(null,$023);
if (tSeconds.OpGt(null,$021)) 
ReturnTextNew=(ReturnTextNew.OpCcblank(null,$025)).OpCcblank(null,ReturnText);
ReturnText=ReturnTextNew;
} // if do
if (tHours.OpGt(null,$021)) 
{
ReturnTextNew=tHours.OpCcblank(null,$026);
if (tHours.OpGt(null,$015)) 
ReturnTextNew=ReturnTextNew.OpCc(null,$023);
if (tMinutes.OpGt(null,$021)) {
if (tSeconds.OpGt(null,$021)) {
ReturnTextNew=(ReturnTextNew.OpCc(null,$027)).OpCcblank(null,ReturnText);
}
else {
ReturnTextNew=(ReturnTextNew.OpCcblank(null,$025)).OpCcblank(null,ReturnText);
}
} // if tMinutes
ReturnText=ReturnTextNew;
} // if do
if (tDays.OpGt(null,$021)) 
{
ReturnTextNew=tDays.OpCcblank(null,$028);
if (tDays.OpGt(null,$015)) 
ReturnTextNew=ReturnTextNew.OpCc(null,$023);
if ((tHours.OpGt(null,$021)|tMinutes.OpGt(null,$021))|tSeconds.OpGt(null,$021)) {
if (tMinutes.OpGt(null,$021)|tSeconds.OpGt(null,$021)) {
ReturnTextNew=(ReturnTextNew.OpCc(null,$027)).OpCcblank(null,ReturnText);
}
else {
ReturnTextNew=(ReturnTextNew.OpCcblank(null,$025)).OpCcblank(null,ReturnText);
}
} // if tHours
ReturnText=ReturnTextNew;
} // if do
if (ReturnText.OpEq(null,$029)) 
ReturnText=(new netrexx.lang.Rexx(tDelta).OpCcblank(null,$030)).OpCcblank(null,ReturnText);
else 
ReturnText=(new netrexx.lang.Rexx(tDelta).OpCcblank(null,netrexx.lang.Rexx.toRexx("millisecs ="))).OpCcblank(null,ReturnText);

return netrexx.lang.Rexx.toString(ReturnText);}


@SuppressWarnings("unchecked")
public static void main(java.lang.String args[]) throws java.text.ParseException{com.rvjansen.Datum d;com.rvjansen.Datum e;com.rvjansen.Datum g;com.rvjansen.Datum m;
d=new com.rvjansen.Datum();

netrexx.lang.RexxIO.Say(com.rvjansen.Datum.getDateStamp());
d.cal.add(java.util.Calendar.DATE,1);
netrexx.lang.RexxIO.Say(com.rvjansen.Datum.getDateStamp());
e=new com.rvjansen.Datum("21/12/98");
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Timestamp :").OpCc(null,com.rvjansen.Datum.getTimestamp()));
netrexx.lang.RexxIO.Say(com.rvjansen.Datum.getLogTimestamp());
netrexx.lang.RexxIO.Say(d.getDayOfWeekInMonth());
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Is Weekend:").OpCcblank(null,d.isWeekend()));
netrexx.lang.RexxIO.Say(d.getDayOfWeekInMonthLocal());
netrexx.lang.RexxIO.Say(d.getDayOfWeekInThreeChars());
netrexx.lang.RexxIO.Say(d.getJulianDate());
netrexx.lang.RexxIO.Say(d.getJulianDateWithDot());
netrexx.lang.RexxIO.Say(d.getDateLocal());
netrexx.lang.RexxIO.Say(d.getDateLocalWithSlashesAndStarsInYearNotY2KCompatible());
netrexx.lang.RexxIO.Say($031.OpCcblank(null,d.getPreviousDay()));
netrexx.lang.RexxIO.Say($032.OpCcblank(null,d.getNextDay()));
netrexx.lang.RexxIO.Say($032.OpCcblank(null,d.getNextDay()));

g=new com.rvjansen.Datum(d.getPreviousDate());
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Gisteren/Yesterday ").OpCcblank(null,g.getDateLocalWithSlashes()));
m=new com.rvjansen.Datum(d.getNextDate());
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Morgen/Tomorrow").OpCcblank(null,m.getDateLocalWithSlashes()));

netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Netview 6000 log entry format: ").OpCcblank(null,d.getPreviousDayInNetview6000LogFormat()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Apache web server log entry format: ").OpCcblank(null,d.getPreviousDayInApacheLogFormat()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("Unix file touch format: ").OpCcblank(null,d.getPreviousDayInTouchFormat()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("weeknummer/weeknumber").OpCcblank(null,g.getWeekNumber()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("geinitialiseerde Datum/Initialized Date").OpCcblank(null,e.getDateLocal()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("laatste dag van maand/lastdayofmonth:").OpCcblank(null,d.getLastDayofMonth()));
netrexx.lang.RexxIO.Say(netrexx.lang.Rexx.toRexx("maand in locaal formaat/monthlocal:").OpCcblank(null,d.getMonthLocal()));
netrexx.lang.RexxIO.Say(com.rvjansen.Datum.getTimeZoneShortID());return;}public java.util.Date getToday(){return today;}public void setToday(java.util.Date $6){today=$6;return;}public java.util.Calendar getCal(){return cal;}public void setCal(java.util.Calendar $7){cal=$7;return;}}
