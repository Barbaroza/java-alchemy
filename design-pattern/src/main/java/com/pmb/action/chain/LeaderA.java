package com.pmb.action.chain;

public class LeaderA implements Leader{
	private String name;
	private Leader nextLeader;
	
	public LeaderA(String name, Leader nextLeader) {
		super();
		this.name = name;
		this.nextLeader = nextLeader;
	}
	@Override
	public void handlerReq(LeaveRequest req) {
		if(req.getDays() < 3){
			System.out.println("批准："+req);
			System.out.println(this);
		}else{
			if(this.nextLeader != null){
				nextLeader.handlerReq(req);
			}
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
		return "LeaderA [name=" + name + "]";
	}
	
}
