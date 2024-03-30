package seleniumtest;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Reg {


    // TODO Auto-generated method stub
    
    
   
    public static boolean useRegex(final String input) {
       
            // Compile regular expression
            final Pattern pattern = Pattern.compile("RAGHURAM\\sVENKAT\\sCHANDAN", Pattern.CASE_INSENSITIVE);
            // Match regex against input
            final Matcher matcher = pattern.matcher(input);
            // Use results...
            return matcher.matches();
        }


    public static void main(String[] args) {
      useRegex("Satyendra Raghuram Chandan");
    }
    }




