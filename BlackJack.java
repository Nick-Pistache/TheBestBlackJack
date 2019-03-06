import java.util.Random;

class BlackJack {

    static String[] cardsPill = {"!", "Roi coeur", "Roi pique", "Roi trefle", "Roi carreau", "Dame coeur", "Dame pique", "Dame trefle", "Dame carreau", "Valet coeur", "Valet pique", "Valet trefle", "Valet carreau", "10 coeur", "10 pique", "10 trefle", "10 carreau", "9 coeur", "9 pique", "9 trefle", "9 carreau", "8 coeur", "8 pique", "8 trefle", "8 carreau", "7 coeur", "7 pique", "7 trefle", "7 carreau", "6 coeur", "6 pique", "6 trefle", "6 carreau", "5 coeur", "5 pique", "5 trefle", "5 carreau", "4 coeur", "4 pique", "4 trefle", "4 carreau", "3 coeur", "3 pique", "3 trefle", "3 carreau", "2 coeur", "2 pique", "2 trefle", "2 carreau", "As coeur", "As pique", "As trefle", "As carreau"};

    //Mix up table and collect
    public static String generateRandomIntIntRange(int min, int max) {
        int index = 0;
        while (cardsPill[index].equals("!")) {
            Random r = new Random();
            index = r.nextInt((max - min) + 1) + min;
        }
        String card = cardsPill[index];
        cardsPill[index] = "!";
        return card;
    }

    //Compare final scores
    public static String whoWins(int scorePlayer, int scoreComputer) {
        return scorePlayer == 21 || (scorePlayer < 21 && scorePlayer > scoreComputer) || (scorePlayer < 21 && scoreComputer > 21) ? "Bravo ! Vous êtes prêts pour ruiner les casinos." : "Dommage ! Tu es trop mauvais";
    }

    //Find out value
    public static int findValue(String card) {
        if (card.equals("Roi coeur") || card.equals("Roi pique") || card.equals("Roi trefle") || card.equals("Roi carreau") || card.equals("Dame coeur") || card.equals("Dame pique") || card.equals("Dame trefle") || card.equals("Dame carreau") || card.equals("Valet coeur") || card.equals("Valet pique") || card.equals("Valet trefle") || card.equals("Valet carreau") || card.equals("10 coeur") || card.equals("10 pique") || card.equals("10 trefle") || card.equals("10 carreau")) {
            return 10;
        }

        if (card.equals("9 coeur") || card.equals("9 pique") || card.equals("9 trefle") || card.equals("9 carreau")) {
            return 9;
        }

        if (card.equals("8 coeur") || card.equals("8 pique") || card.equals("8 trefle") || card.equals("8 carreau")) {
            return 8;
        }

        if (card.equals("7 coeur") || card.equals("7 pique") || card.equals("7 trefle") || card.equals("7 carreau")) {
            return 7;
        }

        if (card.equals("6 coeur") || card.equals("6 pique") || card.equals("6 trefle") || card.equals("6 carreau")) {
            return 6;
        }

        if (card.equals("5 coeur") || card.equals("5 pique") || card.equals("5 trefle") || card.equals("5 carreau")) {
            return 5;
        }

        if (card.equals("4 coeur") || card.equals("4 pique") || card.equals("4 trefle") || card.equals("4 carreau")) {
            return 4;
        }

        if (card.equals("3 coeur") || card.equals("3 pique") || card.equals("3 trefle") || card.equals("3 carreau")) {
            return 3;
        }

        if (card.equals("2 coeur") || card.equals("2 pique") || card.equals("2 trefle") || card.equals("2 carreau")) {
            return 2;
        }

        return 0;
    }

    //Find out statistics
    public static double findStat(int scoreComputer) {
        int amountGoodCard = 0;
        int amountFalseCard = 0;
        for (int i = 0; i < 53; i++) {
            if ((21 - scoreComputer) < findValue(cardsPill[i])) {
                amountGoodCard = amountGoodCard + 1;
            } else {
                amountFalseCard = amountFalseCard + 1;
            }
        }
        Random r = new Random();
        double risk = r.nextInt(1);
        return risk * (amountGoodCard / (amountGoodCard + amountFalseCard));
    }
}
    
    