package application;

import java.util.Date;
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
		
		Department dep = new Department(3, null);
		
		List<Seller> lista = sellerDao.findByDepartment(dep);
		
		System.out.println("========== TESTE 2 =========");
		lista.forEach(System.out::println);
		
		List<Seller> listaAll = sellerDao.findAll();
		System.out.println("========= TESTE 3 ========");
		listaAll.forEach(System.out::println);
		
		System.out.println("========== TESTE 4 =======");
		Seller newSeller = new Seller(null, "Pedro Nelso", "pedro@gmail.com", new Date(), 3200.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Feito! Id inserido: " + newSeller.getId());
		
		System.out.println("========== TESTE 5 ========");
		seller = sellerDao.findById(7);
		seller.setName("Juscier Rodrigues");
		sellerDao.update(seller);
		System.out.println("ATUALIZACAO FEITA!");
	}
}
