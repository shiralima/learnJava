package TicTacToeGame;

import java.util.Scanner;

public class RendererFactory {

    public RendererFactory() {
    }

    public Renderer buildRenderer(RendererType rendererType) {
        System.out.println("Please enter if you want your board game render?");

        if (rendererType.equals(RendererType.CONSOLE)) {
            return new ConsoleRenderer();
        }
        return new VoidRenderer();
    }

    private RendererType getValidRendererType() {
        RendererType renderType = null;
        Scanner scanner = new Scanner(System.in);
        while (renderType == null) {
            String input = scanner.next().toUpperCase();
            try {
                renderType = RendererType.valueOf(input);
            } catch (IllegalArgumentException err) {
                System.err.println("Invalid player type: " + input);
                System.out.println("Valid player types:");
                for (RendererType type : RendererType.values()) {
                    System.out.print(String.format("%s ", type.name()));
                }
                System.out.println("\nPlease enter the player type again:");
            }
        }
        return renderType;
    }
}
