import java.util.*;
import java.util.Map.Entry;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();sc.nextLine();
        Map<String,Integer> map=new HashMap<>();
        String[] tArr=sc.nextLine().split(" ");
        for(int i=0;i<tArr.length;i++){
            map.put(tArr[i],0);
        }
        int M=sc.nextInt();sc.nextLine();
        for(int i=0;i<M;i++){
            tArr=sc.nextLine().split(" ");
            map.put(tArr[0],map.get(tArr[0])+Integer.parseInt(tArr[1]));
        }
        System.out.println(map);
        List<Entry<String,Integer>> lEnt=new ArrayList<Entry<String,Integer>>(map.entrySet());
        Collections.sort(lEnt,new Comparator<Entry<String,Integer>>(){
            public int compare(Entry<String,Integer>obj1,Entry<String,Integer>obj2){
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        System.out.println(lEnt);
        for(Entry<String,Integer>entry:lEnt){
            System.out.println(entry.getKey());
        }
        sc.close();
    }
}
/*








        // 3.比較関数Comparatorを使用してMap.Entryの値を比較する(昇順)
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                // 4. 昇順
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });
        
        System.out.println("昇順でのソート");
        // 5. ループで要素順に値を取得する
        for(Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        // 6. 比較関数Comparatorを使用してMap.Entryの値を比較する（降順）
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
            //compareを使用して値を比較する
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
            {
                //降順
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        
        System.out.println("降順でのソート");
        // 7. ループで要素順に値を取得する
        for(Entry<String, Integer> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
 
}
*/