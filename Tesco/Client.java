package Tesco;

import java.util.*;

public class Client {
    public static void main(String[] args){
        System.out.println("Hello world!");
        System.out.println(1);
    }
}

class Employee{
    String name;
    int age;
    double salary;

    Employee(String _name, int _age, double _salary){
        name=_name;
        age=_age;
        salary=_salary;
    }
    /*static List <Employee> sortEmployees(List <Employee> employeeList){

        Arrays.sort(employeeList);
    }*/

    //Default capacity-16
    public static final int  DEFAULT_SIZE=16;

   /*hashmapPut(LinkList root, Object[] bucketArr, Object key, Object val) {
       int pos = hashFunction(key) % bucketArr.length;
       for (int i = 0; i < bucketArr.length; i++) {
           if (i == pos) {
               if (root != null) {
                    int linkedListSize= checkLinkedListSize();//placeholder method
                    if(linkedListSize>=DEFAULT_SIZE)
                    {
                        Tree node= createBTree();
                        coptyLinkedListDatatoBTree(root);
                        node.add(val);
                    }else {
                        root = root.next;
                        root.data = val;
                    }
               } else {
                   LinkList list = new LinkList(root.data);
               }
           }
       }
   }
       static Integer hashFunction (Object key){
           return (Integer) key ^ 2;
       }

       public class LinkList{
       Object data;
        LinkList next;
        LinkList(Object data){
            this.data=data;
        }
    }*/
    public static void main(String []args){
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("shreya",25, 1200.00));
        employeeList.add(new Employee("Amit",22, 1500.00));
        employeeList.add(new Employee("Ankur",26, 1500.00));
        //sortEmployees(employeeList);
        int []bucketArr=new int[10];
        Map<Integer,Integer> hh=new HashMap<>();
        hh.put(null, 5);

    }
}
