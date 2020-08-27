import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TestResult testResult=new TestResult(sc);
        testResult.calculationRedPoint();
        testResult.showRedPoint();
        sc.close();
    }
}
class TestResult{
    int[] students;
    int rank;
    int[] english;
    int[] japanese;
    int[] math;
    TestResult(Scanner sc){
        this.students=new int[sc.nextInt()];
        this.rank=sc.nextInt();sc.nextLine();
        this.english=new int[students.length];
        this.japanese=new int[students.length];
        this.math=new int[students.length];
        for(int i=0;i<students.length;i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            this.english[i]=Integer.parseInt(temporaryArray[0]);
            this.japanese[i]=Integer.parseInt(temporaryArray[1]);
            this.math[i]=Integer.parseInt(temporaryArray[2]);
        }
    }
    public void calculationRedPoint(){
        this.calculation(this.english);
        this.calculation(this.japanese);
        this.calculation(this.math);
    }
    public void calculation(int[] inputArray){
        int[] temporaryArray=new int[inputArray.length];
        for(int i=0;i<inputArray.length;i++){
            temporaryArray[i]=inputArray[i];
        }
        for(int i=0;i<temporaryArray.length-1;i++){
            for(int j=i+1;j<temporaryArray.length;j++){
                if((!(temporaryArray[i]==999))&&temporaryArray[i]==temporaryArray[j]){
                    temporaryArray[j]=999;
                }
            }
        }
        for(int i=0;i<temporaryArray.length-1;i++){
            for(int j=i+1;j<temporaryArray.length;j++){
                int temporaryInt;
                if(temporaryArray[i]>temporaryArray[j]){
                    temporaryInt=temporaryArray[i];
                    temporaryArray[i]=temporaryArray[j];
                    temporaryArray[j]=temporaryInt;
                }
            }
        }
        for(int i=0,count=0;i<this.rank;i++){
            if(count<this.rank){
                for(int j=0;j<inputArray.length;j++){
                    if(temporaryArray[i]==inputArray[j]){
                        students[j]++;
                        count++;;
                    }
                }
            }
        }
    }
    public void showRedPoint(){
        for(int i:students){
            System.out.println(i);
        }
    }
    public void showStatus(){
        System.out.println(Arrays.toString(students));
        System.out.println(Arrays.toString(english));
        System.out.println(Arrays.toString(japanese));
        System.out.println(Arrays.toString(math));
        System.out.println();
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