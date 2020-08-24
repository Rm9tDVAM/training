import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        SearchResult searchResult=new SearchResult(sc.nextLine());
        sc.close();
        Boolean isPrint=true;
        for(int i=0,page=1;i<searchResult.getCOUNT();){
            for(int j=0;j<searchResult.getPAGESIZE();j++,i++){
                if(i<searchResult.getCOUNT()&&page==searchResult.getPAGENUMBER()){
                    System.out.print(i+1);
                    isPrint=false;
                    if(!(j+1==searchResult.getPAGESIZE())){
                        System.out.print(" ");
                    }
                }
                if(j+1==searchResult.getPAGESIZE()){
                    page++;
                }
            }
        }
        if(isPrint){
            System.out.print("none");
        }
    }
}
class SearchResult{
    private final int COUNT;
    private final int PAGESIZE;
    private final int PAGENUMBER;
    SearchResult(String input){
        String[] temporaryArray=input.split(" ");
        this.COUNT=Integer.parseInt(temporaryArray[0]);
        this.PAGESIZE=Integer.parseInt(temporaryArray[1]);
        this.PAGENUMBER=Integer.parseInt(temporaryArray[2]);
    }
    public int getCOUNT(){
        return this.COUNT;
    }
    public int getPAGENUMBER(){
        return this.PAGENUMBER;
    }
    public int getPAGESIZE(){
        return this.PAGESIZE;
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