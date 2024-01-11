package mastermindScanner;


import java.util.Scanner;

public class Mastermind2
{

    public static void main(String[] args)
    {
	//aanroeping van de Scanner
	Scanner invoer = new Scanner(System.in);
	//aanroeping van de Mastermind class met alle functies
	MastermindCodeGen spel = new MastermindCodeGen();
	//de functies om het hele spel te spelen
	spel.mastermind(invoer);
	//aflsuiting scanner
	invoer.close();
    }
}