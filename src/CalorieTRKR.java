/*
import java.util.*;
import java.sql.*;
import java.io.*;


public class CalorieTRKR extends User{
    private String fileName;
    private User person;
    
    
    public CalorieTRKR (User a){
        person = a;
        try{
            File file = new File(person.getUserName() + "CalorieTRKR.txt");
            if (file.exists()){
                fileName = person.getUserName() + "CalorieTRKR.txt";
            } else {
                Functions1.createFile(person.getUserName() + "CalorieTRKR.txt");
                fileName = person.getUserName() + "CalorieTRKR.txt";
            }
        } catch (Exception e){
            System.out.print(e);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }
    
    public void deleteTRKR(){
        Functions1.deleteFile(fileName);
    }
    
    public void addCalories(double cal){
        File file = Functions1.accessFile(fileName);
        Functions1.writeToFile(file, Double.toString(cal));
    }
    
    public int getDays() {
        File file = Functions1.accessFile(fileName);
        return Functions1.getNumberOfLines(file);
    }
    
}
*/
