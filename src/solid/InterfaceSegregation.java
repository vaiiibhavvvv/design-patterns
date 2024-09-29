package src.solid;

 interface Workable {

        void work();    
}

interface Eatable{
    void eat();
}

class Employee implements Workable,Eatable{

    @Override
    public void work(){
        System.out.println("employee is working");
    }

    @Override
    public void eat(){
        System.out.println("employee is eating");
    }

}

class Robot implements Workable{
    @Override
    public void work(){
        System.out.println("robot is working");
    }
}


public class InterfaceSegregation {
    
public static void main(String[] args){
    
    Employee employee = new Employee();
    Robot robot = new Robot();

    employee.work();
    robot.work();
}

}
