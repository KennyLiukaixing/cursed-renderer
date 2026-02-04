import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public static void main(java.lang.String[] args) throws IOException{
    Scanner sc = new Scanner(new File("alienimage.txt"));
    for(int i = 0; i<4; i++) sc.next();
    Color[][] colors = new Color[90][90];
    for (int i = 0; i < 90; i += 1) {
        for (int j = 0; j < 90; j += 1) {
            int R = Integer.parseInt(sc.next());
            int G = Integer.parseInt(sc.next());
            int B = Integer.parseInt(sc.next());
            int M = (R + G + B) / 3;
            System.out.print(M);
            Color c = new Color(M, M, M);
            colors[i][j] = c;
        }
    }
    char[][] letters = new char[90][90];
    int[] letterCounts = new int[100];
    for (int i = 0; i < 90; i++) {
        for (int j = 0; j < 90; j++) {
            letters[i][j] = colors[i][j].toLetter();
            int cnt = letters[i][j];
            //System.out.println(cnt);
            letterCounts[cnt] += 1;
            System.out.print(letters[i][j] + " ");
        }
        System.out.println();
    }

    for(int i = 69; i<95; i++){
        System.out.print((char)i+": "+letterCounts[i]+" ");
    }
    System.out.println();
}


