import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BreakKeybord bk=new BreakKeybord(sc);
        sc.close();
        calculation(bk);
    }
    static void calculation(BreakKeybord bk){
        for(int i=0;i<bk.getInputArray().length;i++){
            if(bk.getEngArray(bk.getCheckString().indexOf(bk.getInputArray(i)))>0){
                System.out.print(bk.getInputArray(i));
                bk.SetEngArray(bk.getCheckString().indexOf(bk.getInputArray(i)));
            }
        }
    }
}
class BreakKeybord{
    private final String checkString;
    private final int[] engArray=new int[26];
    private String[] inputArray;
    BreakKeybord(Scanner sc){
        checkString="abcdefghijklmnopqrstuvwxyz";
        String[] temp=sc.nextLine().split(" ");
        for(int i=0;i<this.engArray.length;i++){
            this.engArray[i]=Integer.parseInt(temp[i]);
        }
        inputArray=sc.nextLine().split("");
        //showStatus();
    }
    public String getCheckString(){
        return this.checkString;
    }
    public String getCheckString(int index){
        return this.checkString.substring(index,index+1);
    }
    public int[] getEngArray(){
        return this.engArray;
    }
    public int getEngArray(int index){
        return this.engArray[index];
    }
    public String[] getInputArray(){
        return this.inputArray;
    }
    public String getInputArray(int index){
        return this.inputArray[index];
    }
    public void SetEngArray(int index){
        this.engArray[index]--;
    }
    void showStatus(){
        for(int i=0;i<this.engArray.length;i++){
            System.out.print(this.engArray[i]);
            if(!(i+1==this.engArray.length)){
                System.out.print(" ");
            }
        }
        System.out.println();
        for(int i=0;i<this.inputArray.length;i++){
            System.out.print(this.inputArray[i]);
            if(!(i+1==this.inputArray.length)){
                System.out.print(" ");
            }
        }
    }
}
class Common{
    static int maxValueInIntArray(int[] array){
        int max=0;
        for(int i=0;i<array.length;i++){
            max=Math.max(max,array[i]);
        }
        return max;
    }
    static double maxValueInDoubleArray(double[] array){
        double max=0;
        for(int i=0;i<array.length;i++){
            max=Math.max(max,array[i]);
        }
        return max;
    }
    static int minValueInIntArray(int[] array){
        int min=2147483647;
        for(int i=0;i<array.length;i++){
            min=Math.min(min,array[i]);
        }
        return min;
    }
    static double minValueInDoubleArray(double[] array){
        double min=1.7976931348623157E308;
        for(int i=0;i<array.length;i++){
            min=Math.min(min,array[i]);
        }
        return min;
    }
    static int maxIndexInIntArray(int[] array){
        int max=0;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index=i;
            }
        }
        return index;
    }
    static double maxIndexInDoubleArray(double[] array){
        double max=0;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index=i;
            }
        }
        return index;
    }
    static int minIndexInIntArray(int[] array){
        int min=2147483647;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
    }
    static int minIndexInDoubleArray(double[] array){
        double min=1.7976931348623157E308;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
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
                System.out.println();
            }
            if(obj instanceof String[]){
                System.out.println("C.print String[]");
                for(String s:((String[])obj)){
                    System.out.println(s+" ");
                }
                System.out.println();
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
                System.out.println();
            }
        }else if(obj instanceof List){
            System.out.println("C.print List");
            List<?> list=(List<?>)obj;
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
                System.out.println();
        }else{
            System.out.println("C.print");
            System.out.println(obj);
        }
    }
}