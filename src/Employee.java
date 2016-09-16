public class Employee extends AbstractEmployee {
    
    public Employee(String name, int hours, double sales){
	this.name = name;
	this.hours = hours;
	this.sales = sales;
	this.isValid = determineValidity(this.hours, this.sales);
	if (this.isValid) {
	    this.salary = computeSalary(this.hours, this.sales);
	}
    }
    
    @Override
    public double computeSalary(int hrs, double sales) {
	if (sales >= 0 && sales <= 300) {
	    return computeWage(hrs);
	} else if (sales <= 10000 && sales > 300) {
	    return computeCommission(sales);
	} else {
	    return 0;  
	}
    }

    @Override
    public double computeWage(int hrs) {
	double hourlyPay = 10;
	double overtimeMultiplier = 1.5;
	int overtimeThreshold = 40;
	double wagePay = 0;
	double overtimePay = 0;
	
	wagePay = Math.min(hrs, overtimeThreshold)*hourlyPay;
	overtimePay = Math.max(0, hrs - overtimeThreshold)*hourlyPay*overtimeMultiplier;
	
	return wagePay + overtimePay;
    }

    @Override
    public double computeCommission(double sales) {
	double baseCommission = 0;
        double commissionPay = 0;
	
	if(300 >= sales && sales < 1000) {
	    baseCommission = 400;
            commissionPay = (0.10 * sales); 
        } else if (sales >= 1000 && sales < 5000) {
	    baseCommission = 600;
            commissionPay = (0.05 * sales);
        } else if (sales >= 5000 && sales <= 10000) {
	    baseCommission = 900;
            commissionPay = (0.01 * sales);
	}
	
	return baseCommission + commissionPay;
    }

    @Override
    public boolean determineValidity(int hrs, double sales) {
        
        if (sales < 300 || sales > 10000 || hrs > 60 || hrs < 0)
        {
            return false;
        } else {
	    return true;
	}
    }
}
