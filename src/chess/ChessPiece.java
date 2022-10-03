package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color white) {
        super(board);
        this.color = white;
    }

    public Color getColor() {
        return color;
    }

}
