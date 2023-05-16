package sudoku;
import sudoku.SudokuApp.Value;
import static java.lang.Math.sqrt;

public class Sudoku {
    private Field[][] board;
    private int dimension;

    public Sudoku(){
    }

//TODO
    @Override
    public String toString() {
        for(int o = 0; o < dimension; o++){
            StringBuilder s = new StringBuilder();
            for(int p = 0; p < dimension; p++){
                s.append(board[o][p].toString());
                s.append(" ");
                if((p+1)%3==0 && p != dimension-1){
                    s.append("| ");
                }
            }
            System.out.println(s);
            if((o+1)%3==0 && o != dimension-1) System.out.println("------+-------+------");
        }
        return ("");
    }

    public void initialize(int... values){
        if(sqrt(values.length)%1!=0) throw new RuntimeException("BOARD IS NOT SYMMETRICAL - CHECK INPUT");
        this.dimension = (int) sqrt(values.length);
        this.board = new Field[dimension][dimension];
        for(int j = 0; j < dimension; j++){
            for(int k = 0; k < dimension; k++){
                Field tempField = new Field(k,j);
                tempField.setValue(Value.of(values[(j * dimension + k)]));
                board[j][k] = tempField;
            }
        }
    }
}