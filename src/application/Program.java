package application;

import java.util.List;
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
		int id = sc.nextInt();
		System.out.println("ID localizado: ");
		Seller seller = sellerDao.findById(id);
		System.out.println(seller);		
		System.out.println();
		
		System.out.println("====  test2: seller findByDepartment ====");
		System.out.print("Digite um Departamento: ");
		int dep = sc.nextInt();
		System.out.println("Departamento localizado: ");
		Department department = new Department(dep, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("====  test3: seller findAll ====");
		System.out.println("Todos os Departamentos");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

	}

}
