package edu.escuelaing.arsw.app;

public class LinkedList <E> {

    private static class Node <E>{

        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data){
            this.data = data;
        }

    }

    private Node<E> headNode;
    private Node<E> tail;


    public void addNode(E data){
        if(headNode == null){
            headNode = new Node<>(data);
            tail = headNode;
        }else{
            tail.next = new Node<>(data);
            tail = tail.next;
        }
    }
    
    public void removeNode(){
        if(headNode == null){
            return;
        }
        if(headNode == tail){
            headNode = null;
            tail = null;
        }else{
            headNode = headNode.next;
        }
    }

    public void nextNode(){
        if (headNode != null){
            headNode = headNode.next; 
        }
    }

    public void previousNode(){
        if (headNode != null && headNode.prev != null){
            headNode = headNode.prev;
        }
    }

    public E getData(){
        if (headNode != null){
            return headNode.data;
        }
        return null;
    }

    public Node<E> getHead(){
        return headNode;
    }

}
