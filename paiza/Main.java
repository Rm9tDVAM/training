import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BlackAndWhite blackAndWhite=new BlackAndWhite(sc);
        sc.close();
        checkBlackAndWhite(blackAndWhite);
    }
    static void checkBlackAndWhite(BlackAndWhite blackAndWhite){
        for(int i=0;i<blackAndWhite.getVERTICAL();i++){
            String[] temporaryArray=blackAndWhite.getGRAY_IMAGE_ARRAY(i).split(" ");
            for(int j=0;j<blackAndWhite.getHORIZONTAL();j++){
                if(Integer.parseInt(temporaryArray[j])>=128){
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
                if(!(j+1==blackAndWhite.getHORIZONTAL())){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
class BlackAndWhite{
    private final int VERTICAL;
    private final int HORIZONTAL;
    private final String[] GRAY_IMAGE_ARRAY;
    BlackAndWhite(Scanner sc){
        this.VERTICAL=sc.nextInt();
        this.HORIZONTAL=sc.nextInt();sc.nextLine();
        this.GRAY_IMAGE_ARRAY=new String[this.VERTICAL];
        for(int i=0;i<this.VERTICAL;i++){
            this.GRAY_IMAGE_ARRAY[i]=sc.nextLine();
        }
    }
    public int getVERTICAL(){
        return this.VERTICAL;
    }
    public int getHORIZONTAL(){
        return this.HORIZONTAL;
    }
    public String getGRAY_IMAGE_ARRAY(int index){
        return this.GRAY_IMAGE_ARRAY[index];
    }
    public void showStatus(){
        System.out.println(this.VERTICAL);
        System.out.println(this.HORIZONTAL);
        System.out.println(Arrays.toString(this.GRAY_IMAGE_ARRAY));
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