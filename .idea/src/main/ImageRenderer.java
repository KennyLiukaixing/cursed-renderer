import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ImageRenderer {
    private int[][] imagePixels;
    public ImageRenderer(int[][] imagePixels) throws IOException {
        this.imagePixels = imagePixels;
        renderImage();
    }

    public void renderImage() throws IOException{
        if(imagePixels.equals(null)) throw new IOException("IMAGE NULL OR NOT FOUND");
        else{
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
                    for(int j = 0; j<imagePixels[0].length; j++){
                        double r = ((double) i)/(imagePixels[0].length-1);
                        double g = ((double) j)/(imagePixels.length-1);
                        double b = 0;
                        int ir = (int)(255.999 * r);
                        int ig = (int)(255.999 * g);
                        int ib = (int)(255.999 * b);
                        System.out.println(ib);
                        fileWriter.write(""+ir+" "+ig+" "+ib+"\n");
                    }
                }

            } catch(IOException e){
                System.out.println("UNABLE TO PRINT IMAGE");
            }
        }
    }
}
