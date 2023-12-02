public class Grab {
    private int red;
    private int green;
    private int blue;

    public Grab(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue(){
        return blue;
    }

    @Override
    public String toString() {
        return "Grab{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
