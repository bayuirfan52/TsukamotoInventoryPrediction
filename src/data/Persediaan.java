/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author bayuirfan
 */
public class Persediaan {
    public static double persediaan;

    public static double titik1 = 0;
    public static double titik2 = 100;
    public static double titik3 = 600;
    
    public static double value;

    public static double getPersediaan() {
        return persediaan;
    }

    public static void setPersediaan(double persediaan) {
        Persediaan.persediaan = persediaan;
    }

    public static double getTitik1() {
        return titik1;
    }

    public static void setTitik1(double titik1) {
        Persediaan.titik1 = titik1;
    }

    public static double getTitik2() {
        return titik2;
    }

    public static void setTitik2(double titik2) {
        Persediaan.titik2 = titik2;
    }

    public static double getTitik3() {
        return titik3;
    }

    public static void setTitik3(double titik3) {
        Persediaan.titik3 = titik3;
    }
    
    public static double sedikit(){
        if (persediaan >=titik1 && persediaan <=titik2) {
            value = 1;
        }
        else if (persediaan >titik2 && persediaan <titik3) {
            value = (titik3 - persediaan)/(titik3-titik2);
        }
        else {
            value = 0;
        }
        return value;
    }
    
    public static double banyak(){
        if (persediaan >titik2 && persediaan < titik3) {
            value = (persediaan -titik2)/(titik3-titik2);
        }
        else if (persediaan >= titik3) {
            value = 1;
        }
        else {
            value = 0;
        }
        return value;
    }
}
