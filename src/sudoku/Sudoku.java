package sudoku;
import sudoku.SudokuApp.Value;

public class Sudoku {
    private Field[][] board;

    public Sudoku(){
    }

    public Field getField(int x, int y) {
        return board[x][y];
    }

    @Override
    public String toString() {
        for(int o = 0; o < 9; o++){
            StringBuilder s = new StringBuilder();
            for(int p = 0; p < 9; p++){
                s.append(board[o][p].toString());
                s.append(" ");
                if((p)%3==2 && p != 9-1){
                    s.append("| ");
                }
            }
            System.out.println(s);
            if((o)%3==2 && o != 9-1) System.out.println("------+-------+------");
        }
        return ("");
    }

    public void initialize(int... values){
        if(values.length!=81) throw new RuntimeException("BOARD DOES NOT CONTAIN ENOUGH INTEGERS");
        this.board = new Field[9][9];
        for(int j = 0; j < 9; j++){
            for(int k = 0; k < 9; k++){
                Field tempField = new Field(k,j,this.board);
                tempField.setValue(Value.of(values[(j * 9 + k)]));
                board[j][k] = tempField;
            }
        }
    }
}