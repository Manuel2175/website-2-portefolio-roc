package mastermindScanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MastermindCodeGen
{ // aanroeping van de Scanner
    Scanner invoer = new Scanner(System.in);
    // aanroeping van alle benodigde variabelen
    private ArrayList<Integer> code, gok;
    private int goed, halfGoed, codeLengte, poging;
    private boolean goedeInput, winst;

    // functie waar de basis van het spel in zit
    public void mastermind(Scanner invoer)
    {

	while (!goedeInput)
	{
	    try
	    {
		System.out.println("Hoelang wilt u de code hebben");
		codeLengte = invoer.nextInt();
		goedeInput = true; // Set the flag to true if a valid integer is provided
	    }
	    catch (InputMismatchException e)
	    {
		System.out.println("Vul een geldig getal in.");
		invoer.nextLine(); // Consume the invalid input
	    }
	}
	System.out.println(codegen(codeLengte));
	poging = 0;
	while (!winst && poging <= 10)
	{
	    halfGoed = 0;
	    goed = 0;
	    ArrayList<Integer> gok = getGok(invoer);
	    int goed = controleGoed(gok);
	    int halfGoed = controleHalfGoed(gok);
	    if(goed == codeLengte) {
		winst= true;
	    }
	    if (winst == true)
	    {
		System.out.println("je hebt gewonnen gefeliciteerd");
	    }
	    // de statestieken voor het einde van de beurt
	    else
	    {
		poging++;
		System.out.println("aantal goed: " + goed);
		System.out.println("aantal goed op verkeerde plek: " + halfGoed);
		System.out.println("aantal beurten over: " + (10 - poging));
		System.out.println("nieuwe ronde nieuwe kansen succes met je " + poging + "e poging");
	    }

	}

    }

    // functie om de code te genereren
    public ArrayList<Integer> codegen(int codeLengte)
    {
	code = new ArrayList<>();
	for (int i = 1; i <= codeLengte; i++)
	{
	    code.add(i);
	}
	Collections.shuffle(code);
	return code;
    }

    // functie om te controleren op hoeveel goed je hebt gegokt
    public int controleGoed(ArrayList<Integer> gok)
    {
	for (int i = 0; i < code.size(); i++)
	{
	    if (code.get(i).equals(gok.get(i)))
	    {
		goed++;
	    }
	}
	return goed;
    }

    // functie om te controleren hoeveel je goed had op verkeerde plek
    public int controleHalfGoed(ArrayList<Integer> gok)
    {
	for (int i = 0; i < gok.size(); i++)
	{
	    if (!code.get(i).equals(gok.get(i)) && code.contains(gok.get(i)))
	    {
		halfGoed++;
	    }
	    if (goed < 4)
	    {
		halfGoed = 0;
		goed = 0;
	    }
	}
	return halfGoed;
    }

    // functie om je gok aftelezen om vervoglens te gebruiken voor controle
    public ArrayList<Integer> getGok(Scanner invoer)
    {
	gok = new ArrayList<>();

	for (int i = 0; i < code.size(); i++)
	{
	    System.out.println("Doe je " + (i + 1) + "ste gok");

	    try
	    {
		// Try to read an integer
		int input = invoer.nextInt();
		gok.add(input);
	    }
	    catch (InputMismatchException e)
	    {

		System.out.println("Ongeldige invoer. Voer alstublieft een getal in.");
		invoer.nextLine(); 
		i--;
	    }
	}

	return gok;
    }

}
