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
		
		public String sayHello() {
			return "Hello my friends!";
		}
		
		public String think() {
			throw new Exception("Users don't think");
		}
		
		// comment
		public String thinkOutOfTheBox() {
			throw new Exception("Users don't think");
		}
		
		// comment
		public Boolean doSomeWork() {
			return false;
		}
		
		// comment
		public Boolean beLazy() {
			return true;
		}
	}
}