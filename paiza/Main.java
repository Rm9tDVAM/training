import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        TableAutogeneration ta=new TableAutogeneration(sc);
        sc.close();
        verticalCalculation(ta);
        horizontalCalculation(ta);
        showTable(ta);
    }
    static void horizontalCalculation(TableAutogeneration ta){
    }
    static void verticalCalculation(TableAutogeneration ta){
        for(int j=0;j<2;j++){
            for(int i=2;i<ta.getVertical();i++){
                int diffVertical=ta.getTable(1,j)-ta.getTable(0,j);
                ta.setTalbe(i,j,ta.getTable(i-1,j)+diffVertical);
            }
        }
    }
    static void showTable(TableAutogeneration ta){
        System.out.println();
        for(int i=0;i<ta.getVertical();i++){
            for(int j=0;j<ta.getHorizontal();j++){
                System.out.print(ta.getTable(i,j));
                if(!(j+1==ta.getTable()[i].length)){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
class TableAutogeneration{
    private final int vertical;
    private final int horizontal;
    private int[][] table;
    TableAutogeneration(Scanner sc){
        this.vertical=sc.nextInt();
        this.horizontal=sc.nextInt();
        this.table=new int[this.vertical][this.horizontal];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                this.table[i][j]=sc.nextInt();
            }
        }
        //showStatus();
    }
    public int getVertical(){
        return this.vertical;
    }
    public int getHorizontal(){
        return this.horizontal;
    }
    public int[][] getTable(){
        return this.table;
    }
    public int getTable(int i,int j){
        return this.table[i][j];
    }
    public void setTalbe(int i,int j,int inputNum){
        this.table[i][j]=inputNum;
    }
    public void showStatus(){
        System.out.println();
        System.out.println(this.vertical);
        System.out.println(this.horizontal);
        for(int i=0;i<this.vertical;i++){
            for(int j=0;j<this.horizontal;j++){
                System.out.print(table[i][j]);
                if(!(j+1==this.table[i].length)){
                    System.out.print(" ");
                }
            }
            System.out.println();
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