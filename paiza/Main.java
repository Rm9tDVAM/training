import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        final int VERTICAL=sc.nextInt();
        final int HORIZONTAL=sc.nextInt();
        final int INPUT_TIMES=sc.nextInt();sc.nextLine();
        String[] inputArray=new String[INPUT_TIMES];
        for(int i=0;i<inputArray.length;i++){
            inputArray[i]=sc.nextLine();
        }
        sc.close();
        String[][] gameField=initialization(VERTICAL,HORIZONTAL);
        int isWhatNumber=0;
        boolean isFound=false;
        for(int i=0;i<INPUT_TIMES;i++){
            String[] temporaryArray=inputArray[i].split(" ");
            int verticalEntry=Integer.parseInt(temporaryArray[0]);
            int horizontalEntry=Integer.parseInt(temporaryArray[1]);
            int horizontalSpace=Integer.parseInt(temporaryArray[2]);
            for(int j=0;j<gameField.length;j++){
                for(int k=0;k<horizontalEntry;k++){
                    if(isFound==false){
                        if(gameField[j][k+horizontalSpace].equals(".")){
                            if(k+1==horizontalEntry){
                                isWhatNumber=j;
                            }
                        }else{
                            isFound=true;
                        }
                    }
                }
            }
            for(int j=0;j<verticalEntry;j++){
                for(int k=0;k<horizontalEntry;k++){
                    gameField[isWhatNumber][k+horizontalSpace]="#";
                }
                isWhatNumber--;
            }
            isWhatNumber=0;
            isFound=false;
        }
        print(gameField);
    }
    static String[][] initialization(int VERTICAL,int HORIZONTAL){
        String[][] temporaryArray=new String[VERTICAL][HORIZONTAL];
        for(int i=0;i<VERTICAL;i++){
            for(int j=0;j<HORIZONTAL;j++){
                temporaryArray[i][j]=".";
            }
        }
        return temporaryArray;
    }
    static void print(Object object){
        if(object.getClass().isArray()){
            String className=object.getClass().getName();
            if(className.substring(0,2).equals("[[")){
                Object[][] objectArray=(Object[][])object;
                for(int i=0;i<objectArray.length;i++){
                    for(int j=0;j<objectArray[0].length;j++){
                        System.out.print(objectArray[i][j]);
                    }
                    System.out.println();
                }
            }else{
                System.out.println(Arrays.toString((Object[])object));
            }
        }else{
            System.out.println(object);
        }
    }
}