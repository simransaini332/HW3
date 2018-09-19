package hw3;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class dynamicmemory {
	static void sort(String arr[])
    {  //using bubble sort to sort list of keywords
	  int flag=0;
	  for(int k=0;k<arr.length;k++)
	  {
	  for(int a=0;a<(arr.length-1);a++)
	  { 
	  String str1=arr[a];
	  String str2=arr[a+1];
	  int j=0;
	  while(j<str1.length() && j<str2.length())
	  {
	  if(str1.charAt(j)>str2.charAt(j))
	  {
	  arr[a]=str2;
	  arr[a+1]=str1; 
	  flag=1;
	  break;
	  }
	  if(str1.charAt(j)<str2.charAt(j))
	  break;
	  j++; 
	  } 	
	  }
	  if(flag==0)
	   break; 
	  }
   }
	public static void main(String[] args) throws IOException
	{    int c=0,i=0;
		 File file1=new File("C:\\Users\\hp\\Desktop\\javalab\\csx-351-hw3-simransaini332-master\\HW3-unsorted-keywords.txt");//open file of unsorted keywords	
		 Scanner sc1=new Scanner(file1);
		 while(sc1.hasNextLine())
		 {	
		 c++;                                         //calculate number of keywords
		 sc1.nextLine(); 
		 }
		 
		 String keywords[]=new String[c];
		 sc1.close();               
		 Scanner sc2=new Scanner(file1);               //again read file of unsorted keywords
		 
		 while(sc2.hasNextLine())
		 {
			keywords[i]=sc2.nextLine();               //read keywords from file and store them in array
			i++;
		 }
		 sc2.close();

		 sort(keywords);                             //sort keywords
		 
		 File file2=new File("C:\\Users\\hp\\Desktop\\javalab\\csx-351-hw3-simransaini332-master\\HW3-input-code.cpp");//open c++ code file
		 Scanner sc3=new Scanner(file2);
		 c=0;
		 while(sc3.hasNextLine())
		 {	sc3.nextLine();
			c++;                                      // calculate number of lines in c++ file
			
		 }
		 Scanner sc4=new Scanner(file2);
		 data line[]=new data[c];                     //create an array of objects of class data
		 for( i=0; i<line.length; i++) {
		 line[i]=new data();                          //Initialize objects of class data
		}
		for(i=0;i<line.length;i++)
		{String data="";
		 data=sc4.nextLine();                         //read the text from c++ file
		 line[i].getdata(data,i+1,keywords);          //call getdata function 
		}
		FileWriter fw = new FileWriter("C:\\Users\\hp\\Desktop\\javalab\\csx-351-hw3-simransaini332-master\\data.txt"); //create and open output file
		for(i=0;i<line.length;i++)
		{System.out.println(line[i].printkeywords());
		fw.write(line[i].printkeywords());                     //read and store in output file keywords in each line by calling printkeywords function
		fw.write(System.getProperty( "line.separator" ));
		}
		fw.write("total no of keywords=");                    
		fw.write(String.valueOf(data.totalkeywords()));        //print total keywords at end of file
		sc4.close();
		fw.close();
	}
	

}
