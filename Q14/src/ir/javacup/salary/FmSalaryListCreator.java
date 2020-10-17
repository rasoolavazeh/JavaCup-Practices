package ir.javacup.salary;

public class FmSalaryListCreator extends SalaryListCreator{
    public FmSalaryListCreator(Encoder encoder) {
        super(encoder);
    }

    @Override
    protected String doCreate(Employee[] employees) {
        String info = "";
        boolean flag = false;
        for(Employee employee : employees) {
            if (!flag) {
                info += addZeroPrefix(String.valueOf(employee.getSalary()), 10)
                        + getItemSeparator()
                        + addZeroPrefix(String.valueOf(employee.getCode()), 10);
                flag = true;
            } else {
                info += "\n"
                        + addZeroPrefix(String.valueOf(employee.getSalary()), 10)
                        + getItemSeparator()
                        + addZeroPrefix(String.valueOf(employee.getCode()), 10);
            }
        }

        return info;
    }
}
