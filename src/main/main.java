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
    /*Scanner sc = new Scanner(new File("newimage.txt"));
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
    *//*
    Scanner sc = new Scanner(new File("ascii.txt"));
    System.out.println(sc.next().charAt(0));
    for(int i = 0; i < 90; i++){
        for(int j = 0; j < 90; j++){
            //letters[i][j] = sc.next().charAt(0);
        }
    }*//*
    for (int i = 0; i < 90; i++) {
        for (int j = 0; j < 90; j++) {
            letters[i][j] = colors[i][j].toLetter();
            int cnt = letters[i][j];
            //System.out.println(cnt);
            letterCounts[cnt] += 1;
            System.out.print(letters[i][j] + " ");
        }
        System.out.println();
    }*/
    int[] letterCounts = new int[100];
    String st = "                                                                    # # # W H H S K P E E E E E E E E E S S S S H R W B # # # # # # #                                               \n" +
            "                                                                    # # B W G S S K K E E E A A A E E E E P S S H R R W B B # # # # # #                                             \n" +
            "                                                                  # # B W W W S U E E A A A A A A A A E E E P S H O D W W B B B # # #                                               \n" +
            "                                                                  # # B B B W S K E E A [ [ [ [ A A A E E E E K H O W W W B B B # # #                                               \n" +
            "                                                                    # # # # W D K E A [ [ A [ [ [ [ [ A E E E K H R O O O D W B # # #                                               \n" +
            "                                                                    # # # # W O E A [ K E W G [ [ [ F [ A A E E S H O R R O W M # # # #                                             \n" +
            "                                                                    # # # # H P A [ R [ _ L A B A F F [ [ [ A A E S O R R W B # # # # #                                             \n" +
            "                                                                # # # # # # K E [ E E _ _ _ _ F S [ F F [ [ [ [ E S S G O B # # # # # #                                             \n" +
            "                                                              # # # # # # B P E [ E F _ F _ - - F E [ F F F [ [ A S S H O B # # # # # # #                                           \n" +
            "                                                            # # # # # # M H E A A [ L L _ - - - - F K F F F F [ A U S H R W # # # # # # #                                           \n" +
            "                                                          # # # # # # W S E A [ A F L _ - - - - - - F H F F F F [ K S S H D B # # # # # # #                                         \n" +
            "                                                      # # # # # # # # O P E A [ A L - - - - - - - - - E [ F F F [ E S S H W B # # # # # # #                                         \n" +
            "                                                    # # # # # # # # # B U E A [ A _ - - - - - - - - - F K F F F [ A K H G W W # # # # # # #                                         \n" +
            "                                                # # # # # # # # # # B W U E [ [ [ - - - - - - - - - - _ E [ F [ [ A K O D B M # # # # # # #                                         \n" +
            "                                        # # # # # # # # B B B B M B B W U E [ E F - - - - - - - - - - - [ [ F [ [ E K W W M # # # # # # # # #                                       \n" +
            "                                      # # # # # # # # # B W W W B B W H E [ F E _ - - - - - - - - - - - F E [ [ [ A E H W M # # # # # # # # # #                                     \n" +
            "                                    # # # # # # # # # # W D G H O H H E [ [ F E _ - - - - - - - - - - - _ S # U A A E G # # # # # # # # # # # # #                                   \n" +
            "                                  # # # # # # # # # # # W H S S P K K [ F F F A _ - - - - - - - - - - - - E # # B E E D # # # # # #     # # #                                       \n" +
            "                                  # # # # # # # B B B B W H U E E E [ F F F L [ _ - - - - - - - - - - - - E # #   # G G M # # #         #                                           \n" +
            "                            # # # # # # # # B W W W W O R H U E E [ F F F F F F L - - - - - - - - - - _ F [ S # #   # D # # # #                                                     \n" +
            "                          # # # # # # # M B W W R H H H S S K A A [ F F A G K A [ L - - - - - - - L F [ H # # # #     # # # # #                                                     \n" +
            "                    # # # # # # # # # # B W W O S S U U U U E [ [ [ F A # # # # W H A L - _ F [ A S W # # # #         # # # # # #                                                   \n" +
            "          # # #   # # # # # # # # # # B B W W R S U E E E E [ [ F F L # # # # # # # # B [ E # # # # # # # #             # # # # #                                       #           \n" +
            "            # # # # # # # # # # # # # B W R G S K E E E E A [ [ [ A R # # # # # # # # # # # # # # # # # #                   # # # #                                                 \n" +
            "              # # # # # # # # # # # B W H K K E E E A A [ [ [ [ H # # # # # # # # # # # # # # # # # # # #                     # # #                                                 \n" +
            "                # # # # # # # # # # B W B O S K E E A [ [ [ [ [ # # #     # # # # # # # # # # # # # #                         # # #                                                 \n" +
            "                  # # # # # # # # # B B # # W H U E E E E [ F S # #             # # # #     # # #                               # #                                                 \n" +
            "                    # # # # # # # # M M # M B R H H R W R S A # #                                           #                   # # # # # #                                         \n" +
            "                    # # # # # # # # # # # M B W W W W W R S E   #                                           #                 # # # # # # #                                         \n" +
            "                    # # # # # # # # # # # # # # M B # W H E K                                                                   # # # # # # # # # # # #                             \n" +
            "                  # # # # # # # # # # # # # # # # M M W W S #         #                                                         # # # # # # # # # # # #                             \n" +
            "                        # # # # # # # # # # # # # M B W W W #       #                                                           # # # # # # # # # # # #                             \n" +
            "                # # # # # # # # # # # # # # # # # # # B W W #       # #                                                         # # # # # # # # # # # #                             \n" +
            "            # # # # # # # # # # # # # # # # # # # B W W W B # #     # #                                                         # # # # # # # # # # # #                             \n" +
            "            # # # # # # # # # # # # # B W O S P P P P U H B # # # # # #                                         #                 # # # # # # # # # # #                             \n" +
            "              # # # # # # # # # # # # B O H S S U U U U S # #     #                       #                                       # # # # # # # # # # #                             \n" +
            "      # # # # # # # # # # # # # # # # B G U K P E A A E E # # # # #     #         # # # #                 # #                     # # # # # # # # # # # #                           \n" +
            "    #       # # # # # # # # # # # M B O U E E E [ [ [ [ E # # # # #     # #       # #                     # #                     # # # # # # # # # # # # # #                       \n" +
            "# # #   # # # # # # # # # # B B B W W H K E E A [ [ [ [ E # # # # #   # # #                           # # # # #                   # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # # B D G H U E E E E [ [ [ A E # # # # # # # # # #   # #                 # # # #   #                   # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # # W G S U E E E E E A [ [ [ E # # # # # # # # # # # # # #         # # # # # # # # # #               # # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # B W G U P E E E E E E A [ [ P # # # # # # # # # # # # # # #     # # # # # # # # # # # # #           # # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # B W S E E E E E E E E E A A G # # # # # # #             # # # # # # # #         # # # # #           # # # # # # # # # # # # # # #                       \n" +
            "# # # # # # # # # # # # # # B B D S S S K P P E E A A A W # # # # # #       # # # # # # # # # # # #   #     # #   # #           # # # # # # # # # # # # #                           \n" +
            "# # # # # # # # # # # B B W W W W G H S K P E A A A A [ W # # # # # # # # # # # # # # # # # # #       #     # #   # #           # # # # # # # # # # # # # # # # #   # #             \n" +
            "# # # # # # # # B W D O D O H H H H H S K P E A [ [ [ [ B # # B # # # # # # # # # # # # # # #         #     # #   # #           # # # # # # # # # # # # # # # # # # # # # #         \n" +
            "# # # # # # # M B O G S H R H S S S S H S E E E [ [ [ F B # # K #   # # # #         # #             # #           # #   # # # # # # # # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # # # # # W W O H H R R H S S U U S S E E A [ [ [ F # # # W R   # # # # #                       # #             #     # # # # # # # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # # B B W O O R H H G H S E E E E E P E E A [ [ [ F # # # # H   # #                             #               #     # # # W W W # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # B B W D R G G G G H U E A A A A A A A A [ [ [ F F # # #   W   # #             #                     # #       #     #   # E U H O W M # # # # # # # # # # # # # # # # # #     \n" +
            "B B B B B B W R G G H H S E E A A A [ [ [ [ [ [ [ F F F # # # # E # # #         #   #       #               #     # # # # #   W [ A E P O W B # # # # # # # # # # # # # # # # # #   \n" +
            "B B B W W W D O R H S P E E E A A [ [ [ [ [ [ [ F F F F # # # # [ # # # #       # #                                 # # # #   E [ [ [ E H W B B M # # # # # # # # # # # # # # # # # \n" +
            "W W W W O R G H H S K E E A A A A A [ [ [ [ [ [ [ F F F # # # W [ # # # # # #                                               # F F F [ [ E H W B B # # # # # # # # # # # # # # # # # \n" +
            "D D O R G G H S S K E E A A A A A [ [ [ [ [ [ [ [ F F _ # # # P F # # # # # # #                                           # [ L F F F F [ [ P D W W B B # # # # # # # # # # # # # # \n" +
            "H G G H H H H S U E E A A A [ [ [ [ [ [ [ [ [ [ F F F F # # # G F W # # # # # #                                           # _ F F F F F F [ A E K S S H O D D W W # # # # # # # # # \n" +
            "S S H H S S U K K E E A A A [ [ [ [ [ [ [ [ F F F F F F # # # S _ K # # # # # #                                         # B _ F F L F F F [ [ [ [ E E E K S S S O W B B M # # # # # \n" +
            "S S S S S S U K P E E A A A [ [ [ [ [ [ [ [ F F F F F L # # # D _ E # # # # # #                                         # D _ L L L L F F F F F [ [ [ A A E E P S G O W W B M # # # \n" +
            "H H S S S S U K K E E A A A [ [ [ [ [ [ [ [ F F F F F L H # W # - A # # # # # #                                       # # K F L _ _ L L F F F F F [ [ [ [ [ A E K H G O W W B B # # \n" +
            "S S S S U U K P P E E E A A A [ [ [ [ [ [ [ F F F F L _ F R D F - F # # # #   #                                       # # [ F _ _ _ L L F F F F F F [ [ [ A A E U H G O D W W B B M \n" +
            "S U U K K K P E E E E E A A A A [ [ [ [ [ [ F F F F L L _ L F - - _ B # # # #                                         # O F L _ _ _ L L F F F F F F F [ [ A E E K S H H O O W W B B \n" +
            "U U U K K K P E E E E E E E A A [ [ [ [ [ [ [ F F F L L _ _ _ _ _ _ G # # #                                           # P F _ _ _ _ _ _ _ L L F F F F [ [ A A E E K S H R D W B B B \n" +
            "U U U U U K K P P E E E E E E A A A [ [ [ [ [ F F F F F L _ _ _ _ _ E # # #                                         # # E L _ _ - - - _ _ _ L L L F F [ [ [ A E E K S H G W W B B B \n" +
            "S H H H S H S S U U K E E E E A A A A A [ [ [ [ F F F F F L L L L L F # # #                                         # # A _ - - - - _ _ _ _ L F F F F [ [ [ A E K U S H G D W W W W \n" +
            "H H G G G R H S U K E E E A A A [ A A A [ [ [ [ F F F F F F L F F L _ H # #                                           # [ _ _ _ _ _ _ _ L L F F F [ [ [ [ A E E U S S H R W W W W W \n" +
            "S S U S S U E E E E E E A A [ [ [ [ [ [ [ [ [ F F F F F F F F F F F L [ # #                                           [ F L L L L L _ L F F F [ [ [ [ A E E K S H H R O W W B B B B \n" +
            "K K P P U S P E E A A E E A A A A A E A A A A [ [ [ [ [ [ [ [ F F F F F # #                                           [ F F F F F F F F F F [ [ [ [ E E K S G O O O W W W B B B B # \n" +
            "H H H H R O R H S K P P K K K K S S S U K P E E E E E E E A A [ [ [ [ [ B                                             W [ [ [ [ [ [ [ [ [ [ [ A E E K K S S H W W B B B B B M # # # \n" +
            "W W W W W W W W D O R G G R R R D D G H H S K E E S U S K P E E E E E E B                                             W E E E E E E E A A E E E P S S S S S H D W W W W B # # # # # \n" +
            "B B B B W W W B W W W W W D O R W W D O U E U S S S P K U S S S S S S W # #        #                                  # O G H U P E E E E A A E S S P P S O D W W G U S W M # # # # \n" +
            "# # B B W W W W W W W O S H S S D H S E E E E H H G R H H O D D G R W # # #      #                                    # # B W W G H H S U P E E P E E P H W B # W E P S W B # # # # \n" +
            "# B B B B W W W W W O R R R H S H S S S K K E P S W W W O O G H O B # # #                                             # # # # B B W W W O G H S U E S S H O G G S E E S W B # # # D \n";
    StringBuffer sb = new StringBuffer(st);
    int ind = 0;
    for(char c:st.toCharArray()){
        if(c=='F')sb.setCharAt(ind,'A');
        if(c=='K')sb.setCharAt(ind,'U');
        if(c=='W')sb.setCharAt(ind,'R');
        ind ++;
        st = sb.toString();
    }
    for(int i = 0; i < 4140; i++) {
        double seed = Math.random();
        if (seed > 0 && seed < (((double)66) / 4055)) st = st.concat("A ");
        else if (seed > ((float)66) / 4055 && seed < (((float)66+16) / 4055)) st = st.concat("B ");
        else if (seed > (((float)66+16) / 4055) && seed < (((float)66+16+110) / 4055)) st = st.concat("C ");
        else if (seed > (((float)66+16+110) / 4055) && seed < (((float)66+16+110+212) / 4055)) st = st.concat("D ");

        double buf = 66+16+110;

        if (seed > ((buf) / 4055) && seed < ((buf+423) / 4055)) st = st.concat("E ");
        else if (seed > ((buf+423) / 4055) && seed < ((buf+423+127) / 4055)) st = st.concat("F ");
        else if (seed > ((buf+423+127) / 4055) && seed < ((buf+423+127+113) / 4055)) st = st.concat("G ");

        buf += 423+127+113;

        if (seed > ((buf) / 4055) && seed < ((buf+432) / 4055)) st = st.concat("H ");
        else if (seed > ((buf+432) / 4055) && seed < ((buf+432+385) / 4055)) st = st.concat("I ");
        else if (seed > ((buf+432+385) / 4055) && seed < ((buf+432+385+44) / 4055)) st = st.concat("K ");

        buf += 432+385+44;

        if (seed > ((buf) / 4055) && seed < ((buf+163) / 4055)) st = st.concat("L ");
        else if (seed > ((buf+163) / 4055) && seed < ((buf+163+107) / 4055)) st = st.concat("M ");
        else if (seed > ((buf+163+107) / 4055) && seed < ((buf+163+107+385) / 4055)) st = st.concat("N ");

        buf += 163+107+385;

        if (seed > ((buf) / 4055) && seed < ((buf+383) / 4055)) st = st.concat("O ");
        else if (seed > ((buf+383) / 4055) && seed < ((buf+383+61) / 4055)) st = st.concat("P ");
        else if (seed > ((buf+383+61) / 4055) && seed < ((buf+383+61+92) / 4055)) st = st.concat("Q ");

        buf += 383+61+92;

        if (seed > ((buf) / 4055) && seed < ((buf+92) / 4055)) st = st.concat("R ");
        else if (seed > ((buf+92) / 4055) && seed < ((buf+92+229) / 4055)) st = st.concat("S ");
        else if (seed > ((buf+92+229) / 4055) && seed < ((buf+92+229+550) / 4055)) st = st.concat("T ");

        buf += 92+229+550;

        if (seed > ((buf) / 4055) && seed < ((buf+29) / 4055)) st = st.concat("U ");
        else if (seed > ((buf+29) / 4055) && seed < ((buf+29+138) / 4055)) st = st.concat("W ");
        else if (seed > ((buf+29+138) / 4055) && seed < ((buf+29+138+110) / 4055)) st = st.concat("Y ");
        System.out.println(buf);
        if(i!=0&&i%90==0) st = st.concat("\n");
    }
    for(char c:st.toCharArray()){
        int cnt = c;
        letterCounts[cnt]++;
    }
    System.out.println(st);
    int sta = 65;
    for(int i = sta; i<sta+26; i++){
        System.out.print((char)i+": "+letterCounts[i]+" ");
    }
    int tot = 0;
    for(char spc:st.toCharArray())
        if(spc!='#'&&spc!='_'&&spc!='-'&&spc!='['&&spc!=' '&&spc!='.')tot++;
    System.out.println("Total usable characters:"+tot);
}


