public class Ray {
    private Thr origin, dir;
    public Ray(){}
    public Ray(Thr origin, Thr dir){
        this.origin = origin;
        this.dir = dir;
    }
    public Thr at(double t){
        return origin.add(dir.mult(t));
    }
    public Color rayColor(){
        Thr unitDirection = dir.div(dir.length());
        double a = 0.5*(unitDirection.y+1);
        System.out.println(a);
        Color w = new Color(1.0, 1.0, 1.0);
        Color b = new Color(0.5, 0.7, 1.0);
        Color c = w.mult(1-a).add(b.mult(a));
        //System.out.println("R: "+c.x+" G: "+c.y+" B: "+c.z);
        if(this.hitsSphere(new Thr(0,0,1), 0.5)){
            return new Color(0,0,1);
        }
        return c;
    }
    public boolean hitsSphere(Thr center, double radius){
        Thr oc = center.minus(origin);
        double a = dir.dot(dir);
        double b = (dir.dot(oc))*(-2);
        double c = oc.dot(oc)-radius*radius;
        double discriminant = b*b-4*a*c;
        return (discriminant>=0);
    }
}
