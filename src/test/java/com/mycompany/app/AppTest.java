package com.mycompany.app;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;


public class AppTest 
  extends TestCase
{

    public AppTest(String testName){
        super(testName);
    }
    

    public static Test suite(){
        return new TestSuite(AppTest.class);
    }

    public void testApp(){
        assertTrue( true );
    }    

    public void testBadInt(){
      ArrayList<String> array = new ArrayList<>(Arrays.asList("abc","bcd","cde"));
      assertFalse((new App().moreThan(array,3,"abc")) != 1);
    }

    public void testIsNotTrue(){
      ArrayList<String> array = new ArrayList<>(Arrays.asList("abc","abc","bcd"));
      assertFalse((new App().moreThan(array,-2,"abc")) != -1);
    }

    public void testIsTrue(){
      ArrayList<String> array = new ArrayList<>(Arrays.asList("abc","abc","bcd"));
      assertTrue((new App().moreThan(array,1,"abc")) == -1);
    }

    public void testIsFalse(){
      ArrayList<String> array = new ArrayList<>(Arrays.asList("abc","abc","bcd"));
      assertFalse((new App().moreThan(array,1,"abc")) == 1);
    }

    public void checkEquality(){
      ArrayList<String> array = new ArrayList<>(Arrays.asList("abc","abc","bcd"));  
      assertTrue((new App().moreThan(array,0,"efg")) == 0);
    }
}
