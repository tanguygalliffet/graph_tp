public class Vertex {
    private String name;
    private double x;
    private double y;
    private String color;  // Ajout de l'attribut couleur

    public Vertex(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = "white";  // Couleur par défaut : blanc
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    // Définir couleur sommet
    public void setColor(String color) {
        this.color = color;
    }

    // Générer HTML avec couleur spécifiée
    public String toHtml() {
        return String.format("<div class='vertex' style='top: %.2fpx; left: %.2fpx; background-color: %s;'>%s</div>\n",
                100 + this.getY() * 100, 100 + this.getX() * 100, this.color, this.getName());
    }

    @Override
    public String toString() {
        return "Vertex{name='" + name + "', x=" + x + ", y=" + y + ", color='" + color + "'}";
    }
}
