import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Vertex> vertices;
    private Set<Edge> edges;
    private Map<Edge, Set<Vertex>> edgeToVertices;

    public Graph() {
        this.vertices = new HashSet<>();
        this.edges = new HashSet<>();
        this.edgeToVertices = new HashMap<>();
    }

    // Getters
    public Set<Vertex> getVertices() {
        return vertices;
    }

    public Set<Edge> getEdges() {
        return edges;
    }

    public Map<Edge, Set<Vertex>> getEdgeToVertices() {
        return edgeToVertices;
    }

    // Ajouter un sommet
    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    // Ajouter une arête
    public void addEdge(Edge edge, Set<Vertex> vertexPair) {
        edges.add(edge);
        edgeToVertices.put(edge, vertexPair);
        addVertex(edge.getVertex1());
        addVertex(edge.getVertex2());
    }

    // Générer le fichier HTML
    public void generateHtmlFile(String filename) {
        try {
            // Ouvrir un FileWriter pour écrire dans le fichier HTML
            FileWriter writer = new FileWriter(filename);

            // Début du fichier HTML
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang='fr'>\n<head>\n");
            writer.write("<meta charset='UTF-8'>\n");
            writer.write("<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
            writer.write("<title>Représentation du Graphe</title>\n");
            writer.write("<style>\n");  // CSS inline pour styliser le graphe
            writer.write("body {\n");
            writer.write("    font-family: Arial, sans-serif;\n");
            writer.write("    text-align: center;\n");
            writer.write("}\n");
            writer.write(".graph-container {\n");
            writer.write("    position: relative;\n");
            writer.write("    width: 600px;\n");
            writer.write("    height: 400px;\n");
            writer.write("    margin: 0 auto;\n");
            writer.write("    border: 1px solid #ccc;\n");
            writer.write("}\n");
            writer.write(".vertex {\n");
            writer.write("    position: absolute;\n");
            writer.write("    width: 40px;\n");
            writer.write("    height: 40px;\n");
            writer.write("    border: 2px solid black;\n");
            writer.write("    border-radius: 50%;\n");
            writer.write("    line-height: 40px;\n");
            writer.write("    text-align: center;\n");
            writer.write("    font-weight: bold;\n");
            writer.write("}\n");
            writer.write(".edges line {\n");
            writer.write("    stroke-width: 2;\n");
            writer.write("}\n");
            writer.write("</style>\n</head>\n<body>\n");

            writer.write("<h1>Représentation du Graphe</h1>\n");
            writer.write("<div class='graph-container'>\n");

            // Ajouter les sommets
            for (Vertex vertex : vertices) {
                writer.write(vertex.toHtml());
            }

            // Ajouter les arêtes avec SVG
            writer.write("<svg class='edges' height='400' width='600'>\n");
            for (Edge edge : edges) {
                writer.write(edge.toHtml());
            }
            writer.write("</svg>\n");

            writer.write("</div>\n</body>\n</html>");

            // Fermer le FileWriter
            writer.close();

            System.out.println("Le fichier HTML a été généré avec succès : " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Graph{vertices=" + vertices + ", edges=" + edges + '}';
    }
}
