package test;
import views.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import dao.*;
import model.*;

public class Test {

	public static void main(String[] args) {
		/*
		DAO<Article> articleDao =  new ArticleDAO(BDDConnexion.getInstance());
		//Article delArticle = new Article(120);
		//boolean articletmp = articleDao.delete(delArticle);
		//Article article1 = new Article(120,"Pillar",true,10000,"Un tournevis ");
		//Article article2;
		//article2 = articleDao.find(120);
		//System.out.println(article2.getName() + article2.getDescription());
/* 
		ArrayList<Article> articles;
		articles = articleDao.findAll();
		
		Iterator cpt = articles.iterator();
		while (cpt.hasNext()) {
			
			System.out.println(((Article)cpt.next()).getId());
		}
		
		
		//boolean articletmp = articleDao.update(article1);
		//System.out.println(articletmp);
*/
		/*
		DAO<Client> clientDao = new ClientDAO(BDDConnexion.getInstance());
		Client client1 = new Client(5,"rwegrdgdshtsh","htrdhtrdhtrdhtrd","rue du tour","Belgium","7396","021885185151511125181","Stuggart",true);
		Client client2 = new Client(2);
		//System.out.println(clientDao.create(client1));
		//clientDao.delete(client2);
		//clientDao.update(client1);
		ArrayList<Client> clients;
		clients = clientDao.findAll();
		Iterator<Client> cpt = clients.iterator();
		while (cpt.hasNext()) {
			 Client clientTmp = cpt.next();
			System.out.println(clientTmp.getId() + " nom :  " + clientTmp.getLastname());
		};
		Client clientTmp2;
		clientTmp2 = clientDao.find(2);
		System.out.println(clientTmp2.getFirstname());
		*
		DAO<HistoryArticle> histoDao = new HistoryArticleDAO(BDDConnexion.getInstance());
		String date1 ;
		date1 = "2020-03-01";
		HistoryArticle histo2 = new HistoryArticle(1,1,date1,100.00,1);
		HistoryArticle histo1 = new HistoryArticle(1,date1,42.50,1);
		HistoryArticle histo3 = new HistoryArticle();
		ArrayList <HistoryArticle> histos;
		//histoDao.create(histo1);
		//histoDao.update(histo2);
	//histo3 = histoDao.find(666);
		//System.out.println(histo3.getId() + " " + histo3.getPrice());
		/*
		histos = histoDao.findAll();
		Iterator<HistoryArticle> cpt = histos.iterator();
		while (cpt.hasNext()) {
			HistoryArticle artTmp = cpt.next();
			System.out.println(artTmp.getId());
		}*/
		/*
		DAO<Invoice> invoiceDao = new InvoiceDAO(BDDConnexion.getInstance());
		Invoice inv1 = new Invoice(10,123,"2020-03-19",2,1);
		Invoice inv2 = new Invoice(1,255888,"2020-03-19",3,3);
		Invoice inv3 = new Invoice(1);
		Invoice inv4 = new Invoice();
		ArrayList<Invoice> invoices;
		invoiceDao.create(inv1);
		//invoiceDao.update(inv2);
		//invoiceDao.delete(inv3);
		inv4 = invoiceDao.find(5);
		System.out.println(inv4.getId());
		invoices= invoiceDao.findAll();
		Iterator<Invoice> cptInv = invoices.iterator();
		while (cptInv.hasNext()) {
			Invoice invoiceTmp = cptInv.next();
			System.out.println(invoiceTmp.getId());
			
		}
		*/
		/*
		DAO<User> userDao = new UserDAO(BDDConnexion.getInstance());
		User user1 = new User(1,"fsfsgre","fsrgrg","fwwrgg","fe#grdsg@fwte",true);
		//userDao.create(user1);
		//userDao.update(user1);
//		System.out.println(userDao.find(1).getId());
		ArrayList<User> users;
		users = userDao.findAll();
		Iterator<User> cptUser = users.iterator();
		while (cptUser.hasNext()) {
			User userTmp = cptUser.next();
			System.out.println(userTmp.getId());
		}
		*
		DAO<Vat> vatDao = new VatDAO(BDDConnexion.getInstance());
		Vat vat1 = new Vat(1,21.00);
		Vat vat2 = new Vat(5);
//		vatDao.create(vat1);
//		vatDao.delete(vat2);
	//	vatDao.update(vat1);
		/*
		System.out.println(vatDao.find(3).getRate());
		ArrayList<Vat> vats;
		vats = vatDao.findAll();
		Iterator<Vat> cptVat = vats.iterator();
		while (cptVat.hasNext()) {
			Vat vatTmp = cptVat.next();
			System.out.println(vatTmp.getId());
		}
		*
		DAO<InvoiceArticle> invArtDao = new InvoiceArticleDAO(BDDConnexion.getInstance());
		InvoiceArticle invArt1 = new InvoiceArticle(1,2,5,255);
		InvoiceArticle invArt2 = new InvoiceArticle(1);

		invArtDao.create(invArt1);
		*/
		//ArticlesManagementView viewTest = new ArticlesManagementView();
		//ClientsManagementView viewTest = new ClientsManagementView();
		//HomeView viewTest = new HomeView();
		LoginView viewTest = new LoginView();
		viewTest.run();
		
		
	}
}
