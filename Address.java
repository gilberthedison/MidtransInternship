import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * program untuk melihat kesamaan data dari dua buah alamat
 */
public class Address {
    //inisiasi variable , @param nama menandakan nama jalan , kota menandakan kota dari alamat tersebut , dan rt menandakan RT/RW dari alamat tersebut
    boolean nama;
    boolean kota;
    boolean rt;


    public Address() {
        this.nama = false;
        this.kota = false;
        this.rt = false;

    }

    public static void main(String[] args) throws IOException {


        //membaca input pertama
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        String input =in.readLine();

        Address pertama=new Address();
        pertama.fillingAddress(input);

        //membaca input kedua
        input=in.readLine();
        Address kedua=new Address();
        kedua.fillingAddress(input);

        Address.comparing(pertama,kedua);




    }

    public void fillingAddress(String input){
        //terdapat data alamat RT , penulisan RT selalu diikuti tanda titik
        if(input.contains("rt.")||input.contains("RT.")){
            this.rt=true;
        }
        //terdapat data alamat jalan
        if(input.contains("Jalan")||input.contains("Jl")||input.contains("JL")||input.contains("Jln")){
            this.nama=true;
        }

        //asumsi hanya untuk melihat data orang yang berasal dari Jakarta
        if(input.contains("Jak")){
            this.kota=true;
        }


    }

    public static void comparing(Address pertama, Address kedua){
        if(pertama.kota==true&&kedua.kota==true){
            System.out.print("Kedua alamat memiliki data kota");
        }
        if(pertama.rt==true&&kedua.rt==true){
            System.out.print("Kedua alamat memiliki data RT dan RW");
        }

        if(pertama.nama==true&&kedua.nama==true){
            System.out.print("Kedua alamat memiliki data nama jalan");
        }

    }


}
