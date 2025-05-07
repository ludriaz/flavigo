package tfg.jordanlucia.aplicacion.flavigo.web.helper;

import java.io.Serializable;
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
    
   // private List<Map<String, String>> columns;

    private boolean exportar;

    private int id;

    private List<Map<String, String>> search;
    
    
    
 // Nueva clase para reflejar la estructura de columnas de DataTables
    public static class DataTableColumn implements Serializable {
        private String data;
        private String name;
        private Boolean searchable;
        private Boolean orderable;
        private Search search;

        public static class Search implements Serializable {
            private String value;
            private Boolean regex;
            public String getValue() { return value; }
            public void setValue(String value) { this.value = value; }
            public Boolean getRegex() { return regex; }
            public void setRegex(Boolean regex) { this.regex = regex; }
        }

        public String getData() { return data; }
        public void setData(String data) { this.data = data; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public Boolean getSearchable() { return searchable; }
        public void setSearchable(Boolean searchable) { this.searchable = searchable; }
        public Boolean getOrderable() { return orderable; }
        public void setOrderable(Boolean orderable) { this.orderable = orderable; }
        public Search getSearch() { return search; }
        public void setSearch(Search search) { this.search = search; }
    }

    private List<DataTableColumn> columns;
    
    public FiltroPaginadoDatatables() {
        this.columns = new ArrayList<>();
    }
    
    
    
    // Getters y Setters

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<Map<String, String>> getOrder() {
        return order;
    }

    public void setOrder(List<Map<String, String>> order) {
        this.order = order;
    }


    public boolean isExportar() {
        return exportar;
    }

    public void setExportar(boolean exportar) {
        this.exportar = exportar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    
    public List<Map<String, String>> getSearch() {
		return search;
	}

	public void setSearch(List<Map<String, String>> search) {
		this.search = search;
	}

	public List<DataTableColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DataTableColumn> columns) {
		this.columns = columns;
	}

	public Sort getOrdenacionSort() {
       

        Sort sortCompleto = Sort.unsorted();
        List<Sort> listSort = new ArrayList<>();
        if(!StringUtils.isEmpty(order)) {
        	for (Map<String, String> ord : order) {
        		int n = Integer.parseInt(ord.get("column"));
        		Sort sort = Sort.by(Direction.fromString(ord.get("dir")), columns.get(n).getName());
        		listSort.add(sort);
        	}
        }
        
        for(int i = 0; !listSort.isEmpty() && i < listSort.size(); i++) {
        	if( i == 0) {
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
    
}
