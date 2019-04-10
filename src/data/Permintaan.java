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
public class Permintaan {
    private static double permintaan;
    
    private static double titik1 = 0;
    private static double titik2 = 1000;
    private static double titik3 = 5000;
    private static double value;

    public static double getPermintaan() {
        return permintaan;
    }

    public static void setPermintaan(double permintaan) {
        Permintaan.permintaan = permintaan;
    }

    public static double getTitik1() {
        return titik1;
    }

    public static void setTitik1(double titik1) {
        Permintaan.titik1 = titik1;
    }

    public static double getTitik2() {
        return titik2;
    }

    public static void setTitik2(double titik2) {
        Permintaan.titik2 = titik2;
    }

    public static double getTitik3() {
        return titik3;
    }

    public static void setTitik3(double titik3) {
        Permintaan.titik3 = titik3;
    }
    
    public static double turun(){
        if (permintaan >= titik1 && permintaan <= titik2) {
            value = 1;
        }
        else if (permintaan > titik2 && permintaan < titik3) {
            value = (titik3-permintaan)/(titik3-titik2);
        }
        else {
            value = 0;
        }
        return value;
    }
    
    public static double naik(){
        if (permintaan > titik2 && permintaan < titik3) {
            value = (permintaan-titik2)/(titik3-titik2);
        }
        else if (permintaan >= titik3) {
            value = 1;
        }
        else {
            value = 0;
        }
        return value;
    }
}
