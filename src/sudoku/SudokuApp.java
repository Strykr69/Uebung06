package sudoku;


public class SudokuApp {
    public static void main(String[] args){
        String a = Value.EIGHT.toString(); //   "8"
        String b = Value.EIGHT.name();     //   EIGHT
        int c = Value.EIGHT.id;            //   8
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        Value d = of(9);
        System.out.println(d.name());
    }

    public enum Value{
        ONE(1,"1"),
        TWO(2,"2"),
        THREE(3,"3"),
        FOUR(4,"4"),
        FIVE(5,"5"),
        SIX(6,"6"),
        SEVEN(7,"7"),
        EIGHT(8,"8"),
        NINE(9,"9");

        public final int id;
        public final String label;

        private Value(int id, String label){
            this.id = id;
            this.label = label;
        }

        @Override
        public String toString() {
            return this.label;
        }
    }
    public static Value of(int id) {
        for (Value v : Value.values()) {
            if (v.id == id) return v;
        }
        throw new IllegalArgumentException("ID NOT AVAILABLE - CHECK INPUT");
    }
}