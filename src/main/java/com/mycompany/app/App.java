package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static int moreThan(String[] array, int count, String word)
    {
	int a = 0;
	if(array.length == 0) return 2;
	for(int i = 0; i<array.length;i++)
		if(word.equals(array[i]))
			a++;
	if(count > a)
		return 1;
	else if(count == a)
		return 0;
	else
		return -1;
    }
}
