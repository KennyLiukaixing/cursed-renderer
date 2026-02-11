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
    String st = "                                                                   # # # R H H S U P E E E E E E E E E S S S S H R R B # # # # # # #                                               \n" +
            "                                                                    # # B R G S S U U E E E A A A E E E E P S S H R R R B B # # # # # #                                             \n" +
            "                                                                  # # B R R R S U E E A A A A A A A A E E E P S H O D R R B B B # # #                                               \n" +
            "                                                                  # # B B B R S U E E A [ [ [ [ A A A E E E E U H O R R R B B B # # #                                               \n" +
            "                                                                    # # # # R D U E A [ [ A [ [ [ [ [ A E E E U H R O O O D R B # # #                                               \n" +
            "                                                                    # # # # R O E A [ U E R G [ [ [ A [ A A E E S H O R R O R M # # # #                                             \n" +
            "                                                                    # # # # H P A [ R [ _ L A B A A A [ [ [ A A E S O R R R B # # # # #                                             \n" +
            "                                                                # # # # # # U E [ E E _ _ _ _ A S [ A A [ [ [ [ E S S G O B # # # # # #                                             \n" +
            "                                                              # # # # # # B P E [ E A _ A _ - - A E [ A A A [ [ A S S H O B # # # # # # #                                           \n" +
            "                                                            # # # # # # M H E A A [ L L _ - - - - A U A A A A [ A U S H R R # # # # # # #                                           \n" +
            "                                                          # # # # # # R S E A [ A A L _ - - - - - - A H A A A A [ U S S H D B # # # # # # #                                         \n" +
            "                                                      # # # # # # # # O P E A [ A L - - - - - - - - - E [ A A A [ E S S H R B # # # # # # #                                         \n" +
            "                                                    # # # # # # # # # B U E A [ A _ - - - - - - - - - A U A A A [ A U H G R R # # # # # # #                                         \n" +
            "                                                # # # # # # # # # # B R U E [ [ [ - - - - - - - - - - _ E [ A [ [ A U O D B M # # # # # # #                                         \n" +
            "                                        # # # # # # # # B B B B M B B R U E [ E A - - - - - - - - - - - [ [ A [ [ E U R R M # # # # # # # # #                                       \n" +
            "                                      # # # # # # # # # B R R R B B R H E [ A E _ - - - - - - - - - - - A E [ [ [ A E H R M # # # # # # # # # #                                     \n" +
            "                                    # # # # # # # # # # R D G H O H H E [ [ A E _ - - - - - - - - - - - _ S # U A A E G # # # # # # # # # # # # #                                   \n" +
            "                                  # # # # # # # # # # # R H S S P U U [ A A A A _ - - - - - - - - - - - - E # # B E E D # # # # # #     # # #                                       \n" +
            "                                  # # # # # # # B B B B R H U E E E [ A A A L [ _ - - - - - - - - - - - - E # #   # G G M # # #         #                                           \n" +
            "                            # # # # # # # # B R R R R O R H U E E [ A A A A A A L - - - - - - - - - - _ A [ S # #   # D # # # #                                                     \n" +
            "                          # # # # # # # M B R R R H H H S S U A A [ A A A G U A [ L - - - - - - - L A [ H # # # #     # # # # #                                                     \n" +
            "                    # # # # # # # # # # B R R O S S U U U U E [ [ [ A A # # # # R H A L - _ A [ A S R # # # #         # # # # # #                                                   \n" +
            "          # # #   # # # # # # # # # # B B R R R S U E E E E [ [ A A L # # # # # # # # B [ E # # # # # # # #             # # # # #                                       #           \n" +
            "            # # # # # # # # # # # # # B R R G S U E E E E A [ [ [ A R # # # # # # # # # # # # # # # # # #                   # # # #                                                 \n" +
            "              # # # # # # # # # # # B R H U U E E E A A [ [ [ [ H # # # # # # # # # # # # # # # # # # # #                     # # #                                                 \n" +
            "                # # # # # # # # # # B R B O S U E E A [ [ [ [ [ # # #     # # # # # # # # # # # # # #                         # # #                                                 \n" +
            "                  # # # # # # # # # B B # # R H U E E E E [ A S # #             # # # #     # # #                               # #                                                 \n" +
            "                    # # # # # # # # M M # M B R H H R R R S A # #                                           #                   # # # # # #                                         \n" +
            "                    # # # # # # # # # # # M B R R R R R R S E   #                                           #                 # # # # # # #                                         \n" +
            "                    # # # # # # # # # # # # # # M B # R H E U                                                                   # # # # # # # # # # # #                             \n" +
            "                  # # # # # # # # # # # # # # # # M M R R S #         #                                                         # # # # # # # # # # # #                             \n" +
            "                        # # # # # # # # # # # # # M B R R R #       #                                                           # # # # # # # # # # # #                             \n" +
            "                # # # # # # # # # # # # # # # # # # # B R R #       # #                                                         # # # # # # # # # # # #                             \n" +
            "            # # # # # # # # # # # # # # # # # # # B R R R B # #     # #                                                         # # # # # # # # # # # #                             \n" +
            "            # # # # # # # # # # # # # B R O S P P P P U H B # # # # # #                                         #                 # # # # # # # # # # #                             \n" +
            "              # # # # # # # # # # # # B O H S S U U U U S # #     #                       #                                       # # # # # # # # # # #                             \n" +
            "      # # # # # # # # # # # # # # # # B G U U P E A A E E # # # # #     #         # # # #                 # #                     # # # # # # # # # # # #                           \n" +
            "    #       # # # # # # # # # # # M B O U E E E [ [ [ [ E # # # # #     # #       # #                     # #                     # # # # # # # # # # # # # #                       \n" +
            "# # #   # # # # # # # # # # B B B R R H U E E A ( [ [ [ E # # # # #   # # #                           # # # # #                   # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # # B D G H U E E E E ( [ [ A E # # # # # # # # # #   # #                 # # # #   #                   # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # # R G S U E E E E E A [ [ [ E # # # # # # # # # # # # # #         # # # # # # # # # #               # # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # B R G U P E E E E E E A [ [ P # # # # # # # # # # # # # # #     # # # # # # # # # # # # #           # # # # # # # # # # # # # # # #                     \n" +
            "# # # # # # # # # # # # # # B R S E E E E E E E E E A A G # # # # # # #             # # # # # # # #         # # # # #           # # # # # # # # # # # # # # #                       \n" +
            "# # # # # # # # # # # # # # B B D S S S U P P E E A A A R # # # # # # U W   # # # # # # # # # # # #   #     # #   # #           # # # # # # # # # # # # #                           \n" +
            "# # # # # # # # # # # B B R R R R G H S U P E A A A A [ R # # # # # # # # # # # # # # # # # # #       #     # #   # #           # # # # # # # # # # # # # # # # #   # #             \n" +
            "# # # # # # # # B R D O D O H H H H H S U P E A [ [ [ [ B # # B # # # # # # # # # # # # # # #         #     # #   # #           # # # # # # # # # # # # # # # # # # # # # #         \n" +
            "# # # # # # # M B O G S H R H S S S S H S E E E [ [ [ A B # # U #   # # # #         # #             # #           # #   # # # # # # # # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # # # # # R R O H H R R H S S U U S S E E A [ [ [ A # # # R R   # # # # #                       # #             #     # # # # # # # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # # B B R O O R H H G H S E E E E E P E E A [ [ [ A # # # # H   # # R                           #               #     # # # R R R # # # # # # # # # # # # # # # # # # # # #     \n" +
            "# # # B B R D R G G G G H U E A A A A A A A A [ [ [ A A # # #   R   # #   H         #                     # # L O   #     # W # E U H O R M # # # # # # # # # # # # # # # # # #     \n" +
            "B B B B B B R R G G H H S E E A A A [ [ [ [ [ [ [ A A A # # # # E # # #         #   #       #               #   R # # # # # N R [ A E P O R B # # # # # # # # # # # # # # # # # #   \n" +
            "B B B R R R D O R H S P E E E A A [ [ [ [ [ [ [ A A A A # # # # [ # # # #       # #                                 # # # #   E [ [ [ E H R B B M # # # # # # # # # # # # # # # # # \n" +
            "R R R R O R G H H S U E E A A A A A [ [ [ [ [ [ [ A A A # # # R [ # # # # # #                                               # A A A [ [ E H R B B # # # # # # # # # # # # # # # # # \n" +
            "D D O R G G H S S U E E A A A A A [ [ [ [ [ [ [ [ A A _ # # # P A # # # # # # #                                         N # [ L A A A A [ [ P D R R B B # # # # # # # # # # # # # # \n" +
            "H G G H H H H S U E E A A A ( [ [ [ [ [ [ [ [ [ A A A A # # # G A R # # # # # #                                         H # _ A A A A A A [ A E U S S H O D D R R # # # # # # # # # \n" +
            "S S H H S S U U U E E A A A [ [ [ [ [ [ [ [ A A A A A A # # # S _ U # # # # # #                                         # B _ A A L A A A [ [ [ ) E E E U S S S O R B B M # # # # # \n" +
            "S S S S S S U U P E E A A A ( [ [ [ [ [ [ [ A A A A A L # # # D _ E # # # # # #                                         # D _ L L L L A A A A A [ [ ) A A E E P S G O R R B M # # # \n" +
            "H H S S S S U U U E E A A A ( [ [ [ [ [ [ [ A A A A A L H # R # - A # # # # # #                                       # # U A L _ _ L L A A A A A [ [ [ [ ) A E U H G O R R B B # # \n" +
            "S S S S U U U P P E E E A A A [ [ [ [ [ [ [ A A A A L _ A R D A - A # # # #   #                                       # # [ A _ _ _ L L A A A A A A [ [ ) A A E U H G O D R R B B M \n" +
            "S U U U U U P E E E E E A A A A [ [ [ [ [ [ A A A A L L _ L A - - _ B # # # #                                         # O A L _ _ _ L L A A A A A A A [ ) A E E U S H H O O R R B B \n" +
            "U U U U U U P E E E E E E E A A [ [ [ [ [ [ [ A A A L L _ _ _ _ _ _ G # # #                                           # P A _ _ _ _ _ _ _ L L A A A A [ [ A A E E U S H R D R B B B \n" +
            "U U U U U U U P P E E E E E E A A A [ [ [ [ [ A A A A A L _ _ _ _ _ E # # #                                         # # E L _ _ - - - _ _ _ L L L A A [ [ [ A E E U S H G R R B B B \n" +
            "S H H H S H S S U U U E E E E A A A A A [ [ [ [ A A A A A L L L L L A # # #                                         # # A _ - - - - _ _ _ _ L A A A A [ [ [ A E U U S H G D R R R R \n" +
            "H H G G G R H S U U E E E A A A [ A A A [ [ [ [ A A A A A A L A A L _ H # #                                           # [ _ _ _ _ _ _ _ L L A A A [ [ [ [ A E E U S S H R R R R R R \n" +
            "S S U S S U E E E E E E A A [ [ [ [ [ [ [ [ [ A A A A A A A A A A A L [ # #                                           [ A L L L L L _ L A A A [ [ [ [ A E E U S H H R O R R B B B B \n" +
            "U U P P U S P E E A A E E A A A A A E A A A A [ [ [ [ [ [ [ [ A A A A A # #                                           [ A A A A A A A A A A [ [ [ [ E E U S G O O O R R R B B B B # \n" +
            "H H H H R O R H S U P P U U U U S S S U U P E E E E E E E A A [ [ [ [ [ B                                             R [ [ [ [ [ [ [ [ [ [ [ A E E U U S S H R R B B B B B M # # # \n" +
            "R R R R R R R R D O R G G R R R D D G H H S U E E S U S U P E E E E E E B                                             R E E E E E E E A A E E E P S S S S S H D R R R R B # # # # # \n" +
            "B B B B R R R B R R R R R D O R R R D O U E U S S S P U U S S S S S S R # #        #            W                     # O G H U P E E E E A A E S S P P S O D R R G U S R M # # # # \n" +
            "# # B B R R R R R R R O S H S S D H S E E E E H H G R H H O D D G R R # # # C    #            H E   N           K L   # # B R R G H H S U P E E P E E P H R B # R E P S R B # # # # \n" +
            "# B B B B R R R R R O R R R H S H S S S U U E P S R R R O O G H O B # # # T I Q O         D E H U S T E           H   # # # # B B R R R O G H S U E S S H O G G S E E S R B # # # D\n" +
            "O M G D E T L M S D E S O H W D E M I T L I E I Q I H N D E S A E N M W T T O N I T T H S U O T F N O L M R T N D E S N T I E S E L I I H N T E W T N N H M P D E F N D E W T T B N \n" +
            "L N N H T L L N U A H R I S T Q I N T F E D E F I O G T H W P O L N C L N F N M H M P O W Q G H W E K D E O Y O I L H O A F O F N H L H N E H L R E K T H F Q D E S T H O S S I T Y\n" +
            "H H H P G W B N I H H H O O H R H W T N O I N L T H H N M D E L W O E M Y W T H D E Y I L Y D E Y G H H H N K W H O E T T R K N N D E M F I I I T D E I N H T A L Y T N F K C D E D\n" +
            "T Q N Q M D E I S E H F H I E T S N L O O E L S I H T F E E E W N I N E T H S N H G F S H N I D E H E G S N H F O R O D E I D E H E O S C K F L S H O P D E N O Y T D E D E F T S E\n" +
            "N I T P W A O C E C W F G T I I N N G T O N I I I I Y E F H O N R K T S T O N E E A I R H F T K D E E L L R T T T E Y D E U L T W N T N I D E C T H Y W W H L G I D E I A E N C O T\n" +
            "D E U N P Y T C E L D E O H E S Q O E G H C C N I O N T Y O H N S O H I N O O R H O E C T D E I I H H H L I M F Q S I N Y Q A O O H I O I I E O I L S F R O N P G M T O T P I N F R \n" +
            "I I N H G R A O T H P O U L D E Y I O N U T M L F S H G T N H M Q N I W I E T L H N C H Q O E S S A N S I N T G Y H N H I I Q W D E O C T T D E I S E Y O N S E H T I T I Q T O G N \n" +
            "M C W S T N T R T R H I G T T S T D E O O T Y O Y D E S H H D E U S K O D E T M H I P W D E O G H T F S E C T F O T E T Y M U O L T I C E W R S A H N E T C F C E M D E O H E E W I \n" +
            "R N I N N T C T H R Y I T L Y O W H N N S S P Y S T D E L S M T N N C O S H F M T N I O N I N L P G D E O O I G T A H T S O T A T W I E T N Y E I O R L N S O O A R T O T L O D E L \n" +
            "L O W D E N G S Q W R M H N D E I E H Q H F I W M N T P S H T R F R I I N C T D E H F N N I N O I T Y T W G E M M H Y T D E E N T N T H O D E O D E M Y N N W T E E Q F D E K L N Y \n" +
            "U I I I I N Y K O C U I T W D E N D E L N H O T E K T T N O K T N Q F T E S S M E N H N O N C E O P E H F H T T E I L T L M T D E A D E I G H N L O W Y N I F M O I H F G C R T L N\n" +
            "H G O E T C N F D E H D E T H P H B L I E T Y H I T F U C I N N F G A W T D E H G T A B I H S O Q O S O C I T C T D E E O L H F T N W W Q W H S O M L H G H O L I T H N Y L T I E T \n" +
            "H A H Q O I T G I T N T O N W A M D E F T Y L S D E N E C L Y O W M I H M I M T O O O S E L D E I O L Y E N A Q H D E Y T O D E T S O I Q E O I D E R A I M S T G H L O T T H S T M \n" +
            "H T I U T O T R N H H H E C I T H O D E I L N Q H C I O F I E E F D E N M O O Q W S I T N T G I K E P T L D E O S R T O C O P M I T I O D E O A H E T N I N W N A O T H I G A I H D \n" +
            "T Y D E D E H S L M T I A S C L H H M T S E H H N H H N L N H W T I S O Y A T D E H T M O H E O I O I F E H N Y L S H B T N O S I I Q O T L I H D E O E T D E N T H T O Y I E W A K \n" +
            "U W I F N W Y E E O S I O I Q F P W O O S T S H C A N E W B H E R S T H N O K I M F T P H R N N N F N H M N I D E H H S Y E H T Y W E Y S D E N G H O I Y C A H I W E I I C N L O A \n" +
            "T Q Q Y P E W S F S T I C T W O E O G S S L I N P N O H Y T P T H T T N C T T T F Y Q A H T O H T O H I Q O N S O N N I T M Q S Y I W I A E I O T D E N H I T O Y E H N H N N N O N \n" +
            "H A I W E N T H W W I A F C N T W T L O T Y H M H E H M T O F A T T T E I I T O Y M T D E W I O P I T C E H D E G G O T T H T G O L M U T O T R N S D E D E T I E L R S L R O P F N \n" +
            "T L H O H B H U D E I F T H F H P W I Q I H T T I O C N I O T H N P I I N T W T G R G H O H O D E N O L H N E S Y A H N G T L W E G O T H F H Q I N I G W W O T S T S W O S M S D E \n" +
            "T M I G H L H F Y N U S T D E H N F S I H I A A S T O H Q P T O N T I D E U M E D E C N H C N I H T H T G L E O Y A O O I I T G N S N D E H D E T E H T S I E P M L G O T H S Y L M \n" +
            "H K T T N C T N I O S O H M C I L T H N E H M G T A L Q D E F S N H Y O N D E P T H D E T O R S G H N W F O T N N W H O R N H S M T W O L B C Q A H T M Q S L H H F T D E F T I T I \n" +
            "I H T Y H O N C F O R F T T T S D E Q T E Q I T F E M L Y S K W N F Q I F H Y O P F H L S O T I I P T F A L H O I T H I H E O T I S O T Y F G F P T S T T H N H I W N T M H G P T L \n" +
            "F I T E T N H H U H G E N I N I D E S N A L W E N C N D E T K W N O I H U T S T S I D E H Y O A H G F H W U K O T N H S N S Q S H A E N H H H H E H M Q H N P U O S O N N T T T S H\n" +
            "I H D E M N D E T G T D E E G R O M T H N P N A I Y E F E N T N E D E I O W Q H F G W N G C W H H C W I D E I I I W T O H M N K T T T P O N L W N T O N D E I H I E T S I T R K T I \n" +
            "W F H I N T N O L D E G R O I O H I F T O O N H O I H N T H R O K O A H T S I N I N N C X E L T H C O H N D E T N I I T P N B T K H I O L I D E C I S I D E T H D E I I O N S K E H \n" +
            "N O D E T O H Q A H S K T S C I H D E G I H F E O N H T A P L T F A H S Q N T N L D E M F F O E D E H S O H H H H Q N E W T T T S L D E Y L O O Y M N Q Y M D E Y Y H T W E I D E N \n" +
            "L I N N D E N M L O L I I E Y O O N H D E G N T O H N T O W O N T D E S L T F E R H C O T T S H T A T G T L R D E I A L T H Y Q D E F O W N H N E Y N K L E W K L O I O T Q A L T M \n" +
            "U F H W T Y O H N L N C N G O I O O H H T I R A N Q N F N R R C O D E I G G O R E S D E H S W G T N W T Y K Y E E C T M K O N D E F T O H N I T F T I H R H Y M N L M G O W H N T S \n" +
            "L N H O N I Q E W H I A E T S H I L O R T T I F H H W O H C O N O S L W G H D E M L H O W T H Q T I T T I O M C Q T E L S N O C E Y T T H F N O S I T T T W O Q A R O O R N Q L F R \n" +
            "N P S T M L L O T N M T D E L D E M L T I I F H M H H O H O N H H E T C O I W O O N H L H E M N L I K T D E T D E O F T O T N T L S T L N L D E H F H E L O Q K O N S Q A N P D E H \n" +
            "G D E D E W I I O T E H D E D E E I E T G T H E I N H I O O T N H O H H E N E L I E O P W C C N D E T S U I I N C N O W W E G T S N N I D E Q I D E E I O Q G H N S H N O T O I T O \n" +
            "Q M H S S N T R S M E U L I G F H Y O T S O T P N I E T Q F Q S T T O N O H D E I U D E O S S I O T S N H I T H N L D E I H H T R S H O W G O G F S I G H I T H Y T G O I H D E E I \n" +
            "T P O W N A Q H A N W O Y I E I L W M A O W W N Y T A H C A T N N R T I I I H L O G I R L N S R O H O L T P G I O E S H O S D E D E P E L M L T W H I T O T H G H G E I K Y N O S O \n" +
            "H F I A E D E H N O I P I D E O D E T Y I T C O F S E P T W E L T O E A E L L D E A N I Y S S G I L C K T G D E N D E I G P F S P N T Y O G D E S N E W O U O H S S D E S S T T N S \n" +
            "N O Y Q D E L L Q B L I S O I Y S E M Q H T T L T W L L T I G H S M S N H D E L H S E T H N F E S T G Y E Y D E T N S H E I B D E O L C N S H H H N E H L O E N O O H T O N G E N Y \n" +
            "K Y H K L N F S H I S A H Q T O C W N C G I L T I K Q N H K I I O G A N T H H I T F N T N M L O H Q K W O H S L D E N T P N H O O I T D E T H A I G G I T S N H N D E E I T G P D E \n" +
            "S N E H M T E N I S O P H H G O S K N C O H W T D E I D E N O E U N C Q O Y I I T I U W O T N N T W P O I T W E L S Y W N H H I N T T N I T T C H C G N I N M F Q N W O P O I N D E \n" +
            "Q D E N I N E H L N O C N O O L O I B N W I S Q H L N T T Y T T U E E F T T F E I I N I W N D E E T S L I F W R N F T O T M Y O H N Q I S K F H T O F O H D E B I H H O I D E E O N \n" +
            "I C S N S T C Y T R E C D E I K M S T E O H O T D E O T O I H Q P S H O O T H T N R S S H I T I I I Y I M T R L Q L L Y P I O S A Y N E Y T C H D E N H Q N I O T D E G I Y E N L F \n" +
            "I H I S F E Q F O Y H F S N W E O H B M E L D E O T R E N E T T I O H D E E P N Q T T R H H H F T P H S O G T H N N N D E Y H P N D E A F T K H E T Y N H T S O L N Y T Q E T S O G \n" +
            "N T O C C F F D E S D E F D E I I U Q L S S F I H N D E H E O N H D E H R T T N T I I E E O O T T G D E I F O I O T N I E T E L H T O H L H E F I E S O L T D E H H W I H T R Q K I \n" +
            "E L O S G T W O H I I T M D E N I O O G E O Y R E T T T T E H T E L O L T N R S I N S I I O O N O H U Q I I E R E T D E E C W H H N N D E I T G T N E E T N N T O I T C T D E O M A \n" +
            "S L I N O L W N H E R O N N F O I K L O D E O I N R S T D E H K N W G H H L I D E H O L O E I T E S H T M Y O R D E R W T T D E T H O F I E R G I I A R W T S H T L Q F T W L N S T \n" +
            "Q O T N D E R T O N T L T T T N U Y T U T I S I O D E G D E Q Y N O E M H Y S E F I H I I M A D E K C C C H N I G O H C I D E K H O H S T O H Y T O Q I H Y O H T G T M G S I N O I \n";
    StringBuffer sb = new StringBuffer(st);
    int ind = 0;
    /*for(char c:st.toCharArray()){
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
    }*/
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


