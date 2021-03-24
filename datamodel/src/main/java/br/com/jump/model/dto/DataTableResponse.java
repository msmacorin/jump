package br.com.jump.model.dto;

import java.util.List;

public class DataTableResponse {

    private String sEcho;

    private Long iTotalRecords;

    private Long iTotalDisplayRecords;

    private List<Object[]> aaData;
    
    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<Object[]> getAaData() {
        return aaData;
    }

    public void setAaData(List<Object[]> aaData) {
        this.aaData = aaData;
    }
}
