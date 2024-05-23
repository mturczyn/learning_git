namespace UserManagement {
	public class User {
		private String firstName;
		private Integer age;
		
		public User(String firstName, Integer age) {
			this.age = age;
			this.firstName = firstName;
		}
		
		// Comment on method.
		public int getAge() {
			return age;
		}
		
		public Boolean isInterestedIn(Interest interest) {
			return interest.getName() == "beer";
		}
		
		public String sayHello() {
			return "Hello my friends!";
		}
		
		// Comment on method.
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
		
		public Boolean beLazy() {
			return true;
		}
	}
}