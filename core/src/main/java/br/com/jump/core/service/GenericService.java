package br.com.jump.core.service;

import br.com.jump.core.service.iface.IGenericService;
import br.com.jump.model.dto.DataTableResponse;
import in.macor.core.dao.iface.IGenericDao;

import java.util.List;

public abstract class GenericService<T, PK> implements IGenericService<T, PK> {

    //<editor-fold desc="Metodos">
    @Override
    @SuppressWarnings("unchecked")
    public DataTableResponse buscarDataTableResponse(String sEcho, String filtro, String[] campos, int linhaInicial, int maxResultados, Integer indiceColunaOrdenacao, String direcaoOrdenacao) {
        long count = getDao().count();

        List<Object[]> resultadoConsulta = getDao().findForDataTable(filtro, campos, linhaInicial, maxResultados, indiceColunaOrdenacao, direcaoOrdenacao, exclusaoVirtual());
        DataTableResponse dataTableResponse = new DataTableResponse();

        dataTableResponse.setsEcho(sEcho);
        dataTableResponse.setiTotalDisplayRecords(count);
        dataTableResponse.setiTotalRecords(count);
        dataTableResponse.setAaData(resultadoConsulta);

        return dataTableResponse;
    }
    //</editor-fold>

    //<editor-fold desc="Metodos abstratos e sobescritos">
    /**
     *
     * @return GenericDao Retorna a implementação do Dao da Entidade.
     */
    @SuppressWarnings("rawtypes")
    protected abstract IGenericDao getDao();
    
    @SuppressWarnings("rawtypes")
    protected abstract boolean exclusaoVirtual();
    //</editor-fold>
}
