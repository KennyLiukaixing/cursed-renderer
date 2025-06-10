import java.io.IOException;

public static void main(java.lang.String[] args) throws IOException{
    vec3[][] image = new vec3[256][256];
    try{
        ImageRenderer imageRenderer = new ImageRenderer();
    }
    catch(IOException e){
        System.out.println("IMAGE DISPLAY ERROR");
    }
}