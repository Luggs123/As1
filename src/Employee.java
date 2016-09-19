public class Employee extends AbstractEmployee {

	//sole constructor for Employee
	public Employee(String name, int hours, double sales){
		this.name = name;
		this.hours = hours;
		this.sales = sales;
		
		//salary only granted for valid employees
		this.isValid = determineValidity(this.hours, this.sales);
		if (this.isValid) {
			this.salary = computeSalary(this.hours, this.sales);
		}
	}

	@Override
	public double computeSalary(int hrs, double sales) {
		//pay by hourly basis
		if (sales >= 0 && sales <= 300) {
			return computeWage(hrs);
			
		//pay by commission on sales
		} else if (sales <= 10000 && sales > 300) {
			return computeCommission(sales);
		} else {
			return 0;  
		}
	}

	@Override
	public double computeWage(int hrs) {
		//constants for use in overtime calculations: hourly pay, change in pay by overtime, hours required to get overtime
		double hourlyPay = 10;
		double overtimeMultiplier = 1.5;
		int overtimeThreshold = 40;
		double wagePay = 0;
		double overtimePay = 0;

		//split pay into wage and overtime-specific
		wagePay = Math.min(hrs, overtimeThreshold)*hourlyPay;
		overtimePay = Math.max(0, hrs - overtimeThreshold)*hourlyPay*overtimeMultiplier;

		return wagePay + overtimePay;
	}

	@Override
	public double computeCommission(double sales) {
		double baseCommission = 0;
		double commissionPay = 0;

		//different commission brackets
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
		//employee is invalid if less than zero or greater than 10,000 in sales, and hours worked less than zero or more than 60
		if (sales < 0 || sales > 10000 || hrs > 60 || hrs < 0)
		{
			return false;
		} else {
			return true;
		}
	}
}
