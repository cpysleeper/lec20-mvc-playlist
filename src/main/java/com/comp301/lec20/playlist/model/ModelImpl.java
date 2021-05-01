package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

    private List<Clues> _cluess;
    private List<Board> _boards;
    private int _indOfModel;
    private List<ModelObserver> observerList;

    public ModelImpl(List<Clues> clues) {
        _indOfModel = 0;
        if (clues == null) throw new NullPointerException();
        _cluess = clues;
        _boards = new ArrayList<>();
        for (int i = 0; i < clues.size(); i++) {
            Clues helper = (CluesImpl) clues.get(i);
            _boards.add(new BoardImpl(helper));
        }
        observerList = new ArrayList<>();
    }

    private void notify(Model model) {
        for (ModelObserver observer : observerList) {
            observer.update(model);
        }
    }


    @Override
    public boolean isShaded(int row, int col) {
        return _boards.get(_indOfModel).isShaded(row, col);
    }

    @Override
    public boolean isEliminated(int row, int col) {
        return _boards.get(_indOfModel).isEliminated(row, col);
    }

    @Override
    public boolean isSpace(int row, int col) {
        return _boards.get(_indOfModel).isSpace(row, col);
    }

    @Override
    public void toggleCellShaded(int row, int col) {
        notify(this);
        _boards.get(_indOfModel).toggleCellShaded(row, col);
    }

    @Override
    public void toggleCellEliminated(int row, int col) {
        notify(this);
        _boards.get(_indOfModel).toggleCellEliminated(row, col);
    }

    @Override
    public void clear() {
        notify(this);
        _boards.get(_indOfModel).clear();
    }

    @Override
    public int getWidth() {
        return _cluess.get(_indOfModel).getWidth();
    }

    @Override
    public int getHeight() {
        return _cluess.get(_indOfModel).getHeight();
    }

    @Override
    public int[] getRowClues(int index) {
        return _cluess.get(_indOfModel).getRowClues(index);
    }

    @Override
    public int[] getColClues(int index) {
        return _cluess.get(_indOfModel).getColClues(index);
    }

    @Override
    public int getRowCluesLength() {
        return _cluess.get(_indOfModel).getRowCluesLength();
    }

    @Override
    public int getColCluesLength() {
        return _cluess.get(_indOfModel).getColCluesLength();
    }

    @Override
    public int getPuzzleCount() {
        return _cluess.size();
    }

    @Override
    public int getPuzzleIndex() {
        return _indOfModel;
    }

    @Override
    public void setPuzzleIndex(int index) {
        notify(this);
        _indOfModel = index;
    }

    @Override
    public void addObserver(ModelObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public boolean isSolved() {
        BoardImpl board = (BoardImpl) _boards.get(_indOfModel);
        CluesImpl curClues = (CluesImpl) _cluess.get(_indOfModel);
        //loops for checking rowclues
        for (int i = 0; i < curClues.getHeight(); i++) {

            int helper = curClues.getWidth() - 1;
            int countShaded = 0;
            boolean firsFound1 = true;

            for (int j = curClues.getRowCluesLength() - 1; j >= 0; j--) {

                for (int k = helper; k >= 0; k--) {
                    if (board.isShaded(i, k)) {
                        countShaded++;
                        firsFound1 = false;
                    }
                    if ((!firsFound1 && !board.isShaded(i, k)) || k == 0) {
                        if (countShaded != curClues.getRowClues(i)[j]) {
                            return false;
                        }
                        countShaded = 0;
                        firsFound1 = true;
                        helper = k - 1;

                        break;
                    }
                }
            }
        }
        //loops for checking colclues
        for (int i = 0; i < curClues.getWidth(); i++) {

            int curBoardIndex = curClues.getHeight() - 1; // to check board index
            int countShaded = 0;
            boolean firsFound1 = true;

            for (int j = curClues.getColCluesLength() - 1; j >= 0; j--) {
                for (int k = curBoardIndex; k >= 0; k--) {
                    if (board.isShaded(k, i)) {
                        countShaded++;
                        firsFound1 = false;
                    }
                    if ((!firsFound1 && !board.isShaded(k, i)) || k == 0) {
                        if (countShaded != curClues.getColClues(i)[j]) {
                            return false;
                        }
                        countShaded = 0;
                        firsFound1 = true;
                        curBoardIndex = k - 1;
                        break;

                    }
                }
            }
        }

        return true;
    }


    public BoardImpl getCurrentBoard(int index) {
        return (BoardImpl) _boards.get(index);
    }

    public CluesImpl getCurrentClues(int index) {
        return (CluesImpl) _cluess.get(index);
    }
}
