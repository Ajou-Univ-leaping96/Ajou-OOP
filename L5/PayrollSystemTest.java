// PayrollSystemTest.java

public class PayrollSystemTest 
{
   public static void main(String[] args) 
   {
      // create subclass objects
      SalariedEmployee salariedEmployee = 
         new SalariedEmployee("John", "111-11-1111", 800.00);
      HourlyEmployee hourlyEmployee = 
         new HourlyEmployee("Karen", "222-22-2222", 16.75, 40);
      CommissionEmployee commissionEmployee = 
         new CommissionEmployee(
         "Sue", "333-33-3333", 10000, .06);
      Manager manager = 
         new Manager("Bob", "444-44-4444", 2500.0);

      System.out.println("Employees processed individually:");
      
      System.out.printf("%n%s %s: $%,.2f%n%n", 
         salariedEmployee.getName(), "earned", salariedEmployee.getEarnings());
      System.out.printf("%s %s: $%,.2f%n%n",
         hourlyEmployee.getName(), "earned", hourlyEmployee.getEarnings());
      System.out.printf("%s %s: $%,.2f%n%n",
         commissionEmployee.getName(), "earned", commissionEmployee.getEarnings());
      System.out.printf("%s %s: $%,.2f%n%n", 
         manager.getName(), 
         "earned", manager.getEarnings());

      // create four-element Employee array
      Employee[] employees = new Employee[4]; 

      // initialize array with Employees
      employees[0] = salariedEmployee;
      employees[1] = hourlyEmployee;
      employees[2] = commissionEmployee; 
      employees[3] = manager;

      System.out.printf("Employees processed polymorphically:%n%n");
      
      // generically process each element in array employees
      for (Employee currentEmployee : employees) 
      {

         // determine whether element is a Manager
         if (currentEmployee instanceof Manager) 
         {
            // downcast Employee reference to Manager reference
            Manager employee =  (Manager) currentEmployee;
            employee.setBonus(100.0);
         } 

         System.out.printf("%s earned $%,.2f%n%n", currentEmployee.getName(),
             currentEmployee.getEarnings());
      } 
	  
	          System.out.printf("%s %s: $%,.2f%n%n", 
         manager.getName(), 
         "earned", employees[3].getEarnings());
  
Manager m = (Manager) employees[3];
  m.setBonus(1000.0);
        System.out.printf("%s %s: $%,.2f%n%n", 
         manager.getName(), 
         "earned", employees[3].getEarnings());
  
   } // end main
} // end class PayrollSystemTest