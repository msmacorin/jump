package br.com.jump.core.service.iface;

import br.com.jump.model.dto.DataTableResponse;

public interface IGenericService<T, PK> {

    public DataTableResponse buscarDataTableResponse(String sEcho, String sSearch, String[] campos, int linhaInicial, int maxResultados, Integer indiceColunaOrdenacao, String direcaoOrdenacao);

    public void salvar(T entidade);
    
    public void deletar(PK id);

    public T buscarPorId(PK id);
}
