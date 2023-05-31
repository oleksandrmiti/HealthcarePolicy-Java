/**
 * This program will read details of a prospective insurer, calculate the cost of their health insurance, and output a quotation.
 *
 * Programmer: Oleksandr Mitichkin
 * Date: 21.03.2023
 */


import java.text.DecimalFormat; // Import a decimal format

public class HealthPolicy {
    private String personName, dependantName, inpatientInsuranceType,  inpatientInsuranceAgree, addDependant, askAgain; // String variables
    private String dependantsName[]={"","","","","",""}, additionalExtraType[]={"",""}; // String lists
    private byte personAge, dependantAge, dependantsNum, additionalExtra, additionalExtrasNum, inpatientInsurance;
    private int dependantCost, dependantTotalCost, basicCost, inpatientInsuranceCost, inpatientInsuranceRoomCost,  additionalExtrasCost; // Integer variables
    private int dependantsAge[]={1,1,1,1,1,1}; // Integer lists
    private float totalBeforeVAT, vat, totalCost; // Float variables
    private boolean askAddDep = false, validAge = false, validDependantAge = false, validDependantsNum = false, validInsurance = false, validExtra = false, validExtrasNum = false, doQuotationAgain = false; // Booleans
    DecimalFormat money = new DecimalFormat("\u20AC0.00"); //Decimal format for Euro character that showing 2 number after dot
    public HealthPolicy(){
    	basicCost=426; // A basic cost for healthcare
        inpatientInsuranceCost = 200; // A cost of inpatient insurance
    }
    // Method to ask a persons age
    public void setPersonAge(){
        do {
            System.out.print("\nEnter your age please: "); // Asking user to enter an age
            personAge = Main.sc.nextByte();
            if (personAge < 18) {
                System.err.println("You must be at least 18 years old."); // Output error
            }
        } while (personAge < 18); // Working until user enter a age more than 18
        if (personAge > 50){
            basicCost+=80; // If user older than 50 he charged 50 euro extra
        }
}
    // Method to ask a persons age and check that number is correct
    public void askAge() {
        do {
            try {
                setPersonAge(); // Call a method to ask a age
                validAge = true;
            }
            catch(java.util.InputMismatchException e){
                System.err.print("Please use numbers.\n"); // Output error
                Main.sc.next(); // Call scaner again
            }
        } while (!validAge); // Working until user enter a correct age
    }

    // Method to ask a person name
    public void askName(){
        System.out.print("\nEnter your name: "); // Asking user to enter a name
        personName = Main.sc.next();
    }


    public void askPersonToAddDependant(){
        do {
            System.out.println("\nDo you want to add dependant Y/N?"); // Asking user if he wants to add dependant
            System.out.print("\nPlease enter your answer: ");
            addDependant = Main.sc.next();
            switch (addDependant) {
                case "Y": case "y": addDependant(); askAddDep = true; // IF answer Yes we call method witch adding dependants
                    break;
                case "N": case "n": System.out.print("\nThank you.\n"); askAddDep = true; // IF answer No
                    break;
                default:
                    System.err.println("Enter Y or N."); // In case of error
            }
        } while (!askAddDep);

    }
    private void addDependant(){
        do {
            try {
                do {
                    System.out.print("\nEnter how many dependants you want to add: "); // Asking a number of dependants
                    dependantsNum = Main.sc.nextByte();
                    if (dependantsNum > 6 || dependantsNum < 0) {
                        System.err.println("Sorry, something wrong, maximum number of dependants 6. "); // In user entered a number more than 6
                    }
                } while (dependantsNum > 6 || dependantsNum < 0);
                 validDependantsNum = true; // Stopping ask a number of user
            }
            catch(java.util.InputMismatchException e){
                System.err.println("Please use numbers."); // In case if user entered a letters
                Main.sc.next(); //Call scanner again
            }
        } while (!validDependantsNum);
        // Set the total cost of dependants
        if (dependantsNum == 1){
            dependantTotalCost += 250;
        } else if (dependantsNum == 2) {
            dependantTotalCost += 400;
        } else if (dependantsNum == 3) {
            dependantTotalCost += 500;
        } else if (dependantsNum == 4) {
            dependantTotalCost += 550;
        } else{
            dependantTotalCost += 550;
        }
        // Running for loop to add dependants, working until a number of dependants will be reached
        for (int i = 0; i != dependantsNum;i++) {
            System.out.print("\nEnter a name of dependant: "); // Asking to enter a name of dependant
            dependantName = Main.sc.next();
            dependantsName[i] = dependantName; // Adding a name of dependant to list
            do {
                try {
                    do {
                        System.out.print("\nEnter dependant age please: "); // Asking to enter a age of dependant
                        dependantAge = Main.sc.nextByte();
                        dependantsAge[i]= dependantAge; // Adding an age to list
                        if (dependantAge >= 18 || dependantAge < 0) {
                            System.err.println("Dependant must be under 18 years old."); // If user entered an age more than 18
                        }
                    } while (dependantAge >= 18 || dependantAge < 0);
                    validDependantAge = true; // Stopping asking age
                }
                catch(java.util.InputMismatchException e){
                    System.err.println("Please use numbers."); // If user entered a letters
                    Main.sc.next(); // Call user again
                }
            } while (!validDependantAge);
        }
    }

