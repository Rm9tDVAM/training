import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ElectionSpeech es=new ElectionSpeech(sc);
        sc.close();
        electionSpeechCalculation(es);
    }
    static void electionSpeechCalculation(ElectionSpeech es){
        int[] pollArray=new int[es.getSpeechTimes()];
        for(int i=0;i<pollArray.length;i++){
            for(int j=0;j<pollArray.length;j++){
                if(!(j==es.getSpeechTimesArray(i)-1)&&!(0==pollArray[j])){
                    pollArray[j]--;
                }
                if(j==es.getSpeechTimesArray(i)-1){
                    pollArray[j]++;
                }
            }
        C.print(pollArray);
        }
    }
}
class ElectionSpeech{
    private final int candidate;
    private final int voters;
    private final int speechTimes;
    private final int[] speechTimesArray;
    ElectionSpeech(Scanner sc){
        this.candidate=sc.nextInt();
        this.voters=sc.nextInt();
        this.speechTimes=sc.nextInt();
        this.speechTimesArray=new int[speechTimes];
        for(int i=0;i<this.speechTimes;i++){
            this.speechTimesArray[i]=sc.nextInt();
        }
    }
    public int getCandidate(){
        return this.candidate;
    }
    public int getVoters(){
        return this.voters;
    }
    public int getSpeechTimes(){
        return this.speechTimes;
    }
    public int[] getSpeechTimesArray(){
        return this.speechTimesArray;
    }
    public int getSpeechTimesArray(int index){
        return this.speechTimesArray[index];
    }
    public void showStatus(){
        System.out.println(this.candidate);
        System.out.println(this.voters);
        System.out.println(this.speechTimes);
        System.out.println(Arrays.toString(this.speechTimesArray));
    }
}
class Common{
    static int maxValueInIntArray(int[] array){
        int max=0;
        for(int i=0;i<array.length;i++){
            max=Math.max(max,array[i]);
        }
        return max;
    }
    static double maxValueInDoubleArray(double[] array){
        double max=0;
        for(int i=0;i<array.length;i++){
            max=Math.max(max,array[i]);
        }
        return max;
    }
    static int minValueInIntArray(int[] array){
        int min=2147483647;
        for(int i=0;i<array.length;i++){
            min=Math.min(min,array[i]);
        }
        return min;
    }
    static double minValueInDoubleArray(double[] array){
        double min=1.7976931348623157E308;
        for(int i=0;i<array.length;i++){
            min=Math.min(min,array[i]);
        }
        return min;
    }
    static int maxIndexInIntArray(int[] array){
        int max=0;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index=i;
            }
        }
        return index;
    }
    static double maxIndexInDoubleArray(double[] array){
        double max=0;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
                index=i;
            }
        }
        return index;
    }
    static int minIndexInIntArray(int[] array){
        int min=2147483647;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
    }
    static int minIndexInDoubleArray(double[] array){
        double min=1.7976931348623157E308;
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
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