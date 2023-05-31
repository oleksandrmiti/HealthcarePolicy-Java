
public class SkillsDemo2Main {

	public static void main(String[] args) {
		Policy policy = new Policy();
		
		policy.readAge();
		
		if (policy.getAge()>18) {
			policy.readName();
			
		}
		//Need an if here?
	}

}
