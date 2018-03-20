import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * problem 5
 */
public class Anagram {
    public static void main(String[] args) throws IOException {

        //membaca input pertama
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String pertama =in.readLine();
        String kedua= in.readLine();

        //@param count menandakan banyak huruf yang diremove/dihapus , samechar menunjukkan list huruf sama dari kedua string , removechar menunjukkan list huruf yang akan dihapus
        ArrayList<String> sameChar=new ArrayList<>();
        ArrayList<String> removeChar=new ArrayList<>();
        int count=0;

        if(pertama.length()>=kedua.length()){
            for(int i=0;i<kedua.length();i++){
                if(pertama.substring(i,i+1).equalsIgnoreCase(kedua.substring(i,i+1))){
                    sameChar.add(pertama.substring(i,i+1));
                }

            }
            for(int i=kedua.length()-1;i<pertama.length();i++){
                //boolean variable foundSame akan bernilai true jika tidak ada yang sama
                boolean foundSame=false;
                for(int j=0;j<sameChar.size();j++){
                    if(pertama.substring(i,i+1).equalsIgnoreCase(sameChar.get(j))){
                            foundSame=true;
                    }

                }

                if(foundSame==true){
                    sameChar.add(pertama.substring(i,i+1));
                }
                else{
                    removeChar.add(pertama.substring(i,i+1));
                }


            }
        }

        else if(pertama.length()<kedua.length()){
            for(int i=0;i<pertama.length();i++){
                if(kedua.substring(i,i+1).equalsIgnoreCase(pertama.substring(i,i+1))){
                    sameChar.add(pertama.substring(i,i+1));
                }

            }
            for(int i=pertama.length()-1;i<kedua.length();i++){
                //boolean variable foundSame akan bernilai true jika tidak ada yang sama
                boolean foundSame=false;
                for(int j=0;j<sameChar.size();j++){
                    if(kedua.substring(i,i+1).equalsIgnoreCase(sameChar.get(j))){
                        foundSame=true;
                    }

                }

                if(foundSame==true){
                    sameChar.add(kedua.substring(i,i+1));
                }
                else{
                    removeChar.add(kedua.substring(i,i+1));
                    count++;
                }


            }
        }


        System.out.print("OUTPUT : "+count+" removing ");
        for(int i=0;i<removeChar.size();i++){
            System.out.println(removeChar.get(i)+" , ");

        }


    }

}
