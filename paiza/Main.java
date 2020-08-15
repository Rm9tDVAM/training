import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] numberArray=new int[N];
        for(int i=0;i<numberArray.length;i++){
            numberArray[i]=sc.nextInt();
        }
        sc.close();
        Common.print(numberArray);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numberArray.length;i++){
            if(!map.containsKey(numberArray[i])){
                map.put(numberArray[i],0);
            }
            if(map.size()==M){
                System.out.print(i+1);
                return;
            }
            if(i+1==numberArray.length){
                System.out.print("unlucky");
            }
        }
    }
}
class Common{
    static void print(Object object){
        if(object.getClass().isArray()){
            String className=object.getClass().getName();
            if(className.substring(0,2).equals("[[")){
                Object[][] objectArray=(Object[][])object;
                for(int i=0;i<objectArray.length;i++){
                    for(int j=0;j<objectArray[0].length;j++){
                        System.out.print(objectArray[i][j]);
                    }
                    System.out.println();
                }
            }else{
                //System.out.println(Arrays.toString((Object[])object));
                String[] strArray=
                Arrays.asList(object).toArray(new String[object.length]);
            }
        }else{
            System.out.println(object);
        }
    }
}