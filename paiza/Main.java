import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        UsingTimesSurvey uts=new UsingTimesSurvey(sc);
        sc.close();
        Map<Integer,Integer> userIdMap=new TreeMap<>();
        for(int i=0;i<uts.getUserId().length;i++){
            if(userIdMap.containsKey(Integer.parseInt(uts.getUserId(i)))){
                userIdMap.put(Integer.parseInt(uts.getUserId(i)),userIdMap.get(Integer.parseInt(uts.getUserId(i)))+1);
            }else{
                userIdMap.put(Integer.parseInt(uts.getUserId(i)),1);
            }
        }
        int maxValue=0;
        boolean isSecondLine=false;
        for(int i:userIdMap.keySet()){
            maxValue=Math.max(maxValue,userIdMap.get(i));
        }
        for(int i:userIdMap.keySet()){
            if(userIdMap.get(i)==maxValue){
                if(isSecondLine){
                    System.out.print(" ");
                }
                System.out.print(i);
                isSecondLine=true;
            }
        }
    }
}
class UsingTimesSurvey{
    private final int itemUsageTimes;
    private final String[] userId;
    UsingTimesSurvey(Scanner sc){
        this.itemUsageTimes=sc.nextInt();sc.nextLine();
        this.userId=sc.nextLine().split(" ");
    }
    public void showStatus(){
        System.out.println(itemUsageTimes);
        System.out.println(Arrays.toString(userId));
    }
    public int getItemUsageTimes(){
        return this.getItemUsageTimes();
    }
    public String[] getUserId(){
        return this.userId;
    }
    public String getUserId(int index){
        return this.userId[index];
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