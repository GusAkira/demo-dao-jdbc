package application;

import java.util.Date;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("====  test1: seller findById ====");
		
		System.out.print("Digite um ID: ");
		int i = sc.nextInt();

		System.out.print("ID localizado: ");
		Seller seller = sellerDao.findById(i);

		System.out.println(seller);

	}

}
