import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int CITYNUMBER=sc.nextInt();sc.nextLine();
        List<String> city=new ArrayList<>();
        List<String> time=new ArrayList<>();
        String postCity=""; 
        String postTime="";
        for(int i=0;i<CITYNUMBER;i++){
            String[] temp=sc.nextLine().split(" ");
            city.add(temp[0]);
            time.add(temp[1]);
            if(i+1==CITYNUMBER){
                temp=sc.nextLine().split(" ");
                postCity=temp[0]; 
                postTime=temp[1];
            }
        }
        sc.close();
        int timeDifference=Integer.parseInt(postTime.substring(0,2))-Integer.parseInt(time.get(city.indexOf(postCity)));
        for(int i=0;i<city.size();i++){
            int timeCalculation=Integer.parseInt(time.get(i))+24;
            timeCalculation+=timeDifference;
            System.out.printf("%02d%s%n",timeCalculation%24,postTime.substring(2));
        }
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