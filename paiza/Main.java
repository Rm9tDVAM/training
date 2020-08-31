import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        RabbitAndTurtle rabbitAndTurtle=new RabbitAndTurtle(sc);
        sc.close();
        System.out.print(Calculation(rabbitAndTurtle));
    }
    static String Calculation(RabbitAndTurtle rabbitAndTurtle){
        String winner="";
        double usagiRestDistance=rabbitAndTurtle.getUSAGI_REST_DISTANCE();
        int usagiRestCount=0;
        double usagiDistance=0;
        double kameDistance=0;
        boolean isUsagiRun=true;
        while(true){
            if(isUsagiRun){
                usagiDistance+=1000/rabbitAndTurtle.getUSAGI_SPEED();
            }
            kameDistance+=1000/rabbitAndTurtle.getKAME_SPEED();
            if(usagiDistance>=rabbitAndTurtle.getDISTANCE()||
               kameDistance>=rabbitAndTurtle.getDISTANCE()){
                   break;
            }
            if(!isUsagiRun){
                usagiRestCount--;
                if(usagiRestCount==0){
                    isUsagiRun=true;
                }
            }
            if(usagiDistance>=usagiRestDistance){
                isUsagiRun=false;
                usagiRestCount=rabbitAndTurtle.getUSAGI_REST();
                usagiRestDistance+=rabbitAndTurtle.getUSAGI_REST_DISTANCE();
            }
        }
        if(usagiDistance==kameDistance){
            winner="DRAW";
        }else if(usagiDistance<kameDistance){
            winner="KAME";
        }else{
            winner="USAGI";
        }
        return winner;
    }
    static class RabbitAndTurtle{
        private final double DISTANCE;
        private final double USAGI_SPEED;
        private final double USAGI_REST_DISTANCE;
        private final int USAGI_REST;
        private final double KAME_SPEED;
        RabbitAndTurtle(Scanner sc){
            this.DISTANCE=sc.nextDouble()*1000;
            this.USAGI_SPEED=sc.nextDouble();
            this.USAGI_REST_DISTANCE=sc.nextDouble()*1000;
            this.USAGI_REST=sc.nextInt();
            this.KAME_SPEED=sc.nextDouble();
        }
        public double getDISTANCE(){
            return this.DISTANCE;
        }
        public double getUSAGI_SPEED(){
            return this.USAGI_SPEED;
        }
        public double getUSAGI_REST_DISTANCE(){
            return this.USAGI_REST_DISTANCE;
        }
        public int getUSAGI_REST(){
            return this.USAGI_REST;
        }
        public double getKAME_SPEED(){
            return this.KAME_SPEED;
        }
    }
}
class C{
    static void print(Object obj){
        //System.out.println(obj.getClass());
        //System.out.println(obj.getClass().getName());
        if(obj.getClass().isArray()){
            if(obj instanceof int[]){
                System.out.println("C.print int[]");
                for(int i:((int[])obj)){
                    System.out.print(i+" ");
                }
            }
            if(obj instanceof String[]){
                System.out.println("C.print String[]");
                for(String s:((String[])obj)){
                    System.out.println(s+" ");
                }
            }
            if(obj instanceof int[][]){
                int[][] intArray=((int[][])obj);
                System.out.println("C.print int[][]");
                for(int i=0;i<intArray.length;i++){
                    for(int j=0;j<intArray[i].length;j++){
                        System.out.printf("%3d",intArray[i][j]);
                    }
                    System.out.println();
                }
            }
        }else if(obj instanceof List){
            System.out.println("C.print List");
            List<?> list=(List<?>)obj;
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }else{
            System.out.println("C.print");
            System.out.println(obj);
        }
    }
}