package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



public class AppTest 
  extends TestCase
{

    public void test1()
    {
	App a = new App();
	String[] array = {"Turkey", "England", "Spain", "Turkey", "Russia", "France", "Norway", "Turkey"};
	assertTrue((a.moreThan(array, 4, "Turkey"))==1);
    }

    public void test2()
    {
	App a = new App();
	String[] array = {"Turkey", "England", "Spain", "Turkey", "Russia", "France", "Norway", "Turkey"};
	assertTrue((a.moreThan(array,3, "Turkey"))==0);
    }

    public void test3()
    {
	App a = new App();
	String[] array = {"Turkey", "England", "Spain", "Turkey", "Russia", "France", "Norway", "Turkey"};
	assertTrue((a.moreThan(array,2,"Turkey"))==-1);
    }

    public void test4()
    {
	App a = new App();
	String[] array = {"Turkey", "England", "Spain", "Turkey", "Russia", "France", "Norway", "Turkey"};
	assertFalse((a.moreThan(array,2,"Spain"))==0);
    }

    public void test5()
    {
	App a = new App();
	String[] array = {"Turkey", "England", "Spain", "Turkey", "Russia", "France", "Norway", "Turkey"};
	assertTrue((a.moreThan(array,4,"Russia"))==1);
    }
}
