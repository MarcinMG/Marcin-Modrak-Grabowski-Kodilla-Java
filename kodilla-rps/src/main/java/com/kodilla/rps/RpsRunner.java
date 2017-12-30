package com.kodilla.rps;

public class RpsRunner {
    public static void main(String[] args) {

        boolean end = false;
        RpsRules rules = new RpsRules();

        while(!end) {
            rules.getInfo();
            rules.showRules();
            end = true;
        }
    }
}
