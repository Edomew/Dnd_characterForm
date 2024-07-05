package test;

import com.edomew.dnd.character.skill.InfluenceType;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        Arrays.stream(InfluenceType.values()).forEach(s -> System.out.println(s.getDescription()));
    }
}
