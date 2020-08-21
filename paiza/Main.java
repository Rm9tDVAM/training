import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Cook cook=new Cook(sc.nextInt());sc.nextLine();
        for(int i=0;i<cook.getFoodstuffNumber();i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            cook.setRequiredFoodstuff(temporaryArray[0],Integer.parseInt(temporaryArray[1]));
        }
        cook.setFoodstuffNumber(sc.nextInt());sc.nextLine();
        for(int i=0;i<cook.getFoodstuffNumber();i++){
            String[] temporaryArray=sc.nextLine().split(" ");
            cook.setFoodstuffStock(temporaryArray[0],Integer.parseInt(temporaryArray[1]));
        }
        sc.close();
        if(!cook.isFoodstuffEnough()){
            System.out.print("0");
            return;
        }
        System.out.print(cook.someCountCreatable());
    }
}
class Cook{
    private int foodstuffNumber;
    private Map<String,Integer> requiredFoodstuff;
    private Map<String,Integer> foodstuffStock;
    Cook(){
        this.foodstuffNumber=0;
        this.requiredFoodstuff=new HashMap<>();
        this.foodstuffStock=new HashMap<>();
    }
    Cook(int foodstuffNumber){
        new Cook();
        this.foodstuffNumber=foodstuffNumber;
    }
    public int getFoodstuffNumber(){
        return this.foodstuffNumber;
    }
    public int getRequiredFoodstuff(String key){
        return this.requiredFoodstuff.get(key);
    }
    public int getfoodstuffStock(String key){
        return this.foodstuffStock.get(key);
    }
    public void setFoodstuffNumber(int foodstuffNumber){
        this.foodstuffNumber=foodstuffNumber;
    }
    public void setRequiredFoodstuff(String key,int value){
        this.requiredFoodstuff.put(key,value);
    }
    public void setFoodstuffStock(String key,int value){
        this.foodstuffStock.put(key,value);
    }
    public void showStatus(){
        System.out.println(foodstuffNumber);
        System.out.println(requiredFoodstuff);
        System.out.println(foodstuffStock);
    }
    public Boolean isFoodstuffEnough(){
        for(String key:this.requiredFoodstuff.keySet()){
            if(!foodstuffStock.containsKey(key)){
                return false;
            }
        }
        return true;
    }
    public int someCountCreatable(){
        int creatableNumber=10000;
        for(String key:this.requiredFoodstuff.keySet()){
            creatableNumber=Math.min(creatableNumber,this.foodstuffStock.get(key)/this.requiredFoodstuff.get(key));
        }
        return creatableNumber;
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