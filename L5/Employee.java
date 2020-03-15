// Employee.java
// Employee abstract superclass.

public abstract class Employee 
{
   private final String name;
   private final String ssn;

   // constructor
   public Employee(String name,String ssn)
   {
      this.name = name;                                    
      this.ssn = ssn;         
   } 

   // return name
   public String getName()
   {
      return name;
   } 

   // return social security number
   public String getSsn()
   {
      return ssn;
   } 

   // abstract method must be overridden by concrete subclasses
   public abstract double getEarnings(); // no implementation here

} // end abstract class Employee