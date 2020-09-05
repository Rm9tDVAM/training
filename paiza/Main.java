import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        AttendanceTime at=new AttendanceTime(sc);
        sc.close();
        calculation(at);
    }
    static void calculation(AttendanceTime at){
        int hour=0;
        int minute=0;
        for(int i=1;i<at.getTO_TRAIN().length;i++){
            minute+=Integer.parseInt(at.getTO_TRAIN(i));
        }
        hour=minute/60;
        minute%=60;
        for(int i=0;i<at.getTRAIN_TIMES();i++){
            at.setLimitHour(i,at.getHOUR(i)+hour);
            at.setLimitMinute(i,at.getMINUTE(i)+minute);
        }
        at.showStatus();
    }
}
class AttendanceTime{
    private final int LIMIT_HOUR=8;
    private final int LIMIT_MINUTE=59;
    private final String[] TO_TRAIN;
    private final int TRAIN_TIMES;
    private final int[] HOUR;
    private final int[] MINUTE;
    private int[] limitHour;
    private int[] limitMinute;
    AttendanceTime(Scanner sc){
        TO_TRAIN=sc.nextLine().split(" ");
        TRAIN_TIMES=sc.nextInt();
        HOUR=new int[TRAIN_TIMES];
        MINUTE=new int[TRAIN_TIMES];
        for(int i=0;i<TRAIN_TIMES;i++){
            HOUR[i]=sc.nextInt();
            MINUTE[i]=sc.nextInt();
        }
        limitHour=new int[TRAIN_TIMES];
        limitMinute=new int[TRAIN_TIMES];
        showStatus();
    }
    public String[] getTO_TRAIN(){
        return this.TO_TRAIN;
    }
    public String getTO_TRAIN(int index){
        return this.TO_TRAIN[index];
    }
    public int getTRAIN_TIMES(){
        return this.TRAIN_TIMES;
    }
    public int getHOUR(int index){
        return this.HOUR[index];
    }
    public int getMINUTE(int index){
        return this.MINUTE[index];
    }
    public void setLimitHour(int index,int hour){
        this.limitHour[index]=hour;
    }
    public void setLimitMinute(int index,int minute){
        this.limitMinute[index]=minute;
    }
    public void showStatus(){
        System.out.println(Arrays.toString(TO_TRAIN));
        System.out.println(TRAIN_TIMES);
        System.out.println(Arrays.toString(HOUR));
        System.out.println(Arrays.toString(MINUTE));
        System.out.println(Arrays.toString(limitHour));
        System.out.println(Arrays.toString(limitMinute));
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