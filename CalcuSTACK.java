package Postfix_Calculator;

public class CalcuSTACK {

private int MAX_SIZE;
private int myArray[];
private int top; 

public CalcuSTACK(int i){
MAX_SIZE = i; 
myArray = new int[MAX_SIZE];
top = -1;
}

public void push(int o) {
myArray[++top] = o;
}

public int pop(){
return myArray[top--];
}

public boolean isEmpty(){
return(top==-1);
}
}