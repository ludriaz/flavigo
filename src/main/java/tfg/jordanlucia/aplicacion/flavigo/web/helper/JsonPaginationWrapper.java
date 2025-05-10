package tfg.jordanlucia.aplicacion.flavigo.web.helper;

import org.springframework.data.domain.Page;

public class  JsonPaginationWrapper <T> {
	private Iterable<T> data;
	private long recordsTotal;
	private long recordsFiltered;
	private int draw;
		
	
	public JsonPaginationWrapper(Page<T> pagina, int draw) {
		this.data = pagina.getContent();
		this.draw = draw++;
		this.recordsTotal = pagina.getTotalElements();
		this.recordsFiltered  = pagina.getTotalElements();
	}

	public Iterable<T> getData() {
		return data;
	}

	public void setData(Iterable<T> data) {
		this.data = data;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	
	

}
