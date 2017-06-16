package game;

public class Board {
    private Cell[][] cells;
    public Integer ROWS = 8; // Try to put it something different
    public Integer COLS = 8; // Try to put it something different
    public Integer SIGNS_TO_WIN = 5; // Try to put it something different

    public Board() {
        this.cells = new Cell[ROWS][COLS];
    }

    public void init() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                this.cells[rowIndex][columnIndex] = new Cell();
            }
        }
    }

    public boolean isDraw() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                if (this.getCell(rowIndex, columnIndex).getContent() == Seed.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Cell usersMove) {
        Integer row = usersMove.getRow();
        Integer col = usersMove.getCol();
        Seed content = usersMove.getContent();

        // Checking vertically win
        Integer upAndDownSigns = checkUpperSigns(row, col, content) +
                checkLowerSigns(row, col, content) - 1;
        // -1 because 2 times for loops counts usersMove itself and add 1 because
        // usersMove place should also be counted once
        if (upAndDownSigns >= this.SIGNS_TO_WIN) {
            return true;
        }

        // Checking horizontally win
        Integer LeftAndRightSigns = checkRightSigns(row, col, content) +
                checkLeftSigns(row, col, content) - 1;
        if (LeftAndRightSigns >= this.SIGNS_TO_WIN) {
            return true;
        }

        // Checking bevel win (up right - down left)
        Integer bevel1Counter = checkUpRightSigns(row, col, content) +
                checkLowerLeftSigns(row, col, content) -1;
        if (bevel1Counter >= this.SIGNS_TO_WIN) {
            return true;
        }

        // Checking bevel win (up left - down right)
        Integer bevel2Counter = checkUpLeftSigns(row, col, content) +
                checkLowerRightSigns(row, col, content) - 1;
        if (bevel2Counter >= this.SIGNS_TO_WIN) {
            return true;
        }
        return false;

    }

    private Integer checkUpperSigns(Integer row, Integer col, Seed content) {
        // Check higher signs in board
        Integer counter = 0;
        for (int r = row; r >= 0; r--) {
            if (content == cells[r][col].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkLowerSigns(Integer row, Integer col, Seed content) {
        // Check lower signs in board
        Integer counter = 0;
        for (int r = row; r < this.ROWS; r++) {
            if (content == cells[r][col].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkLeftSigns(Integer row, Integer col, Seed content) {
        // Check left signs in board
        Integer counter = 0;
        for (Integer c = col; c >= 0; c--) {
            if (content.equals(cells[row][c].getContent())) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkRightSigns(Integer row, Integer col, Seed content) {
        // Check right signs in board
        Integer counter = 0;
        for (Integer c = col; c < this.COLS; c++) {
            if (content.equals(cells[row][c].getContent())) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkUpRightSigns(Integer row, Integer col, Seed content) {
        Integer counter = 0;
        // Check up right signs in board
        for (Integer r = row, c = col; isMatrixElement(r, c); r--, c++) {
            if (content == cells[r][c].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkUpLeftSigns(Integer row, Integer col, Seed content) {
        // Check up left signs in board
        Integer counter = 0;
        for (Integer r = row, c = col; isMatrixElement(r, c); r--, c--) {
            if (content == cells[r][c].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkLowerRightSigns(Integer row, Integer col, Seed content) {
        Integer counter = 0;
        // Check down right signs in board
        for (Integer r = row, c = col; isMatrixElement(r, c); r++, c++) {
            if (content == cells[r][c].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private Integer checkLowerLeftSigns(Integer row, Integer col, Seed content) {
        // Check down left signs in board
        Integer counter = 0;
        for (Integer r = row, c = col; isMatrixElement(r, c); r++, c--) {
            if (content == cells[r][c].getContent()) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }


    private boolean isMatrixElement(Integer row, Integer col) {
        if (row < cells.length && row >= 0) {
            return (col < cells[row].length && col >= 0);
        }
        return false;
    }

    public Cell getCell(Integer row, Integer col) {
        return this.cells[row][col];

    }

    public void clearAllCells() {
        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++){
            for(int columnIndex = 0; columnIndex < this.COLS; columnIndex++) {
                this.cells[rowIndex][columnIndex].clear();
            }
        }

    }

}
