import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int machineNumber=sc.nextInt();
        int sweetTreatNumber=sc.nextInt();
        int[] containerNumber=new int[machineNumber];
        for(int i=0;i<containerNumber.length;i++){
            containerNumber[i]=sc.nextInt();
        }
        sc.close();
        int[] contentArray=new int[containerNumber.length];
        int[] remainderArray=new int[containerNumber.length];
        boolean[] remainderBoolArray=new boolean[containerNumber.length];
        for(int i=0;i<containerNumber.length;i++){
            contentArray[i]=sweetTreatNumber/containerNumber[i];
            remainderArray[i]=sweetTreatNumber%containerNumber[i];
            remainderBoolArray[i]=false;
        }
        int remainderMin=1000;
        for(int i=0;i<remainderArray.length;i++){
            if(remainderArray[i]<remainderMin){
                remainderMin=remainderArray[i];
            }
        }
        for(int i=0;i<remainderArray.length;i++){
            if(remainderArray[i]==remainderMin){
                remainderBoolArray[i]=true;
            }
        }
        int machineMax=0;
        int answerIndex=0;
        for(int i=0;i<remainderBoolArray.length;i++){
            if(remainderBoolArray[i]==true){
                if(machineMax<containerNumber[i]){
                    machineMax=containerNumber[i];
                    answerIndex=i+1;
                }
            }
        }
        System.out.print(answerIndex);
    }
}
class c{
    static void print(Object obj){
        //System.out.println(obj.getClass());
        //System.out.println(obj.getClass().getName());
        if(obj.getClass().isArray()){
            if(obj instanceof int[]){
                System.out.println("c.print int[]");
                for(int i:((int[])obj)){
                    System.out.print(i+" ");
                }
            }
            if(obj instanceof int[][]){
                int[][] intArray=((int[][])obj);
                System.out.println("c.print int[][]");
                for(int i=0;i<intArray.length;i++){
                    for(int j=0;j<intArray[i].length;j++){
                        System.out.printf("%3d",intArray[i][j]);
                    }
                    System.out.println();
                }
            }
        }else if(obj instanceof List){
            System.out.println("c.print List");
            List<?> list=(List<?>)obj;
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }else{
            System.out.println("c.print");
            System.out.println(obj);
        }
    }
}