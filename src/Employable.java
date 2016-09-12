public interface Employable {
    public double computeSalary(int hrs, double sales);
    
    public double computeWage(int hrs, double perHour);
    
    public double computeCommission(double sales);
    
    public boolean determineValidity(int hrs, double sales);
}