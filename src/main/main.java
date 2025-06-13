import java.io.IOException;

public static void main(java.lang.String[] args) throws IOException{
    double aspectRatio = 1.7778;
    int imageWidth = 400;
    double imageHeightF = ((double)imageWidth)/aspectRatio;
    int imageHeight = (int)imageHeightF;
    System.out.println(imageHeight);
    double focal = 1;
    double viewHeight = 2;
    double viewWidth = viewHeight * ((double)(imageWidth)/imageHeight);
    Tri cameraCenter = new Tri(0,0,0);

    Tri viewU = new Tri(viewWidth, 0, 0);
    Tri viewV = new Tri(0, -viewHeight, 0);

    Tri pixeldU = viewU.div(imageWidth);
    Tri pixeldV = viewV.div(imageHeight);

    Tri viewUpperLeft = cameraCenter.minus(new Tri(0,0,focal))
            .minus(viewU.div(2)).minus(viewV.div(2));

    Tri pixelOrigin = viewUpperLeft.add((pixeldV.add(pixeldU).mult(0.5)));
    Color[][] image = new Color[(int)imageHeight][imageWidth];

    for(int i = 0; i<imageHeight; i++){
        System.out.println("Line "+i+" Printed!");
        for(int j = 0; j<imageWidth; j++){
            Tri pixelCenter = pixelOrigin.add(pixeldU.mult(j).add(pixeldV.mult(i)));
            Tri rayDir = pixelCenter.minus(cameraCenter);

            Ray r = new Ray(cameraCenter, rayDir);

            Color pixelcolor = r.rayColor();
            image[i][j] = pixelcolor;
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