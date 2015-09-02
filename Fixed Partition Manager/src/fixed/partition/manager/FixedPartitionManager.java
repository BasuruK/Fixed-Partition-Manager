/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.util.Scanner;

/**
 *
 * @author Basuru
 */
public class FixedPartitionManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Variables the system needs are defined here
        int noOfRegions;
        int noOfPrograms;
        
               
        System.out.println("Welcome to the Fixed Partition Manager");
        System.out.println("======================================= \n");
        
        //Get the inputs 
        
        Scanner getInput = new Scanner(System.in);
        
        System.out.println("Please Enter the number of memory Reigoions : ");
        
        noOfRegions = getInput.nextInt();
        
        System.out.println("Please Enter the number of programs to be executed : ");
        
        noOfPrograms = getInput.nextInt();
        
        System.out.println("According to the Regions you have entered enter the Memory sizes in order : ");
        
        for(int i = 0; i< noOfRegions; i++)
        {
            
        }
        
        
        
        
        
        
        
        
        
    }
    
}
