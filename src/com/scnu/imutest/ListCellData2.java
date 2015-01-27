package com.scnu.imutest;

import android.os.Parcel;
import android.os.Parcelable;


public class ListCellData2 implements Parcelable{

	public ListCellData2(String name, String position, String department,
			String club) {
		super();
		this.name = name;
		this.position = position;
		this.department = department;
		this.club = club;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	
	@Override
	public String toString() {
		return department + " - " + name;
	}

	private String name=" ";
	private String position=" ";
	private String department=" ";
	private String club=" ";
	public boolean isCheck = false; 

	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(position);
		dest.writeString(department);
		dest.writeString(club);
	}
	
	public static final Parcelable.Creator<ListCellData2> CREATOR = new Parcelable.Creator<ListCellData2>() {

		@Override
		public ListCellData2 createFromParcel(Parcel source) {			
			return new ListCellData2(source);
		}

		@Override
		public ListCellData2[] newArray(int size) {
			return new ListCellData2[size];
		}
	};
	
	public ListCellData2(Parcel source){
		name = source.readString();
		position = source.readString();
		department = source.readString();
		club = source.readString();
	}
}

