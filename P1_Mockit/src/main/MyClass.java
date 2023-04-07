package main;

import java.util.Stack;
import java.util.Iterator;

interface Scene{
    
}

class MySergio implements Scene{
    int x;
}

class MyDanlles implements Scene{
    int x;
}

public class MyClass {
    
    public int searchInStack(Stack stack, String nameClass) {
        Iterator iterator = stack.iterator();
        
        System.out.println("Searching");
        
        boolean hasBeenFound = false;
        int skipped = 0;
        while(iterator.hasNext() && !hasBeenFound){
            Object value = iterator.next();
            
            String valueName = value.getClass().getSimpleName();
            boolean val =  valueName.equals(nameClass); 
            
            if(val) {
            	System.out.println("Bien");
            	hasBeenFound = true;
            }else {
            	skipped++;
            }
        }
        
        int toPop = stack.size() - skipped - 1;
        
        return toPop;
    }
    
    public static void main(String args[]) {
      
        MyClass s = new MyClass();
        s.create();
    }
    
    
    public void create(){
      Stack stac = new Stack();
      
      MyDanlles danlles = new MyDanlles();
      MyDanlles danlles2 = new MyDanlles();
      MySergio serioGrande = new MySergio();
      
      stac.push(danlles);
      stac.push(danlles2);
      
      int toPop = searchInStack(stac, "MySergio");
      
      System.out.print(toPop);
    }
}