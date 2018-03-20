import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * problem 3
 */
public class NumberNormalizer {

    public static void main(String[] args) throws IOException {

        //membaca input pertama
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String phone =in.readLine();

        //lambang + di depan nomor , diabaikan
        if(phone.contains("+")){
            phone=phone.replace("+","");

        }

        if(phone.contains("*")){
            phone=phone.replace("*","");

        }

        if(phone.contains("?")){
            phone=phone.replace("?","");

        }

        if(phone.contains("/")){
            phone=phone.replace("/","");

        }

        if(phone.contains("-")){
            phone=phone.replace("-","");

        }



        //angka 0 di depan nomor , diabaikan
        if(phone.substring(0,1).equalsIgnoreCase("0")){
            phone=phone.replace("0","");
        }

        if(phone.substring(0,5).equalsIgnoreCase("(021)")){
            phone=phone.replace("(021)","");
        }



        System.out.println(phone);




    }


}
