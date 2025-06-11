import java.io.IOException;

public static void main(java.lang.String[] args) throws IOException{
    try{
        ImageRenderer imageRenderer = new ImageRenderer();
        imageRenderer.renderImage(imageRenderer.generateTestImage());
    }
    catch(IOException e){
        System.out.println("IMAGE DISPLAY ERROR");
    }
}