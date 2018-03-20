import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * problem 2
 */
public class Transaction {
    ArrayList<String> id;
    ArrayList<String> email;
    ArrayList<String> phone;
    ArrayList<String> card;


    public static void main(String[] args) throws IOException {

        //dataset dari transaksi :
        ArrayList<Transaction> transactions=new ArrayList<>();


        //membaca input pertama
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);
        System.out.print("Masukkan id customer : ");
        String input=in.readLine();

        //berhenti menerima input jika dilakukan command 'stop'
        while(!input.equalsIgnoreCase("stop")){
            Transaction newTransaction=new Transaction();
            newTransaction.id.add(input);

            System.out.print("Masukkan email customer : ");
            input=in.readLine();
            newTransaction.email.add(input);

            System.out.print("Masukkan phone customer : ");
            input=in.readLine();
            newTransaction.phone.add(input);

            System.out.print("Masukkan card customer : ");
            input=in.readLine();
            newTransaction.card.add(input);

            System.out.println("Data berhasil dimasukkan!");

            //list yg berisikan objek transaksi yang mungkin dimerged
            ArrayList<Transaction> merged=new ArrayList<>();
            //@param newcustomer menandakan apakah data transaksi yang terbaru merupakan data dari customer terbaru . Jika tidak (data customer sudah ada) , maka boolean variabel akan bernilai false
            boolean newcustomer=true;

            //jika data baru hanya ada satu (input pertama) , tidak perlu dicek apakah ada data yang sama
            if(transactions.size()!=0){
                for(int i=0;i<transactions.size();i++){
                    //data dari phone/card/email bisa multi-value
                    for(int j=0;j<transactions.get(i).email.size();j++){
                        if(newTransaction.email.equals(transactions.get(i).email.get(j))){
                            transactions.get(i).email.add(String.valueOf(newTransaction.email));
                            newcustomer=false;
                        }
                    }


                    for(int j=0;j<transactions.get(i).phone.size();j++){
                        if(newTransaction.phone.equals(transactions.get(i).phone.get(j))){
                            transactions.get(i).phone.add(String.valueOf(newTransaction.phone));
                            newcustomer=false;
                        }
                    }

                    for(int j=0;j<transactions.get(i).card.size();j++){
                        if(newTransaction.card.equals(transactions.get(i).card.get(j))){
                            transactions.get(i).card.add(String.valueOf(newTransaction.card));
                            newcustomer=false;
                        }
                    }

                    if(newcustomer==false){
                        //memasukkan data transaksi
                        transactions.get(i).id.add(String.valueOf(newTransaction.id));

                        //memasukkan objek tersebut dalam merged list jika misalnya belum dimasukkan
                        if(!merged.contains(transactions.get(i))){
                            merged.add(transactions.get(i));
                        }
                    }
                    //data customer baru
                    else if (newcustomer==true){
                        transactions.add(newTransaction);
                    }
                }

                //proses merging data customer
                for(int i=1;i<merged.size();i++){
                    //merging data transaksi ID
                    for(int j=0;j<merged.get(i).id.size();j++){
                        //mencegah duplikasi data
                        if(!merged.get(0).id.contains(merged.get(i).id.get(j))){
                            merged.get(0).id.add(merged.get(i).id.get(j));
                        }
                    }

                    //merging data transaksi email
                    for(int j=0;j<merged.get(i).email.size();j++){
                        //mencegah duplikasi data
                        if(!merged.get(0).email.contains(merged.get(i).email.get(j))){
                            merged.get(0).email.add(merged.get(i).email.get(j));
                        }
                    }

                    //merging data transaksi phone
                    for(int j=0;j<merged.get(i).phone.size();j++){
                        //mencegah duplikasi data
                        if(!merged.get(0).phone.contains(merged.get(i).phone.get(j))){
                            merged.get(0).phone.add(merged.get(i).phone.get(j));
                        }
                    }

                    //merging data transaksi card
                    for(int j=0;j<merged.get(i).id.size();j++){
                        //mencegah duplikasi data
                        if(!merged.get(0).card.contains(merged.get(i).card.get(j))){
                            merged.get(0).card.add(merged.get(i).card.get(j));
                        }
                    }



                }

                for(int i=0;i<merged.size();i++){
                    for(int j=0;j<transactions.size();j++)
                    if(transactions.get(j)==merged.get(i)){
                        transactions.remove(j);
                    }
                }


            }
            //memasukkan data pertama
            else{
                transactions.add(newTransaction);
            }

            System.out.println("DATA TRANSAKSI CUSTOMER : ");
            for(int i=0;i<transactions.size();i++){
                System.out.println("Customer"+i);
                System.out.print("    Transactions : ");
                for(int j=0;j<transactions.get(i).id.size();j++){
                    System.out.print(transactions.get(i).id.get(j)+" , ");
                }
                System.out.print("\n    Emails : ");
                for(int j=0;j<transactions.get(i).email.size();j++){
                    System.out.print(transactions.get(i).email.get(j)+" , ");
                }
                System.out.print("\n    Phone : ");
                for(int j=0;j<transactions.get(i).phone.size();j++){
                    System.out.print(transactions.get(i).phone.get(j)+" , ");
                }

                System.out.print("\n    Card : ");
                for(int j=0;j<transactions.get(i).card.size();j++){
                    System.out.print(transactions.get(i).card.get(j)+" , ");
                }
            }

            System.out.print("Masukkan id customer : ");
            input=in.readLine();
        }


    }

}
