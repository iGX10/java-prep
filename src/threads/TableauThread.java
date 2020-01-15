package com.company.threads;

public class TableauThread extends Thread {
    int[] tableau = new int[5];
    int somme = 0;
    public TableauThread(int[] tableau){
        this.tableau = tableau;
    }
    @Override
    public void run(){

        for(int i=0; i<tableau.length; i++){
            somme +=tableau[i];
            System.out.println(getName()+" : Somme = "+somme);
        }
        System.out.println(getName()+  " : Fin calcul Somme !!");

    }
}
