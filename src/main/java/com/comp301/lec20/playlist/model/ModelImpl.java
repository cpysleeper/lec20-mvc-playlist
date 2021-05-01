package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

    private int[][] _board;

    public BoardImpl(Clues b) {

        if (b == null) {
            throw new IllegalArgumentException();
        }

        int width = b.getWidth();
        int height = b.getHeight();
        _board = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                _board[i][j] = 0;
            }
        }
    }


    @Override
    public boolean isShaded(int row, int col) {
        if ((row > _board[0].length) || (col > _board.length) || (col < 0) || (row < 0)) {
            throw new IllegalArgumentException();
        }
        if (_board[row][col] == (1)) return true;
        return false;
    }

    @Override
    public boolean isEliminated(int row, int col) {
        if ((row > _board[0].length) || (col > _board.length) || (col < 0) || (row < 0)) {
            throw new IllegalArgumentException();
        }
        if (_board[row][col] == (-1)) return true;
        return false;
    }

    @Override
    public boolean isSpace(int row, int col) {
        if ((row > _board[0].length) || (col > _board.length) || (col < 0) || (row < 0)) {
            throw new IllegalArgumentException();
        }
        if (_board[row][col] == (-1) || _board[row][col] == (-1)) return false;
        return true;
    }

    @Override
    public void toggleCellShaded(int row, int col) {
        if ((row > _board[0].length) || (col > _board.length) || (col < 0) || (row < 0)) {
            throw new IllegalArgumentException();
        }
        if (_board[row][col] == (1)) _board[row][col] = 0;
        else if (_board[row][col] == (0)) _board[row][col] = 1;


    }

    @Override
    public void toggleCellEliminated(int row, int col) {
        if ((row > _board[0].length) || (col > _board.length) || (col < 0) || (row < 0)) {
            throw new IllegalArgumentException();
        }
        if (_board[row][col] == (-1)) _board[row][col] = 0;
        else if (_board[row][col] == (0)) _board[row][col] = -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; i < _board[0].length; i++) {
                _board[i][j] = 0;
            }
        }
    }
}
