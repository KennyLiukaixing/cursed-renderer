import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ImageRenderer {
    private vec3[][] imagePixels;
    public ImageRenderer() throws IOException {

    }

    public void renderImage() throws IOException{
        if(imagePixels.equals(null)) throw new IOException("IMAGE NOT FOUND");
        else {
            try {
                File renderedImage = new File("r.ppm");
                if (renderedImage.createNewFile()) {
                    System.out.println("File created: " + renderedImage.getName());
                } else {
                    System.out.println("File already exists.");
                }
                FileWriter fileWriter = new FileWriter("r.ppm");
                fileWriter.write("P3\n" + imagePixels[0].length + ' ' + imagePixels.length + "\n255\n");
                for(int i = 0; i<imagePixels.length; i++){
                    System.out.println("Line "+i+" Printed!");
                    for(int j = 0; j<imagePixels[0].length; j++){
                        fileWriter.write(""+imagePixels[i][j].x+" "+imagePixels[i][j].y+" "+imagePixels[i][j].z+"\n");
                    }
                }
            }
            catch(IOException e){
                System.out.println("UNABLE TO PRINT IMAGE");
            }
        }
    }

    public vec3[][] generateTestImage() throws IOException{
        vec3[][] image = new vec3[256][256];
        for(int i = 0; i<imagePixels.length; i++){
            for(int j = 0; j<imagePixels[0].length; j++){
                double r = ((double) i)/(imagePixels[0].length-1);
                double g = ((double) j)/(imagePixels.length-1);
                double b = 0;
                int ir = (int)(255.999 * r);
                int ig = (int)(255.999 * g);
                int ib = (int)(255.999 * b);
                image[i][j] = new vec3(ir, ig, ib);
            }
        }
        return image;
    }
}
