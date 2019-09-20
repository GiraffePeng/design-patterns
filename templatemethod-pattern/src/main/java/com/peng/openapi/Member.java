package com.peng.openapi;

import java.io.Serializable;

public class Member implements Serializable{

	private Long id;
	
	private String name;
	
	private String phone;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Member(Long id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}
	
	
	static class MemberBuilder{
		
		private Long id;
		
		private String name;
		
		private String phone;
		
		public MemberBuilder id(Long id) {
			this.id = id;
			return this;
		}
		
		public MemberBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public MemberBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public Member build() {
			return new Member(id, name, phone);
		}
	}
	
	public static MemberBuilder builder() {
		return new MemberBuilder();
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
