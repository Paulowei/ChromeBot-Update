import java.lang.Exception ; 
import java.lang.NullPointerException ; 
import java.lang.Thread ;
import java.io.Serializable ; 
import java.io.IOException;
import java.awt.* ;
import java.awt.AWTException ;
import java.lang.Throwable ;
import java.util.LinkedList ;
import java.util.Arrays ;
public class ChromeBotException extends AWTException implements Throwable{
public String ErrorStatement ;
public static long serialUUID = 792902730730;
public ChromeBotException(){
super(); 
Throwable[] throwable1 = this.getSurpressed() ; 
int num1 = throwable1.length ; 
LinkedList<StackTraceElement> list1 = new LinkedList<StackTraceElement>() ;
StackTraceElement[] elements ;
Throwable throwable2 ;
if(throwable1==null){
return ;
}
for(int c=0;c<num1;c++){
	throwable2 = throwable1[c];
		if(thrwowable2==null){
			break ;
			}
	elements = throwable2.getStackTrace() ; 
	int num3 = elements.length ; 
	
	for(int v=0;v<num3;v++){
	StackTraceElement s1 = elements[v]; 
	list1.add(s1);
	}
	
}
int num4 = list1.size();
elements = list1.toArray(new StackTraceElement[num4])  ; 
this.setStackTrace(elements)  ;
this.ErrorStatement = list1.get(0).toString() ;
}
public ChromeBotException(String str1){
super(str1)  ;
this.ErrorStatement = str1 ; 
this.setStackTrace() ;
}
public void printStackTrace(){
super() ;
Throwable[] throwable1 = this.getSurpressed()  ;
int num1 = throwable1.length ; 
Throwable throwable2 = null ; 

for(int i=0;i<num1;i++){
throwable2 = throwable1[i]  ;
if(throwable2==null){
break ;
}
else{
if(throwable2.serialUUID==this.serialUUID){
throwable2.setStackTrace() ;
throwable2.printStackTrace() ;
}
else{
throwable2.printStackTrace() ;
			}
		}
	}
}
public void setErrorStatement(String str1){
String str2 = str1 ;
this.ErrorStatement = str2 ; 
}
public String getErrorStatement(){
String str2 = new String() ; 
str2 = this.ErrorStatement ;
return str2 ;
}
public void setStackTrace(){
Throwable[] throwable1 = this.getSurpressed() ; 
int num1 = throwable1.length ; 
LinkedList<StackTraceElement> list1 = new LinkedList<StackTraceElement>() ;
StackTraceElement[] elements ;
Throwable throwable2 ;
if(throwable1==null){
return ;
}
for(int c=0;c<num1;c++){
	throwable2 = throwable1[c];
		if(thrwowable2==null){
			break ;
			}
	elements = throwable2.getStackTrace() ; 
	int num3 = elements.length ; 
	
	for(int v=0;v<num3;v++){
	StackTraceElement s1 = elements[v]; 
	list1.add(s1);
	}
	
}
int num4 = list1.size();
elements = list1.toArray(new StackTraceElement[num4])  ; 
this.setStackTrace(elements)  ;
this.ErrorStatement = list1.get(0).toString() ;
}
}