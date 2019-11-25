package com.pmb.action.chain;

public class LeaveRequest {
	
	String name;
	int days;
	String reason;
	public LeaveRequest(String name, int days, String reason) {
		super();
		this.name = name;
		this.days = days;
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "LeaveRequest [name=" + name + ", days=" + days + ", reason="
				+ reason + "]";
	}
	
}
