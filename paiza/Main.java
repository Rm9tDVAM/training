import java.util.*;
import java.util.regex.Pattern;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        AddressSurvey addressSurvey=new AddressSurvey(sc);
        sc.close();
        for(int i=0;i<addressSurvey.getIpAddressArraylength();i++){
            String[] temporaryArray=addressSurvey.getIpAddressArray(i).split(Pattern.quote("."));
            if(nullCheck(temporaryArray)){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }
    }
    static boolean nullCheck(Object[] obj){
        if(!(obj.length==4)){
            return false;
        }
        for(int i=0;i<4;i++){
            if(obj[i].equals("")){
                return false;
            }
        }
        for(int i=0;i<4;i++){
            if(Integer.parseInt(obj[i].toString())>255){
                return false;
            }
        }
        return true;
    }
}
class AddressSurvey{
    private final int INPUT_LINE;
    private final String[] ipAddressArray;
    AddressSurvey(Scanner sc){
        this.INPUT_LINE=sc.nextInt();sc.nextLine();
        this.ipAddressArray=new String[this.INPUT_LINE];
        for(int i=0;i<this.INPUT_LINE;i++){
            ipAddressArray[i]=sc.nextLine();
        }
    }
    public int getIpAddressArraylength(){
        return this.ipAddressArray.length;
    }
    public String getIpAddressArray(int index){
        return this.ipAddressArray[index];
    }
    public void showStatus(){
        System.out.println(this.INPUT_LINE);
        System.out.println(Arrays.toString(this.ipAddressArray));
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