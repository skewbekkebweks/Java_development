package com.example.java_development.module3;

public class Situation {
    Situation[] direction;
    int[] directionIndexes;
    String subject,text;
    int dK,dA,dR;
    public Situation (String subject, String text, int[] variantsIndexes, int dk,int da,int dr) {
        this.subject=subject;
        this.text=text;
        dK=dk;
        dA=da;
        dR=dr;
        directionIndexes = variantsIndexes;
        direction=new Situation[variantsIndexes.length];
    }
}
