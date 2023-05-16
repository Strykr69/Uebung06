package sudoku;

import sudoku.SudokuApp.Value;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Field {

    private final int Spalte;
    private final int Zeile;
    private Value value;
    private List<Field> dependents;
    private Set<Value> domain;
    private Field[][] board;

    public Field(int x, int y, Field[][] board){
        this.Spalte = x;
        this.Zeile = y;
        this.value = null;
        this.dependents = new ArrayList<Field>();
        this.domain = new HashSet<Value>();
        this.board = board;
    }

// TODO
    public List<Field> getDependents() {
        if(this.dependents.isEmpty()){
            for(int g = 0; g < 9; g++){
                this.dependents.add(this.board[g][this.Zeile]);
            }
            for(int k = 0; k < 9; k++){
                this.dependents.add(this.board[this.Spalte][k]);
            }
            this.dependents.remove(this.board[this.Spalte][this.Zeile]);
        }
        return this.dependents;
    }

// TODO
//    public Set<Value> getDomain() {
//        return this.domain;
//    }

    public int getSpalte() {
        return this.Spalte;
    }

    public int getZeile() {
        return this.Zeile;
    }

    public Value getValue() {
        return this.value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setDependents(List<Field> dependents) {
        this.dependents = dependents;
    }

    public void setDomain(Set<Value> domain) {
        this.domain = domain;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    @Override
    public String toString() {
        if(isEmpty()) return ".";
        else return this.value.toString();
    }
}