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
		
		public String think() {
			throw new Exception("Users don't think");
		}
		
		public String thinkOutOfTheBox() {
			throw new Exception("Users don't think");
		}
		
		public Boolean doSomeWork() {
			return false;
		}
		
		public Boolean beLazy() {
			return true;
		}
		// comment: branch comments, try rebasing...
		// comment: master comment
		// comment : another master comment
	}
}