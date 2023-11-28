package com.bilolbek.mycodingpractices;

public class DynamicArray {

    private int array[];
    private int count;

    private int arraySize;

    public DynamicArray(){
        array=new int[1];
        count=0;
        arraySize=1;
    }

    public void addElement(int a){
        if(count==arraySize){
            growSize();
        }
        array[count]=a;
        count++;
    }

    public void growSize(){
        int temp[]=null;
        if(count==arraySize){
            temp=new int[arraySize*2];
        }
        for(int i=0;i<arraySize;i++){
            temp[i]=array[i];
        }
        array=temp;
        arraySize*=2;
    }

    public void addElementAt(int index, int a){
        if(count==arraySize){
            growSize();
        }
        for(int i=count-1; i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=a;
        count++;
    }

    public int[] getArray(){
        return array;
    }
}
