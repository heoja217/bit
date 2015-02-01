package carrot.domain;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int no;
	protected int supplierNo;
	
	protected String clientCorName;
	protected String clientName;
	protected String clientPassword;
	protected String clientTel;
	protected String clientMail;
	protected String clientPostNo;
	protected String clientAddress;
	protected String clientAddressDet;
	protected String clientMemo;
	
	protected String mLevel;
	protected Date mDate;
	
	protected int orderMonthTotal;

	@Override
	public String toString() {
		return "Client [no=" + no + ", supplierNo=" + supplierNo
				+ ", clientCorName=" + clientCorName + ", clientName="
				+ clientName + ", clientPassword=" + clientPassword
				+ ", clientTel=" + clientTel + ", clientMail=" + clientMail
				+ ", clientPostNo=" + clientPostNo + ", clientAddress="
				+ clientAddress + ", clientAddressDet=" + clientAddressDet
				+ ", clientMemo=" + clientMemo + ", mLevel=" + mLevel
				+ ", mDate=" + mDate + ", orderMonthTotal=" + orderMonthTotal
				+ "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(int supplierNo) {
		this.supplierNo = supplierNo;
	}

	public String getClientCorName() {
		return clientCorName;
	}

	public void setClientCorName(String clientCorName) {
		this.clientCorName = clientCorName;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientPassword() {
		return clientPassword;
	}

	public void setClientPassword(String clientPassword) {
		this.clientPassword = clientPassword;
	}

	public String getClientTel() {
		return clientTel;
	}

	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
	}

	public String getClientMail() {
		return clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public String getClientPostNo() {
		return clientPostNo;
	}

	public void setClientPostNo(String clientPostNo) {
		this.clientPostNo = clientPostNo;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientAddressDet() {
		return clientAddressDet;
	}

	public void setClientAddressDet(String clientAddressDet) {
		this.clientAddressDet = clientAddressDet;
	}

	public String getClientMemo() {
		return clientMemo;
	}

	public void setClientMemo(String clientMemo) {
		this.clientMemo = clientMemo;
	}

	public String getmLevel() {
		return mLevel;
	}

	public void setmLevel(String mLevel) {
		this.mLevel = mLevel;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	public int getOrderMonthTotal() {
		return orderMonthTotal;
	}

	public void setOrderMonthTotal(int orderMonthTotal) {
		this.orderMonthTotal = orderMonthTotal;
	}
	
}