import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        NumsGame numsGame=new NumsGame(sc.nextInt());sc.nextLine();
        for(int i=0;i<numsGame.getInputLine();i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            switch(temporaryArray[0]){
                case ">":
                    numsGame.setSmall(Integer.parseInt(temporaryArray[1]));
                    break;
                case "<":
                    numsGame.setBig(Integer.parseInt(temporaryArray[1]));
                    break;
                case "/":
                    numsGame.setSlashList(Integer.parseInt(temporaryArray[1]));
                    break;
            }
        }
        sc.close();
        for(int i=numsGame.getSmall()+1;i<numsGame.getBig();i++){
            for(int j=0;j<numsGame.getSlashListSize();j++){
                if(!(i%numsGame.getSlashList(j)==0)){
                    break;
                }
                if(j+1==numsGame.getSlashListSize()){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
class NumsGame{
    private final int INPUTLINE;
    private int small; // >n より大きい
    private int big; // <n より小さい
    private List<Integer> slashList;
    NumsGame(int INPUTLINE){
        this.INPUTLINE=INPUTLINE;
        this.small=0;
        this.big=100;
        this.slashList=new ArrayList<>();
    }
    public int getInputLine(){
        return this.INPUTLINE;
    }
    public int getSmall(){
        return this.small;
    }
    public int getBig(){
        return this.big;
    }
    public int getSlashListSize(){
        return this.slashList.size();
    }
    public int getSlashList(int index){
        return this.slashList.get(index);
    }
    public void setSmall(int input){
        this.small=Math.max(this.small,input);
    }
    public void setBig(int input){
        this.big=Math.min(this.big,input);
    }
    public void setSlashList(int input){
        this.slashList.add(input);
    }
    public void showStatus(){
        System.out.println("INPUTLINE:"+this.INPUTLINE);
        System.out.println("small:"+this.small);
        System.out.println("big:"+this.big);
        System.out.println("slashList:"+this.slashList);
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