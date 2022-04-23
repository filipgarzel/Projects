public class Pozycja {
    public double x;
    public double y;

    Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void przenies(double predkosc, double delta_t, Pozycja cel) {
        double delta_x=0;
        double delta_y=0;
        if (cel.x != this.x && cel.y != this.y) {
            delta_x += predkosc * delta_t * (cel.x - this.x) / Math.sqrt(Math.pow(cel.x - this.x, 2) + Math.pow(cel.y - this.y, 2));
            delta_y += predkosc * delta_t * (cel.y - this.y) / Math.sqrt(Math.pow(cel.x - this.x, 2) + Math.pow(cel.y - this.y, 2));
            if (cel.x > this.x + delta_x || cel.x < this.x - delta_x) {
                this.x = this.x + delta_x;
            } else {
                this.x = cel.x;
            }
            if (cel.y > this.y + delta_y || cel.y < this.y - delta_y) {
                this.y = this.y + delta_y;
            } else {
                this.y = cel.y;
            }
        }
    }
    public double getX() {return this.x;}

    public double getY() {return this.y;}

    public void setX(double x) {this.x = x;}

    public void setY(double y) {this.y = y;}

}