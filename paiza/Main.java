import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        CompatibilityCheck CC=new CompatibilityCheck(sc);
        System.out.print(Math.max(compatibilityCalculation(CC,CC.getNameA()),compatibilityCalculation(CC,CC.getNameB())));
        sc.close();
    }
    static int compatibilityCalculation(CompatibilityCheck CC,String name){
        String[] nameArray=name.split("");
        List<Integer> numberList=new ArrayList<>();
        for(int i=0;i<nameArray.length;i++){
            numberList.add(CC.getNumberFromCharacter(nameArray[i]));
        }
        for(int i=0;i<name.length()-1;i++){
            int size=numberList.size();
            for(int j=0;j<size-1;j++){
                int addNum=(numberList.get(j)+numberList.get(j+1));
                if(addNum>=101){
                    addNum-=101;
                }
                numberList.add(addNum);
            }
            for(int j=0;j<size;j++){
                numberList.remove(0);
            }
        }
        return numberList.get(0);
    }
}
class CompatibilityCheck{
    private final String nameA;
    private final String nameB;
    private final Map<String,Integer> numberFromCharacter;
    CompatibilityCheck(Scanner sc){
        String[] temp=sc.nextLine().split(" ");
        this.nameA=temp[0]+temp[1];
        this.nameB=temp[1]+temp[0];
        this.numberFromCharacter=new HashMap<>();
        for(int i=97,j=1;i<123;i++,j++){
            this.numberFromCharacter.put(String.valueOf((char)i),j);
        }
        //showStatus();
    }
    public String getNameA(){
        return this.nameA;
    }
    public String getNameB(){
        return this.nameB;
    }
    public int getNumberFromCharacter(String serchNumber){
        return this.numberFromCharacter.get(serchNumber);
    }
    public void showStatus(){
        System.out.println(this.nameA);
        System.out.println(this.nameB);
        System.out.println(this.numberFromCharacter);
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