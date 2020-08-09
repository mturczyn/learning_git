namespace UserManagement {
	public class Interest {
		private String name;
		private String description;
		private User user;
		
		public Interest(String name, String description, User user) {
			this.description = description;
			this.name = name;
			this.user = user;
		}
		
		public String getName() {
			return name;
		}
		
		
		
		@Override
		public String toString() {
			return "Interest is " + name + ": " + description;
		}
	}
}