package TicTacToeGame;

public class RendererFactory {

    public RendererFactory() {
    }

    public Renderer buildRenderer(RendererType rendererType) {
        if (rendererType.equals(RendererType.CONSOLE)) {
            return new ConsoleRenderer();
        }
        return new VoidRenderer();
    }
}
