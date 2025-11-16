public class Color extends Thr {
    public Color(double x, double y, double z){
        super(x, y, z);
    }
    public String writeColor() {
        int rbyte = (int)(x);
        int gbyte = (int)(y);
        int bbyte = (int)(z);
        return "" + rbyte + " " + gbyte + " " + bbyte + "\n";
    }
    public Color add (Color v) {return new Color (x+v.x, y+v.y, z+v.z);}
    public Color add (double d) {return new Color(x+d, y+d, z+d);}
    public Color minus (Color v) {return new Color (x-v.x, y-v.y, z-v.z);}
    public Color minus (double d) {return new Color(x-d, y-d, z-d);}
    public Color dot (Color v) {return new Color(x*v.x, y*v.y, z*v.z);}
    public Color mult (double d) {return new Color(x*d, y*d, z*d);}
    public Color div (double d) {return new Color(x/d, y/d, z/d);}
}
