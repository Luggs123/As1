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
        
//        double bonusSalary;
//	if(300 >= sales && sales <= 1000)
//        {
//            bonusSalary = (0.10 * sales); 
//        }
//        else if (sales > 1000 && sales <= 5000)   
//        {
//            bonusSalary = (0.05 * sales);
//        }
//        else if (sales > 5000 && sales <= 10000)
//        {
//            bonusSalary = (0.01 * sales);
    }

    @Override
    public boolean determineValidity(int hrs, double sales) {
        
	boolean validity = true;
        
        if (sales < 300 && sales > 10000 )
        {
            validity = false;
        }
        
        return validity;
    }
    
}
