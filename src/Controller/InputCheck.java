package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputCheck {
    private Scanner in = new Scanner(System.in).useDelimiter("\\n");
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public String inputString(){
        String string = in.next();
        return string;
    }

    public int inputIntegerSvar(){
        int svar = -1;
        boolean isInt = false;

        while (!isInt){
        try {
            svar = in.nextInt();
            isInt = true;
        } catch (InputMismatchException exception) {
            System.out.println("Please type a number:");
            in.nextLine();
        }}

        return svar;
    }

    public Date inputDato(){

        boolean validerDatoInput = false;
        String svar;
        Date date = null;
        simpleDateFormat.setLenient(false);

        while(!validerDatoInput) {
            svar = in.next();

            try {
                date = simpleDateFormat.parse(svar);
                validerDatoInput = true;

            } catch (ParseException e) {
                System.out.println("Indtast venligst en korrekt dato (dd/mm/åååå):");
            }

        }
        return date;
    }

    public String inputEmailadresse(){
        boolean validerEmailadresseInput = false;
        String emailadresse = "";
        while(!validerEmailadresseInput){
            emailadresse = inputString();
            if(emailadresse.contains("@")){
                validerEmailadresseInput = true;
            }
            else{
                System.out.println("emailadressen skal indeholde '@':");
            }
        }
        return emailadresse;
    }

    public int inputTelefonnummer(){
        boolean validerSvar = false;
        int telefonnummer = -1;
        while(!validerSvar) {
            telefonnummer = inputIntegerSvar();
            if(telefonnummer > 0 && telefonnummer < 99999999){
                validerSvar = true;
            }
            else{
                System.out.println("Indtast venligst et korrekt telefonnummer:");
            }
        }
        return telefonnummer;
    }

    public void scannerClose(){
        in.close();
    }

    public String omregnTid(int tid){
        int min = tid / 6000;
        int sekund = tid % 6000 / 100;
        int hundrededele = tid % 6000 % 100;
        String string;
        if(sekund < 10 && hundrededele < 10){
            string = min + ":0" + sekund + ":0" + hundrededele;
        }
        else if(sekund < 10 && hundrededele >= 10){
            string = min + ":0" + sekund + ":" + hundrededele;
        }
        else if(sekund >= hundrededele && hundrededele < 10){
            string = min + ":" + sekund + ":0" + hundrededele;
        }
        else{
            string = min + ":" + sekund + ":" + hundrededele;
        }
        return string;
    }

}
