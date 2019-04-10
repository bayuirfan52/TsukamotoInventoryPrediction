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
public class Produksi {

    private static double titik1 = 0;
    private static double titik2 = 2000;
    private static double titik3 = 7000;
    
    private static double value;
    private static double status;

    public static double getValue() {
        return value;
    }

    public static void setValue(double value) {
        Produksi.value = value;
    }

    public static double getStatus() {
        return status;
    }

    public static void setStatus(double status) {
        Produksi.status = status;
    }

    public static double getTitik1() {
        return titik1;
    }

    public static void setTitik1(double titik1) {
        Produksi.titik1 = titik1;
    }

    public static double getTitik2() {
        return titik2;
    }

    public static void setTitik2(double titik2) {
        Produksi.titik2 = titik2;
    }

    public static double getTitik3() {
        return titik3;
    }

    public static void setTitik3(double titik3) {
        Produksi.titik3 = titik3;
    }
    
    public static double bertambah(double in){
        value = (titik2 + (in * (titik3 - titik2)));
        return value;
    }
    
    public static double berkurang(double in){
        value = (titik3 - (in * (titik3 - titik2)));
        return value;
    }
}
