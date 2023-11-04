package TicTacToeGame;

enum RendererType {
    CONSOLE,
    NONE
}

interface Renderer {
    public void renderBoard(Board board);
}
