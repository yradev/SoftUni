package Method;

import java.util.*;

public class TopNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List <Integer> Numbers = new ArrayList<>();
        for(int loop=1; loop<=n; loop++){
            GetNumbers(Numbers, loop);
            if(GetSumResult(Numbers) && GetOddResult(Numbers)){
                System.out.println(loop);
            }
            ClearList(Numbers);
        }
    }

    public static boolean GetOddResult(List<Integer> numbers) {
        boolean Result = false;
        for(int i = 0; i<= numbers.size()-1; i++){
            if(numbers.get(i)%2!=0){
                Result=true;
                break;
            }
        }
        if(Result){
            return true;
        }else{
            return false;
        }
    }

    public static void ClearList(List<Integer> numbers) {
        for(int b = numbers.size()-1; b>=0; b--) {
            numbers.remove(b);
        }
    }

    public static boolean GetSumResult(List<Integer> numbers) {
        int sum=0;
        for(int i = 0; i<= numbers.size()-1; i++){
            sum+= numbers.get(i);
        }
        if(sum%8==0){
            return true;
        }else{
            return false;
        }
    }

    public static void GetNumbers(List<Integer> numbers, int index) {
        String numberAsString = String.valueOf(index);

        for(int i=0; i<=numberAsString.length()-1; i++){
            numbers.add(numberAsString.charAt(i)-48);
        }
    }
}
