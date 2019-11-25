package com.pmb.action.chain;

public class LeaderC implements Leader{
	private String name;
	private Leader nextLeader;
	
	public LeaderC(String name, Leader nextLeader) {
		super();
		this.name = name;
		this.nextLeader = nextLeader;
	}
	@Override
	public void handlerReq(LeaveRequest req) {
		if(req.getDays() < 30){
			System.out.println("批准："+req);
			System.out.println(this);
		}else{
			System.out.println("不批准："+req);
			System.out.println(this);
		}
	}
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader getNextLeader() {
		return nextLeader;
	}

	@Override
	public String toString() {
		return "LeaderC [name=" + name + "]";
	}
	
}
