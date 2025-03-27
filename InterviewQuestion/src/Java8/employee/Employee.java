package Java8.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum Gender
{
	Male,
	Female
}
public class Employee
{
    private int empoyeeId;
    private double salary;
    private int age;
    private String empName;
    private String gender;
    private String department;
    int yearOfJoining;
    

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) 
    {
        this.empoyeeId = id;
        this.empName = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }


	
	public int getEmpoyeeId() {
		return empoyeeId;
	}


	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}


	public double getSalary() {
		return salary;
	}


	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}


	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	



	@Override
	public String toString() {
		return "Employee [empoyeeId=" + empoyeeId + ", salary=" + salary + ", age=" + age + ", empName=" + empName
				+ ", gender=" + gender + ", department=" + department + ", yearOfJoining=" + yearOfJoining + "]";
	}


	public static void main(String[] args) {
	
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		countOfMaleAndFemale(employeeList); 
		nameOfAllTheDepartment(employeeList);
		averageAgeOfMaleAndFemale(employeeList); 
		highestSalaryOfEmployee(employeeList);
		secondHighestSalaryOfTheOrganisation(employeeList); 
		employeeJoineAfter2015(employeeList);
		countOfEmployeeInEachDepartment(employeeList);
		averageSalaryOfEachDepartment(employeeList);
		youngestEmployeeInProductionDepartment(employeeList);
		mostExperienceInOrganisation(employeeList);
		countOfMaleAndFemaleInSalesAndMarketingTeam(employeeList);
		averageSalaryOfMaleAndFemaleEmployee(employeeList);
		countOfEmployeeInEachDepartment(employeeList);
		averageAndTotalSalaryOfOrganisation(employeeList); 
		olderEmployeeInOrganisation(employeeList); 

	}

	private static void secondHighestSalaryOfTheOrganisation(List<Employee> employeeList) {
		System.out.println("Second Highest Salary In the Organisation : ");
		Optional<Employee> optionalEmployeeObject = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst();
		
		optionalEmployeeObject.ifPresent(employee->System.out.println("EmpName : "+employee.getEmpName() + " : "+employee.getSalary()));
		
		/**
		 *  Another way
		 */
		
		double secondHighestsalary =employeeList.stream().map(employee->employee.getSalary())
		.sorted(Collections.reverseOrder(Double::compareTo)).skip(1).findFirst().orElseGet(null);
		
		System.out.println("secondHighestsalary  :"+secondHighestsalary);
		System.out.println("**************************************************");
	}



	private static void olderEmployeeInOrganisation(List<Employee> employeeList) {
		System.out.println("Older Employee In the Organisation : ");
		Optional<Employee> olderEmployee= employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).findFirst();
		olderEmployee.ifPresent(employee->System.out.println("EmpName : "+employee.getEmpName() + " Age : "+employee.getAge()));
		System.out.println("**************************************************");
	}



	private static void averageAndTotalSalaryOfOrganisation(List<Employee> employeeList) {
		System.out.println("Average  Salary Of the Organisation : ");
		
		/**
		 *  Note : 
		 *  ===========
		 *  
		 *   --)  If the Stream is IntStream , we can directly apply sum(),average() functions.
		 *   --) Thats why For this question, instead of map which will return Stream<Double> I choose MapTODouble which return DoubleStream.
		 *   --) Any Place where you have to do some task like
		 *   
		 *                                              findAverage()
		 *                                              findSum()
		 *                                              
		 *              Choose IntStream or DoubleStream to apply sum() and average() method  . Later on apply method getAsDouble/getAsInt to parse.                                      
		 */
		double averageSalaryOfOrganisation =employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
		System.out.println("averageSalaryOfOrganisation : "+averageSalaryOfOrganisation);
		
		double totalSalaryOfOrganisation = employeeList.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("totalSalaryOfOrganisation : "+totalSalaryOfOrganisation);
		System.out.println("**************************************************");
	}



	private static void averageSalaryOfMaleAndFemaleEmployee(List<Employee> employeeList) {
		System.out.println("AverageSalaryOfMaleAndFemale");
		double averageSalaryOfMale = employeeList.stream()
																.filter(employee->employee.getGender().equals("Male"))
																.mapToDouble(Employee::getSalary)
																.average()
																.getAsDouble();
		double averageSalaryOfFemale = employeeList.stream()
				.filter(employee->employee.getGender().equals("Female"))
				.mapToDouble(Employee::getSalary)
				.average()
				.getAsDouble();
		System.out.println("averageSalaryOfMale : "+averageSalaryOfMale);
		System.out.println("averageSalaryOfFemale : "+averageSalaryOfFemale);
		System.out.println("**************************************************");
	}



	private static void countOfMaleAndFemaleInSalesAndMarketingTeam(List<Employee> employeeList) {
		
		System.out.println("Count of Male and Female in Sales And Marketing Team");
		long countOfMales = employeeList.stream()
										  .filter(employee->employee.getGender().equals("Male"))
										  .filter(emp->emp.getDepartment().equals("Sales And Marketing")).count();
		long countOfFemales = employeeList.stream()
				  .filter(employee->employee.getGender().equals("Female"))
				  .filter(emp->emp.getDepartment().equals("Sales And Marketing")).count();
		
		/** Another Way */
		Map<String,Long> countOfMaleAndFemaleInSalesAndMarketing = employeeList.stream().filter(emp->emp.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		
		System.out.println("Males In Sales And Marketing : "+countOfMales);
		System.out.println("Females In Sales And Marketing : "+countOfFemales);
		System.out.println("countOfMaleAndFemaleInSalesAndMarketing : "+countOfMaleAndFemaleInSalesAndMarketing);
		System.out.println("**************************************************");
	}



	private static void mostExperienceInOrganisation(List<Employee> employeeList) {
		
		System.out.println("Most Experience Person in the Organisation : ");
		Optional<Employee> employeeSortingbasedonJoining = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
		
		/** Another Way */
		Optional<Employee> employeeSortingbasedonJoining2 = employeeList.stream()
				.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
		/** Another Way */
		
		Optional<Employee> employeeSortingbasedonJoining3 = employeeList.stream()
				.sorted((e1,e2)->Integer.compare(e1.getYearOfJoining(), e2.getYearOfJoining())).findFirst();
		       
			employeeSortingbasedonJoining.ifPresent(employee -> System.out
				.println("EmployeeName : " + employee.getEmpName() + " Joining : " + employee.getYearOfJoining()));
			
			System.out.println("**************************************************");
	}



	private static void youngestEmployeeInProductionDepartment(List<Employee> employeeList)
	{
		System.out.println("Youngest Employee In Production  ");
		Employee youngestEmployeeInProduction =  
				employeeList.stream()
				.sorted(Comparator.comparing(Employee::getYearOfJoining).reversed())
				.filter(employee->employee.getDepartment().equals("Product Development")).findFirst().get();
		System.out.println("YoungestEmployeeInProduction : "+youngestEmployeeInProduction);
		System.out.println("**************************************************");
	}



	private static void averageSalaryOfEachDepartment(List<Employee> employeeList) {
		System.out.println("Average Salary Of Each Department In the Organisation");
		Map<String, Double> averageSalaryOfEachDepartment = employeeList.stream()
					.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(averageSalaryOfEachDepartment);
		System.out.println("**************************************************");

	}



	private static void countOfEmployeeInEachDepartment(List<Employee> employeeList) {
		System.out.println("Count Of Employee In Each Department In the Organisation");
		
		Map<String, Long> employeeCountFromEachDepartment = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		
		employeeCountFromEachDepartment.entrySet().forEach(entry -> System.out
				.println("Department : " + entry.getKey() + " Total EMployee : " + entry.getValue()));
		System.out.println("**************************************************");

	}



	private static void employeeJoineAfter2015(List<Employee> employeeList) {
		System.out.println("Employee Joined After 2015");
		List<Employee> employeeJoinedAfter2015 = employeeList.stream()
				.filter(employee -> employee.getYearOfJoining() > 2015).collect(Collectors.toList());
		System.out.println(employeeJoinedAfter2015);
		System.out.println("**************************************************");

	}



	private static void highestSalaryOfEmployee(List<Employee> employeeList) {
		System.out.println("Highest Salary Of Employee");
		Employee employeeWithHighestSalary = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().get();
		System.out.println("employeeWithHighestSalary : " + employeeWithHighestSalary);
		System.out.println("**************************************************");

	}



	private static void averageAgeOfMaleAndFemale(List<Employee> employeeList) {
		System.out.println("Average Age Of Male And Female");
		double averageAgeofMaleInTheOrganisation = employeeList.stream()
				.filter(employee -> employee.getGender().equals("Male")).mapToInt(Employee::getAge).average()
				.getAsDouble();
		double averageAgeofFemaleInTheOrganisation = employeeList.stream()
				.filter(employee -> employee.getGender().equals("Female")).mapToInt(Employee::getAge).average()
				.getAsDouble();

		System.out.println("averageAgeofFemaleInTheOrganisation : " + averageAgeofFemaleInTheOrganisation);
		System.out.println("averageAgeofMaleInTheOrganisation : " + averageAgeofMaleInTheOrganisation);

		/** Another way */
		Map<String, Double> averageAgeOfMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));

		System.out.println("averageAgeOfMaleAndFemale : " + averageAgeOfMaleAndFemale);
		System.out.println("**************************************************");

	}



	private static void nameOfAllTheDepartment(List<Employee> employeeList) {
		System.out.println("Name Of All The Department");
		List<String> allTheDepartmentInTheOrgansiation = employeeList.stream().map(Employee::getDepartment)
				.collect(Collectors.toList());
		System.out.println("allTheDepartmentInTheOrgansiation : " + allTheDepartmentInTheOrgansiation);
		System.out.println("**************************************************");

	}



	private static void countOfMaleAndFemale(List<Employee> employeeList) {
		System.out.println("Count of Total Male And Female");
		Map<String, Long> numberOfMaleAndFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		
		System.out.println("numberOfMaleAndFemale :"+numberOfMaleAndFemale);
		System.out.println("**************************************************");

	}


}
