import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/**
 * This class sorts the cars in each train through classification yard
 * @author:Liam Nguyen
 * @since: November 16,2019
 */
public class RailYard<T extends Comparable<T>>{
  /*This field represents the array of classification yard*/
  private int[] tracks;
  /*This field represents the paratracks in each classification yard*/
  private ArrayList<ArrayList<LinkedList<T>>> paraTracks;
  
  /**
   * This is the contructor for RailYard 
   * @param tracks the array of classification yard
   */
  public RailYard(int[] tracks){
    this.tracks = tracks;
    paraTracks = new ArrayList<ArrayList<LinkedList<T>>>(tracks.length);
    for(int i =0;i<tracks.length;i++){
      paraTracks.add(new ArrayList<LinkedList<T>>(tracks[i]));
      for(int j=0;j<tracks[i];j++){
        paraTracks.get(i).add(new LinkedList<T>());
      }
    }
  }
  
  /**
   * This method helps merge the cars in the tracks into a list
   * @param merge is the collection yard
   * @param save the list that after we merge
   */
  public void merge(ArrayList<LinkedList<T>> merge, List<T> save){
    save.clear();
    /*This save the index of rays that the method is acting on*/
    int saveRays=0;
    /*This stores the min value of the cars in the front of each rays*/
    T min = null;
    /*This stores the number of elements in merge which is a classification yard*/
    int length =0;
    /*This loop helps count the number of elements in merge*/
    for(int i=0; i<merge.size(); i++){
      length+= merge.get(i).size();
    }
    
    /*This loops helps remove the smalest value of the cars in front 
     *Then add it to the array that need to be saved
     */
    for(int j=0; j< length;j++){
      /*This stores the smallest value of last cars*/
      min = null;
      /*The ray of the cars that has smallest value*/
      saveRays = 0;
    
     /*This loop helps find the min value*/
      
    for(int k =0; k< merge.size(); k++){
      if(!merge.get(k).isEmpty()){
      if(min == null || merge.get(k).getFirst().compareTo(min)<0){
        min = merge.get(k).getFirst();
        saveRays = k;
      }
    }
   }
    if(!merge.get(saveRays).isEmpty()){
    save.add(merge.get(saveRays).getFirst());
    merge.get(saveRays).remove(); 
   }
 }
}
  
  /**
   * This is methods uses cycle sort algorithm with array
   * @param train is the arrays of cars we take in
   */
  public void cycleSort(T[] train){
  
    /*This loop goes through each collection yard*/
    for(int i =0; i<tracks.length;i++){
       
      /*This remembers the rays that the method is acting on*/
      int saveRays =0;
      /*This store the list after using the merge method*/
      LinkedList<T> save = new LinkedList<T>();
      paraTracks.get(i).get(0).addLast(train[0]);
      
      /*This loop does the Cycle Sort algoriithm by comparing the value of the train and the train preceding to it
       *If it is larger then or equal to add it next to the preceding train
       *If it is not larger than add it to the next paratrack
       */
      for(int j =1;j<train.length;j++){
      if(train[j].compareTo(train[j-1])>=0)
        paraTracks.get(i).get(saveRays).addLast(train[j]);
      else{
        if(saveRays+1<paraTracks.get(i).size()){
        paraTracks.get(i).get(saveRays+1).addLast(train[j]);
        saveRays = saveRays+1; 
        }
        else{
          paraTracks.get(i).get(0).addLast(train[j]);
          saveRays =0;
        }
      }
   
    }
      this.merge(paraTracks.get(i),save);
      train = save.toArray(train);
  }
    for(T element: train){
       System.out.print(element+ " ");
    }
}
   /**
    * This methods uses cycle sort algorithm with a list 
    * @param train the list of cars we take in
    */
   public void cycleSort(List<T> train){
    /*This loop goes through each collection yard*/
    for(int i =0; i<tracks.length;i++){
      /*This remembers the rays that the method is acting on*/
      int saveRays =0;
      paraTracks.get(i).get(0).addLast(train.get(0));
      
      /*This loop does the Cycle Sort algoriithm by comparing the value of the train and the train preceding to it
       *If it is larger then or equal to add it next to the preceding train
       *If it is not larger than add it to the next paratrack
       */
      for(int j =1;j<train.size();j++){
      if(train.get(j).compareTo(train.get(j-1))>=0)
        paraTracks.get(i).get(saveRays).addLast(train.get(j));
      else{
        if(saveRays+1<paraTracks.get(i).size()){
        paraTracks.get(i).get(saveRays+1).addLast(train.get(j));
        saveRays = saveRays+1; 
        }
        else{
          paraTracks.get(i).get(0).addLast(train.get(j));
          saveRays =0;
        }
      }
    }
      this.merge(paraTracks.get(i),train);
  }
 }
  
