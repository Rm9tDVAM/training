import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SpeedViolation speedViolation=new SpeedViolation(sc);
        System.out.print(speedViolation.calculation());
        sc.close();
    }
}
class SpeedViolation{
    private final int INPUTLINE;
    private final Double SPEEDLIMIT;
    private String[] observationData;
    private Double[] timeArray;
    private Double[] locationArray;
    SpeedViolation(Scanner sc){
        this.INPUTLINE=sc.nextInt();
        this.SPEEDLIMIT=sc.nextDouble();sc.nextLine();
        this.observationData=new String[INPUTLINE];
        this.timeArray=new Double[INPUTLINE];
        this.locationArray=new Double[INPUTLINE];
        for(int i=0;i<INPUTLINE;i++){
            observationData[i]=sc.nextLine();
        }
        for(int i=0;i<this.observationData.length;i++){
            String[] temporaryArray=this.observationData[i].split(" ");
            this.timeArray[i]=Double.parseDouble(temporaryArray[0]);
            this.locationArray[i]=Double.parseDouble(temporaryArray[1]);
        }
    }
    public String calculation(){
        for(int i=1;i<this.observationData.length;i++){
            if(this.timeArray[i]==0&&this.locationArray[i]-this.locationArray[i-1]>this.SPEEDLIMIT||
              (this.locationArray[i]-this.locationArray[i-1])/(this.timeArray[i]-this.timeArray[i-1])>this.SPEEDLIMIT){
                return "YES";
            }
        }
        return "NO";
    }
    public void showStatus(){
        System.out.println(this.INPUTLINE);
        System.out.println(this.SPEEDLIMIT);
        System.out.println(Arrays.toString(this.observationData));
        System.out.println(Arrays.toString(this.timeArray));
        System.out.println(Arrays.toString(this.locationArray));
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