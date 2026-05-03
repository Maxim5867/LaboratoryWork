package lab8.num1;

public class Cylinder {
    private int diameter;
    private int height;

    public Cylinder(int diameter, int height){
        this.height = Math.abs(height);
        this.diameter = Math.abs(diameter);
    }

    public int getArea(){
        return (int) Math.ceil(2 * Math.PI * diameter/2 * (diameter/2 + height));
    }

    public int getVolume(){
        return (int) Math.ceil( (Math.PI * Math.pow(diameter/2,2) * height));
    }

    public boolean isEqualAreas(Cylinder cylinder){
        return getArea() == cylinder.getArea();
    }

    public boolean isEqualVolume(Cylinder cylinder){
        return getVolume() == cylinder.getVolume();
    }
}
