package tfg.jordanlucia.aplicacion.flavigo.web.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

public class FiltroPaginadoDatatables {

	private Integer draw;

	private Integer page;
	private Integer length;
	private Integer start;

	private List<Map<String, String>> order;
	private List<Map<String, String>> columns;

	private boolean exportar;


	public List<Map<String, String>> getOrder() {

		return order;
	}

	public List<Map<String, String>> getColumns() {

		return columns;
	}

	public Integer getDraw() {

		return draw;
	}

	public void setDraw(Integer draw) {

		this.draw = draw;
	}

	public void setOrder(List<Map<String, String>> order) {

		this.order = order;
	}

	public void setColumns(List<Map<String, String>> columns) {

		this.columns = columns;
	}
	
	@SuppressWarnings("deprecation")
	public Sort getOrdenacionSort() {
		Sort sortCompleto = Sort.unsorted();
		List<Sort> listSort = new ArrayList<>();
		if (!StringUtils.isEmpty(order)) {
			for (Map<String, String> ord : order) {
				int n = Integer.parseInt(ord.get("column"));
				Sort sort = Sort.by(Direction.fromString(ord.get("dir")),columns.get(n).get("name"));
				listSort.add(sort);
			}
		}
		
		for(int i = 0; !listSort.isEmpty() && i < listSort.size(); i++){
			if(i == 0){
				sortCompleto = listSort.get(i);
			} else {
				sortCompleto = sortCompleto.and(listSort.get(i));
			}
		}

		return sortCompleto;
	}
	
	public Pageable getPageable() {
	    int pageNumber = (start != null && length != null && length > 0) ? start / length : 0;
	    int pageSize = (length != null && length > 0) ? length : 10; 

	    return PageRequest.of(pageNumber, pageSize, getOrdenacionSort());
	}

	public boolean isExportar() {

		return exportar;
	}

	public void setExportar(boolean exportar) {

		this.exportar = exportar;
	}

	public Integer getPage() {
	    
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getLength() {
		return length;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}
}