    public void askInpatientInsurance(){
        System.out.print("\nInpatient insurance costs an additional €200. This includes insurance " +
                "for a semi-private room.\nInsurance for a private room costs €100 extra.");
        do {
            try {
                do {
                    System.out.print("\n\nMake your choice: \n1. Inpatient insurance with semi-private room (€200)." +
                            "\n2. Inpatient insurance with private room (€300)." +
                            "\n3. I don`t need inpatient insurance."); // Output "menu" of inpatient insurance
                    System.out.print("\n\nEnter a number of your choice:"); // Asking to enter a number of choice
                    inpatientInsurance = Main.sc.nextByte();
                    if (inpatientInsurance > 3 || inpatientInsurance < 1) {
                        System.err.println("Please use numbers from 1 to 3."); // If user entered a wrong number
                    }
                } while (inpatientInsurance > 3 || inpatientInsurance < 1);
                validInsurance = true; // Stop asking
            }
            catch(java.util.InputMismatchException e){
                System.err.println("Please use numbers."); // If user entered a letters
                Main.sc.next(); // Call scanner again
            }
        } while (!validInsurance);
        switch (inpatientInsurance) {
            case 1:inpatientInsuranceType = "Semi-private"; inpatientInsuranceAgree ="Yes"; inpatientInsuranceRoomCost = 0; // If user choice is a 1
                break;
            case 2: inpatientInsuranceType = "Private";inpatientInsuranceAgree ="Yes"; inpatientInsuranceRoomCost = 100; // If user choice is a 2
                break;
            case 3: inpatientInsuranceType = "NA"; inpatientInsuranceAgree ="No"; inpatientInsuranceCost = 0; // If user choice is a 3
        }
    }
    public void additionalExtras() {
        do {
            try {
                do {
                    System.err.print("\nEach additional extra costs €50.");
                    System.out.print("\n\nNow you can make a choice up to 2 extras from list below: " +
                            "\n1. Orthopaedic care." +
                            "\n2. Ophthalmic care.\n3. Maternity care.\n4. Fertility care." +
                            "\n5. Psychiatric care."); // Output a "menu" of additional extras
                    System.out.print("\nEnter how many extra's you want to add or 0 if you don`t want: "); // Asking user to enter a choice
                    additionalExtrasNum = Main.sc.nextByte();
                    if (additionalExtrasNum > 2 || additionalExtrasNum < 0) {
                        System.err.println("Sorry, something wrong, maximum number of extra's 2. "); // If user entered a wrong number
                    }
                    if (additionalExtrasNum == 1){
                        additionalExtrasCost = 50; // If user choose 1 extra set the cost to 50
                    } else if (additionalExtrasNum == 2) {
                        additionalExtrasCost = 100; // If user choose 2 extras set the cost to 100
                    } else {
                        additionalExtrasCost = 0; // If user entered 0 set the cost to 0
                    }
                } while (additionalExtrasNum > 2 || additionalExtrasNum < 0); // Loop working until user enter a correct number
                validExtrasNum = true; // Stop asking user
            } catch (java.util.InputMismatchException e) {
                System.err.println("Please use numbers."); // In case of error
                Main.sc.next(); // Call user again
            }
        } while (!validExtrasNum);
        // For loop to add extras
        for (int i = 0; i != additionalExtrasNum; i++) {
            do {
                try {
                    do {
                        System.out.print("Enter a number of your choice:  "); // Asking user to enter a choice
                        additionalExtra = Main.sc.nextByte();
                        switch (additionalExtra) {
                            case 1:
                                additionalExtraType[i] = "Orthopaedic care"; // Add a choice to list
                                break;
                            case 2:
                                additionalExtraType[i] = "Ophthalmic care"; // Add a choice to list
                                break;
                            case 3:
                                additionalExtraType[i] = "Maternity care"; // Add a choice to list
                                break;
                            case 4:
                                additionalExtraType[i] = "Fertility care"; // Add a choice to list
                                break;
                            case 5:
                                additionalExtraType[i] = "Psychiatric care"; // Add a choice to list
                                break;
                        }
                        if (additionalExtra > 5 || additionalExtra < 0) {
                            System.err.println("\nPlease use numbers from 1 to 5."); // If user entered a wrong number
                        }
                    } while (additionalExtra > 5 || additionalExtra < 0); // Loop keep asking until enter a correct number
                    validExtra = true; // Stop asking
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Please use numbers."); // If user entered a letters
                    Main.sc.next(); // Call scanner again
                }
            } while (!validExtra);
        }
    }

