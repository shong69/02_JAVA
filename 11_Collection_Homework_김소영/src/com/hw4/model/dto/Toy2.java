package com.hw4.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy2 {
	public class Toy {

		private String name; //이름
		private int properAge; //사용 가능 연령
		private int price; //가격
		private String color; //색상
		private String manufactDate; //제조일(문자열로 표현)
		private  Set<String> element; //재료(중복되지 않는 값으로 저장)
		
		public Toy() {
			
		}
		public Toy(String name, int properAge, int price, String color, String manufactDate, Set<String> element) {
			super();
			this.name = name;
			this.properAge = properAge;
			this.price = price;
			this.color = color;
			this.manufactDate = manufactDate;
			this.element = element;
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getProperAge() {
			return properAge;
		}
		public void setProperAge(int properAge) {
			this.properAge = properAge;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getManufactDate() {
			return manufactDate;
		}
		public void setManufactDate(String manufactDate) {
			this.manufactDate = manufactDate;
		}
		public Set<String> getElement() {
			return element;
		}
		public void setElement(Set<String> element) {
			this.element = element;
		}
		
		
		
		//materials 안에 있는 모든 재료를 문자열 형태로 만들어 반환하는 메서드
		public String getMaterialsAsString() {
			StringBuilder sb = new StringBuilder();
			
			for(String material : element) {
				sb.append(material).append(", ");
			}
			
			//마지막 쉼표와 공백 제거하기
			if(sb.length() > 0) {
				sb.setLength(sb.length()-2);
			}
			return sb.toString();
		}
		
		
		
		@Override
		public String toString() {
			return "이름 : " + name + " / 가격 : " + price + " / 색상 : " + color
					+ " / 사용가능연령 : "+properAge +" / 제조년월일 : " + manufactDate + " / 재료 : " + getMaterialsAsString();
		}
		
		//HashSet 사용하기 위해 hashCode()와 equals() 오버라이딩 하기
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(color, element, manufactDate, name, price, properAge);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Toy other = (Toy) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(color, other.color) && Objects.equals(element, other.element)
					&& Objects.equals(manufactDate, other.manufactDate) && Objects.equals(name, other.name)
					&& price == other.price && properAge == other.properAge;
		}
		private Toy2 getEnclosingInstance() {
			return Toy2.this;
		}
		
		
		
	}
		
		
}

