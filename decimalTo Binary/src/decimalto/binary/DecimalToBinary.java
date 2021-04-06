
package decimalto.binary;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Random;


public class DecimalToBinary {
       

  

    
    static String decimalToBinary(double num)
    {
        String binary = "";
  
        // Fetch the integral part of decimal number
        int Integral = (int) num;
  
        // Fetch the fractional part decimal number
        double fractional = num - Integral;
  
        // Conversion of integral part to
        // binary equivalent
        while (Integral > 0) 
        {
            int rem = Integral % 2;
  
            // Append 0 in binary
            binary += ((char)(rem + '0'));
  
            Integral /= 2;
        }
  
        // Reverse string to get original binary
        // equivalent
        binary = reverse(binary);
  
        // Append point before conversion of
        // fractional part
        binary += ('.');
  
        // Conversion of fractional part to
        // binary equivalent
        while (fractional != 0)
        {
            // Find next bit in fraction
            fractional *= 2;
            int fract_bit = (int) fractional;
  
            if (fract_bit == 1)
            {
                fractional -= fract_bit;
                binary += (char)(1 + '0');
            }
            else
            {
                binary += (char)(0 + '0');
            }
        }
        
    
        return binary;
    }
  
    static String reverse(String input) 
    {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;
  
        for (left = 0; left < right; left++, right--) 
        {
            // Swap values of left and right 
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }
  
    // Driver code
    public static void main(String[] args) {
        
        System.out.println("S/No.\t\tDecimal Number\t\tBinary Number\t\tRemarks");
        
        
        for(int j=1;j<=30;j++){
            DecimalFormat df2 = new DecimalFormat(".###");
            double min = 0;
            double max = 100.135;
            double diff = max - min;
            double randomValue = min + Math.random( ) * diff;
              DecimalFormat df3 = new DecimalFormat(".#####");
            BigDecimal bd=new BigDecimal(decimalToBinary(randomValue));
            int binaryNumber = Integer.parseInt(df3.format(bd));
            
            String doubleNumber = decimalToBinary(binaryNumber);
            String doubleAsString = String.valueOf(doubleNumber);
            int indexOfDecimal = doubleAsString.indexOf(".");
            String str = String.valueOf(doubleAsString.substring(indexOfDecimal));
            int charCount = str.length()-1;
            
        if(charCount>5){
          
           
           
            System.out.printf(j+"\t\t"+df2.format(randomValue)+"\t\t"+df3.format(bd)+"\t\tApproximate\n", j,j,j,j,j);
        }
        else
        {

           
            System.out.printf(j+"\t\t"+df2.format(randomValue)+"\t\t"+df3.format(bd)+"\t\tExact\n", j,j,j,j,j);  
        
        }
        
        



       
     
        
        
    }
    
    }
}
