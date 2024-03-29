package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color white) {
        super(board);
        this.color = white;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;

    }

    public void increaseMoveCount() {
        moveCount++;
        moveCount--;
    }

    public ChessPosition gChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;

    }

    public void decreaseMoveCount() {
    }

}
