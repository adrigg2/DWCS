package com.adrian;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");  // index = 0
        arrayList.add("Second"); // index = 1
        arrayList.add("Third");  // index = 2
        arrayList.add("Fourth"); // index = 3
        arrayList.add("Fifth");  // index = 4
        
        System.out.println(arrayList.get(3));
        arrayList.remove(2);
        System.out.println(arrayList.get(3));
    }
}
