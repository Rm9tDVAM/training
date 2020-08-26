import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        GameScore gameScore=new GameScore(sc.nextLine());
        gameScore.inputFactor(sc.nextLine());
        gameScore.inputScore(sc);
        sc.close();
        gameScore.showScore();
    }
}
class GameScore{
    private final int PARAMETER;
    private final int USERS;
    private final int TOP;
    private Double[] factor;
    private int[] score;
    GameScore(String nextLine){
        String[] temporaryArray=nextLine.split(" ");
        this.PARAMETER=Integer.parseInt(temporaryArray[0]);
        this.USERS=Integer.parseInt(temporaryArray[1]);
        this.TOP=Integer.parseInt(temporaryArray[2]);
        this.factor=new Double[PARAMETER];
        this.score=new int[USERS];
    }
    public void inputFactor(String nextLine){
        String[] temporaryArray=nextLine.split(" ");
        for(int i=0;i<temporaryArray.length;i++){
            this.factor[i]=Double.parseDouble(temporaryArray[i]);
        }
    }
    public void inputScore(Scanner sc){
        double temporaryDouble=0;
        for(int i=0;i<USERS;i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            for(int j=0;j<this.PARAMETER;j++){
                temporaryDouble+=Double.parseDouble(temporaryArray[j])*this.factor[j];
            }
            score[i]=(int)Math.round(temporaryDouble);
            temporaryDouble=0;
        }
    }
    public void showScore(){
        for(int i=0;i<this.score.length-1;i++){
            for(int j=i+1;j<this.score.length;j++){
                if(this.score[i]<this.score[j]){
                    int temporaryInt=this.score[i];
                    this.score[i]=this.score[j];
                    this.score[j]=temporaryInt;
                }
            }
        }
        for(int i=0;i<this.TOP;i++){
            System.out.println(this.score[i]);
        }
    }
    public void showStatus(){
        System.out.println(this.PARAMETER);
        System.out.println(this.USERS);
        System.out.println(this.TOP);
        System.out.println(Arrays.toString(factor));
        System.out.println(Arrays.toString(score));
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