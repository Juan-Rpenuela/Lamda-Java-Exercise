# Lamda-Java-Exercise

## Descripción
Este proyecto implementa una lista enlazada genérica en Java y utiliza expresiones lambda para realizar operaciones estadísticas como la media y la desviación estándar sobre datos leídos desde archivos.

## Estructura del proyecto
```text
├── src
│   ├── main
│   │   └── java
│   │       └── edu
│   │           └── escuelaing
│   │               └── arsw
│   │                   └── app
│   │                       ├── LinkedList.java
│   │                       └── Stadistics.java
│   ├── data
│   │   ├── data.txt
│   │   └── data2.txt
│   └── test
│       └── java
│           └── edu
│               └── escuelaing
│                   └── arsw
│                       └── app
│                           └── StatisticsTest.java
```

## Requisitos
- Java 8 o superior
- Maven

## Compilación y ejecución

### Compilar el proyecto
```sh
mvn clean package
```

### Ejecutar la aplicación principal
```sh
mvn exec:java
```

### Ejecutar los tests
```sh
mvn test
```
## Implementacion de la estructura de datos linked list compatible con la API collections  de java

```java
public class LinkedList <E> {
    
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

    public void forEach(Consumer<E> action) {
        Node<E> current = headNode;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

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

    public int getSize(){
        return size;
    }   

}

```


## Pruebas unitarias

```java

public class StatisticsTest {
	@Test
	public void testData1() {
		Statistics stadistics = new Statistics();
		LinkedList<Double> data = stadistics.storeData("src/data/data.txt");
		double mean = stadistics.getMean(data);
		double std = stadistics.getStdDev(data);
		assertEquals(550.6, mean, 0.01);
		assertEquals(572.03, std, 0.01);
	}

	@Test
	public void testData2() {
        Statistics stadistics = new Statistics();
		LinkedList<Double> data = stadistics.storeData("src/data/data2.txt");
		double mean = stadistics.getMean(data);
		double std = stadistics.getStdDev(data);
		assertEquals(60.32, mean, 0.01);
		assertEquals(62.26, std, 0.01);
	}
}
```

## Resultados esperados
Para `data.txt`:
- Media: 550.6
- Desviación estándar: 572.03

Para `data2.txt`:
- Media: 60.32
- Desviación estándar: 62.26

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

## Autor 
Juan Andrés Rodríguez Peñuela

---
