package entities;

public class Employee {
	
	private String nome;
	private Integer hours;
	private Double valueperHour;
	

	
	public Employee() {
	}

	public Employee(String nome, Integer hours, Double valueperHour) {
		this.nome = nome;
		this.hours = hours;
		this.valueperHour = valueperHour;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValueperHour() {
		return valueperHour;
	}

	public void setValueperHour(Double valueperHour) {
		this.valueperHour = valueperHour;
	}
	
	public double payment() {
		return hours * valueperHour;
	}


}
