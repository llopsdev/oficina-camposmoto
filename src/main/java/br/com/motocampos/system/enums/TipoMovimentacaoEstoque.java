package br.com.motocampos.system.enums;

public enum TipoMovimentacaoEstoque {

	ENTRADA, SAIDA, AJUSTE, ESTORNO;

	/*private int codigo;

	TipoMovimentacaoEstoque(int codigoi) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public static TipoMovimentacaoEstoque valueOf(int codigo) {
		for(TipoMovimentacaoEstoque sos : TipoMovimentacaoEstoque.values()) {
			if(sos.getCodigo() == codigo) {
				return sos;
			}
			
		}
		throw new IllegalArgumentException ("Codigo Invalid.");
	}*/

	
}
