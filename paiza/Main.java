import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();sc.nextLine();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            String str=sc.nextLine();
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        int count=0;
        for(String key:map.keySet()){
            String str;
            String t_i=key.substring(0,1);
            if(t_i.equals("L")){
                str=key.substring(2)+" R";
            }else{
                str=key.substring(2)+" L";
            }
            System.out.println(str);
            if(map.containsKey(str)){
                int temp=1;
                while(true){
                    if(map.get(key)/temp==map.get(str)/temp){
                        temp++;
                    }else{
                        count+=temp-1;
                    }
                }
            }
        }
        System.out.print(count);
        sc.close();
    }
}