public class Person {
	private int age;
	private Gender gender;
	public Person(int age, Gender gender) {
		this.age = age;
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public Gender getGender() {
		return gender;
	}
	@Override
	public String toString() {
		return "Age: " + age + " Gender: " + gender;
	}
}
