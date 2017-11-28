package br.com.dfdevforge.sisfin.estabelecimento.business;

import java.sql.SQLException;
import java.util.List;

import br.com.cagece.core.persistence.ConnectionManager;
import br.com.dfdevforge.sisfin.estabelecimento.bean.BtpEstabelecimento;
import br.com.dfdevforge.sisfin.estabelecimento.persistence.PrsEstabelecimento;
import br.com.dfdevforge.sisfin.estabelecimento.persistence.PrsEstabelecimentoDelete;
import br.com.dfdevforge.sisfin.estabelecimento.persistence.PrsEstabelecimentoInsert;
import br.com.dfdevforge.sisfin.estabelecimento.persistence.PrsEstabelecimentoUpdate;
import br.com.dfdevforge.sisfin.exception.SessionUserNotFoundException;
import br.com.dfdevforge.sisfin.exception.TimezoneValueException;

public class BusEstabelecimento
{
	private ConnectionManager connectionManager;

	public BusEstabelecimento(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
	}

	public void alterar(BtpEstabelecimento btpEstabelecimento) throws SQLException, Exception
	{
		PrsEstabelecimentoUpdate prsEstabelecimento = new PrsEstabelecimentoUpdate(btpEstabelecimento, this.connectionManager);
		prsEstabelecimento.execute();

		if (prsEstabelecimento.getAffectedRows() != 1)
			throw new Exception("O n�mero de registros inseridos foi diferente de 1");
	}

	public List<BtpEstabelecimento> editar(BtpEstabelecimento btpEstabelecimento) throws SQLException, SessionUserNotFoundException, TimezoneValueException
	{
		return this.consultar(btpEstabelecimento, 0);
	}

	public void excluir(BtpEstabelecimento btpEstabelecimento) throws SQLException, Exception
	{
		PrsEstabelecimentoDelete prsEstabelecimento = new PrsEstabelecimentoDelete(btpEstabelecimento, this.connectionManager);
		prsEstabelecimento.execute();

		if (prsEstabelecimento.getAffectedRows() != 1)
			throw new Exception("O n�mero de registros inseridos foi diferente de 1");
	}

	public void exibir(BtpEstabelecimento btpEstabelecimento)
	{
	}

	public List<BtpEstabelecimento> consultar(BtpEstabelecimento btpEstabelecimento, Integer sqlOrdem) throws SQLException, SessionUserNotFoundException, TimezoneValueException
	{
		PrsEstabelecimento prs = new PrsEstabelecimento(this.connectionManager);
		List<BtpEstabelecimento> btpEstabelecimentoList = prs.select(btpEstabelecimento, sqlOrdem);

		return btpEstabelecimentoList;
	}

	public void incluir(BtpEstabelecimento btpEstabelecimento) throws SQLException, Exception
	{
		PrsEstabelecimentoInsert prsEstabelecimento = new PrsEstabelecimentoInsert(btpEstabelecimento, this.connectionManager);
		prsEstabelecimento.execute();

		if (prsEstabelecimento.getAffectedRows() != 1)
			throw new Exception("O n�mero de registros inseridos foi diferente de 1");
	}
}