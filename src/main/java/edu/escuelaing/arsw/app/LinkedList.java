package edu.escuelaing.arsw.app;

import java.util.function.Consumer;

/**
 * Implementación de una lista doblemente enlazada genérica.
 * Permite almacenar cualquier tipo de dato y recorrer la lista con lambdas.
 * @param <E> Tipo de dato almacenado en la lista.
 */
public class LinkedList <E> {

    /**
     * Nodo de la lista enlazada.
     * @param <E> Tipo de dato almacenado.
     */
    static class Node <E>{

        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data){
            this.data = data;
        }

    }

    private Node<E> headNode;
    private Node<E> tail;
    private int size = 0;

    /**
     * Aplica una acción a cada elemento de la lista usando una lambda.
     * @param action Acción a aplicar a cada elemento.
     */
    public void forEach(Consumer<E> action) {
        Node<E> current = headNode;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    /**
     * Agrega un nuevo nodo al final de la lista.
     * @param data Dato a agregar.
     */
    public void addNode(E data){
        if(headNode == null){
            headNode = new Node<>(data);
            tail = headNode;
        }else{
            tail.next = new Node<>(data);
            tail = tail.next;
        }
        size++;
    }
    
    /**
     * Elimina el nodo actual de la lista.
     */
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
        size--;
    }

    /**
     * Mueve el cursor al siguiente nodo.
     */
    public void nextNode(){
        if (headNode != null){
            headNode = headNode.next; 
        }
    }

    /**
     * Mueve el cursor al nodo anterior.
     */
    public void previousNode(){
        if (headNode != null && headNode.prev != null){
            headNode = headNode.prev;
        }
    }

    /**
     * Obtiene el dato del nodo actual.
     * @return Dato almacenado o null si la lista está vacía.
     */
    public E getData(){
        if (headNode != null){
            return headNode.data;
        }
        return null;
    }

    /**
     * Retorna el nodo cabeza de la lista.
     * @return Nodo cabeza.
     */
    public Node<E> getHead(){
        return headNode;
    }

    /**
     * Retorna el tamaño de la lista.
     * @return Número de elementos.
     */
    public int getSize(){
        return size;
    }   

}
