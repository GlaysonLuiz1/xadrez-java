package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro ao criar quadro: deve haver pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int columns) {
        if (!positionExists(row, columns)) {
            throw new BoardException("Nao ha essa posição no quadro");
        }
        return pieces[row][columns];
    }

    public Piece piece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Não há essa posição no quadro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("Já tem uma peça na posição: " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Não há essa posição no quadro");
        }
        return piece(position) != null;
    }

    private boolean positionExists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());

    }

}
