public interface Employable {
	//abstract methods necessary for Employee
    public void computeSalary(int hrs, double sales);
    public double computeWage(int hrs);
    public double computeCommission(double sales);
    public void determineValidity(double sales);
}