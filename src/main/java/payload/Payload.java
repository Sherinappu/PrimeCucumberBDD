package payload;

import pojoData.Addpdtreq;

public class Payload {
	
	public Addpdtreq Addpdtpayload() {
	
	Addpdtreq addpdtreq = new Addpdtreq();
    addpdtreq.setDescription("laptop");
	addpdtreq.setImage("www.file.com");
	addpdtreq.setManufacturer("HP");
	addpdtreq.setModel("2021-1/19");
	addpdtreq.setName("HP lap");
	addpdtreq.setPrice(35000);
	addpdtreq.setShipping(500);
	addpdtreq.setType("computer");
	addpdtreq.setUrl("www.hp.com");
	addpdtreq.setUpc("ax123");
	
	return addpdtreq;
	}


}
