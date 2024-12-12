import classes.Company;
import classes.Individual;
import classes.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int quantity, numberOfEmployees;
        String name;
        char type;
        double anualIncome, healthExpenditures, totalTaxes = 0;

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Entre com a quantidade de contribuintes: ");
        quantity = scan.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Contribuinte #: " + (i + 1));
            System.out.print("Individual ou Companhia? (i/c): ");
            type = scan.next().charAt(0);

            if(type == 'i') {

                System.out.print("Nome: ");
                scan.nextLine();
                name = scan.nextLine();
                System.out.print("Renda anual: ");
                anualIncome = scan.nextDouble();
                System.out.print("Gastos com Saúde: ");
                healthExpenditures = scan.nextDouble();

                taxPayers.add(new Individual(name, anualIncome, healthExpenditures));

            } else if (type == 'c') {

                System.out.print("Nome da Companhia: ");
                scan.nextLine();
                name = scan.nextLine();
                System.out.print("Renda anual: ");
                anualIncome = scan.nextDouble();
                System.out.print("Número de Funcionários: ");
                numberOfEmployees = scan.nextInt();

                taxPayers.add(new Company(name, anualIncome, numberOfEmployees));

            } else {
                System.out.print("Código inválido");
                i--;
            }
        }

        System.out.println("\nTAXAS PAGAS:");

        for (TaxPayer taxPayer : taxPayers) {
            System.out.printf("%s: R$ %.2f\n", taxPayer.getName(), taxPayer.tax());
            totalTaxes += taxPayer.tax();
        }

        System.out.println("\nTOTAL DE TAXAS: R$ " + totalTaxes);

    }
}