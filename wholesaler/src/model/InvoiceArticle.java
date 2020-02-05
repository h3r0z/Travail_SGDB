package model;

public class InvoiceArticle {
	private int id;
	private int invoiceId;
	private int articleId;
	private int amount;
	public InvoiceArticle(int id, int invoiceId, int articleId, int amount) {
		super();
		this.id = id;
		this.invoiceId = invoiceId;
		this.articleId = articleId;
		this.amount = amount;
	}
	public InvoiceArticle() {
		// TODO Auto-generated constructor stub
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	
}
