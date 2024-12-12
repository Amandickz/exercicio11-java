package classes;

public class Company extends TaxPayer{

    private int numberOfEmployees;

    public Company(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        double totalTax = 0;
        if(numberOfEmployees <= 10){
            totalTax = getAnualIncome() * 0.16;
        } else {
            totalTax = getAnualIncome() * 0.14;
        }
        return totalTax;
    }
}
