public class Ray {
    private Tri origin, dir;
    public Ray(){}
    public Ray(Tri origin, Tri dir){
        this.origin = origin;
        this.dir = dir;
    }
    public Tri at(double t){
        return origin.add(dir.mult(t));
    }
    public Color rayColor(){
        Tri unitDirection = dir.div(dir.length());
        double a = 0.5*(unitDirection.y+1);
        System.out.println(a);
        Color w = new Color(1.0, 1.0, 1.0);
        Color b = new Color(0.5, 0.7, 1.0);
        Color c = w.mult(1-a).add(b.mult(a));
        //System.out.println("R: "+c.x+" G: "+c.y+" B: "+c.z);
        return c;
    }
}
