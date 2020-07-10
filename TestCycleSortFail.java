import org.junit.*;
import static org.junit.Assert.*;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

//Test when Cycle Sort fails and when Closest Sort works
public class TestCycleSortFail{
@Test
public void testCycleSortFail(){
  RailYard<Integer> ry = new RailYard<Integer>(new int[]{4});

  Integer[] train1 = {6,4,3,0,6,4};
  Integer[] train2 = {6,4,3,0,6,4};
  
  Integer[] wrongResult = {0,3,4,6,4,6};
  Integer[] rightResult= {0,3,4,4,6,6};
  
  ry.cycleSort(train1);
  ry.closestSort(train2);
  
  assertArrayEquals("Test to make sure Cycle Sort is not working",wrongResult,train1);
  assertArrayEquals("Test to make sure Closest Sort is working",rightResult,train2);
  
}
}