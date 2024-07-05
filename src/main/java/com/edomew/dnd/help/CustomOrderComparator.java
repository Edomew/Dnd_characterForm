package com.edomew.dnd.help;

import java.util.Comparator;

public class CustomOrderComparator implements Comparator<String> {
    private final String order;

    public CustomOrderComparator(String order) {
        this.order = order;
    }

    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            int index1 = order.indexOf(java.lang.Character.toLowerCase(o1.charAt(i)));
            int index2 = order.indexOf(java.lang.Character.toLowerCase(o2.charAt(i)));
            if (index1 != index2) {
                return index1 - index2;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}