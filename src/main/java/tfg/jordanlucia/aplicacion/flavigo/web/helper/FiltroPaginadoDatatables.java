package tfg.jordanlucia.aplicacion.flavigo.web.helper;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class FiltroPaginadoDatatables {

    private Integer draw;
    private Integer page;
    private Integer length;
    private Integer start;

    private List<Map<String, String>> order;
    private List<Map<String, String>> columns;

    private boolean exportar;

    private int id;

    private List<Map<String, String>> search;

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

    public List<Map<String, String>> getColumns() {
        return columns;
    }

    public void setColumns(List<Map<String, String>> columns) {
        this.columns = columns;
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
    
    public Sort getOrdenacionSort() {
        if (order == null || columns == null) {
            return Sort.unsorted();
        }

        Sort sort = Sort.unsorted();

        for (Map<String, String> orden : order) {
            String columnIndexStr = orden.get("column");
            String dir = orden.get("dir");

            if (columnIndexStr != null && dir != null) {
                try {
                    int columnIndex = Integer.parseInt(columnIndexStr);
                    String columnName = columns.get(columnIndex).get("data");

                    Sort.Direction direction = dir.equalsIgnoreCase("asc") ?
                            Sort.Direction.ASC : Sort.Direction.DESC;

                    Sort currentSort = Sort.by(direction, columnName);
                    sort = sort.and(currentSort);
                } catch (NumberFormatException | IndexOutOfBoundsException e) {
                    // Ignorar errores
                }
            }
        }

        return sort;
    }

    public Pageable getPageable() {
        int pageNumber = (start != null && length != null && length > 0) ? start / length : 0;
        int pageSize = (length != null && length > 0) ? length : 10;

        return PageRequest.of(pageNumber, pageSize, getOrdenacionSort());
    }
    
}
