package ir.javacup.salary;

public class HrmSalaryListCreator extends SalaryListCreator{
    public HrmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        String info = "";
        boolean flag = false;
        for (Employee employee : employees) {
            if (!flag) {
                info += addZeroPrefix(String.valueOf(employee.getCode()), 8)
                        + getItemSeparator()
                        + addZeroPrefix(String.valueOf(employee.getSalary()), 10);

                flag = true;
            } else {
                info += "\n"
                        + addZeroPrefix(String.valueOf(employee.getCode()), 8)
                        + getItemSeparator()
                        + addZeroPrefix(String.valueOf(employee.getSalary()), 10);

            }
        }

        return info;
    }

//    public static void main(String[] args) {
//        System.out.println(addZeroPrefix("1234", 8));
//        System.out.println(addZeroPrefix("0234", 8));
//        System.out.println(addZeroPrefix("12345678", 8));
//
//        Encoder encoder = new Encoder() {
//            @Override
//            public String encode(String str) {
//                return super.encode(str);
//            }
//        };
//        HrmSalaryListCreator creator = new HrmSalaryListCreator(encoder);
//        Employee[] employees = new Employee[2];
//        employees[0] = new Employee("71235", 1_500_000);
//        employees[1] = new Employee("03451", 3_200_000);
//        System.out.println(creator.doCreate(employees));
//
////        FmSalaryListCreator creator = new FmSalaryListCreator(encoder);
////        Employee[] employees = new Employee[2];
////        employees[0] = new Employee("31235", 2_000_000);
////        employees[1] = new Employee("00531", 1_200_000);
////        System.out.println(creator.doCreate(employees));;
//    }
}
