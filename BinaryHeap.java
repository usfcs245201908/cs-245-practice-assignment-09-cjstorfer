import java.util.Arrays;
import java.io.*;

public class BinaryHeap {
    private int[] heap;
    private int size;

    public BinaryHeap(){
        heap = new int[10];
        size = 0;
    }
    public boolean isEmpty(){
    	if (size == 0)
    		return (true);
    	return(false);
    }
    public boolean isFull(){
    	if (size == heap.length-1)
    		return (true);
    	return(false);
    }
    private void growHeap(){
        heap = Arrays.copyOf(heap, heap.length*2);
    }
    private void swap(int idx1, int idx2){
        int temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }
    private void fillUp(int idx){
        while((idx>1) && (heap[idx])<(heap[idx/2])){
            swap(idx,idx/2);
            idx = idx/2;
        }
    }
    private void fillDown(int idx){
        int parent = idx;
        int child = 2*parent;

        while(child <= size){
            if ((child<=size-1) && (heap[child]>heap[child+1]))
                child++;
            if (heap[parent]>heap[child])
                swap(parent,child);
            parent = child;
            child = 2*parent;
        }
    }
    public void add(int item){
        if (isFull())
            growHeap();
        size++;
        heap[size] = item;
        fillUp(size);
    }
    public int remove(){
        if(isEmpty())
            return (-1);
        int temp = heap[1];
        heap[1] = heap[size--];
        fillDown(1);
        return (temp);
    }
}