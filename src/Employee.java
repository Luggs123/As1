public class Employee extends AbstractEmployee {

	//sole constructor for Employee
	public Employee(String name, int hours, double sales){
		this.setName(name);
		this.setHours(hours);
		this.setSales(sales);
		
		//salary only granted for valid employees
		this.determineValidity(this.hours, this.sales);
		if (this.isValid) {
			computeSalary(this.hours, this.sales);
		}
	}

	@Override
	public void computeSalary(int hrs, double sales) {
		//pay by hourly basis
		if (sales >= 0 && sales <= 300) {
			this.setSalary(computeWage(hrs));
			
		//pay by commission on sales
		} else if (sales <= 10000 && sales > 300) {
			this.setSalary(computeCommission(sales));
		} else {
			this.setSalary(0);  
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

		this.setOvertimePay(overtimePay);
		return wagePay + overtimePay;
	}

	@Override
	public double computeCommission(double sales) {
		double commissionPay = 0;

		//different commission brackets
		if (300 >= sales && sales < 1000) {
			this.setBaseCommission(400);
			this.setBonusPercent(0.10);
		} else if (sales >= 1000 && sales < 5000) {
			this.setBaseCommission(600);
			this.setBonusPercent(0.05);
		} else if (sales >= 5000 && sales <= 10000) {
			this.setBaseCommission(900);
			this.setBonusPercent(0.01);
		}

		commissionPay = sales * this.getBonusPercent();
		return this.getBaseCommission() + commissionPay;
	}

	@Override
	public void determineValidity(int hrs, double sales) {
		//employee is invalid if less than zero or greater than 10,000 in sales, and hours worked less than zero or more than 60
		if (sales < 0 || sales > 10000)
		{
			this.setValid(false);
		} else {
			this.setValid(true);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSales() {
		return sales;
	}
	
	public void setSales(double sales) {
		this.sales = sales;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public double getOvertimePay() {
		return overtimePay;
	}
	
	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}
	
	public double getBaseCommission() {
		return baseCommission;
	}
	
	public void setBaseCommission(double baseCommission) {
		this.baseCommission = baseCommission;
	}
	
	public double getBonusPercent() {
		return bonusPercent;
	}
	
	public void setBonusPercent(double bonusPercent) {
		this.bonusPercent = bonusPercent;
	}
}
