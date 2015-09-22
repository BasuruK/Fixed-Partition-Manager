/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fixed.partition.manager;

import java.util.Arrays;

/**
 *
 * @author Basuru
 */
public class Algorithms {
    
    private int minimumIndexValue = 0 ,minimumTime = 0;
    private int [] ChangedIndexes;
    
    
   public Algorithms()
   {
       
   }
   //Replace eliments to front with minimum selected time
   public void ReplaceSort(int [][] Array,int time)
   {
        for(int i = 0; i < time;i++)
        {
            if(Array[i][0] > 1)
            {
                minimumIndexValue = Array[i][2];
                
                for(int k = 1; k <= Array[i][0]*2;k++)
                {
                    if((k%2)==0)
                    {
                        try
                        {
                            if(minimumIndexValue >= Array[i][k+2])
                            {
                                minimumIndexValue = Array[i][k+2];
                                minimumTime = Array[i][k+1];
                            }
                            else
                            {
                                minimumTime = Array[i][k-1];
                                break;
                            }
                        }
                        catch(ArrayIndexOutOfBoundsException e)
                        {
                            //Do nothing
                        }
                    }
                }
                Array[i][1] = minimumTime;
                Array[i][2] = minimumIndexValue;
            }
        }
    }
   
   //Not used ignore 
   public void locationSort(int [][] Array,int time)
   {
       int [] temp;
       int [] min;
       int count=0,count1=0;
       
       for(int a = 0;a < time;a++)
       {
           count++;
       }
       min = new int[count];
       ChangedIndexes = new int[count];
       count = 0;
       for(int a = 0;a < time;a++)
       {
           if(Array[a][0] > 1)
           {
               min[count] = a;
               count++;
           }
       }
       count=0;
       
       for(int i = 0; i < time;i++)
        {
            if(Array[i][0] > 1)
            {
                temp = new int[50];
                minimumTime = Array[i][2];
                count1=0;
                //Get the minimum Index
                for(int b = 0; b < time;b++)
                {
                    if(Array[b][0] > 1)
                    {
                        try{
                            if(minimumTime > Array[min[count1+1]][2])
                            {
                                minimumIndexValue = min[count1+1];
                            }
                            else
                            {
                                minimumIndexValue = min[count1]; 
                            }
                        }catch(ArrayIndexOutOfBoundsException e){
                            //Do nothing
                        }catch(NullPointerException n){
                            System.out.println(n.getMessage());
                        }
                        count1++;
                    }
                }

                for(int j = 0;j < Array[i].length;j++)
                {
                    temp[j] = Array[minimumIndexValue][j];
                    Array[minimumIndexValue][j] = Array[i][j];
                    Array[i][j] = temp[j];
                    ChangedIndexes[i] = minimumIndexValue+1;
                }
                count++;
                break;
            }
        }
   }
   
   public void SORT(int [][] Array,int time)
    {
        int [] temp = new int[50];
        int minValue=0,minIndex=0;
        int i = 0;
        int j = 1;
      
        for(int k =0;k<time-1;k++)
        {
            //if Pair size is greater then 1
            if(Array[k][0] > 1)
            {
             //insert to the TempArray  the selected Row
               for(int l = 0;l<Array[k].length;l++)
               {
                   temp[l]=Array[k][l];
               }
               
               //initiate a min value
                minValue = Array[k][2];
                          
                for(;j<time;j++)
                {
                        //Compare the min time and select the minimum values row
                         if(minValue > Array[j][2])
                         {
                            minIndex = j;
                            minValue = Array[j][2];
                         }
                }
                //increment J according to K
                j=k+1;

                //Exchange
                try
                {
                    for(int a=0;a < Array[k].length;a++)
                    {
                        Array[k][a]=Array[minIndex][a];
                        Array[minIndex][a] = temp[a];
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //Do nothing cause array size varies according to the elements that are in it
                }
                    //fill array with 0
                    Arrays.fill(temp,0);
            }
        }
    }
   
       
    public void addProgramNo(int [][] Array,int time)
    {
        for(int i = 0;i < time;i++)
        {
            Array[i][3] = i+1;
        }
        
    }
   
   
   public static double Clear(int[][] timeCounter, int[][] programsAndTime, boolean[] isSet) 
    {
        double avgTurnAroundTime;
        
        //Clear time Counter
        for(int [] p : timeCounter)
        {
            Arrays.fill(p,0);
        }
        //Clear AVG time
        avgTurnAroundTime = 0;
        //Clear Programs and times
        for(int [] p : programsAndTime)
        {
            Arrays.fill(p, 0);
        }
        //clear isSet array
        Arrays.fill(isSet, false);
        return avgTurnAroundTime;
    }
}
