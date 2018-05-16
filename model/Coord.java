package model;

/**
 * Classe de Coordonéne
 */
public class Coord {
    private int x;
    private int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args)
    {
        Coord c1 = new Coord(5,7);
        Coord c2 = new Coord(5,7);
        System.out.println("C1 = "+ c1);
        System.out.println("C2 = "+ c2);
        System.out.println("C1.equals(C2) ? "+ c1.equals(c2));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static boolean coordonnees_valides(int x, int y, int length)
    {
        return x >= length && y >= length;
    }

    @Override
    public String toString() {
        return "{ x : " + this.x + ", y : " + this.y + " }";
    }

    /**
     * Fonction qui check si 2 objets Coord sont égaux
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x &&
                y == coord.y;
    }

    /**
     * A copier coller comme tel
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
}
