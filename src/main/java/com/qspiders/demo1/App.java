package com.qspiders.demo1;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        try {
        	Class.forName("org.postgresql.Driver");
        	System.out.println("Driver loaded");
        	
        	} catch (ClassNotFoundException e) {
        }
    }
}
