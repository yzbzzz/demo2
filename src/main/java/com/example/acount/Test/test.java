package com.example.acount.Test;

public class test {
//    public static void main(String[] args) {
//
//        System.out.println("总数为"+count());
//    }


    public static int count(){
        //当前最大
        int max=0;
        String Y="";
        //正在累计
        int count = 0;
        String Z="";
        for( int a=1;a<10;a++){
            for(int b=0;b<10;b++){
                for(int c=0;c<10;c++){
                    int X = a*100+b*10+c;

                    if (b>a+c){
                        count=count+1;
                    }
                    else {
                        Z ="";
                        count=0;
                    }
                    if(count!=0){
                        Z=Z+ X +" ";
                    }
                    if(count>=max){
                        max=count;
                        Y=Z;
                    }

                }
            }
        }
        System.out.println("符合条件的数为"+Y);
        return max;
    }}





