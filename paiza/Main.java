import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        GameUsingNumber gameUsingNumber=new GameUsingNumber(sc.nextInt());sc.nextLine();
        for(int i=0;i<gameUsingNumber.getHINTNUMBER();i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            switch(temporaryArray[0]){
                case "<":
                    gameUsingNumber.setHintSymbolMax(Integer.parseInt(temporaryArray[1]));
                    break;
                case ">":
                    gameUsingNumber.setHintSymbolMin(Integer.parseInt(temporaryArray[1]));
                    break;
                case "/":
                    gameUsingNumber.setHintSymbolSlash(Integer.parseInt(temporaryArray[1]));
                    break;
            }
        }
        sc.close();
        if(!gameUsingNumber.hintSymbolMax.isEmpty()&&
           !gameUsingNumber.hintSymbolMin.isEmpty()&&
           !gameUsingNumber.hintSymbolSlash.isEmpty()){
               hintAnswerThree(gameUsingNumber);
        }else if(!gameUsingNumber.hintSymbolMax.isEmpty()&&
                 !gameUsingNumber.hintSymbolMin.isEmpty()){
                     hintAnswerTwo(gameUsingNumber);
        }else if(!gameUsingNumber.hintSymbolMax.isEmpty()&&
                 !gameUsingNumber.hintSymbolSlash.isEmpty()){
                     hintAnswerMax(gameUsingNumber);
        }else if(!gameUsingNumber.hintSymbolMin.isEmpty()&&
                 !gameUsingNumber.hintSymbolSlash.isEmpty()){
                     hintAnswerMin(gameUsingNumber);
        }
    }
    static void hintAnswerMin(GameUsingNumber gameUsingNumber){
        for(int i=hintMin(gameUsingNumber)+1;i<100;i++){
            for(int j=0;j<gameUsingNumber.hintSymbolSlash.size();j++){
                if(i%gameUsingNumber.getHintSymbolSlash(j)==0){
                    System.out.print(i);
                    return;
                }
            }
        }
    }
    static void hintAnswerMax(GameUsingNumber gameUsingNumber){
        for(int i=hintMax(gameUsingNumber)-1;i>0;i--){
            for(int j=0;j<gameUsingNumber.hintSymbolSlash.size();j++){
                if(i%gameUsingNumber.getHintSymbolSlash(j)==0){
                    System.out.print(i);
                    return;
                }
            }
        }
    }
    static void hintAnswerTwo(GameUsingNumber gameUsingNumber){
        for(int i=hintMin(gameUsingNumber)+1;i<hintMax(gameUsingNumber);i++){
            System.out.print(i);
        }
    }
    static void hintAnswerThree(GameUsingNumber gameUsingNumber){
        for(int i=hintMin(gameUsingNumber)+1;i<hintMax(gameUsingNumber);i++){
            for(int j=0;j<gameUsingNumber.hintSymbolSlash.size();j++){
                if(!(i%gameUsingNumber.getHintSymbolSlash(j)==0)){
                    break;
                }
                if(j+1==gameUsingNumber.hintSymbolSlash.size()){
                    System.out.print(i);
                }
            }
        }
    }
    static int hintMax(GameUsingNumber gameUsingNumber){
        int hintMax=0;
        for(int i=0;i<gameUsingNumber.hintSymbolMax.size();i++){
            hintMax=Math.max(hintMax,gameUsingNumber.getHintSymbolMax(i));
        }
        return hintMax;
    }
    static int hintMin(GameUsingNumber gameUsingNumber){
        int hintMin=1000;
        for(int i=0;i<gameUsingNumber.hintSymbolMin.size();i++){
            hintMin=Math.min(hintMin,gameUsingNumber.getHintSymbolMin(i));
        }
        return hintMin;
    }
}
class GameUsingNumber{
    final int HINTNUMBER;
    List<Integer> hintSymbolMax;
    List<Integer> hintSymbolMin;
    List<Integer> hintSymbolSlash;
    GameUsingNumber(int nextInt){
        this.HINTNUMBER=nextInt;
        this.hintSymbolMax=new ArrayList<>();
        this.hintSymbolMin=new ArrayList<>();
        this.hintSymbolSlash=new ArrayList<>();
    }
    public int getHINTNUMBER(){
        return this.HINTNUMBER;
    }
    public int getHintSymbolMax(int index){
        return this.hintSymbolMax.get(index);
    }
    public int getHintSymbolMin(int index){
        return this.hintSymbolMin.get(index);
    }
    public int getHintSymbolSlash(int index){
        return this.hintSymbolSlash.get(index);
    }
    public void setHintSymbolMax(int hintSymbolMax){
        this.hintSymbolMax.add(hintSymbolMax);
    }
    public void setHintSymbolMin(int hintSymbolMin){
        this.hintSymbolMin.add(hintSymbolMin);
    }
    public void setHintSymbolSlash(int hintSymbolSlash){
        this.hintSymbolSlash.add(hintSymbolSlash);
    }
    public void showStatus(){
        System.out.println(this.HINTNUMBER);
        System.out.println("Max"+this.hintSymbolMax);
        System.out.println("Mix"+this.hintSymbolMin);
        System.out.println("Slash"+this.hintSymbolSlash);
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