/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logical;

import data.Permintaan;
import data.Persediaan;
import data.Produksi;
import java.util.Arrays;

/**
 *
 * @author bayuirfan
 */
public class Rule {
    private static double[] predicate;
    private static double[] zValue;
    private static int[][] rule;
    private static double result;
    
    /*
        Rule 2D Array
        use value 1 and -1
        [][0] = detect AND | OR
        [][1] = detect Permintaan naik | turun
        [][2] = detect Persediaan banyak | sedikit
        [][3] = detect Produksi bertambah | berkurang
    */
    public static void setRule(int[][] rule){
        Rule.rule = rule;
        predicate = new double[rule.length];
        zValue = new double[rule.length];
    }
    
    public static void getPredicate(){        
        for (int i = 0; i < rule.length; i++) {
            //AND
            if (rule[i][0] == 1) {
                //Permintaan Naik
                if (rule[i][1] == 1) {
                    //Persediaan Banyak
                    if (rule[i][2] == 1) {
                        predicate[i] = Math.min(Permintaan.naik(), Persediaan.banyak());
                    }
                    //Persediaan Sedikit
                    else {
                        predicate[i] = Math.min(Permintaan.naik(), Persediaan.sedikit());
                    }
                }
                //Permintaan Turun
                else {
                    //Persediaan Banyak
                    if (rule[i][2] == 1) {
                        predicate[i] = Math.min(Permintaan.turun(), Persediaan.banyak());
                    }
                    //Persediaan Sedikit
                    else {
                        predicate[i] = Math.min(Permintaan.turun(), Persediaan.sedikit());
                    }
                }
            }
            //OR
            else {
                //Permintaan Naik
                if (rule[i][1] == 1) {
                    //Persediaan Banyak
                    if (rule[i][2] == 1) {
                        predicate[i] = Math.max(Permintaan.naik(), Persediaan.banyak());
                    }
                    //Persediaan Sedikit
                    else {
                        predicate[i] = Math.max(Permintaan.naik(), Persediaan.sedikit());
                    }
                }
                //Permintaan Turun
                else {
                    //Persediaan Banyak
                    if (rule[i][2] == 1) {
                        predicate[i] = Math.max(Permintaan.turun(), Persediaan.banyak());
                    }
                    //Persediaan Sedikit
                    else {
                        predicate[i] = Math.max(Permintaan.turun(), Persediaan.sedikit());
                    }
                }
            }
        }
    }
    
    public static void getZValue(){
        for (int i = 0; i < rule.length; i++) {
            //Produksi Bertambah
            if (rule[i][3] == 1) {
                System.out.println("Bertambah");
                zValue[i] = Produksi.bertambah(predicate[i]);
            }
            //Produksi Berkurang
            else {
                System.out.println("Berkurang");
                zValue[i] = Produksi.berkurang(predicate[i]);
            }
        }
    }
    
    public static double getResult(){
        double pembilang = 0, penyebut = 0;
        for (int i = 0; i < rule.length; i++) {
            System.out.println("predikat[" + i + "] : " + predicate[i]);
            System.out.println("zValue[" + i + "] : " + zValue[i]);
            pembilang += (predicate[i] * zValue[i]);
            penyebut += predicate[i];
        }
        result = pembilang / penyebut;
        System.out.println("Result : " + result);
        return result;
    }
}
