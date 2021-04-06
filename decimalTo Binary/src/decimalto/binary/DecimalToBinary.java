
package decimalto.binary;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Random;

import java.util.Scanner;


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
        System.out.println("Hello. Welcome to Wale Wase Float Converters.\n");
        
        
        System.out.println(" \nIf you would like to output 30 random numbers,press 1 \nIf you would like to input the numbers to convert, press 2");
        
        
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
            switch (number) {
                case 1:
                    System.out.println("S/No.\t\tDecimal Number\t\tBinary Number\t\tRemarks");
                    for(int j=1;j<=30;j++){
                        
                        
                        DecimalFormat df2 = new DecimalFormat(".###");
                        double min = 0;
                        double max = 10.135;
                        double diff = max - min;
                        double randomValue = min + Math.random( ) * diff;
                        DecimalFormat df3 = new DecimalFormat(".#####");
                        BigDecimal bd=new BigDecimal(decimalToBinary(randomValue));
                        
                        double binaryNumber=Double.parseDouble(df2.format(randomValue));
//            doubleAsString.substring(indexOfDecimal)

                        String doubleNumber = df3.format(bd);

                        String doubleAsString = String.valueOf(doubleNumber);
                        int indexOfDecimal = doubleAsString.indexOf(".");
                        String str = String.valueOf(doubleAsString.substring(indexOfDecimal));
                        int charCount = str.length()-1;

                        if(charCount>4){



                            System.out.printf(j+"\t\t"+df2.format(randomValue)+"\t\t"+df3.format(bd)+"\t\tApproximate\n", j,j,j,j,j);
                        }
                        else
                        {


                            System.out.printf(j+"\t\t"+df2.format(randomValue)+"\t\t"+df3.format(bd)+"\t\tExact\n", j,j,j,j,j);

}}          break;
                case 2:
                    System.out.println(" Input the value you would like to convert");
                    Scanner input2 = new Scanner(System.in);
                    float value = input2.nextFloat();
                     
                       
                        DecimalFormat df3 = new DecimalFormat(".#####");
                        BigDecimal bd=new BigDecimal(decimalToBinary(value));
                        
                        


                        String doubleNumber = decimalToBinary(value);

                        String doubleAsString = String.valueOf(doubleNumber);
                        int indexOfDecimal = doubleAsString.indexOf(".");
                        String str = String.valueOf(doubleAsString.substring(indexOfDecimal));
                        int charCount = str.length()-1;
                        System.out.println("S/No.\t\tDecimal Number\t\tBinary Number\t\tRemarks");
                    if(charCount>5){
                        
                        
                        
                        System.out.printf(1+"\t\t"+value+"\t\t"+df3.format(decimalToBinary(value))+"\t\tApproximate\n");
                    }
                    else
                    {
                        
                        
                        System.out.printf(1+"\t\t"+value+"\t\t"+decimalToBinary(value)+"\t\tExact\n");
                        
                    }           break;
                default:
                    System.out.printf("Wrong Choice! Try Again");
                    break;
            }
            System.out.printf("Thank you!");
        
        
        
              
        



       
     
        
        
    }
    
    }

