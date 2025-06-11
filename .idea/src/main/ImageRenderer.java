import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ImageRenderer {
    private Color[][] imagePixels;
    public ImageRenderer() throws IOException {}

    public void renderImage(Color[][] image) throws IOException{
        imagePixels = image;
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
                        fileWriter.write(imagePixels[i][j].writeColor());
                    }
                }
            }
            catch(IOException e){
                System.out.println("UNABLE TO PRINT IMAGE");
            }
        }
    }

    public Color[][] generateTestImage() throws IOException{
        int l = 256;
        int w = 256;
        Color[][] image = new Color[256][256];
        for(int i = 0; i<l; i++){
            for(int j = 0; j<w; j++){
                double r = ((double) i)/(l-1);
                double g = ((double) j)/(w-1);
                double b = 0;
                int ir = (int)(255.999 * r);
                int ig = (int)(255.999 * g);
                int ib = (int)(255.999 * b);
                image[i][j] = new Color(ir, ig, ib);
            }
        }
        return image;
    }

}
