public interface Employable {
	//abstract methods necessary for Employee
    public double computeSalary(int hrs, double sales);
    public double computeWage(int hrs);
    public double computeCommission(double sales);
    public boolean determineValidity(int hrs, double sales);
}