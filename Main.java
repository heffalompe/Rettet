import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graf graf = new Graf();
        
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        
        
        graf.addNode(nodeA);
        graf.addNode(nodeB);
        graf.addNode(nodeC);
        graf.addNode(nodeD);
        graf.addNode(nodeE);
        

        graf.addEdge(nodeA, nodeB);
        graf.addEdge(nodeA, nodeE);
        graf.addEdge(nodeE, nodeB);
        graf.addEdge(nodeB, nodeE);
        graf.addEdge(nodeE, nodeD);
        graf.addEdge(nodeB, nodeC);
        graf.addEdge(nodeE, nodeC);
        graf.addEdge(nodeD, nodeC);
        graf.addEdge(nodeC, nodeD);
       

        graf.printKanter();
        System.out.println();

    }
}