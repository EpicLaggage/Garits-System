package Processing;

import java.util.Date;
import Account.*;
import StockControl.*;

public class Job {

	private int num;
	private String status;
	private String type;
	private Mechanic mechanic;
	private Part[] parts;
	private String[] description;
	private Date estimate_duration;
	private Date duration;
	private Date date_start;
	private Date date_end;
	private float total_cost;

	/**
	 * 
	 * @param type
	 * @param mech
	 * @param desc
	 */
	public Job Job(String type, Mechanic mech, String desc) {
		// TODO - implement Job.Job
		throw new UnsupportedOperationException();
	}

	public int getNum() {
		return this.num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Mechanic getMechanic() {
		return this.mechanic;
	}

	/**
	 * 
	 * @param mechanic
	 */
	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Part[] getParts() {
		return this.parts;
	}

	/**
	 * 
	 * @param parts
	 */
	public void setParts(Part[] parts) {
		this.parts = parts;
	}

	public String[] getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String[] description) {
		this.description = description;
	}

	public Date getEstimate_duration() {
		return this.estimate_duration;
	}

	/**
	 * 
	 * @param estimate_duration
	 */
	public void setEstimate_duration(Date estimate_duration) {
		this.estimate_duration = estimate_duration;
	}

	public Date getDuration() {
		return this.duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Date getDate_start() {
		return this.date_start;
	}

	/**
	 * 
	 * @param date_start
	 */
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return this.date_end;
	}

	/**
	 * 
	 * @param date_end
	 */
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public float getTotal_cost() {
		return this.total_cost;
	}

	/**
	 * 
	 * @param total_cost
	 */
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}

	public void CreateJobSheet() {
		// TODO - implement Job.CreateJobSheet
		throw new UnsupportedOperationException();
	}

}