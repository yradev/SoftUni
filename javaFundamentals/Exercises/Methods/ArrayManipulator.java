package Method;

import java.util.*;

public class ArrayManipulator {
    public static void main(String[] args) {
    Scanner Input = new Scanner(System.in);
    String input = Input.nextLine();
    int[] Array = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        while (!input.equalsIgnoreCase("end")) {
        String[] Split = input.split(" ");

        String Command = Split[0];
        switch (Command) {
            case "exchange":
                int index = Integer.parseInt(Split[1]);
                Array = getExchange(Array, index);
                break;
            case "max":
                switch (Split[1]) {
                    case "odd":
                        getOddMaxIndex(Array);
                        break;
                    case "even":
                        getEvenMaxIndex(Array);
                        break;
                }
                break;
            case "min":
                switch (Split[1]) {
                    case "odd":
                        getMinOdd(Array);
                        break;
                    case "even":
                        getMinEven(Array);
                        break;
                }
                break;
            case "first":
                switch (Split[2]) {
                    case "odd":
                        int count = Integer.parseInt(Split[1]);
                        GetFirstOdd(Array, count);
                        break;
                    case "even":
                        count = Integer.parseInt(Split[1]);
                        GetFirstEven(Array, count);
                        break;
                }
                break;
            case "last":
                switch (Split[2]) {
                    case "odd":
                        int count = Integer.parseInt(Split[1]);
                        getLastOdd(Array, count);
                        break;
                    case "even":
                        count = Integer.parseInt(Split[1]);
                        getLastEven(Array, count);
                        break;
                }
        }
        input = Input.nextLine();
    }
        System.out.println(String.join(" ", Arrays.toString(Array)));
}

    private static void GetFirstOdd(int[] array, int count){
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int[] NumsArray = new int[count];
            int Index = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (array[i] % 2 != 0) {
                    NumsArray[Index] = array[i];
                    Index++;
                }
                if (Index == count) {
                    break;
                }
            }

            NumsArray = Arrays.stream(NumsArray)
                    .limit(Index)
                    .toArray();

            System.out.println(String.join(" ", Arrays.toString(NumsArray)));
        }
    }

    private static void GetFirstEven(int[] array, int count) {
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int[] NumsArray = new int[count];
            int Index = 0;
            for (int i = 0; i <= array.length - 1; i++) {
                if (array[i] % 2 == 0) {
                    NumsArray[Index] = array[i];
                    Index++;
                }
                if (Index == count) {
                    break;
                }
            }

            NumsArray = Arrays.stream(NumsArray)
                    .limit(Index)
                    .toArray();

            System.out.println(String.join(" ", Arrays.toString(NumsArray)));
        }
    }

    private static void getMinEven(int[] array) {
        int Number = Integer.MAX_VALUE;
        int Index = 0;
        int True = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] % 2 == 0 && array[i]<=Number) {
                Number = array[i];
                Index = i;
                True = 1;
            }
        }

        if (True == 1) {
            System.out.println(Index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMinOdd(int[] array) {
        int Number = Integer.MAX_VALUE;
        int Index = 0;
        int True = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] % 2 != 0 && array[i]<=Number) {
                Number = array[i];
                Index = i;
                True = 1;
            }
        }

        if (True == 1) {
            System.out.println(Index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getLastOdd(int[] array, int count) {
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int[] lastOdd = new int[count];
            int Index = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 != 0) {
                    lastOdd[Index] = array[i];
                    Index++;
                }
                if (Index == count) {
                    break;
                }
            }
            lastOdd = Arrays.stream(lastOdd)
                    .limit(Index)
                    .toArray();

            int ReverseIndex =0;
            int [] ReversedArray = new int [lastOdd.length+1];
            for(int i=lastOdd.length-1; i>=0;i--){
                ReversedArray[ReverseIndex]=lastOdd[i];
                ReverseIndex++;
            }

            ReversedArray = Arrays.stream(ReversedArray)
                    .limit(Index)
                    .toArray();

            System.out.println(String.join(" ", Arrays.toString(ReversedArray)));

        }
    }
    private static void getLastEven(int[] array, int count) {
        if (count > array.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            int Index = 0;
            int[] lastEven = new int[count];
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] % 2 == 0) {
                    lastEven[Index] = array[i];
                    Index++;
                }
                if (Index == count) {
                    break;
                }
            }
            lastEven = Arrays.stream(lastEven)
                    .limit(Index)
                    .toArray();

            int ReverseIndex =0;
            int [] ReversedArray = new int [lastEven.length+1];
            for(int i=lastEven.length-1; i>=0;i--){
                ReversedArray[ReverseIndex]=lastEven[i];
                ReverseIndex++;
            }

            ReversedArray = Arrays.stream(ReversedArray)
                    .limit(Index)
                    .toArray();

            System.out.println(String.join(" ", Arrays.toString(ReversedArray)));
        }
    }

    private static void getOddMaxIndex(int[] array) {
        int Number = Integer.MIN_VALUE;
        int Index = 0;
        int True = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i]>=Number) {
                Number = array[i];
                Index = i;
                True = 1;
            }
        }

        if (True == 1) {
            System.out.println(Index);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getEvenMaxIndex(int[] array) {
        int Number = Integer.MIN_VALUE;
        int Index = 0;
        int True = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i]>=Number) {
                Number = array[i];
                Index = i;
                True = 1;
            }
        }

        if (True == 1) {
            System.out.println(Index);
        } else {
            System.out.println("No matches");
        }
    }

    private static int[] getExchange(int[] array, int index) {
        if (index < array.length && index >= 0) {
            int OldIndex = 0;
            int[] tempArray = new int[array.length];
            for (int i = index + 1; i <= array.length - 1; i++) {
                tempArray[OldIndex] = array[i];
                OldIndex++;
            }

            for (int i = 0; i <= index; i++) {
                tempArray[OldIndex] = array[i];
                OldIndex++;
            }

            array = tempArray;
            return array;
        } else {
            System.out.println("Invalid index");
        }
        return array;
    }
}
