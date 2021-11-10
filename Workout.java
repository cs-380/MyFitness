

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob Shank
 */
public class Workout {
    private double maxWeight;
    private double lastWeight;
    private String name;
    private int maxReps;
    private int lastReps;
    
    public Workout(){
        
    }
    
    public Workout(double newMaxWeight, double newLastWeight, String newName, int newMaxReps, int newLastReps){
        maxWeight = newMaxWeight;
        lastWeight = newLastWeight;
        name = newName;
        maxReps = newMaxReps;
        lastReps = newLastReps;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getLastWeight() {
        return lastWeight;
    }

    public void setLastWeight(double lastWeight) {
        this.lastWeight = lastWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxReps() {
        return maxReps;
    }

    public void setMaxReps(int maxReps) {
        this.maxReps = maxReps;
    }

    public int getLastReps() {
        return lastReps;
    }

    public void setLastReps(int lastReps) {
        this.lastReps = lastReps;
    }
    
    public boolean equals(Workout a){
        if (this.name.equals(a.name)){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "For " + name + " \n" +
               "Your max weight is: " + maxWeight+ " lbs \n" +
               "Last time you used: " + lastWeight + " lbs \n" +
               "Your max repitions are: " + maxReps+ "\n" +
               "Last time you did: " + lastReps;
    }
    
}
