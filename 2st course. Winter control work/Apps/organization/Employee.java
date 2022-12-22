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

/**
 * Публичный класс Employee – работник некоторой организации
 */
public class Employee {
	/**
	 * Стандартное значение должности и жалования
	 */
	public static final String DEFAULT_POSITION = "Инженер";
	public static final double DEFAULT_SALARY = 30000.0;
	
	/**
	 * Каждый работник занимает определенную должность
	 */
	private String position;
	
	/**
	 * Каждый работник получает определенное жалование
	 */
	private double salary;
	
	/**
	 * Каждый работник характеризуется именем
	 */
	private String name;
	
	/**
	 * Каждый работник характеризуется фамилией
	 */
	private String surname;
	
	/**
     * Конструктор может принимать имя и фамилию
     */
    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;

        this.setPosition(Employee.DEFAULT_POSITION);
        this.setSalary(Employee.DEFAULT_SALARY);
    }
	
    /**
     * Конструктор может принимать имя, фамилию, должность, жалование
     */
    public Employee(String name, String surname, String position, Double salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.salary = salary;
    }
    
    /**
     * Метод получения имени
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Метод изменения имени
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * Метод получения фамилии
     */
    public String getSurname() {
    	return surname;
    }
    
    /**
     * Метод изменения фамилии
     */
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    /**
     * Метод получения должности
     */
    public String getPosition() {
    	return position;
    }
    
    /**
     * Метод изменения должности
     */
    public void setPosition(String position) {
    	this.position = position;
    }
    
    /**
     * Метод получения жалования
     */
    public double getSalary() {
    	return salary;
    }
    
    /**
     * Метод изменения жалования
     */
    public void setSalary(Double salary) {
    	this.salary = salary;
    }
}