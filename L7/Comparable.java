//Employee.java
package interfaces;

public class Employee implements Comparable<Employee> //Employee 객체를 매개변수로 받는 Comparable 인터페이스를 구현
{
   private String name;
   private double salary;

   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

 //이부분을 월급이 아닌 이름으로 비교하도록 변경함!!
   @Override
   public int compareTo(Employee other) {
	   return this.name.compareTo(other.getName()); 
       //여기서 사용하는 compareTo는 String을 매개변수로받는 다른 메소드임
   }
}