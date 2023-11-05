package TicTacToeGame;

enum RendererType {
    CONSOLE,
    NONE
}

interface Renderer {
    void renderBoard(Board board);
}
