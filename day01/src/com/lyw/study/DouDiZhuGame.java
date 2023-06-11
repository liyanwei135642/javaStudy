package com.lyw.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 斗地主游戏
 */
public class DouDiZhuGame {
    public static void main(String[] args) {
        DouDiZhuGame game=new DouDiZhuGame();
    }
    static ArrayList<String> list;


    static{
        String[] colors={"♥","♠","♣","♦"};
        String[] numbers={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        list=new ArrayList<>();
        for (String color : colors) {
            for (String number : numbers) {
                list.add(color+number);
            }
        }
        list.add("🃏大王");
        list.add("🃏小王");
    }

    public DouDiZhuGame(){
        //洗牌
        Collections.shuffle(list);
        //发牌
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            player1.add(list.get(i*3));
            player2.add(list.get(i*3+1));
            player3.add(list.get(i*3+2));
        }
        diPai.add(list.get(51));
        diPai.add(list.get(52));
        diPai.add(list.get(53));

        System.out.println(list);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(diPai);
        List<String> list4 = List.of("645", "978", "saa");
        list4.add("789");
        System.out.println(list4);

    }






}
