package com;


/**
 * @author heqiang
 * @date 2025年07月27日15:56
 */
public class testt {

    public static class tt {
        public double occurbalance;

        public void setOccurbalance(double a){
            this.occurbalance = a;
        }
        public double getOccurbalance(){
            return this.occurbalance;
        }
    }

    public static void main(String[] args) {
        tt t = new tt();
        t.setOccurbalance(1);
        System.out.println(t.getOccurbalance());
        double aa = t.getOccurbalance();
        t.setOccurbalance(-aa);
        System.out.println(t.getOccurbalance());
    }
}
