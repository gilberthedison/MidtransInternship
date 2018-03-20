import java.util.ArrayList;

/**
 * problem 4
 */
public class Elevator {
    String nama;
    int origin;
    int destination;

    public Elevator(String nama,int origin, int destination) {
        this.nama=nama;
        this.origin = origin;
        this.destination = destination;
    }

    public static void main(String[] args){
        int cost=0;

        Elevator p1=new Elevator("p1",1,5);
        Elevator p2=new Elevator("p2",2,3);
        Elevator p3=new Elevator("p3",2,4);
        Elevator p4=new Elevator("p4",3,4);
        Elevator p5=new Elevator("p5",3,1);
        Elevator p6=new Elevator("p6",5,1);

        Elevator[] penumpang={p1,p2,p3,p4,p5,p6};

        //membuat list berisikan urutan embark/disembark
        ArrayList<String> embark=new ArrayList<>();
        ArrayList<String> disembark=new ArrayList<>();


        //ada 5 lantai lift , lift bergerak naik terlebih dahulu
        for(int i=1;i<=5;i++){
            for(int j=0;j<penumpang.length;j++){
                //embark
                if(penumpang[j].origin==i){

                    embark.add(penumpang[j].nama);
                    cost+=2;
                }

                //disembark
                if(penumpang[j].destination==i&&penumpang[j].origin<penumpang[j].destination){

                    disembark.add(penumpang[j].nama);
                    cost+=2;
                }
            }
            //bergerak 1 floor (naik)
            cost++;
        }

        //lift bergerak menurun
        for(int i=5;i>=1;i--){
            for(int j=0;j<penumpang.length;j++){
                //disembark
                if(penumpang[j].destination==i&&penumpang[j].origin>penumpang[j].destination){
                    disembark.add(penumpang[j].nama);
                    cost+=2;
                }
            }
            //bergerak 1 floor (turun)
            cost++;
        }

        System.out.println("Cost : "+cost);
        System.out.print("Embark orders : ");

        for(int i=0;i<embark.size();i++){
            System.out.print(embark.get(i)+" , ");
        }

        System.out.print("\nDisembark orders : ");

        for(int i=0;i<disembark.size();i++){
            System.out.print(disembark.get(i)+" , ");
        }

    }
}
