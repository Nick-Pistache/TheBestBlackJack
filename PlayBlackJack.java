import java.util.Scanner;

class PlayBlackJack {
    
    static int[] score = {0,0};
    //Player    
    public static void main(String[] args) {
        int min = 0;
        int max = 52;
        int value;

        boolean response = true;
        
        //distribution et calcul score player
        for (int i=0; i<2; i++) {
            String card = BlackJack.generateRandomIntIntRange(min, max);
            System.out.println("Vous avez tiré : " + card);
            if (card == "As coeur" || card == "As pique"|| card == "As trefle"|| card == "As carreau" ) {
                Scanner myChoice = new Scanner(System.in);
                System.out.println("Quelle valeur donnez-vous à votre As ? Saisir [1] ou [11]");
                value = Integer.parseInt(myChoice.next());
            } 
            
            else {
            value = BlackJack.findValue(card);
            }         
            
            score[0] = score[0] + value;
        }

        System.out.println("Vous avez actuellement un total de : "+ score[0] + " points.");
        
        //distribution et calcul score computer
        for (int i=0; i<2; i++) {
            String card = BlackJack.generateRandomIntIntRange(min, max);
            if (card == "As coeur" || card == "As pique"|| card == "As trefle"|| card == "As carreau" ) {
                if (score[1]<11) {
                   value = 11; 
                }
                else{
                    value = 1;
                }
            } 
            
            else {
            value = BlackJack.findValue(card);
            }         
            score[1] = score[1] + value;
        }
        //deamnde de carte pour player
        while (response == true && score[0]<21) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("Voulez-vous une carte supplémentaire ? Si oui, mettre [Y] sinon taper une autre lettre.");
            char answer = myObj.next().charAt(0);
            if (answer == 'Y' || answer == 'y') {
                String card = BlackJack.generateRandomIntIntRange(min, max);
                System.out.println("Vous avez tiré : " + card);
                if (card == "As coeur" || card == "As pique"|| card == "As trefle"|| card == "As carreau" ) {
                    Scanner myChoice = new Scanner(System.in);
                    System.out.println("Quelle valeur donnez-vous à votre As ? Saisir [1] ou [11]");
                    value = Integer.parseInt(myChoice.next());
                } 
            
                else {
                    value = BlackJack.findValue(card);
                }      
                
                score[0] = score[0] + value;
                System.out.println("Vous avez maintenant un total de : "+ score[0] + " points.");
            } 
            else {
                response = false;
            }
        }
        //deamnde de carte pour computer
        while (score[1]<11 || BlackJack.findStat(score[1])>=0.4) {
            String card = BlackJack.generateRandomIntIntRange(min, max);
            if (card == "As coeur" || card == "As pique"|| card == "As trefle"|| card == "As carreau" ) {
                if (score[1]<11) {
                   value = 11; 
                }
                else{
                    value = 1;
                }
            }
            else {
                value = BlackJack.findValue(card); 
            }        
            System.out.println("La banque a tiré une carte supplémentaire");
            score[1] = score[1] + value;
        }
        
        //annonce du résultat de la partie
        System.out.println("La banque a obtenu : "+ score[1] + " points.");
        System.out.println(BlackJack.whoWins(score[0], score[1]));
          
    }
}  

