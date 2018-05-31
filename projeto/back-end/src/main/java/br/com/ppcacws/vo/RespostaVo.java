package br.com.ppcacws.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import br.com.ppcacws.enumeration.EnumDescricaoSituacaoResposta;
import br.com.ppcacws.model.Resposta;

@XmlRootElement(name = "resposta")
@XmlAccessorType(XmlAccessType.FIELD)
public class RespostaVo {

	private Integer idResposta;
	private String descricaoResposta;
	private String situacaoResposta;
	private String letraResposta;
	private String descricaoSituacaoResposta;
	
	private Integer idQuestao;
	@XmlTransient
	private QuestaoVo questao;
	
	
	public RespostaVo() {
		
	}
	
	public RespostaVo(String descricaoResposta, String situacaoResposta, 
			Integer idQuestao, QuestaoVo questao, 
			String descricaoSituacaoResposta, String letraResposta) {
		super();
		this.descricaoResposta = descricaoResposta;
		this.situacaoResposta = situacaoResposta;
		this.idQuestao = idQuestao;
		this.questao = questao;
		this.descricaoSituacaoResposta = descricaoSituacaoResposta;
		this.letraResposta = letraResposta;
	}
	
	public RespostaVo(Integer idResposta, String descricaoResposta, 
			String situacaoResposta, QuestaoVo questao,
			String descricaoSituacaoResposta, String letraResposta) {
		super();
		this.idResposta = idResposta;
		this.descricaoResposta = descricaoResposta;
		this.situacaoResposta = situacaoResposta;
		this.idQuestao = questao.getIdQuestao();
		this.questao = questao;
		this.descricaoSituacaoResposta = descricaoSituacaoResposta;
		this.letraResposta = letraResposta;
	}

	public static List<RespostaVo> popularRespostas(List<Resposta> listaRespostas) {
		
		List<RespostaVo> lista = new ArrayList<RespostaVo>();
		
		QuestaoVo questao = null;
		
		for(Resposta resposta : listaRespostas) {
			
			questao = QuestaoVo.clone(resposta.getQuestao());
			
			lista.add(new RespostaVo(resposta.getIdResposta(), resposta.getDescricaoResposta(), resposta.getSituacaoResposta(), questao, 
					EnumDescricaoSituacaoResposta.fromSituacaoResposta(resposta.getSituacaoResposta()).getDescricaoSituacaoReposta(), resposta.getLetraResposta()));
		}
		
		return lista;
	}
	
	public static RespostaVo clone(Resposta respostaEntity) {
		
		QuestaoVo questao = QuestaoVo.clone(respostaEntity.getQuestao());
		
		RespostaVo resposta = new RespostaVo(respostaEntity.getIdResposta(), respostaEntity.getDescricaoResposta(), respostaEntity.getSituacaoResposta(), 
				questao, EnumDescricaoSituacaoResposta.fromSituacaoResposta(respostaEntity.getSituacaoResposta()).getDescricaoSituacaoReposta(), respostaEntity.getLetraResposta());
		
		return resposta;
	}


	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	
	public String getDescricaoResposta() {
		return descricaoResposta;
	}
	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
	
	public String getSituacaoResposta() {
		return situacaoResposta;
	}
	public void setSituacaoResposta(String situacaoResposta) {
		this.situacaoResposta = situacaoResposta;
	}
	
	public String getLetraResposta() {
		return letraResposta;
	}
	public void setLetraResposta(String letraResposta) {
		this.letraResposta = letraResposta;
	}
	
	public Integer getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(Integer idResposta) {
		this.idResposta = idResposta;
	}
	
	public QuestaoVo getQuestao() {
		return questao;
	}
	public void setQuestao(QuestaoVo questao) {
		this.questao = questao;
	}
	
	public String getDescricaoSituacaoResposta() {
		return descricaoSituacaoResposta;
	}
	public void setDescricaoSituacaoResposta(String descricaoSituacaoResposta) {
		this.descricaoSituacaoResposta = descricaoSituacaoResposta;
	}
	
}
