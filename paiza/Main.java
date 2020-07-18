import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<String> besList=new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        List<String> afsList1=new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        List<String> afsList2=new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        int N=sc.nextInt();sc.nextLine();
        for(int i=0;i<N;i++){
            afsList1.add(0,afsList1.get(afsList1.size()-1));
            afsList1.remove(afsList1.size()-1);
        }
        for(int i=0;i<N;i++){
            afsList2.add(afsList2.size(),afsList2.get(0));
            afsList2.remove(0);
        }
        String S=sc.nextLine();
        String[] sArr=S.split("");
        for(int i=0,n=0;i<sArr.length;i++){
            n=besList.indexOf(sArr[i]);
            if(i%2==0){
                System.out.print(afsList1.get(n));
            }else{
                System.out.print(afsList2.get(n));
            }
        }
        sc.close();
    }
}