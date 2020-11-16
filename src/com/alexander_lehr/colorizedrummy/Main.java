package com.alexander_lehr.colorizedrummy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static ConcurrentHashMap<Integer, List<Character>> lists = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Character> chars = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        int count = 0;

        for(char c : args[0].toCharArray()) {
            if(!(c == 'r' || c == 'y' || c == 'b' || c == 'k')) return;
            chars.put(count, c);
            count++;
        }

        count = 0;

        while (chars.size() > 0) {
            for(int i : chars.keySet()) {
                if(lists.get(0) == null) {
                    lists.put(count, new ArrayList<>());
                    lists.get(count).add(chars.get(i));
                    chars.remove(i);
                    count++;
                } else {
                    for(int j : lists.keySet()) {
                        if(!lists.get(j).contains(chars.get(i)) && lists.get(j).size() < 3) {
                            lists.get(j).add(chars.get(i));
                            chars.remove(i);
                        } else if(chars.size() >= 3 && isEverythingMin()) {
                            lists.put(count, new ArrayList<>());
                            lists.get(count).add(chars.get(i));
                            chars.remove(i);
                            count++;
                        }
                    }
                }
            }

            if(chars.size() < 3) break;
        }

        for(int k : lists.keySet()) {
            for(int l : chars.keySet()) {
                if(!lists.get(k).contains(chars.get(l))) {
                    lists.get(k).add(chars.get(l));
                    chars.remove(l);
                }
            }
        }

        if(chars.size() > 0) {
            System.out.println("Error");
        } else {
            System.out.println("Success");
        }
    }

    private static boolean isEverythingMin() {
        for(int i : lists.keySet()) {
            if(lists.get(i).size() < 3) {
                return false;
            }
        }
        return true;
    }

}
