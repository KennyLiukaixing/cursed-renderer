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
    public Tri addScalar (double d) {return new Tri(x+d, y+d, z+d);}
    public Tri dot (Tri v) {return new Tri(x*v.x, y*v.y, z*v.z);}
    public Tri multScalar(double d) {return new Tri(x*d, y*d, z*d);}
}