   /**
    * This method uses closestSort algorithm with an array of cars
    * @param train the array of cars we take in
    */
   public void closestSort(T[] train){
    /*This loop goes through each collection yard
    * i is index of collection yard
    */
     for(int i=0; i< tracks.length;i++){
      /*This store the list after using the merge method*/
      LinkedList<T> save = new LinkedList<T>();
      
       /*This loop goes through each cars in train
        * j is index of cars in train that need to be added
        */
      for(int j =0;j< train.length; j++){
        
        if(paraTracks.get(i).get(0).isEmpty()){
           paraTracks.get(i).get(0).add(train[j]);
         }
         else{
           /*This stores the biggest value of the car in tracks in collection yard*/
           T max = paraTracks.get(i).get(0).getLast();
           /*This stores the index of tracks of last-car that has the smallest value*/
           int indexMin =0;
           /*This stores the index of the last-car that has the biggest value*/
           int indexMax =0; 
           
           //*This loops helps find the smallest value of back car in track*/
           for(int k=0; k< tracks[i]; k++){
                if(!paraTracks.get(i).get(k).isEmpty() && max.compareTo(paraTracks.get(i).get(k).getLast())>0){
                 max = paraTracks.get(i).get(k).getLast();
                 indexMin = k;
               }
             }
           
           /*This loop goes through each track to find the max value of the last cars*/
           for(int k=0; k < tracks[i];k++){
             if(!paraTracks.get(i).get(k).isEmpty() && max.compareTo(paraTracks.get(i).get(k).getLast())<0 &&
                paraTracks.get(i).get(k).getLast().compareTo(train[j])<0){
               max = paraTracks.get(i).get(k).getLast();
               indexMax = k;  
             }
           }
          
           /*If there is no last cars in track that is smaller than cars we need to add*/
             if(train[j].compareTo(max)<0){ 
             //*This stores whether we find an empty track in collection yard or not*/
               boolean add = false;
             // index of the loop
              int n=0;
              /* This loops goes through each track to find empty track*/
              while(n< tracks[i]&&add == false){
                if(paraTracks.get(i).get(n).isEmpty()){
                  paraTracks.get(i).get(n).add(train[j]);
                  add = true;
                }
                else{
                  n++;
                }
              }
              
              /*If we can't find an empty track add it to the track that has smallest back car*/
              if(add == false){
                paraTracks.get(i).get(indexMin).add(train[j]);
              }
           }
             else{
               paraTracks.get(i).get(indexMax).add(train[j]);
             }
         }
       }
      this.merge(paraTracks.get(i),save);
      train = save.toArray(train);
       }   
  }
   
   /**
    * This method uses closestSort algorithm with list
    * @param train the list of cars that we need to take in
    */
   public void closestSort(List<T> train){
     /*This loop goes through each collection yard
    * i is index of collection yard
    */
     for(int i=0; i< tracks.length;i++){
      /*This store the list after using the merge method*/
      LinkedList<T> save = new LinkedList<T>();
      
       /*This loop goes through each cars in train
        */
       for(T cars : train){
        if(paraTracks.get(i).get(0).isEmpty()){
           paraTracks.get(i).get(0).add(cars);
         }
         else{
           /*This stores the biggest value of the car in tracks in collection yard*/
           T max = paraTracks.get(i).get(0).getLast();
           /*This stores the smallest value of back-car in the tracks*/
           T min = paraTracks.get(i).get(0).getLast();
           /*This stores the index of tracks of car that has the smallest value*/
           int indexMin =0;
           /*This stores the index of tracks of last-car that has biggest value*/
           int indexMax =0; 
           
           //*This loops goes through each tracks to find the smallest value of back car in track*/
           for(int k=0; k< tracks[i]; k++){
                if(!paraTracks.get(i).get(k).isEmpty() && min.compareTo(paraTracks.get(i).get(k).getLast())>0){
                  min = paraTracks.get(i).get(k).getLast();
                  indexMin = k;
               }
             }
           
           /*This loop goes through each track to find the max value of the last cars*/
           for(int k=0; k < tracks[i];k++){
             if(!paraTracks.get(i).get(k).isEmpty() && max.compareTo(paraTracks.get(i).get(k).getLast())<0 &&
                paraTracks.get(i).get(k).getLast().compareTo(cars)<0){
               max = paraTracks.get(i).get(k).getLast();
               indexMax = k;  
             }
           }
          
             /*If there is no last cars in track that is smaller than cars we need to add*/
             if(cars.compareTo(max)<0){
              /*This stores whether we find an empty track in collection yard or not*/
              boolean add = false;
              int n=0;
              /* This loops goes through each track to find empty track*/
              while(n< tracks[i]&&add == false){
                if(paraTracks.get(i).get(n).isEmpty()){
                  paraTracks.get(i).get(n).add(cars);
                  add = true;
                }
                else{
                  n++;
                }
              }
              
              /*If we can't find an empty track add it to the track that has smallest back car*/
              if(add == false){
                paraTracks.get(i).get(indexMin).add(cars);
              }
           }
             else{
               paraTracks.get(i).get(indexMax).add(cars);
             }
         }
       }
      this.merge(paraTracks.get(i),train);
     }
   }
   
   /*
    * This is the main method
    * @param args the input String
    */
   public static <T extends Comparable<T>> void main(String[] args){
     /*This store value of array of collection yard*/
     int [] colYard = new int[Integer.parseInt(args[1])];
     /*This loop goes through the input string to add the value of collection yard*/
     for(int i=2; i< colYard.length+2;i++){
       colYard[i-2] = Integer.parseInt(args[i]);
     }
     /*This stores the list that contains the value of train*/
     LinkedList<String> train = new LinkedList<String>();
     /*This loop goes through the input string to add the value of cars in yard*/
     for(int k= 2+ colYard.length;k<args.length;k++){
       train.add(args[k]);
     }
     /*This stores the value of railyard*/
     RailYard<String> railyard = new RailYard<String>(colYard);
     if(args[0].equals("cycle")){
       railyard.cycleSort(train);
       System.out.println(train);
     }
     else{
       railyard.closestSort(train);
       System.out.println(train);
    }
   }
}