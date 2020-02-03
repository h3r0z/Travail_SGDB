package model;

public class InvoiceArticle {
	private int id;
	private int invoiceId;
	private int articleId;
	public InvoiceArticle(int id, int invoiceId, int articleId) {
		super();
		this.id = id;
		this.invoiceId = invoiceId;
		this.articleId = articleId;
	}
	public InvoiceArticle() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFactId() {
		return invoiceId;
	}
	public void setFactId(int factId) {
		this.invoiceId = factId;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	
}
