import java.util.Scanner;

class Chat {
    public static void main(String[] args) {
        String[] repliesForBot1 = {
                "I'm sorry, I can't do that. ",
                "I don't understand. ",
                "Please rephrase your question. "
        };

        // Create the first bot
        ChatterBot bot1 = new ChatterBot(repliesForBot1, "bot1");

        // Define the replies for the second bot
        String[] repliesForBot2 = {
                "I cannot provide that information. ",
                "That's not within my capabilities. ",
                "Try asking a different question. "
        };

        // Create the second bot
        ChatterBot bot2 = new ChatterBot(repliesForBot2, "bot2");

        // Store the bots in an array
        ChatterBot[] bots = { bot1, bot2 };

        String statement = "hi you";
        Scanner scanner = new Scanner(System.in);

        for (int i = 0;; i++) {
            statement = bots[i % bots.length].replyTo(statement);
            System.out.print(bots[i % bots.length].getName() + ": " + statement);
            scanner.nextLine();
        }

    }
}