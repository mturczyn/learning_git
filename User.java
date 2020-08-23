namespace UserManagement {
	public class User {
		private String firstName;
		private Integer age;
		
		// Special constructor for a class. Use at your own risk.
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
		
		// Comment on method (branchB)
		public String think() {
			throw new Exception("Users don't think");
		}
		
		// Comment on method
		public String thinkOutOfTheBox() {
			throw new Exception("Users don't think");
		}
		
		// Comment on method
		public Boolean doSomeWork() {
			return false;
		}
		
		// Comment on method
		public Boolean beLazy() {
			return true;
		}
	}
}