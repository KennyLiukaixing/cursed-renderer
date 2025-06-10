public class vec3 {
    public double x,y,z;
    public vec3(){}
    public vec3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public vec3 add (vec3 v){
        x+=v.x;
        y+=v.y;
        z+=v.z;
        return this;
    }
    public vec3 addS (double d){
        x+=d;
        y+=d;
        z+=d;
        return this;
    }
    public vec3 dot (vec3 v){
        x*=v.x;
        y*=v.y;
        z*=v.z;
        return this;
    }
    public vec3 mult(double d){
        x*=d;
        y*=d;
        z*=d;
        return this;
    }
}