    private void outputDependants(){
        if (dependantsNum == 0){
            dependantCost = 0; // Set cost for output
        } else{
            dependantCost=250; // Set cost for output
        }
        System.out.printf("\nNumber of dependants:%16d", dependantsNum); // Output a number of dependants
        for (int i = 0; i != dependantsNum;i++ ){
            switch (i) {
                case 1:
                    dependantCost -=100; // Minus E100 of cost for second dependant
                    break;
                case 2, 3, 4:
                    dependantCost -= 50; // Minus E50 of cost for third, fourth and fifth dependants
                    break;
                case 5:
                    dependantCost = 0;
                    break;
            }
                System.out.printf("\n\t\t\t\t\t\t\t\t #"+(i+1)+" Dependant:%16s",dependantsName[i]); // Output dependants name
                System.out.printf("\n\t\t\t\t\t\t\t\t\t"+"Age:%19d", dependantsAge[i]); // Output dependants age
                System.out.printf("\n\t\t\t\t\t\t\t\t\tCost:%24s", money.format(dependantCost)); // Output dependants cost

        }
    }

    private void outputAdditionalExtras(){
        System.out.printf("\nAdditional extras: "); // Output additional extras
        if (additionalExtrasNum > 0){
            for (int i = 0; i != additionalExtrasNum;i++ ){
                System.out.printf("\n\t\t\t\t\t\t\t\t\t"+(i+1)+" "+additionalExtraType[i]+"\t  €50.00"); // Output additional extras and cost of them
            }
        }else{
            System.out.printf("\n\t\t\t\t\t\t\t\t\tNone\t\t\t\t  €0.00"); // Output a cost of additional extras
        }

    }

    public void outputQuotation(){
        totalBeforeVAT = basicCost+inpatientInsuranceCost+inpatientInsuranceRoomCost+additionalExtrasCost+dependantTotalCost; // Calculate a total before paid tax
        vat = totalBeforeVAT*21/100; // Calculate tax
        totalCost = totalBeforeVAT-vat; // Calculate a total with paid vat
        System.out.printf("\n\n\n%55s","HCI Healthcare Policy\n\n");
        System.out.printf("Name: %32s", personName); // Output a person name
        outputDependants(); // Call method to output dependants
        System.out.printf("\nBasic cost (outpatient care): %35s", money.format(basicCost)); // Output basic cost
        System.out.printf("\nInpatient cost: \t\t\t\t\t%-21s %2s", inpatientInsuranceAgree, money.format(inpatientInsuranceCost)); // Output if the user agree with inpatient insurance and cost
        System.out.printf("\nRoom type: \t\t\t\t\t\t\t%-21s %2s", inpatientInsuranceType, money.format(inpatientInsuranceRoomCost)); // Output a type of room and cost
        outputAdditionalExtras(); // Call method to output additional extras
        System.out.printf("\n\nTotal before VAT: %48s", money.format(totalBeforeVAT)); // Output a total before paid vat
        System.out.printf("\nVAT:%61s", money.format(vat)); // Output a vat
        System.out.printf("\nTotal:%59s", money.format(totalCost)); // Output a total with paid vat
    }
    public void askUserDoAgain(){
        doQuotationAgain = false;
        // While loop
        do {
            System.out.println("\nDo you want to make another quotation, Y/N?");
            System.out.print("\nPlease enter your answer: "); // Asking user to enter a answer
            askAgain = Main.sc.next();
            switch (askAgain) {
                case "Y": case "y": Main.Again = false; doQuotationAgain = true;
                    break;
                case "N": case "n": Main.Again = true; doQuotationAgain = true;
                    break;
                default:
                    System.err.println("Enter Y or N.");
            }
        } while (!doQuotationAgain);
    }
}