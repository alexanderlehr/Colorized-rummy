package com.alexander_lehr.colorizedrummy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static ConcurrentHashMap<Integer, List<Character>> lists = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, Character> chars = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        for (char c : args[0].toCharArray()) {
            if (!(c == 'r' || c == 'y' || c == 'b' || c == 'k')) return;
            chars.put(chars.size(), c);
        }

        lists.put(0, new ArrayList<>());
        lists.get(0).add(chars.get(0));
        chars.remove(0);

        for (int i : chars.keySet()) {
            for (int j : lists.keySet()) {
                if (!lists.get(j).contains(chars.get(i)) && lists.get(j).size() < 3) {
                    lists.get(j).add(chars.get(i));
                    chars.remove(i);
                } else if (chars.size() >= 3 && isEverythingMin()) {
                    lists.put(lists.size(), new ArrayList<>());
                    lists.get(lists.size() - 1).add(chars.get(i));
                    chars.remove(i);
                }
            }
        }


        for (int k : lists.keySet()) {
            for (int l : chars.keySet()) {
                if (!lists.get(k).contains(chars.get(l))) {
                    lists.get(k).add(chars.get(l));
                    chars.remove(l);
                }
            }
        }

        System.out.println((chars.size() > 0 ? "Error" : "Success"));
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
