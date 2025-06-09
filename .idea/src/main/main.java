public static void main(String[] args){
    System.out.println("BRUH");
    int[][] image = new int[256][256];
    for(int[] i:image){
        for(int j:i){
            j=0;
        }
    }
    ImageRenderer imageRenderer = new ImageRenderer(image);
}