/*Author: Wael Al-Akhali
 * version 1.0
 * Numbers to words converter 
 */

// the following function converts numbers to words,
//currently only supports numbers up to One Hundred Thousand
//This is code is still in debug mode.
class NumberToWords
{
      static public boolean HelperConverter(int num, String[] result)
      {
          String [] onez = {
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
          };
       
          String [] tenz = {
              "Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty",
              "Seventy", "Eighty", "Ninety", "Hundred"
          };
 
          result[0] = "";
          int single, tens, hundreds;
       
          if(num > 1000)
              return false;
       
          hundreds = num / 100;
          num = num - hundreds * 100;
          if( num < 20)
          {
              tens = 0; // special case
              single = num;
          }
          else
          {
              tens = num / 10;
              num = num - tens * 10;
              single = num;
          }
         
          if(hundreds > 0)
          {
             result[0] += onez[hundreds-1];
             result[0] += " Hundred ";
          }
          if(tens > 0)
          {
             result[0] += tenz[tens - 1];
             result[0] += " ";
          }
          if(single > 0)
          {
             result[0] += onez[single - 1];
             result[0] += " ";
          }
          return true;
      }
 
      static public boolean Convert(int num, String[] result)
      {
          String tempString[] = new String[1];
          tempString[0] = "";
          int thousands;
          int temp;
          result[0] = "";
          if(num < 0 || num > 100000)
          {
              System.out.println(num + " \tNot Supported yet");
              return false;
          }
       
          if( num == 0)
          {
             System.out.println(num + " \tZero");
             return false;
          }
               
          if(num < 1000)
          {  
              HelperConverter(num, tempString);
              result[0] += tempString[0];
          }
          else
          {
              thousands = num / 1000;
              temp = num - thousands * 1000;
              HelperConverter(thousands, tempString);
              result[0] += tempString[0];
              result[0] += "Thousand ";             
              HelperConverter(temp, tempString);
              result[0] += tempString[0];
          }
          return true;
      }
 
      public static void main(String[] args)
      {
          String [] result = new String[1];
          result[0] = "";
          int  i, num;
          //Array of numbers for testing purposes
          int [] list =
          {
            -1, 0, 5, 10, 15, 19, 20, 21, 25, 33, 49, 50, 72,
            99, 100, 101, 117, 199, 200, 214, 517, 589, 999,
            1000, 1010, 1018, 1200, 9890, 10119, 13535, 57019,
            99999, 100000, 100001
          };
 
          for (i = 0; i < list.length; i++)
          {
              num = list[i];
              if( Convert(num, result) == true)
                 System.out.println(num  + "\t" + result[0]);
          }
      }
}
