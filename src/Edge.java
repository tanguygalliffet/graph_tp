public class Edge {
    private Vertex vertex1;
    private Vertex vertex2;
    private String label;
    private boolean isCurved;
    private String color;

    public Edge(Vertex v1, Vertex v2, String label, boolean isCurved) {
        this.vertex1 = v1;
        this.vertex2 = v2;
        this.label = label;
        this.isCurved = isCurved;
        this.color = "black"; // Couleur par défaut : noir
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public void setVertex1(Vertex vertex1) {
        this.vertex1 = vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }

    public void setVertex2(Vertex vertex2) {
        this.vertex2 = vertex2;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isCurved() {
        return isCurved;
    }

    public void setCurved(boolean curved) {
        isCurved = curved;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Méthode pour générer une arète courbée ou droite
    public String toHtml() {
        if (isCurved) {
            // arête courbe
            return String.format("<path d='M %.2f %.2f C %.2f %.2f, %.2f %.2f, %.2f %.2f' stroke='%s' fill='transparent' />\n",
                    120 + vertex1.getX() * 100, 120 + vertex1.getY() * 100,  // Point de départ
                    150.0, 200.0,  // Point de contrôle courbe (ajustement)
                    180.0, 300.0,  // Deuxième point de contrôle courbe (ajustement)
                    120 + vertex2.getX() * 100, 120 + vertex2.getY() * 100,  // Point d'arrivée
                    this.color) +
                    String.format("<text x='%.2f' y='%.2f' fill='black'>%s</text>\n",
                            (120 + vertex1.getX() * 100 + 120 + vertex2.getX() * 100) / 2.0,
                            (120 + vertex1.getY() * 100 + 120 + vertex2.getY() * 100) / 2.0,
                            this.label);  // Positionnement du label
        } else {
            // Arête droite
            return String.format("<line x1='%.2f' y1='%.2f' x2='%.2f' y2='%.2f' stroke='%s' />\n",
                    120 + vertex1.getX() * 100, 120 + vertex1.getY() * 100,
                    120 + vertex2.getX() * 100, 120 + vertex2.getY() * 100,
                    this.color) +
                    String.format("<text x='%.2f' y='%.2f' fill='black'>%s</text>\n",
                            (120 + vertex1.getX() * 100 + 120 + vertex2.getX() * 100) / 2.0,
                            (120 + vertex1.getY() * 100 + 120 + vertex2.getY() * 100) / 2.0,
                            this.label);  // Positionnement du label
        }
    }

    @Override
    public String toString() {
        return "Edge{" + vertex1.getName() + " - " + vertex2.getName() + ", label='" + label + "', curved=" + isCurved + ", color='" + color + "'}";
    }
}
