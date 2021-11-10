/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Shank
 */
import java.util.*;
import java.sql.*;
import java.io.*;
public class Functions1 {


    public double calorieConverter(int tr, int tw, int aw, int dci) {
        int dw = tw - aw;
        if(dw == 0){
            return 0;
        }
        if (dw < 0){
            int cta = Math.abs(dw) * 3594;
            double cpd = cta / tr;
            return dci - cpd;
        } 
        else {
            int cta = dw *2750;
            double cpd = cta / tr;
            double cit = cpd - dci;
            return dci + Math.abs(cit);
        }
    }
    
    public int[] arrayAddition(int[][] arr ){
        int[] sumArr = new int[4];
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = 0; j < arr[0].length; j++){
                sum += arr[i][j];
            }
            sumArr[i] = sum; 
        }
        return sumArr;
    }
    
    public String addFood (String name, int cal){
        String str = "INSERT INTO TABLE_NAME " + "VALUES ('" + name + "', " + cal + ")";
        return str;
    }
    
    public static File accessFile(String str){
        File file = new File(str);
        return file;
    }
    
    public static void createFile(String str){
        try{
            File testFile = new File(str);
            if(testFile.createNewFile()){
                System.out.println("File created: " + testFile.getName());
            } else {
                System.out.println("That file already exists.");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void deleteFile(String str){
        try{
            File testFile = new File(str);
            if(testFile.delete()){
                System.out.println("File deleted: " + testFile.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public StringBuilder readFromFile(File file){
        StringBuilder strb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            do{
                strb = strb.append(line + "\n");
                line = br.readLine();
            } while (line != null); 
        } catch (Exception e){
            System.out.println(e);
        }
        return strb;
    }
    
    public static void writeToFile(File file, String str){
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(file, true));
            myWriter.append("\n" + str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public String readLine(StringBuilder sb, int n){
        Scanner reader = new Scanner(sb.toString());
        String str = " ";
        for(int i = 0; i < n; i++){
            str = reader.nextLine();
        }
        return str;
    }
    
    public static int getNumberOfLines(File file){
        int i = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            do{
                i++;
            } while (br.readLine() != null); 
        } catch (Exception e){
            System.out.println(e);
        }
        return i - 1;
    }
    
    public void replaceLine(String str, int n){
        
    }
    
    public int[] fillArray(int lineNu, int numFoods){
        int k = 0;
        int p = 1;
        int[] arr = new int[numFoods];
        //JavaTestCodeForCS380 a = new JavaTestCodeForCS380();
        while(k < numFoods){ 
            String str = "Food" + p + ".txt";
            //arr[k] = Integer.parseInt(
                    //a.readLine(a.readFromFile(a.accessFile(str)), lineNu));
            k++;
            p++;
        }
        return arr;
    }
}
