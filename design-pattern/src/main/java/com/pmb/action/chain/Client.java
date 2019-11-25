package com.pmb.action.chain;

public class Client {
	public static void main(String[] args) {

		LeaderA a = new LeaderA("LeaderA", new LeaderB("LeaderB", new LeaderC(
				"LeaderC", null)));

		LeaveRequest l1 = new LeaveRequest("zhangsan", 2, "reason111");
		LeaveRequest l2 = new LeaveRequest("zhangsan", 5, "reason111");
		LeaveRequest l3 = new LeaveRequest("zhangsan", 20, "reason111");
		LeaveRequest l4 = new LeaveRequest("zhangsan", 50, "reason111");
		
		a.handlerReq(l1);
		a.handlerReq(l2);
		a.handlerReq(l3);
		a.handlerReq(l4);
		
	}
}
