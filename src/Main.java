import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Créer les sommets A,B,C,D avec des positions spécifiques
        Vertex A = new Vertex("A", 0, 0);
        Vertex B = new Vertex("B", 2, 0);
        Vertex C = new Vertex("C", 1, 2);
        Vertex D = new Vertex("D", 3, -1);

        // Créer le graphe
        Graph graph = new Graph();

        // Créer les arêtes avec les étiquettes et spécifier si elles sont courbes ou non
        Edge edgeA = new Edge(A, B, "a", false);
        Edge edgeB = new Edge(A, B, "b", false);
        Edge edgeC = new Edge(A, C, "c", true);  // Arête courbé
        Edge edgeD = new Edge(B, D, "d", false);
        Edge edgeE = new Edge(C, B, "e", false);
        Edge edgeF = new Edge(C, B, "f", true);  // Arête courbé
        Edge edgeG = new Edge(B, D, "g", false);

        // Ajouter Sommets et arêtes au graphe
        Set<Vertex> vertexPair1 = new HashSet<>();
        vertexPair1.add(A);
        vertexPair1.add(B);
        graph.addEdge(edgeA, vertexPair1);

        Set<Vertex> vertexPair2 = new HashSet<>();
        vertexPair2.add(A);
        vertexPair2.add(C);
        graph.addEdge(edgeC, vertexPair2);

        Set<Vertex> vertexPair3 = new HashSet<>();
        vertexPair3.add(B);
        vertexPair3.add(C);
        graph.addEdge(edgeE, vertexPair3);

        Set<Vertex> vertexPair4 = new HashSet<>();
        vertexPair4.add(B);
        vertexPair4.add(D);
        graph.addEdge(edgeG, vertexPair4);

        // Générer le fichier HTML pour représenter le graphe
        graph.generateHtmlFile("graph.html");
    }
}
