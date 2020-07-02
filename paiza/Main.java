import java.util.*;
import java.util.stream.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int ans=0;
        int n=sc.nextInt();sc.nextLine();
        String str=sc.nextLine();
        List<Integer> intList=Arrays.stream(str.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        if(n>=intList.get(0)){
            ans=n*intList.get(1);
        }else{
            ans=n*intList.get(2);
        }
        System.out.print(ans);
        sc.close();
    }
}