package vaisu;
import java.util.Random;
import java.util.Scanner;
    class Game{
        public int number;
        public int inputNumber;
        public int Guesses = 0;
        public int getGuesses() {

            return Guesses;
        }

        public void setNoOfGuesses(int Guesses) {

            this.Guesses = Guesses;
        }

        Game(){
            Random rand = new Random();
            this.number = rand.nextInt(100);
        }
        void takeUserInput(){
            System.out.println("Guess the number");
            Scanner sc = new Scanner(System.in);
            inputNumber = sc.nextInt();
        }
        boolean isCorrectNumber(){
            Guesses++;
            if (inputNumber==number){
                System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts", number, Guesses);
                return true;
            }
            else if(inputNumber<number){
                System.out.println("it's a small number .");
            }
            else if(inputNumber>number){
                System.out.println("it's a bigger number...");
            }
            return false;
        }

    }
    public class Guessinggame{
        public static void main(String[] args) {
            Game guessing = new Game();
            boolean c= false;
            while(!c){
                guessing.takeUserInput();
                c = guessing.isCorrectNumber();
            }
        }
    }


