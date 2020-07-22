package com.example.demo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/* Note: converting for numeric number to digits is not handled,as per the requirment it has to be handled
 * I could have used inhenritance for writing seperate methods to handle Question-1 and Optional Question-2,however this is a sample progrma it has not handled
 * There are some assumptions i made. Also code is not cleaned as this a sample program like un used variables
 * However all the  scanner readers are closed properly
 * I have not done the exception handling with try,catch and finally blocks*/
public class Roulette
{
   public static void main(String[] args)
   {

       Scanner scanner = new Scanner(System.in);
       Random generator = new Random();
       double total = 500;
       double amount=0;
       double choice=0.0;
       int spin = 0,win = 0,lose=0;
       int number;
       int rouletteNum;
       int result;
       String name=null;
       char response = 'y';
       int resultArr[] = new int[36];
       String a[];
       Map hMap = new HashMap();
	   String line;
       int key=1;
       choice = 0;
  	   number= 0;
            System.out.println("Enter your name,number and even/odd separate by space");
    	   while(scanner.hasNextLine() && !( line = scanner.nextLine() ).equals( "" ))
           {
    		   Map<String, String> hMapi = new HashMap<String, String>();
               String[] tokens = line.split(" ");
              for(int i=0;i<tokens.length;i++)
              {
            	  if(i==0)
            		  hMapi.put("name",tokens[i]);
            	  if(i==1)
            		  hMapi.put("number", tokens[i]);
            	  if(i==2)
            		  hMapi.put("choice", tokens[i]);
              }
              hMap.put(key, hMapi);
              key++;
           }
    	 
           scanner.close();
   		   
           rouletteNum = generator.nextInt(37);
           spin++;
           System.out.println("Number: " + rouletteNum);
    	 
   		Set set = hMap.entrySet();
        Iterator iterator = set.iterator();
        System.out.println("Player"+"  "+"Bet"+"  "+"Outcome"+"  "+"Winnings");
        while(iterator.hasNext()) {
           Map.Entry mentry = (Map.Entry)iterator.next();
           //System.out.print("key is: "+ mentry.getKey() + " & Value is: " +mentry.getValue());
           HashMap map2=  (HashMap)mentry.getValue();
           Set set2= map2.entrySet();
           Iterator iterin=set2.iterator();
         while(iterin.hasNext())
         {
        	 Map.Entry entry = (Map.Entry)iterin.next();
        	 
        	 if(entry.getKey()=="name")
        		 name=(String) entry.getValue();
        	 if(entry.getKey()=="number")
        		 number=Integer.parseInt((String) entry.getValue());
        	 if(entry.getKey()=="choice")
        		 choice=Double.parseDouble((String)entry.getValue());
        	  amount = 100;
         }
              if (choice == 2)
               {
                   if (rouletteNum == number)
                       result = 35;
                   else
                       result = 0;
               }
               else
               {
                   if (rouletteNum == 0 || rouletteNum % 2 != choice)
                       result = 0;
                   else
                       result = 1;
               }

               
               if (result > 0)
               {
                   
            	   System.out.println(name+"      "+ number+"      "+result+"     "+choice);
                   total = (result + 1) * amount + total;
                   win ++;
                 resultArr[rouletteNum]++; 
                   
               }
               else
               {
                  System.out.println(name+"      "+ number+"      "+result+"     "+choice);
                   total = total - (result + 1) * (amount);
                   lose ++;
                   resultArr[rouletteNum]++; 
                   
                   if (total <= 0) {
                	   break;
                   }

               }

               System.out.println("Player"+"  "+"Total Win"+"  "+"Total Bet");
               
               for (int totals=1; totals<36; totals++) {
            		if( resultArr[totals] > 0 ) {
            			System.out.println(name+"       " + totals +"       "+ resultArr[totals] );
            		}
            	}
      }

   }
}