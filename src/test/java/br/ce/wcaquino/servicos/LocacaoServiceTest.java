package br.ce.wcaquino.servicos;

import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import servicos.LocacaoService;
import utils.DataUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class LocacaoServiceTest {
    @Test
    public void teste(){
        //cenario
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);

        //acao
        Locacao locacao = service.alugarFilme(usuario, filme);

        //verificacao
        Assert.assertTrue(locacao.getValor() == 5.0);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
}
