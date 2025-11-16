import java.io.IOException;

public static void main(java.lang.String[] args) throws IOException{
    double aspectRatio = 1.7778;
    int imageWidth = 400;
    double imageHeightF = ((double)imageWidth)/aspectRatio;
    int imageHeight = (int)imageHeightF;

    Color[][] image = new Color[(int)imageHeight][imageWidth];

    for(int i = 0; i<imageHeight; i++){
        System.out.println("Line "+i+" Printed!");
        for(int j = 0; j<imageWidth; j++){
            //grid of 225:400
            double x = j - imageWidth/2;
            double y = i - imageHeight/2;
            double diffy = -2*x*y;
            diffy*=0.1;
            if(diffy > 255.99) diffy = 255.99;
            if(diffy < -255.99) diffy = -255.99;
            Color c = new Color(diffy, 0, -diffy);
            image[i][j] = c;
        }
    }
    try{
        ImageRenderer imageRenderer = new ImageRenderer();
        imageRenderer.renderImage(image);
        System.out.println("ver0.0.7");
    }
    catch(IOException e){
        System.out.println("IMAGE DISPLAY ERROR");
    }
}

