package sudoku;


public class SudokuApp {
    public static void main(String[] args){
        final Sudoku board = new Sudoku();
        board.initialize(4, 5, 0, 0, 0, 0, 2, 0, 0, 6, 0, 0, 0, 2, 4, 8, 0, 0, 8, 0, 0, 0, 6, 1, 3, 0, 0, 0, 9, 0, 4, 0, 0, 0, 5, 0, 0, 1, 0, 2, 0, 8, 0, 7, 0, 0, 3, 0, 0, 0, 9, 0, 8, 0, 0, 0, 7, 1, 4, 0, 0, 0, 8, 0, 0, 2, 7, 9, 0, 0, 0, 6, 0, 0, 5, 0, 0, 0, 0, 2, 1);
        System.out.println(board);
        board.getField(3,3).getDependents();
        String x = board.getField(3,3).getDependents().toString();
        System.out.println(x);
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

        public static Value of(int id) {
            if(id == 0){
                return null;
            }
            else{
                for (Value v : Value.values()) {
                    if (v.id == id) return v;
                }
            }
            throw new IllegalArgumentException("ID NOT AVAILABLE - CHECK INPUT");
        }
    }
}