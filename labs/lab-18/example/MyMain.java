public class MyMain {
	public static void main(String args[]) {
		ArrayList<Person> people = new ArrayList<Person>();
		for(int x = 0; x < 150; x++) {
			people.add(new Person((int) (Math.random() * 80), (Math.random() > .5)? Gender.MALE: Gender.FEMALE));
		}
		tester(people, new Predicate<Person>() { // wihtout lambdas
			public boolean test(Person p) {
				return p.getGender() == Gender.MALE
		        && p.getAge() >= 18
		        && p.getAge() <= 25;
		     }
		   });

		tester(people, // with lambdas
		(Person p) -> p.getGender() == Gender.MALE
		        && p.getAge() >= 18
		        && p.getAge() <= 25);


	}
	public static void tester(List<Person> people, Predicate<Person>test) {
	for(Person p : people) {
		if(test.test(p)) {
			System.out.println("This passed the test " + p);
		}else {
			System.out.println("This did not pass the test " + p);
		}
	}
}

}
