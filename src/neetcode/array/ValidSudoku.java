package neetcode.array;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowHasNumber = new boolean[9][9];
        boolean[][] columnHasNumber = new boolean[9][9];
        boolean[][] boxHasNumber = new boolean[9][9];

        for (int row = 0; row < 9; row++){
            for (int column = 0; column < 9; column++){
                char curVal = board[row][column];

                if (curVal == '.'){
                    continue;
                }

                int numVal = curVal - '1';
                int subBox = (row/3) * 3 + (column/3);

                if (rowHasNumber[row][numVal] ||
                        columnHasNumber[column][numVal] ||
                        boxHasNumber[subBox][numVal]){
                    return false;
                }

                rowHasNumber[row][numVal] = true;
                columnHasNumber[column][numVal] = true;
                boxHasNumber[subBox][numVal] = true;
            }
        }
        return true;
    }
}
