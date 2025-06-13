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
                    System.out.println("File already exists");
                }
                FileWriter fileWriter = new FileWriter("r.ppm");
                fileWriter.write("P3\n" + imagePixels[0].length + ' ' + imagePixels.length + "\n255\n");

                for(int i = 0; i<imagePixels.length; i++){
                    for(int j = 0; j<imagePixels[0].length; j++){
                        fileWriter.write(imagePixels[i][j].writeColor());
                        System.out.println(imagePixels[i][j].writeColor());
                    }
                }
            }
            catch(IOException e){
                System.out.println("Exception Found");
            }
        }
    }
}
