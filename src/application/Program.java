package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(6);
		System.out.println("========= TESTE 1 ==========");
		System.out.println(seller);
		
		Department dep = new Department(2, null);
		
		List<Seller> lista = sellerDao.findByDepartment(dep);
		
		System.out.println("========== TESTE 2 =========");
		lista.forEach(System.out::println);
		
		List<Seller> listaAll = sellerDao.findAll();
		System.out.println("========= TESTE 3 ========");
		listaAll.forEach(System.out::println);
	}
}
