namespace UserManagement {
	public class User {
		private String firstName;
		private Integer age;
		
		public User(String firstName, Integer age) {
			this.age = age;
			this.firstName = firstName;
		}
		
		public int getAge() {
			return age;
		}
		
		public Boolean isInterestedIn(Interest interest) {
			return interest.getName() == "beer";
		}
		
		@Override
		public String toString() {
			return "My name is " + firstName + " and my age is " + age;
		}
	}
}