import java.io.IOException;

public static void main(java.lang.String[] args) {
    int[][] image = new int[256][256];
    for(int[] i:image){
        for(int j:i){
            j=0;
        }
    }
    try{
        ImageRenderer imageRenderer = new ImageRenderer(image);
    }
    catch(IOException e){

    }
}