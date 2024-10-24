import java.util.*;

class Graf {
    Set<Node> noder = new HashSet<>();
    Map<Node, Set<Node>> kanter = new HashMap<>();

    public void addNode(Node v) {
        noder.add(v);
        kanter.putIfAbsent(v, new HashSet<>());
    }

    public void addEdge(Node from, Node to) {
        if (noder.contains(from) && noder.contains(to)) {
            kanter.get(from).add(to);
        }
        else {
            System.out.println("One or both nodes are not present in the graph.");
        }
    }

    public void printNoder() {
        for (Node n : noder) {
            System.out.print(n.getName() + " ");
        }
    }

    public void printKanter() {
        for (Node node : kanter.keySet()) {
            System.out.print(node.getName() + " is connected to: ");
            for (Node connectedNode : kanter.get(node)) {
                System.out.print(connectedNode.getName() + " ");
            }
            System.out.println();
        }
    }

    /*
    public void DFSVisit(Graf G, Node u, Set<Node> visited) {
        visited.add(u);
        System.out.print(u.getName() + " ");
        for (Node v : kanter.get(u)) {
            if (!visited.contains(v)) {
                DFSVisit(G, v, visited);
            }
        }
    }
    */

    /*
    public void DFSFull(Graf G) {
        Set<Node> visited = new HashSet<>();
        for (Node v : noder) {
            if (!visited.contains(v)) {
                DFSVisit(G, v, visited);
            }
        }
    }
    */

    public void BFSVisit(Graf G, Node s, Set<Node> visited) {
        visited.add(s);
        Queue<Node> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            System.out.print(u.getName() + " ");
            for (Node v : kanter.get(u)) {
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.add(v);
                }
            }
        }
    }

    public void BFSFull(Graf G) {
        Set<Node> visited = new HashSet<>();
        for (Node v : noder) {
            if (!visited.contains(v)) {
                BFSVisit(G, v, visited);
            }
        }
    }

    List<Node> TOPSort(Graf G) {
        Map<Node, Integer> indegree = new HashMap<>();
        for (Node node : noder) {
            indegree.put(node, 0);
        } 
        for (Node v : kanter.keySet()) {
            for (Node u : kanter.get(v)) {
                indegree.put(u, indegree.get(u) + 1);
            }
        }

        Deque<Node> stack = new ArrayDeque<>();
        List<Node> output = new ArrayList<>();
        
        for (Node node : noder) {
            if (indegree.get(node) == 0) {
                stack.push(node);
            }
        }

        while (! stack.isEmpty()) {
            Node u = stack.pop();
            output.add(u);
            for (Node v : kanter.get(u)) {
                indegree.put(v, indegree.get(v) - 1);
                if (indegree.get(v) == 0) {
                    stack.push(v);
                }
            }
        }
        if (output.size() < noder.size()) {
            throw new RuntimeException("Grafen inneholder en sykel");
        }
        return output;
    }

    public Stack<Node> DFSTopSort(Graf G) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node node : noder) {
            if(!visited.contains(node)) {
                DFSVisit(G, node, visited, stack);
            }
        }
        return stack;
    }

    public void DFSVisit(Graf G, Node u, Set<Node> visited, Stack<Node> stack) {
        visited.add(u);
        for (Node node : kanter.get(u)) {
            if (!visited.contains(node)) {
                DFSVisit(G, node, visited, stack);
            }
        }
        stack.push(u);

    }

    
}