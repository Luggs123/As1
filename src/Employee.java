public class Employee extends AbstractEmployee {
    
    public Employee(String name, int hours, double sales){
	this.name = name;
	this.hours = hours;
	this.sales = sales;
	this.isValid = determineValidity(this.hours, this.sales);
	this.salary = computeSalary(this.hours, this.sales);
    }
    
    @Override
    public double computeSalary(int hrs, double sales) {
	
    }

    @Override
    public double computeWage(int hrs, double perHour) {
	
    }

    @Override
    public double computeCommission(double sales) {
	
    }

    @Override
    public boolean determineValidity(int hrs, double sales) {
	
    }
    
}
