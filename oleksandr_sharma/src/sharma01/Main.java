//package sharma01;

public class Main {
	  public static int even_calculate(long arg_1) {
	    int res = 0;
	    long temp;
	    while(arg_1 !=0) {
	      temp = arg_1 % 10;
	      arg_1 = arg_1 / 10;
	      if( temp % 2 == 0){
	        res++;
	      }
	    }
	    return res;
	  }
	  public static int even_calculate(int arg_1) {
	    int res = 0;
	    int temp;
	    while(arg_1 !=0) {
	      temp = arg_1 % 10;
	      arg_1 = arg_1 / 10;
	      if(temp % 2 == 0) {
	        res++;
	      }
	    }
	    return res;
	  }
	  
	  public static int odd_calculate(long arg_1) {
	    int res = 0;
	    long temp;
	    while(arg_1 !=0) {
	      temp = arg_1 % 10;
	      arg_1 = arg_1 / 10;
	      if(temp % 2 != 0 && temp != 0) {
	        res++;
	      }
	    }
	    return res;
	  }
	  public static int odd_calculate(int arg_1) {
	    int res = 0;
	    int temp;
	    while(arg_1 !=0) {
	      temp = arg_1 % 10;
	      arg_1 = arg_1 / 10;
	      if(temp % 2 != 0 && temp != 0) {
	        res++;
	      }
	    }
	    return res;
	  }
	  
	  public static int binary_calculate(int arg) {
	    String temp = Integer.toBinaryString(arg);
	    int one = 0;
	    int res = 0;
	    for(int i = 0;i < temp.length();i++) {
	      one = (int)temp.charAt(i);
	      if(one == 49) {
	        res++ ; 
	      }
	    }
	    
	    return res;
	  }
	  
	  public static int binary_calculate(long arg) {
	    String temp = Long.toBinaryString(arg);
	    int one = 0;
	    int res = 0;
	    for(int i = 0;i < temp.length();i++) {
	      one = (int)temp.charAt(i);
	      if(one == 49) {
	        res++ ; 
	      }
	    }
	    
	    return res;
	  }
	  
	  public static void main(String arg[]) {
	    final int record_book = 0x18089;
	    long phone_number = 380996183233L;
	    final int binary_code = 0b110010100001;
	    final int octal_number = 06241;
	    int remainder = ((25-1)%26)+1;
	    char remainder_ascii_letter = 66;
	    int temp_odd = odd_calculate(phone_number);
	    int temp_even = even_calculate(phone_number);
	    int temp_binary = binary_calculate(binary_code);
	    System.out.println("Compiled succeed.\n");
	  }
	}
