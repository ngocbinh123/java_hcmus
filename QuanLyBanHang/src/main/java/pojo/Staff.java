/**
 * 
 */
package pojo;

import java.sql.Date;

/**
 * @author nguyenngocbinh
 *
 */
public class Staff extends PojoBase { 
	private String image;
	private Boolean sex = true; // : man | false: women
	private Date birthday;
	private Date startWorking;
	private int baseSalary;
	private String note;
	//private int id_staffType; //int not null references STAFFTYPE(id),  
	private int id_workingStatus;// int not null references WORKINGSTATUS(id)
	private StaffType staffType;
	private WorkingStatus workingStatus;
	/**
	 * 
	 */
	public Staff() {
		// TODO Auto-generated constructor stub
	}

}
