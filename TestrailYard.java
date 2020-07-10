import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
public class TestrailYard<T>{

//Test CycleSort both array and List
@Test
public void testCycleSort(){
  RailYard<String> ry1 = new RailYard<String>(new int[]{4,5,5});
  
  //Test with array of String
  String[] str = {"aiam","dguyen","baige","crang"};
  String[] str1 ={"Liam"};
  
  String[] result1 = {"aiam","baige","crang","dguyen"};
  String[] result2 ={"Liam"};
  
  ry1.cycleSort(str);
  assertArrayEquals("Test for train that contains many string",result1,str);
  
  ry1.cycleSort(str1);
  assertArrayEquals("Test for train that contains 1 string",result2,str1);

  //Test with List of String
  List<String> str3 = new LinkedList<String>();
  str3.add("aiam");
  str3.add("dguyen");
  str3.add("baige");
  str3.add("crang");
   
  List<String> result3 = new LinkedList<String>();
  result3.add("aiam");
  result3.add("baige");
  result3.add("crang");
  result3.add("dguyen");
  ry1.cycleSort(str3);
  assertEquals("Test for train that contains many integer but in form of list",result3,str3);
  
  List<String> str4 = new LinkedList<String>();
  str4.add("Liam");
  
  List<String> result4 = new LinkedList<String>();
  result4.add("Liam");
  
  assertEquals("Test for train that contains many integer but in form of list",result4,str4);
  

  //Test with array of Integers
  RailYard<Integer> ry = new RailYard<Integer>(new int[]{4,5,5});
  Integer[] train = new Integer[]{2,9,10,3};
  Integer[] train1 = new Integer[]{2};
  
  Integer[] r1 = new Integer[]{2, 3, 9, 10};
  ry.cycleSort(train);
  assertArrayEquals("Test for train that contains many integers",r1,train);
  
  Integer[] r2 = new Integer[]{2};
  ry.cycleSort(train1);
  assertArrayEquals("test for train that contain 1 integers",r2,train1);
  //Test with List of Integers
  List<Integer> train2 = new LinkedList<Integer>();
  train2.add(2);
  train2.add(9);
  train2.add(10);
  train2.add(3);
   
  List<Integer> r3 = new LinkedList<Integer>();
  r3.add(2);
  r3.add(3);
  r3.add(9);
  r3.add(10);
  ry.cycleSort(train2);
  assertEquals("Test for train that contains many integer but in form of list",r3,train2);
  
  List<Integer> train3 = new LinkedList<Integer>();
  train3.add(2);
  
  List<Integer> r4 = new LinkedList<Integer>();
  r4.add(2);
  ry.cycleSort(train3);
  assertEquals("Test for train that contains one integer but in form of list",r4,train3);
}


//Test Closet Sort both array and list
@Test 
public void testClosetSort(){
 RailYard<String> ry1 = new RailYard<String>(new int[]{4,5,5});
  
  //Test with array of String
  String[] str0 = {};
  String[] str = {"aiam","dguyen","baige","crang"};
  String[] str1 ={"Liam"};
  
  String[] result0 = {};
  String[] result1 = {"aiam","baige","crang","dguyen"};
  String[] result2 ={"Liam"};

  ry1.closestSort(str);
  assertArrayEquals("Test for train that contains many string",result1,str);
  
  ry1.closestSort(str1);
  assertArrayEquals("Test for train that contains 1 string",result2,str1);
  
  ry1.closestSort(str1);
  assertArrayEquals("Test for train that contains 0 string",result0,str0);
  
  //Test with List of String
  List<String> str3 = new LinkedList<String>();
  str3.add("aiam");
  str3.add("dguyen");
  str3.add("baige");
  str3.add("crang");
   
  List<String> result3 = new LinkedList<String>();
  result3.add("aiam");
  result3.add("baige");
  result3.add("crang");
  result3.add("dguyen");
  ry1.closestSort(str3);
  assertEquals("Test for train that contains many integer but in form of list",result3,str3);
  
  List<String> str4 = new LinkedList<String>();
  str4.add("Liam");
  
  List<String> result4 = new LinkedList<String>();
  result4.add("Liam");
  ry1.closestSort(str4);
  assertEquals("Test for train that contains many integer but in form of list",result4,str4);
  
  List<String> str5 = new LinkedList<String>();
  
  List<String> result5 = new LinkedList<String>();
  ry1.closestSort(str5);
  assertEquals("Test for train that contains nothing but in form of list",result5,str5);

  //Test array of Integer
  RailYard<Integer> ry = new RailYard<Integer>(new int[]{4,5,5});
  
  Integer[] train0 = new Integer[]{};
  Integer[] train = new Integer[]{1,9,11,3};
  Integer[] train1 = new Integer[]{2};
  
  Integer[] r0 = new Integer[]{};
  ry.closestSort(train0);
  assertArrayEquals("Test for train that contains no integers that in form of array",r0,train0);

  Integer[] r1 = new Integer[]{1, 3, 9, 11};
  ry.closestSort(train);
  assertArrayEquals("Test for train that contains many integers that in form of array",r1,train);
  
  Integer[] r2 = new Integer[]{2};
  ry.closestSort(train1);
  assertArrayEquals("Test for train that contain 1 integer that in form of array",r2,train1);
  
  //Test List of Integer
  List<Integer> train5 = new LinkedList<Integer>();
  
  List<Integer> r5 = new LinkedList<Integer>();
  ry.closestSort(train0);
  assertEquals("Test for train that contain no integer that in form of List",r5,train5);
  
  List<Integer> train2 = new LinkedList<Integer>();
  train2.add(1);
  train2.add(9);
  train2.add(11);
  train2.add(3);
   
  List<Integer> r3 = new LinkedList<Integer>();
  r3.add(1);
  r3.add(3);
  r3.add(9);
  r3.add(11);
  ry.cycleSort(train2);
  assertEquals("Test for train that contain many integer but in form of list",r3,train2);
  
  List<Integer> train3 = new LinkedList<Integer>();
  train3.add(2);
  
  List<Integer> r4 = new LinkedList<Integer>();
  r4.add(2);
  ry.cycleSort(train3);
  assertEquals("Test for train that contains one integer but in form of list",r4,train3);
}

}