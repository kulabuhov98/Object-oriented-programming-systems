/**
 * Вариант: 1. Номер зачетной книжки: 21-677.
 *
 * Автор: Кулабухов Александр Максимович, ЗИТ-21
 * Дата: 22.12.2022
 *
 */

/**
 * Пакет organization
 */
package organization;

import java.util.Arrays;
import java.util.Comparator;

public class Department {
	/**
	 * 	Разные подразделения имеют разные имена
	 */
	private String title;
	
	/**
	 * Класс хранит явным образом массив своих работников
	 */
	private Employee[] employees;
	
	/**
	 * Конструктор может принимать имя подразделения 
	 * (в этом случае количество работников = 0)
	 */
	public Department(String title) {
		this.title = title;
		this.employees = new Employee[0];
	}
	
	/**
	 * Конструктор может принимать массив работников
	 */
	public Department(Employee[] employees) {
		this.employees = employees;
	}
	
	/**
	 * Метод получения имени подразделения
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Метод изменения имени подразделения
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Метод, возвращающий общее число работников подразделения
	 */
	public int getEmployeesCount() {
		return this.employees.length;
	}
	
	/**
	 * Метод, возвращающий суммарную зарплату всех работников, относящихся к данному подразделению
	 */
	public double getEmployeesSalary() {	
		double employeesSalary = 0;
		for (Employee employee : this.employees) {
			employeesSalary += employee.getSalary();
		}
		return employeesSalary;
	}
	
	/**
	 * Метод, возвращающий ссылку на работника по фамилии и имени
	 */
	public Employee getEployeeByInitials(String surname, String name) {
		for (Employee employee : this.employees) {
			if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {	
				return employee;
			}	
		}	
		return null;
	}
	
	/**
	 * Метод увольнения работника 
	 * (принимает в качестве входных параметров фамилию, имя, должность работника, 
	 * которого нужно удалить, удаляет соответствующий этим данным элемент из массива работников)
	 */
	public void fireEmployee(String surname, String name, String position) {	
		for (int i = 0; i < this.employees.length; i++) {	
			Employee employee = this.employees[i];
            		if (employee.getName().equals(name) && employee.getSurname().equals(surname)
                    		&& employee.getPosition().equals(position)) {
				Employee[] newEmployees = new Employee[this.employees.length - 1];
				System.arraycopy(this.employees, 0, newEmployees, 0, i);
				if (this.employees.length != i) {
					System.arraycopy(this.employees, i + 1, newEmployees, i,
						this.employees.length - i - 1);
				}
				this.employees = newEmployees;
				return;
            		}
        	}
    	}
	
	/**
	 * Метод приема работника на работу 
	 * (принимает в качестве входных параметров ссылку  на экземпляр класса Employee, 
	 * расширяет массив работников путем добавления нового элемента в конец массива)
	 */
	 public void hireEmployee(Employee newEmployee) {
		 Employee[] newEmployees = new Employee[this.employees.length + 1];
		 System.arraycopy(this.employees, 0, newEmployees, 0, this.employees.length);
		 newEmployees[this.employees.length] = newEmployee;

		 this.employees = newEmployees;
	 }
	
	/**
	 * Метод, возвращающий массив работников отдела
	 */
    	public Employee[] getEmployees() {
        	Employee[] resultEmployees = new Employee[this.employees.length];
        	System.arraycopy(this.employees, 0, resultEmployees, 0, this.employees.length);
        
        	return resultEmployees;
    	}
	
	/**
	 * Метод, возвращающий массив работников отдела, отсортированный по фамилиям 
	 * (и если одинаковые фамилии – то по именам)
	 */
	public Employee[] getSortedEmployees() {
		Employee[] sortedEmployees = this.getEmployees();
		Arrays.sort(sortedEmployees, new Comparator<Employee>() {
		    @Override
		    public int compare(Employee employeeX, Employee employeeY) {
			if (employeeX.getSurname().equals(employeeY.getSurname())) {
			    return employeeX.getName().compareTo(employeeY.getName());
			}
			return employeeX.getSurname().compareTo(employeeY.getSurname());
		    }
		});
		return sortedEmployees;
	    }
}
