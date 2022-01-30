/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queues;

/**
 *
 * @author user
 */
import java.util.Scanner;
class Queue{
    private int cap;
    private int q[];
    private int front;
    private int rear;
    private int items;
    
    public Queue(int m){
        cap=m;
        q=new int[cap];
        front=0;
        rear=-1;
        items=0;
        
    }
    
    public void insert(int in){
        if(rear==cap-1)
            rear=-1;
        q[++rear]=in;  
        items++;
    }
    
    public int remove(){
        int temp=q[front++];
        if (front==cap)
           front=0;
        items--;
        return temp;
    }
    
    public void peek(){
        System.out.println(q[front]);
    }
    
    public int size(){
        
        return items;
    }
    public void display(){
         for(int i=0; i<q.length; i++){
            System.out.println("Item "+(i+1)+" : "+q[i]);
        }
    }
    
    /*public boolean isEmpty(){
        return (front==0 && rear==0);
    }
    
    public boolean isFull(){
        return (rear==cap-1);
    }*/
    //--------------------------------------------------------------
public boolean isEmpty() // true if queue is empty
{
return ( rear+1==front || (front+cap-1==rear) );
}
//--------------------------------------------------------------
public boolean isFull() // true if queue is full
{
return ( rear+2==front || (front+cap-2==rear) );
}
//--------------------------------------------------------------
/*public int size() // (assumes queue not empty)
{
if(rear >= front) // contiguous sequence
return rear-front+1;
else // broken sequence
return (cap-front) + (rear+1);
}*/
}
public class Queues {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter maximum size of the queue");
        int size=input.nextInt();
        
        Queue qu=new Queue(size);
        boolean finish=true;
        while(finish=true){
            System.out.println("Enter\n 1.Insert an Item \n 2.Remove an item from the queue \n 3.Show item at the peek \n 4.Show the queue \n 5.Show size of the queue 6.Exit");
            int choice=input.nextInt();
            switch (choice) {
                case 1:
                    if(qu.isFull()){
                        System.out.println("Failed! The queue is full");
                    }else{
                        System.out.println("Enter item");
                    int item=input.nextInt();
                    qu.insert(item);
                    }
                    break;
                case 2:
                    if(qu.isEmpty()){
                        System.out.println("Failed! The queue is empty");
                    }else{
                        qu.remove();
                    }
                    break;
                case 3:
                    qu.peek();
                    break;
                case 4:
                    qu.display();
                    break;
                case 5:
                    System.out.println(qu.size());
                    
                    break;
                case 6:
                    finish=false;
                    break;
                default:
                    System.out.println("Invalid choice, Try Again");
                    break;
            }
        }
    }
}
