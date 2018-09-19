package hw3;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class data {
	int line;                                               //create line variable to store the line number of c++ file
	List<String> words=new ArrayList<String>();             //create and initialize an arraylist words to store keywords
	List<Integer> pos= new ArrayList<Integer>();            //create and initialize an arraylist pos to store position of keywords
	static int c=0;                                         //create a static variable to store number of keywords
	data()                                                  //constructor data
	{
	}
   void getdata(String data,int lineno,String[] keywords)
   {
	line=lineno;
	int i=0;
	int a = data.indexOf("//");
	if (a != -1) 
	{
	    data= data.substring(0 , a); //ignore comments
	}
	Pattern p = Pattern.compile("[a-zA-Z]+"); 
    Matcher m1 = p.matcher(data);                                //store data in m1
	while(m1.find())                                             //find the word in string m1
	{
	 String s=m1.group();                                   
	 for(i=0;i<keywords.length;i++)                              //check if character is in list keywords
	 {
	 if(keywords[i].equals(s))
	 {
	 words.add(s);                                              //add keyword in list words
	 pos.add(data.indexOf(s));                                  //store position of keyword in list pos
	 System.out.println((++c)+" line"+line);                                             
	 }				
	 }
	 }
   }
   String printkeywords()
   { String s="lineno"+String.valueOf(line)+":";
	if(words.isEmpty())
	 s=s+"no keyword";
	else
	{
	for(int i=0;i<words.size();i++)
	{
	  s=s+words.get(i)+"("+String.valueOf(pos.get(i))+")"+" ";	   //concatenate all keyword from list words along with their position
	}
	}
	return s;                                                      //return string
   }
   public static int totalkeywords()
   {
	return c;                                                      //return total number of keywords
   }
}
