import java.io.Console;
import java.util.List;

import DAO.FoodDAO;
import pojo.Food;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Food> fList = FoodDAO.getAllFoods();
		System.out.print("Tong so luong cac mon an: "+ fList.size());
	}

}
