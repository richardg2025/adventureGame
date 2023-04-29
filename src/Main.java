import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Map(10, 10);

        Random rand = new Random();

        int upperBound = 9;

        int x = rand.nextInt(upperBound - 1) + 1;
        int y = rand.nextInt(upperBound - 1) + 1;

        int playerX = 1;
        int playerY = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello Traveller. Type in 'start', to start.");

        String input1 = scanner.nextLine();
        if (input1.equals("start")) {
            Map.update(playerX, playerY, "■");
            Map.update(x, y, "x");
            Map.print2d();
            System.out.println("Hahaha, you dumb ****, why would you believe a random voice?");
            System.out.println("Above you is a map, the exit is marked with an x. Have fun escaping my simulation. MuhAHhhhhAhhA!!");
            System.out.println("But of course, because this is owned by Disney (as everything now is owned by Disney), please listen to my\nevil villain backstory. Once upon a time, there was a little boy living in New Hampshire. He loved nothing\nmore in life than his girlfriend, Patrisha Ecott James-Smith. Everyday, he would drive his little\ncar down to her house, and spend hours talking to her. But then she died. He was devastated.\nHis heart broke. I am him. I hate everything. Die. The End.");
            System.out.println("Oh I'm sorry, did I mention you need to escape the simulation? MuahhahahHAhAHhA");
            while (playerX != x || playerY != y) {
                System.out.println(biome());
                System.out.println(eat());
                System.out.println("What will you do next: ");
                String input2 = scanner.nextLine();
                if (input2.equals("eat berries")) {
                    System.out.println(deathMessage("berries"));
                    System.exit(0);
                } else if (input2.equals("eat candy")) {
                    System.out.println(deathMessage("candy"));
                    System.exit(0);
                } else if (input2.equals("eat beans")) {
                    System.out.println(deathMessage("beans"));
                    System.exit(0);
                } else if (input2.equals("pick up box")) {
                    System.out.println(deathMessage("box"));
                    System.exit(0);
                }

                move(input2, playerX, playerY);
                if (input2.equals("move left") || input2.equals("move right"))
                    playerX = playerX + move(input2, playerX, playerY);
                else if (input2.equals("move up") || input2.equals("move down"))
                    playerY = playerY + move(input2, playerX, playerY);
                Map.print2d();
            }

            System.out.println("You escaped!");
        }

    }

    static String forest() {
        Random rand = new Random();
        String[] list = {"You are still in the forest.", "You are out of the forest", "You have entered the forest"};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String city() {
        Random rand = new Random();
        String[] list = {"You are still in the city.", "You are out of the city", "You have entered the city"};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String suburbs() {
        Random rand = new Random();
        String[] list = {"You are still in the suburbs.", "You are out of the suburbs", "You have entered the suburbs"};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String fields() {
        Random rand = new Random();
        String[] list = {"You are still in the fields.", "You are out of the fields", "You have entered the fields"};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String biome() {
        Random rand = new Random();
        String[] list = {fields(), forest(), city(), suburbs()};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String food() {
        Random rand = new Random();
        String[] list = {"You find some berries.", "You find a can of beans.", "You find some candy.", "You find a box."};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static String deathMessage(String msg) {
        if (msg.equals("berries"))
            return "Those berries were poisonous. You died.";
        else if (msg.equals("beans"))
            return "You farted to death.";
        else if (msg.equals("candy"))
            return "The candy man came and took you away in his white van. You were sold.";
        else if (msg.equals("box"))
            return "The box is too heavy. Your spine snapped. Your dead.";
        return null;
    }

    static String eat() {
        Random rand = new Random();
        String[] list = {food(), " ", " "};
        int option = rand.nextInt(list.length);
        return list[option];
    }

    static int move(String input, int x, int y) {
        if (input.equals("move left")) {
            Map.update(x + 1, y, "■");
            Map.update(x, y, "□");
            return 1;
        } else if (input.equals("move right")) {
            Map.update(x - 1, y, "■");
            Map.update(x, y, "□");
            return -1;
        } else if (input.equals("move down")) {
            Map.update(x, y + 1, "■");
            Map.update(x, y, "□");
            return 1;
        } else if (input.equals("move up")) {
            Map.update(x, y - 1, "■");
            Map.update(x, y, "□");
            return -1;
        }
        return 0;
    }
}


