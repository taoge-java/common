package dunamic.service;


public class UserProxy implements UserService{

	private UserServiceImpl userService;
	
	public UserProxy(UserServiceImpl userService){
		this.userService=userService;
	}
	
	@Override
	public void add() {
		log("add");
		userService.add();
	}

	@Override
	public void delete() {
		log("delete");
		userService.delete();
	}

	@Override
	public void update() {
		log("update");
		userService.update();;
	}

	@Override
	public void find() {
		log("find");
		userService.find();
	}
	
	public void log(String meothName){
		System.out.println("执行"+meothName+"方法");
	}
}
