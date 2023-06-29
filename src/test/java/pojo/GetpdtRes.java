package pojo;

import java.util.List;

public class GetpdtRes {
	String total;
	String limit;
	String skip;
	List<GetDataResp> getpdtRes;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getSkip() {
		return skip;
	}
	public void setSkip(String skip) {
		this.skip = skip;
	}
	public List<GetDataResp> getGetpdtRes() {
		return getpdtRes;
	}
	public void setGetpdtRes(List<GetDataResp> getpdtRes) {
		this.getpdtRes = getpdtRes;
	}

}
