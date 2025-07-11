package application;

import java.util.Date;
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
		System.out.println();

		System.out.println("====  test4: seller insert ====");
		System.out.println("Inserindo 1 ");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("====  test5: seller Update ====");
		seller = sellerDao.findById(1);
		seller.setName("Marina Sivero");
		sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("====  test6: seller Delete ====");
		System.out.println("Entre com um ID para deletar");
		int delId = sc.nextInt();
		sellerDao.deleteById(delId);
		System.out.println("Delete Completed");

		sc.close();
	}

}
