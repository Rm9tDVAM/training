import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int instructionNumber=sc.nextInt();sc.nextLine();
        String[] instructionNumberArray=new String[instructionNumber];
        for(int i=0;i<instructionNumber;i++){
            instructionNumberArray[i]=sc.nextLine();
        }
        sc.close();
        Computer computer=new Computer();
        for(int i=0;i<instructionNumber;i++){
            String[] temporaryArray=instructionNumberArray[i].split(" ");
            switch(temporaryArray[0]){
                case "ADD":
                    computer.add(Integer.parseInt(temporaryArray[1]));
                    break;
                case "SET":
                    if(Integer.parseInt(temporaryArray[1])==1){
                        computer.setVariableOne(Integer.parseInt(temporaryArray[2]));
                    }else{
                        computer.setVariableTwo(Integer.parseInt(temporaryArray[2]));
                    }
                    break;
                case "SUB":
                    computer.sub(Integer.parseInt(temporaryArray[1]));
                    break;
            }
        }
        computer.showStatus();
    }
}
class Computer{
    private int variableOne;
    private int variableTwo;
    public Computer(){
        this.variableOne=0;
        this.variableTwo=0;
    }
    public int getVariableOne(){
        return this.variableOne;
    }
    public int getVariableTwo(){
        return this.variableTwo;
    }
    public void setVariableOne(int variableOne){
        this.variableOne=variableOne;
    }
    public void setVariableTwo(int variableTwo){
        this.variableTwo=variableTwo;
    }
    public void add(int num){
        this.variableTwo=variableOne+num;
    }
    public void sub(int num){
        this.variableTwo=variableOne-num;
    }
    public void showStatus(){
        System.out.printf("%d %d%n",variableOne,variableTwo);
    }
}
class C{
    static void print(Object obj){
        //System.out.println(obj.getClass());
        //System.out.println(obj.getClass().getName());
        if(obj.getClass().isArray()){
            //System.out.println("isArray");
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