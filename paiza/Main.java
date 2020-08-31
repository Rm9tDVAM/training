import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sc.close();
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