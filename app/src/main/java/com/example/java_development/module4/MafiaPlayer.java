package com.example.java_development.module4;

import java.util.HashMap;
import java.util.Map;

public class MafiaPlayer {
    private String name;
    private String role;
    private Integer score;

    public MafiaPlayer(String name, String role, Integer score) {
        setName(name);
        setRole(role);
        setScore(score);
    }

    public MafiaPlayer(String name, String role) {
        this(name, role, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "MafiaPlayer{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        MafiaPlayer mafiaPlayer1 = new MafiaPlayer("player1", "peaceful citizen");
        MafiaPlayer mafiaPlayer2 = new MafiaPlayer("player2", "peaceful citizen");

        HashMap<String, MafiaPlayer> hashMap = new HashMap<>();
        hashMap.put(mafiaPlayer1.getRole(), mafiaPlayer1);
        hashMap.put(mafiaPlayer2.getRole(), mafiaPlayer2);

        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key);
        }
        for (MafiaPlayer player : hashMap.values()) {
            System.out.println("Player: " + player);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Player: "
                    + entry.getValue());
        }
    }
}
