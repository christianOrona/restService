/**
 * 
 */
package com.christianorona.restService;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Sarge
 *
 */
@XmlRootElement
public class Toy {

	private String toy_id;
	private String toy_name;
	private String toy_photo_path;
	private String toy_desc;
	
	/**
	 * 
	 */
	public Toy() {
		// TODO Auto-generated constructor stub
	}

	public String getToy_id() {
		return toy_id;
	}

	public void setToy_id(String toy_id) {
		this.toy_id = toy_id;
	}

	public String getToy_name() {
		return toy_name;
	}

	public void setToy_name(String toy_name) {
		this.toy_name = toy_name;
	}

	public String getToy_photo_path() {
		return toy_photo_path;
	}

	public void setToy_photo_path(String toy_photo_path) {
		this.toy_photo_path = toy_photo_path;
	}

	public String getToy_desc() {
		return toy_desc;
	}

	public void setToy_desc(String toy_desc) {
		this.toy_desc = toy_desc;
	}

	@Override
	public String toString() {
		return "Toy [toy_id=" + toy_id + ", toy_name=" + toy_name + ", toy_photo_path=" + toy_photo_path + ", toy_desc="
				+ toy_desc + "]";
	}

	
	
}
