package basicTest;

import java.util.Arrays;

public class Gitclass2 {


		 public static void main(String[] args)
		 {
     
			 String string = "List of Supplemental Services Custody Services Additional Services Fee Schedule Third-Party Agent Portfolio Transaction Fees+ $ 15.00 - transaction fee will be assessed for each loan, return, and reallocation transactions (loan/return) +Each Third-Party Agent Lender will be invoiced directly Subject to annual CPI increase - All Urban Consumers - U.S. City Average"; 
			 String CustAddHeader = "Custody Services Additional Services Fee Schedule";
			 String txtNAsubHeader = "Third-Party Agent Portfolio Transaction Fees+";
      	 String[] arr=string.split(" ");
      	 String s="";
      	 System.out.println(Arrays.asList(arr));
      	 
      	 for(String arr1:arr)
      	 {
      		 
      			  s+=arr1;
      			  
      		 
      	 }
			 
	 
       }
}
