public class Tri {
    public double x, y, z;
    public Tri(){}
    public Tri(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    //vector functions
    public Tri add (Tri v) {return new Tri (x+v.x, y+v.y, z+v.z);}
    public Tri add (double d) {return new Tri(x+d, y+d, z+d);}
    public Tri minus (Tri v) {return new Tri (x-v.x, y-v.y, z-v.z);}
    public Tri minus (double d) {return new Tri(x-d, y-d, z-d);}
    public Tri dot (Tri v) {return new Tri(x*v.x, y*v.y, z*v.z);}
    public Tri mult (double d) {return new Tri(x*d, y*d, z*d);}
    public Tri div (double d) {return new Tri(x/d, y/d, z/d);}
    public double length() {return Math.sqrt(x*x + y*y + z*z);}
}
