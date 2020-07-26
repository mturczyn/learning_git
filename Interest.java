namespace UserManagement {
	public class Interest {
		private String name;
		private String description;
		
		public Interest(String name, String description) {
			this.description = description;
			this.name = name;
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