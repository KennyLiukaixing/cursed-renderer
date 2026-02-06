public class Color extends Thr {
    private static final double[] BRIGHTNESS_VALUES = {
            5, 63.370439794200074, 63.57422718098488,
            63.72198543223025, 66.07372162571014, 79.08140606588547,
            83.22359543133581, 84.70068211073213, 88.05895941168913,
            89.67240018199985, 90.42209976550008, 102.54868886183951,
            104.04065053297188, 109.11599771333461, 112.42667504073604, 113.69154517136377,
            129.75554458025297, 135.72388709784047,
            157.9044831086205, 207.31077649401308, 225.3412498104168,
            229.01388527006375, 255
    };

    private static final char[] CHARACTERS = {
            'P', '#', '%', 'M', 'B', 'D', 'O', 'R', 'G',
            'H', 'S', 'U', 'U', 'P', 'E', 'E', 'A', '[',
            'A', 'L', '_', '-', '.', ' '
    };
    public Color(double x, double y, double z){
        super(x, y, z);
    }
    public String writeColor() {
        int rbyte = (int)(x);
        int gbyte = (int)(y);
        int bbyte = (int)(z);
        return "" + rbyte + " " + gbyte + " " + bbyte + "\n";
    }
    public Color add (Color v) {return new Color (x+v.x, y+v.y, z+v.z);}
    public Color add (double d) {return new Color(x+d, y+d, z+d);}
    public Color minus (Color v) {return new Color (x-v.x, y-v.y, z-v.z);}
    public Color minus (double d) {return new Color(x-d, y-d, z-d);}
    public Color dot (Color v) {return new Color(x*v.x, y*v.y, z*v.z);}
    public Color mult (double d) {return new Color(x*d, y*d, z*d);}
    public Color div (double d) {return new Color(x/d, y/d, z/d);}
    public char toLetter(){

        int value = (int)this.x;
        double brightness = Math.max(0, Math.min(255, value));

        int closestIndex = 0;
        double minDistance = Math.abs(brightness - BRIGHTNESS_VALUES[0]);

        for (int i = 1; i < BRIGHTNESS_VALUES.length; i++) {
            double distance = Math.abs(brightness - BRIGHTNESS_VALUES[i]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestIndex = i;
                }
            }

        return CHARACTERS[closestIndex];
    }
}
