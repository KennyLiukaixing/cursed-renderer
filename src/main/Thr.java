public class Thr {
    public double x, y, z;
    public Thr(){}
    public Thr(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //vector functions
    public Thr add (Thr v) {return new Thr(x+v.x, y+v.y, z+v.z);}
    public Thr add (double d) {return new Thr(x+d, y+d, z+d);}
    public Thr minus (Thr v) {return new Thr(x-v.x, y-v.y, z-v.z);}
    public Thr minus (double d) {return new Thr(x-d, y-d, z-d);}
    public double dot (Thr v) {return x*v.x+y*v.y+z*v.z;}
    public Thr mult (double d) {return new Thr(x*d, y*d, z*d);}
    public Thr div (double d) {return new Thr(x/d, y/d, z/d);}
    public double length() {return Math.sqrt(x*x + y*y + z*z);}
}
