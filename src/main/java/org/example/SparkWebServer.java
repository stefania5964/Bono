package org.example;
import static spark.Spark.*;
public class SparkWebServer {
    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("cos", (req,res) -> {
            Double x = Double.parseDouble(req.queryParams("v"));
            return Double.valueOf(Math.cos(x));
        });
        get("sin", (req,res) -> {
            Double x = Double.parseDouble(req.queryParams("v"));
            return Double.valueOf(Math.sin(x));
        });
        get("palindrome", (req,res) ->  {
            Boolean pal =getPalindrome(req.queryParams("v"));

            return pal;
        });
        get("magnitud", (req,res) ->  {
            double mag = mag(req.queryParamsValues("v"));

            return mag;
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    private static Boolean getPalindrome(String str){
         if(str ==null){
             return false;
         } for( int i = 0, j =str.length()-1; i<j;i++,j--){
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
         return true;

    }
    private static double mag(String[] s){
        double a = Double.parseDouble(s[0]);
        double b = Double.parseDouble(s[1]);
        double hypo = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        return hypo ;

    }

}
