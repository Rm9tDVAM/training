import java.util.*;
import java.util.stream.*;
public class Main{
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    List<Integer> iList=Arrays.stream(str.split(" "))
        .map(Integer::parseInt)
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    for(int i=0,sum=0;i<iList.size();i++){
        if(i==0||i==1){
            sum+=iList.get(i)*10;
        }else{
            sum+=iList.get(i);
        }
        if(i+1==iList.size()){
            System.out.print(sum);
        }
    }
    sc.close();
    }
}