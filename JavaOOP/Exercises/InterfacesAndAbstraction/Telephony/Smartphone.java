package JavaOOP.Exercises.InterfacesAndAbstraction.Telephony;

import java.util.List;

public class Smartphone implements Callable,Browsable{
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers= numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        String url = urls.get(0);
        for(int i=0;i<url.length();i++){
            if(Character.isDigit(url.charAt(i))){
                return "Invalid URL!";
            }
        }
        return String.format("Browsing: %s!",urls.remove(0));
    }

    @Override
    public String call() {
        String number = numbers.get(0);
        for(int i=0;i<number.length();i++){
            if(!Character.isDigit(number.charAt(i))){
                return "Invalid number!";
            }
        }
        return String.format("Calling... %s",numbers.remove(0));
    }
}
