package br.com.motocampos.system.enums;

public enum StatusOrdemServico {

	ABERTO(1),
	EM_ANDAMENTO(2),
	PENDENTE(3),
	CONCLUIDO(4);
	
	private int codigo;

	private StatusOrdemServico(int codigo) {
		this.codigo=codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusOrdemServico valueOf(int codigo) {
		for(StatusOrdemServico sos: StatusOrdemServico.values()) {
			if(sos.getCodigo() == codigo) {
				return sos;
			}
		}
		throw new IllegalArgumentException("Codigo do Status Invalido");
	}
	
	
}
