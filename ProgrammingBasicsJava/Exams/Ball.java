package Exams;

import java.util.Scanner;

public class Ball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        int Points = 0;
        int [] ColorPoints = new int [6];

        for(int colors = 1; colors<=n; colors++ ){
            String color = in.nextLine();
            switch(color){
                case"red":
                    Points+=5;
                    ColorPoints[0]+=1;
                    break;
                case"orange":
                    Points+=10;
                    ColorPoints[1]+=1;
                    break;
                case"yellow":
                    Points+=15;
                    ColorPoints[2]+=1;
                    break;
                case"white":
                    Points+=20;
                    ColorPoints[3]+=1;
                    break;
                case"black":
                    Points/=2;
                    ColorPoints[4]+=1;
                    break;
                default:
                    ColorPoints[5]+=1;
            }
        }
        System.out.printf("Total points: %s\nPoints from red balls: %s\nPoints from orange balls: %s\nPoints from yellow balls: %s\nPoints from white balls: %s\nOther colors picked: %s\nDivides from black balls: %s",Points,ColorPoints[0],ColorPoints[1],ColorPoints[2],ColorPoints[3],ColorPoints[5],ColorPoints[4]);
    }
}